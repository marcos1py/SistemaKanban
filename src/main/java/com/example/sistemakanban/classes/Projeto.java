package com.example.sistemakanban.classes;

import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.util.List;

public class Projeto {
    private int id;
    private String nome;
    private String titulo;
    private String descricao;
    private List<Atividade> atividades;
    private Pane pane;
    private LocalDate inícioDefinido;
    private LocalDate fimDefinido;
    private String status;
    private String responsavel;
    private String area;

    // Construtor
    public Projeto() {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.atividades = atividades;
        this.titulo = titulo;
        this.descricao = descricao;
        this.fimDefinido = fimDefinido;
        this.inícioDefinido = inícioDefinido;
        this.status = status;
        this.responsavel = responsavel;
        this.area = area;

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

    public LocalDate getInicioDefinido(){return inícioDefinido;}

    public void setInicioDefinido(LocalDate inicioDefinido){this.inícioDefinido = inicioDefinido;}

    public LocalDate getFimDefinido(){return inícioDefinido;}

    public void setFimDefinido(LocalDate fimDefinido){this.fimDefinido = fimDefinido;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }
    public void setResponsavel(String responsavel){this.responsavel = responsavel;}

    public String getResponsavel(){return responsavel;}
}
