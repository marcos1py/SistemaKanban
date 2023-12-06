package com.example.sistemakanban.classes;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private int id;
    private String nomeEmpresa;
    private String local;
    private String tel;
    private String qtFuncionario;
    private int Yeixo;
    private List<Projeto> projetos;

    // Construtor
    public Empresa() {
        this.projetos = new ArrayList<>();
    }
    public void adicionarProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }
    // Getters e Setters

    public void removerProjeto(Projeto projeto){this.projetos.remove(projeto);}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYeixo() {
        return Yeixo;
    }

    public void setYeixo(int Yeixo) {
        this.Yeixo = Yeixo;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQtFuncionario() {
        return qtFuncionario;
    }

    public void setQtFuncionario(String qtFuncionario) {
        this.qtFuncionario = qtFuncionario;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void addProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }


}
