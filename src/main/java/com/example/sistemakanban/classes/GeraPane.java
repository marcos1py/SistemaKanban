package com.example.sistemakanban.classes;
import com.example.sistemakanban.AtividadeController;
import com.example.sistemakanban.DetalhesController;
import com.example.sistemakanban.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.sistemakanban.AtividadeController.ativarBtnDelet;

public class GeraPane {



    // Método para configurar o controlador da tela ProjetoController

    public GeraPane(){

    }
    private Pane novoProjeto;
    private String tituloProj;
    private String descProj;
    private String area;
    private String responsavel;
    List<Pane> listaProjetos = new ArrayList<>();






    public void addProjeto(Projeto projeto) {
        System.out.println();
//Pane novoProjeto = newProject(projeto.getTitulo(), projeto.getDescricao());
        // projeto.setPane(novoProjeto);
        //listaProjetos.add(novoProjeto);
    }

    public void removerProjeto(Projeto projeto) {
        listaProjetos.remove(projeto.getPane());
    }
    public List<Pane> getListaProjetos() {
        return listaProjetos;
    }
    public void setTituloProj(String tituloProj) {
        this.tituloProj = tituloProj;
    }

    public void setDescProj(String descProj) {
        this.descProj = descProj;
    }

    public String getDescProj() {
        return descProj;
    }

    public Pane getNovoProjeto() {
        return novoProjeto;
    }

    public String getTituloProj() {
        return tituloProj;
    }

    public void setNovoProjeto(Pane novoProjeto) {
        this.novoProjeto = novoProjeto;
    }
    public void addProjeto(Pane novoProjeto){
        listaProjetos.add(novoProjeto);
    }
    public void removerProjeto(Pane novoProjeto){
        listaProjetos.remove(novoProjeto);
    }


    static int eixoY = 0;

    public Pane newProject(Projeto  meuProjeto){
        int contagem = 0;
        contagem = meuProjeto.getId();
        eixoY += 110;
        System.out.println(eixoY);
        System.out.println("");
        String nomePane = "projeto "+contagem;
        novoProjeto = new Pane();
        novoProjeto.setPrefSize(318, 104);
        novoProjeto.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novoProjeto.setLayoutX(15);
        novoProjeto.setLayoutY(eixoY);

        String tituloProj =  meuProjeto.getTitulo();

        Hyperlink labelTituloCard = new Hyperlink (tituloProj);
        labelTituloCard.setLayoutX(22.0);
        labelTituloCard.setLayoutY(3.0);
        labelTituloCard.setOnMouseClicked (new EventHandler<MouseEvent> () {
            @Override
            public void handle (MouseEvent event) {



                Main.mudarTela("atividades");
            }
        });
        Label labelDescriçãoCard = new Label(descProj);
        labelDescriçãoCard.setLayoutX(23.0);
        labelDescriçãoCard.setLayoutY(27.0);
        labelDescriçãoCard.setPrefWidth(222.0);
        labelDescriçãoCard.setPrefHeight(29.0);
        labelDescriçãoCard.setWrapText(true);
        labelDescriçãoCard.setFont(new Font(9.0));

        // Adicione o novo nome como um identificador à nova Pane
        novoProjeto.setId(nomePane);

        // Adicione os Labels à Pane
        novoProjeto.getChildren().addAll(labelTituloCard, labelDescriçãoCard);

        return novoProjeto;
    }
    @FXML
    private AnchorPane achorPaneEmpresa;
    public Pane newEmpresa(Empresa  meuEmpresa){
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
        novoProjeto = new Pane();
        novoProjeto.setPrefSize(1412, 104);
        novoProjeto.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novoProjeto.setLayoutX(13);
        novoProjeto.setLayoutY(eixoY);

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

        tituloEmpresa.setOnMouseClicked (new EventHandler<MouseEvent> () {
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
        novoProjeto.getChildren().addAll(tituloEmpresa, labelLocal,labelTel,labelQtFuncionario,labelID,meuBotaoDeletar,meuBotaoEditar);
        return novoProjeto;
    }

    public Pane newAtividade(Atividade atividade) {

        int contagem = 0;
        contagem = atividade.getId();

        if (contagem == 0){
            eixoY = 70;
        }
        else {
            eixoY += 110;
        }
        contagem += 1;

        String nomeAtividade = atividade.getNome();
        LocalDate dataInicio = atividade.getInícioDefinido();
        LocalDate dataFim = atividade.getFimDefinido();
        String responsavel = atividade.getResponsavel();
        String descricao = atividade.getDescrição();


        int atividadeID1 =  atividade.getId();
        String atividadeID = ""+atividadeID1;

        //eixoX += 15;

        Pane novaAtividade = new Pane();
        novaAtividade.setPrefSize(318, 104);
        novaAtividade.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novaAtividade.setLayoutX(3);
        novaAtividade.setLayoutY(eixoY);


        Label labelTituloCard = new Label(nomeAtividade);
        labelTituloCard.setLayoutX(22.0);
        labelTituloCard.setLayoutY(3.0);

        Label labelDescriçãoCard = new Label(descricao);
        labelDescriçãoCard.setLayoutX(30.0);
        labelDescriçãoCard.setLayoutY(20);
        labelDescriçãoCard.setPrefWidth(222.0);
        labelDescriçãoCard.setPrefHeight(29.0);
        labelDescriçãoCard.setWrapText(true);
        labelDescriçãoCard.setFont(new Font(9.0));


        Label labelInicio = new Label("Início: " );//+ dataInicio.toString());
        labelInicio.setLayoutX(24.0);
        labelInicio.setLayoutY(53.0);

        Label labelFim = new Label("Fim: "); // + dataFim.toString());
        labelFim.setLayoutX(120.0);
        labelFim.setLayoutY(53.0);

        Label labelStatus = new Label("Status: Normal");
        labelStatus.setLayoutX(23.0);
        labelStatus.setLayoutY(65.0);

        Label labelResponsavel = new Label("Responsável: " + responsavel);
        labelResponsavel.setLayoutX(23.0);
        labelResponsavel.setLayoutY(80);

        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(245.0);
        progressIndicator.setLayoutY(31.0);
        progressIndicator.setPrefHeight(59.0);
        progressIndicator.setPrefWidth(40.0);
        progressIndicator.setProgress(0);

        MenuButton menuButton = new MenuButton("");
        menuButton.setLayoutX(284.0);
        menuButton.setLayoutY(4.0);
        menuButton.setStyle("-fx-background-color: 0; -fx-cursor: hand;");

// Adicione a imagem à ImageInput do MenuButton
        ImageInput imageInput = new ImageInput();
        Image minhaImagem3pontos = new Image(getClass().getResourceAsStream("/Imagens/3pontos.png"));
        imageInput.setSource(minhaImagem3pontos);
        menuButton.setEffect(imageInput);

// Adicione itens ao MenuButton
        MenuItem detalhesItem = new MenuItem("Detalhes");
        MenuItem editarItem = new MenuItem("Editar");
        MenuItem deletarItem = new MenuItem("Deletar");

        detalhesItem.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                Main.mudarTela ("detalhes");
            }
        });
        editarItem.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                // Chama o método mudarTela da classe Main
                Main.mudarTela ("detalhes");
            }
        });
        deletarItem.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                System.out.println("");
            }
        });
        menuButton.getItems().addAll(detalhesItem, editarItem, deletarItem);


        // Adicione os Labels à Pane
        novaAtividade.getChildren().addAll(labelTituloCard, labelDescriçãoCard, labelInicio, labelFim, labelStatus, menuButton,labelResponsavel,progressIndicator);

        return novaAtividade;
    }
}
