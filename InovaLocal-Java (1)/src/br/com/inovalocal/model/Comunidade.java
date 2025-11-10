package br.com.inovalocal.model;

public class Comunidade {
    private int id;
    private String nome;
    private String localizacao;
    private int populacao;
    private String situacaoConectividade;

    public Comunidade() {}

    public Comunidade(int id, String nome, String localizacao, int populacao, String situacaoConectividade) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.populacao = populacao;
        this.situacaoConectividade = situacaoConectividade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getPopulacao() { return populacao; }
    public void setPopulacao(int populacao) { this.populacao = populacao; }

    public String getSituacaoConectividade() { return situacaoConectividade; }
    public void setSituacaoConectividade(String situacaoConectividade) { this.situacaoConectividade = situacaoConectividade; }
}