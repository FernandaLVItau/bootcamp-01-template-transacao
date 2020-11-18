package br.com.zup.cartaotransacao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRetorno {

    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoRetorno estabelecimento;

    public TransacaoRetorno(Transacao transacao) {
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = new EstabelecimentoRetorno(transacao.getEstabelecimento());
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoRetorno getEstabelecimento() {
        return estabelecimento;
    }
}
