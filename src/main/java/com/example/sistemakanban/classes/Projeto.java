package com.example.sistemakanban.classes;

import com.example.sistemakanban.classes.Atividade;
import javafx.scene.layout.Pane;

import java.util.List;

public class Projeto {
    private int id;
    private String nome;
    private String titulo;
    private String descricao;
    private List<Atividade> atividades;
    private Pane pane;

    // Construtor
    public Projeto() {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.atividades = atividades;
        this.titulo = titulo;
        this.descricao = descricao;

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

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }
}
