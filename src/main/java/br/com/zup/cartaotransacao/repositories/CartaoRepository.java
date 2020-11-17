package br.com.zup.cartaotransacao.repositories;

import br.com.zup.cartaotransacao.entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CartaoRepository extends JpaRepository<Cartao, String> {
    Optional<Cartao> findByIdLegado(String idLegado);
}
