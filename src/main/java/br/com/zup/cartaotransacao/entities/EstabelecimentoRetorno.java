package br.com.zup.cartaotransacao.entities;

public class EstabelecimentoRetorno {
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoRetorno(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
