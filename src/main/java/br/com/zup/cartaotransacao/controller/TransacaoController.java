package br.com.zup.cartaotransacao.controller;

import br.com.zup.cartaotransacao.entities.Cartao;
import br.com.zup.cartaotransacao.entities.Transacao;
import br.com.zup.cartaotransacao.entities.TransacaoRetorno;
import br.com.zup.cartaotransacao.repositories.CartaoRepository;
import br.com.zup.cartaotransacao.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{nCartao}")
    public ResponseEntity<List<TransacaoRetorno>> buscaListaTransacoes(@PathVariable("nCartao") String nCartao) {

        Optional<Cartao> verificaCartao = cartaoRepository.findByIdLegado(nCartao);

        if (verificaCartao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Transacao> listaTransacoes = transacaoRepository.findTop10ByCartaoOrderByEfetivadaEmDesc(verificaCartao.get());

        List<TransacaoRetorno> transacaoRetornos = listaTransacoes.stream()
                .map(TransacaoRetorno::new)
                .limit(10)
                .collect(Collectors.toList());

        return ResponseEntity.ok(transacaoRetornos);

    }
}
