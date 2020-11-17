package br.com.zup.cartaotransacao.entities;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

    @Id
    private String id;
    @NotBlank
    private String idLegado;
    @NotBlank
    private String email;

    @Deprecated
    public Cartao(){}

    public Cartao(String id, @NotBlank String idLegado, @NotBlank String email) {
        this.id = id;
        this.idLegado = idLegado;
        this.email = email;
    }
}
