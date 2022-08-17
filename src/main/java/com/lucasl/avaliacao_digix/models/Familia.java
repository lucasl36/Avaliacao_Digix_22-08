package com.lucasl.avaliacao_digix.models;

/**
 *
 * @author Lucas Lopes
 */
public class Familia {
    
    private String descricao;
    private int dependentes;
    private double renda;
    private int pontos;
    
    public Familia() {
        this.descricao = "";
        this.dependentes = 0;
        this.renda = 0.0;
        this.pontos = 0;
    }
    
    public Familia(String descricao, int dependentes, double renda, int pontos) {
        this.descricao = descricao;
        this.dependentes = dependentes;
        this.renda = renda;
        this.pontos = pontos;
    }
    
    public String toString() {
        return "Família: " + this.descricao 
                + "\nDependentes: " + String.valueOf(this.dependentes)
                + "\nRenda: R$" + String.valueOf(this.renda)
                + "\nPontuação: " + String.valueOf(this.pontos);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
