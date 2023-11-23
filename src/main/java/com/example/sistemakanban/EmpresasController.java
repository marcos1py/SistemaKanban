package com.example.sistemakanban;


import com.example.sistemakanban.classes.Empresa;
import com.example.sistemakanban.classes.GeraPane;
import com.example.sistemakanban.classes.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EmpresasController {

    @FXML
    private AnchorPane principal;

    @FXML
    private AnchorPane addPane;

    @FXML
    private Pane nav;

    @FXML
    private TextField QtFuncionarioADD;

    @FXML
    private Pane atividade1;

    @FXML
    private TextField localEmpresaADD;

    @FXML
    private Label title1;

    @FXML
    private TextField telefoneEmpresaADD;

    @FXML
    private Label title;

    @FXML
    private Label title11;

    @FXML
    private Pane nav1;

    @FXML
    private TextField nomeEmpresaADD;
    @FXML
    private TextField qtFuncionarioADD;

    @FXML
    private AnchorPane achorPaneEmpresa;
    int numeroID = 0;


    @FXML
    void confirmarBtn(ActionEvent event) {
        Empresa meuEmpresa = new Empresa( ) ;
        GeraPane gerador = new GeraPane();

        numeroID += 1;
        meuEmpresa.setId(numeroID);

        meuEmpresa.setNomeEmpresa(nomeEmpresaADD.getText());
        meuEmpresa.setLocal(localEmpresaADD.getText());
        meuEmpresa.setTel(telefoneEmpresaADD.getText());
        meuEmpresa.setQtFuncionario(qtFuncionarioADD.getText());
        Pane newPane = gerador.newEmpresa(meuEmpresa);

        achorPaneEmpresa.getChildren().add(newPane);
        int teste =meuEmpresa.getYeixo();
        int teste1 = (int) achorPaneEmpresa.getHeight();
        teste += 100;

        int teste3 = teste1+teste;
        achorPaneEmpresa.setPrefHeight(teste3);


    }
    @FXML
    void cancelarBtn(ActionEvent event) {
        addPane.setVisible(false);

    }
    @FXML
    void novoProjBtn(ActionEvent event) {
        addPane.setVisible(true);
    }


}
