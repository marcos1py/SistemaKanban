package com.example.sistemakanban.classes;

import java.util.Date;

public class Ação {
    private int id;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private String areaResponsavel;
    private int barraProgresso;
    private String status;
    private String nome;

    // Construtor
    public Ação(String nome) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.areaResponsavel = areaResponsavel;
        this.barraProgresso = barraProgresso;
        this.status = status;
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getAreaResponsavel() {
        return areaResponsavel;
    }

    public void setAreaResponsavel(String areaResponsavel) {
        this.areaResponsavel = areaResponsavel;
    }


    public int getBarraProgresso() {
        return barraProgresso;
    }

    public void setBarraProgresso(int barraProgresso) {
        this.barraProgresso = barraProgresso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
