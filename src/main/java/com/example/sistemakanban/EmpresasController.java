package com.example.sistemakanban;


import com.example.sistemakanban.classes.Empresa;
import com.example.sistemakanban.classes.GeraPane;
import com.example.sistemakanban.classes.Projeto;
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

public class EmpresasController {
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

    public Pane newEmpresa(Empresa meuEmpresa){
        int contagem = 0;
        contagem = meuEmpresa.getId();

        if (contagem == 0){
            eixoY = 70;
        }
        else {
            eixoY += 110;
        }
        contagem += 1;
        String nomePane = "Empresa "+contagem;
        Pane novaEmpresa = new Pane();
        novaEmpresa.setPrefSize(1412, 104);
        novaEmpresa.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novaEmpresa.setLayoutX(13);
        novaEmpresa.setLayoutY(eixoY);

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

        // Adicione os Labels à Pane
        novaEmpresa.getChildren().addAll(tituloEmpresa, labelLocal,labelTel,labelQtFuncionario,labelID,meuBotaoDeletar,meuBotaoEditar);
        return novaEmpresa;
    }
}
