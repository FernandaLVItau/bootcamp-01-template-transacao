package br.com.zup.cartaotransacao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private String efetivadaEm;
    private Estabelecimento estabelecimento;
    private Cartao cartao;


    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                '}';
    }
}
