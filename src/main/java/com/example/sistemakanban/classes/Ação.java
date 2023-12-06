package com.example.sistemakanban.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ação {
    private int id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String areaResponsavel;
    private int barraProgresso;
    private String status;
    private String nome;
    private  String feito;

    // Construtor
    public Ação() {
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

    public String getfeito() {
        return feito;
    }

    public void setFeito(String feito) {
        this.feito = feito;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
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
    @Override
    public String toString() {
        return ". "+nome;
    }
}
