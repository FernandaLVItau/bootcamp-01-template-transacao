package br.com.zup.cartaotransacao.repositories;

import br.com.zup.cartaotransacao.entities.Cartao;
import br.com.zup.cartaotransacao.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findByCartao(Cartao cartao);
}
