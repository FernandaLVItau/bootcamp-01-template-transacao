package br.com.zup.cartaotransacao.entities;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

    @NotBlank
    @Id
    private String idLegado;
    @NotBlank
    private String email;

    @Deprecated
    public Cartao(){}

    public Cartao(@NotBlank String idLegado, @NotBlank String email) {
        this.idLegado = idLegado;
        this.email = email;
    }
}
