package com.example.sistemakanban.classes;

public class Empresa {
    private int id;
    private String nomeEmpresa;
    private String local;
    private String tel;
    private String qtFuncionario;
    int Yeixo;

    // Construtor
    public Empresa() {
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getYeixo() {
        return Yeixo;
    }

    public void getYeixo(int Yeixo) {
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
}
