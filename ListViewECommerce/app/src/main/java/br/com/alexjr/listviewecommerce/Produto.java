package br.com.alexjr.listviewecommerce;

public class Produto {
    private String nome;
    private Double preco;
    private int imageResId;
    private String avaliacao;
    private String descricao;

    public Produto() {
    }

    public Produto(String nome, Double preco, int imageResId, String avaliacao, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.imageResId = imageResId;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
