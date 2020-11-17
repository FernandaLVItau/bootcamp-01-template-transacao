package br.com.zup.cartaotransacao.repositories;

import br.com.zup.cartaotransacao.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
