package com.example.sistemakanban.classes;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private int id;
    private Hyperlink nome;
    private String titulo;
    private String descricao;
    private List<Atividade> atividades;

    private Pane pane;
    private LocalDate inícioDefinido;
    private LocalDate fimDefinido;
    private String status;
    private String responsavel;
    private String area;
    private Empresa empresa;
    // Getter e Setter para a Empresa
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    private List<Projeto> projetos;


    // Construtor
    public Projeto() {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

        this.titulo = titulo;
        this.descricao = descricao;
        this.fimDefinido = fimDefinido;
        this.inícioDefinido = inícioDefinido;
        this.status = status;
        this.responsavel = responsavel;
        this.area = area;
        this.projetos = new ArrayList<>();
        this.atividades = new ArrayList<>();

    }
    // Getter e Setter para a lista de projetos
    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }
    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }
    // Obtém a lista de atividades do projeto
    public List<Atividade> getAtividades() {
        System.out.println("get atividade chamado: "+ atividades);
        return atividades;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hyperlink getNome() {
        return nome;
    }

    public void setNome(Hyperlink nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void setArea(String area){
        this.area = area;
    }

    public String getArea(){
        return area;
    }

    public String toString(){
        return titulo;
    }


}
