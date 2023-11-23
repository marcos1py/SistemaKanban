package com.example.sistemakanban.classes;

import com.example.sistemakanban.classes.Ação;
import java.time.LocalDate; // Importa a classe LocalDate do pacote java.time
import java.util.List;

public class Atividade {
    private int id;
    private String nome;
    private String descrição;
    private LocalDate inícioDefinido; // Tipo atualizado para LocalDate
    private LocalDate fimDefinido; // Tipo atualizado para LocalDate
    private String status;
    private String responsavel;
    private String area;
    private int diasNaAtividade;
    private int barraProgresso;
    private List<Ação> ações;

    // Construtor
    public Atividade() {

    }

    public String getArea() {
        return area;
    }

    public void setArea(String novaArea) {
        this.area = novaArea;
    }
    // Getter para id
    public int getId() {
        return id;
    }

    // Setter para id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para nome
    public String getNome() {
        return nome;
    }

    // Setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para descrição
    public String getDescrição() {
        return descrição;
    }

    // Setter para descrição
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    // Getter para inícioDefinido
    public LocalDate getInícioDefinido() {
        return inícioDefinido;
    }

    // Setter para inícioDefinido
    public void setInícioDefinido(LocalDate inícioDefinido) {
        this.inícioDefinido = inícioDefinido;
    }

    // Getter para fimDefinido
    public LocalDate getFimDefinido() {
        return fimDefinido;
    }

    // Setter para fimDefinido
    public void setFimDefinido(LocalDate fimDefinido) {
        this.fimDefinido = fimDefinido;
    }

    // Getter para status
    public String getStatus() {
        return status;
    }

    // Setter para status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter para responsavel
    public String getResponsavel() {
        return responsavel;
    }

    // Setter para responsavel
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    // Getter para diasNaAtividade
    public int getDiasNaAtividade() {
        return diasNaAtividade;
    }

    // Setter para diasNaAtividade
    public void setDiasNaAtividade(int diasNaAtividade) {
        this.diasNaAtividade = diasNaAtividade;
    }

    // Getter para barraProgresso
    public int getBarraProgresso() {
        return barraProgresso;
    }

    // Setter para barraProgresso
    public void setBarraProgresso(int barraProgresso) {
        this.barraProgresso = barraProgresso;
    }

    // Getter para ações
    public List<Ação> getAções() {
        return ações;
    }

    // Setter para ações
    public void setAções(List<Ação> ações) {
        this.ações = ações;
    }
}
