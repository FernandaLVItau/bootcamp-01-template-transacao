package br.com.zup.cartaotransacao;

import br.com.zup.cartaotransacao.entities.Cartao;
import br.com.zup.cartaotransacao.entities.Estabelecimento;
import br.com.zup.cartaotransacao.entities.Transacao;
import br.com.zup.cartaotransacao.entities.TransacaoRequest;
import br.com.zup.cartaotransacao.repositories.CartaoRepository;
import br.com.zup.cartaotransacao.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class ListenerDeTransacao {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoRequest transacaoRequest) {
        System.out.println(transacaoRequest);

        String idCartaoLegado = transacaoRequest.getCartao().getId();
        String email = transacaoRequest.getCartao().getEmail();
        /*
          Criando idCartao aleatório temporariamente
          TODO: 17/11/2020
          Busca em proposta o id do cartão
         */
        double random_double1 = Math.random() * (99999 - 10000 + 1) + 10000;
        double random_double2 = Math.random() * (99999 - 10000 + 1) + 10000;
        String idCartao = "Teste-" + random_double1 + "_" + random_double2;

        Optional<Cartao> verificaCartao = cartaoRepository.findByIdLegado(idCartaoLegado);
        Cartao cartao = verificaCartao.orElse(new Cartao(idCartao, idCartaoLegado, email));

        Estabelecimento estabelecimento = transacaoRequest.getEstabelecimento().toModel();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(transacaoRequest.getEfetivadaEm(), formatter);

        Transacao transacao = new Transacao(transacaoRequest.getId(),transacaoRequest.getValor(),dateTime,
                estabelecimento, cartao);

        transacaoRepository.save(transacao);
    }
}
