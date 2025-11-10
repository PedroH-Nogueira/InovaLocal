package br.com.inovalocal.model;

import java.math.BigDecimal;

public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private String responsavel;
    private BigDecimal orcamento;

    public Projeto() {}

    public Projeto(int id, String nome, String descricao, String responsavel, BigDecimal orcamento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.orcamento = orcamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    public BigDecimal getOrcamento() { return orcamento; }
    public void setOrcamento(BigDecimal orcamento) { this.orcamento = orcamento; }
}