package com.example.sistemakanban;


import com.example.sistemakanban.classes.Empresa;
import com.example.sistemakanban.classes.GeraPane;
import com.example.sistemakanban.classes.Projeto;
import com.example.sistemakanban.classes.Validador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmpresasController {
    private ProjetoController projetoController;
    public void setProjetoController(ProjetoController projetoController) {
        this.projetoController = projetoController;
    }
    int eixoX = 0;
    int eixoY = 0;
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
    private List<Empresa> listaEmpresas = new ArrayList<>();

    int numeroID = 0;
    public Empresa getEmpresaById(int id) {


        for (Empresa empresa : listaEmpresas) {
            if (empresa.getId() == id) {
                System.out.println(empresa.getId());
                return empresa;
            }
        }
        return null;
    }


    @FXML
    void confirmarBtn(ActionEvent event) {
        if (Objects.equals(localEmpresaADD.getText(), "") || Objects.equals(telefoneEmpresaADD.getText(), "") || Objects.equals(qtFuncionarioADD.getText(), "") || Objects.equals(nomeEmpresaADD.getText(), "")) {
            labelErro.setVisible(true);
        } else {
            labelErro.setVisible(false);

            Empresa meuEmpresa = new Empresa();
            numeroID += 1;
            meuEmpresa.setId(numeroID);

            meuEmpresa.setNomeEmpresa(nomeEmpresaADD.getText());
            meuEmpresa.setLocal(localEmpresaADD.getText());
            meuEmpresa.setTel(telefoneEmpresaADD.getText());
            meuEmpresa.setQtFuncionario(qtFuncionarioADD.getText());

            Pane newPane = newEmpresa(meuEmpresa);
            listaEmpresas.add(meuEmpresa);
            achorPaneEmpresa.getChildren().add(newPane);

            int teste = meuEmpresa.getYeixo();
            int teste1 = (int) achorPaneEmpresa.getHeight();
            teste += 100;

            int teste3 = teste1 + teste;
            achorPaneEmpresa.setPrefHeight(teste3);
            labelErro.setVisible(false);
            nomeEmpresaADD.clear();
            qtFuncionarioADD.clear();
            telefoneEmpresaADD.clear();
            localEmpresaADD.clear();
        }
    }
    @FXML
    private Label labelErro;
    public void initialize(){
        Validador.mskNumero(nomeEmpresaADD,40);
        Validador.mskLetra(telefoneEmpresaADD,11);
        Validador.mskLetra(qtFuncionarioADD,6);
        Validador.mskNumero(localEmpresaADD1,60);

    }
    @FXML
    void cancelarBtn(ActionEvent event) {
        addPane.setVisible(false);
        labelErro.setVisible(false);
        nomeEmpresaADD.clear();
        qtFuncionarioADD.clear();
        telefoneEmpresaADD.clear();
        localEmpresaADD.clear();

    }
    @FXML
    void novoProjBtn(ActionEvent event) {
        addPane.setVisible(true);
    }
    @FXML
    private TextField nomeEmpresaADD1;
    @FXML
    private TextField localEmpresaADD1;
    @FXML
    private Pane addPaneEditar;
    int ab = 0;
    @FXML
    void confirmarBtn1(ActionEvent event) {
    ab++;
    addPaneEditar.setVisible(false);
    }

    public Pane newEmpresa(Empresa meuEmpresa){
        int contagem = 0;
        contagem = meuEmpresa.getId();

        contagem += 1;
        String nomePane = "Empresa "+contagem;
        Pane novaEmpresa = new Pane();
        novaEmpresa.setPrefSize(1412, 104);
        novaEmpresa.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novaEmpresa.setLayoutX(13);
        novaEmpresa.setLayoutY(eixoY);
        eixoY += 110;

        String nomeEmpresa =  meuEmpresa.getNomeEmpresa();
        String labelLocalGet =  meuEmpresa.getLocal();
        String tel =  meuEmpresa.getTel();
        String qtFuncionario =  meuEmpresa.getQtFuncionario();
        int empresaID1 =  meuEmpresa.getId();
        String empresaID = ""+empresaID1;

        // add o titulo da emrpesa
        Hyperlink tituloEmpresa = new Hyperlink(nomeEmpresa);
        tituloEmpresa.setLayoutX(116);
        tituloEmpresa.setLayoutY(46);
        tituloEmpresa.setFont(new Font(15.0));
        tituloEmpresa.setId(empresaID);

        tituloEmpresa.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {

                projetoController.usarDadosRecebidosEmpresa(meuEmpresa.getNomeEmpresa(),meuEmpresa.getId());
                Main.mudarTela("projetos");
            }
        });
        Label labelLocal = new Label(labelLocalGet);
        labelLocal.setLayoutX(399);
        labelLocal.setLayoutY(46);
        labelLocal.setWrapText(true);
        labelLocal.setFont(new Font(15.0));

        // add o titulo da tel
        Label labelTel = new Label(tel);
        labelTel.setLayoutX(751);
        labelTel.setLayoutY(46);
        labelTel.setWrapText(true);
        labelTel.setFont(new Font(15.0));

        // add o titulo da qtFuncionario
        Label labelQtFuncionario = new Label(qtFuncionario);
        labelQtFuncionario.setLayoutX(963);
        labelQtFuncionario.setLayoutY(46);
        labelQtFuncionario.setWrapText(true);
        labelQtFuncionario.setFont(new Font(15.0));

        Label labelID = new Label(empresaID);
        labelID.setLayoutX(31);
        labelID.setLayoutY(46);

        // Criar um botão
        Button meuBotaoDeletar = new Button();
        meuBotaoDeletar.setStyle("-fx-background-color: 0; -fx-cursor: hand;");

        meuBotaoDeletar.setLayoutX(1288);
        meuBotaoDeletar.setLayoutY(39);
        meuBotaoDeletar.setPrefHeight(20);
        Image minhaImagem = new Image(getClass().getResourceAsStream("/Imagens/icone deletar.png"));
        ImageView imageView = new ImageView(minhaImagem);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        meuBotaoDeletar.setGraphic(imageView);


        // Criar um botão
        Button meuBotaoEditar = new Button();
        meuBotaoEditar.setStyle("-fx-background-color: 0; -fx-cursor: hand;");
        meuBotaoEditar.setLayoutX(1175);
        meuBotaoEditar.setLayoutY(35);
        meuBotaoEditar.setPrefHeight(15);
        Image minhaImagemEditar = new Image(getClass().getResourceAsStream("/Imagens/icone editar.png"));
        ImageView imageViewEditar = new ImageView(minhaImagemEditar);
        imageViewEditar.setFitWidth(20);
        imageViewEditar.setFitHeight(20);
        meuBotaoEditar.setGraphic(imageViewEditar);


        meuBotaoEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addPaneEditar.setVisible(true);
                    int cont = 0;
                    nomeEmpresaADD1.setText(tituloEmpresa.getText());

                    cont++;
                    if(cont >= 1){
                        meuEmpresa.setNomeEmpresa(nomeEmpresaADD1.getText());

                    }
            }
        });

        // Adicione os Labels à Pane
        novaEmpresa.getChildren().addAll(tituloEmpresa, labelLocal,labelTel,labelQtFuncionario,labelID,meuBotaoDeletar,meuBotaoEditar);
        return novaEmpresa;
    }
}
