package com.example.sistemakanban.classes;

import com.example.sistemakanban.classes.Ação;

import java.util.List;

public class Atividade {
    private int id;
    private String nome;
    private int barraProgresso;
    private List<Ação> ações; // Relacionamento 1:N com Ação

    // Construtor
    public Atividade(int id, String nome, int barraProgresso, List<Ação> ações) {
        this.id = id;
        this.nome = nome;
        this.barraProgresso = barraProgresso;
        this.ações = ações;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBarraProgresso() {
        return barraProgresso;
    }

    public void setBarraProgresso(int barraProgresso) {
        this.barraProgresso = barraProgresso;
    }

    public List<Ação> getAções() {
        return ações;
    }

    public void setAções(List<Ação> ações) {
        this.ações = ações;
    }
}
