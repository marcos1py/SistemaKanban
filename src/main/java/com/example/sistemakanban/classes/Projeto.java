package com.example.sistemakanban.classes;

import com.example.sistemakanban.classes.Atividade;

import java.util.List;

public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private List<Atividade> atividades;

    // Construtor
    public Projeto(int id, String nome, String descricao, List<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.atividades = atividades;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}
