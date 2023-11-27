package com.example.sistemakanban;
import com.example.sistemakanban.classes.Atividade;
import com.example.sistemakanban.classes.GeraPane;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.jar.Manifest;


public class AtividadeController {
    private DetalhesController detalhesController;
    private GeraPane geraPane;

    // Método para configurar o controlador da tela ProjetoController
    public void setDetalhesController(DetalhesController detalhesController) {
        this.detalhesController = detalhesController;
    }
    @FXML
    private Label LabelResponsavel1;

    @FXML
    private Label labelStatus11;

    @FXML
    private Label LabelResponsavel;

    @FXML
    private Label labelTituloCard11;

    @FXML
    private AnchorPane anchorPanefazer;

    @FXML
    private ScrollPane scrollpaneAndamento;
    @FXML
    private ScrollPane testea;


    @FXML
    private Label labelDataInicio11;

    @FXML
    private Label labelDescriçaoCard;

    @FXML
    private Label labelDescriçaoCard11;

    @FXML
    private Label labelDataInicio;
    @FXML
    private Label title;

    @FXML
    private AnchorPane anchorPaneAndamento;

    @FXML
    private ScrollPane scrollpaneAfazer;

    @FXML
    private Label labelDataFim11;

    @FXML
    private Label labelDataFim;

    @FXML
    private Pane atividade3;
    @FXML
    private Pane nav1;

    @FXML
    private Label labelTituloCard1;

    @FXML
    private ScrollPane scrollpaneConcluidas;

    @FXML
    private Pane atividade1;

    @FXML
    private Pane atividade2;

    @FXML
    private Label labelStatus;
    @FXML
    private AnchorPane principal;

    @FXML
    private AnchorPane anchorPaneConcluidas;

    @FXML
    private Pane paneAfazer;
    @FXML
    private Pane paneConcluidas;
    @FXML
    private Pane paneAndamento;
    @FXML
    private Label labelStatus1;
    private Pane currentPanel;
    @FXML
    private Label LabelResponsavel11;

    @FXML
    private Label labelDescriçaoCard1;

    @FXML
    private Label labelDataFim1;

    @FXML
    private Label labelTituloCard;
    @FXML
    private Pane nav;

    @FXML
    private Pane dashbord;
    @FXML
    private Label labelDataInicio1;
    private double offsetX;
    private double offsetY;
    double x = 0, y = 0;
    int contagem;
    int eixoY = 0;
    @FXML
    private void initialize() {

        ObservableList<Node> children = anchorPanefazer.getChildren();

        for (Node node : children) {
            if (node instanceof Pane) {
                System.out.println(node);
                mexerPane((Pane) node);
            }
        }
    }
    @FXML
    private TextField responsavelID;
    @FXML
    private TextField nomeID;
    @FXML
    private TextArea descriçaoInput;
    @FXML
    private ListView<?> listaAçoes;
    @FXML
    private TextField açaoInput;
    @FXML
    private DatePicker inicioDefinidoAçao;
    @FXML
    private DatePicker fimDefinidoAçao;
    @FXML
    private DatePicker inicioDefinido;
    @FXML
    private DatePicker fimDefinido;
    @FXML
    public static Pane cardDeletar;
    @FXML
    private AnchorPane addPane;
    @FXML
    void novoProjBtn(ActionEvent event) {
        addPane.setVisible(true);
        deixarBorrado();
    }
    @FXML
    void cancelarBtn(ActionEvent event) {
        addPane.setVisible(false);
        limpaBorrado();
    }
    public static void ativarBtnDelet(){
        btnDeletar();
    }

    @FXML
    public static void btnDeletar() {
        cardDeletar.setVisible(true);

    }

    private AtividadeController atividadeController;
    private EmpresasController empresasController;



    private void deixarBorrado() {
        BoxBlur boxBlur = new BoxBlur(5, 5, 2); // Ajuste os parâmetros conforme necessário
        System.out.println(paneAndamento.getEffectiveNodeOrientation());
        paneAndamento.setEffect(boxBlur);
        scrollpaneAndamento.setEffect(boxBlur);
        paneConcluidas.setEffect(boxBlur);
        scrollpaneConcluidas.setEffect(boxBlur);
        paneAfazer.setEffect(boxBlur);
        scrollpaneAfazer.setEffect(boxBlur);
        nav.setEffect(boxBlur);
        dashbord.setEffect(boxBlur);
        nav1.setEffect(boxBlur);
        title.setEffect(boxBlur);
    }
    private void limpaBorrado() {
        DropShadow dropShadow = new DropShadow();

        paneAndamento.setEffect(dropShadow);
        paneConcluidas.setEffect(dropShadow);
        paneAfazer.setEffect(dropShadow);

        scrollpaneConcluidas.setEffect(null);
        scrollpaneAndamento.setEffect(null);
        scrollpaneAfazer.setEffect(null);

        nav.setEffect(null);
        dashbord.setEffect(dropShadow);
        nav1.setEffect(null);
        title.setEffect(null);
    }
    public void btnAddAçao(ActionEvent event) {

    }

    public void cancelarDelet(ActionEvent event) {
        cardDeletar.setVisible(false);
    }
    int numeroID = 0;
    public void btnAddAtividade(ActionEvent event) {

        Atividade atividade = new Atividade();


        numeroID += 1;
        atividade.setId(numeroID);

        atividade.setNome(nomeID.getText());
        atividade.setInícioDefinido(inicioDefinido.getValue());
        atividade.setFimDefinido(fimDefinido.getValue());
        atividade.setResponsavel(responsavelID.getText());
        atividade.setDescrição(descriçaoInput.getText());
        //atividade.setAções(açaoInput.getText());

        Pane newPane = newAtividade(atividade);

        anchorPanefazer.getChildren().add(newPane);
        addPane.setVisible(false);
        limpaBorrado();

    }
    private void mexerPane(Pane atividade) {


        atividade.setOnMousePressed(event -> {
            offsetX = event.getSceneX() - atividade.getLayoutX();
            offsetY = event.getSceneY() - atividade.getLayoutY();

        });

        // Adicione um evento de arrastar o mouse
        atividade.setOnMouseDragged(event -> {
            atividade.setLayoutX(event.getSceneX() - offsetX);
            atividade.setLayoutY(event.getSceneY() - offsetY);
        });

        // Adicione um evento de soltar o mouse
        atividade.setOnMouseReleased(event -> {
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY(),atividade);

            // Check if atividade is already a child of a panel and remove it if so
            if (atividade.getParent() != null) {
                ((Pane) atividade.getParent()).getChildren().remove(atividade);
            }
            if (nearestPanel != null) {
                nearestPanel.getChildren().add(atividade);
                System.out.println(nearestPanel);

                reorganizarAtividades(nearestPanel);
                currentPanel = nearestPanel;

            }


        });
    }

    private void reorganizarAtividades(Pane panel) {
        List<Node> atividades = panel.getChildren().filtered(node -> node instanceof Pane);
        double spacing = 0;

        for (Node node : atividades) {

            if (node instanceof Pane) {
                node.setLayoutX(3);
                node.setLayoutY(spacing);
                double teste =  panel.getHeight();
                teste =+ spacing;
                panel.setPrefHeight(teste);
                spacing += 108;

            }
        }
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
        dataInicio = inicioDefinido.getValue();
        String dataInFormat = dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataFim = atividade.getFimDefinido();
        dataInicio = fimDefinido.getValue();
        String dataFnFormat = dataFim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String responsavel = atividade.getResponsavel();
        String descricao = atividade.getDescrição();
        String area = atividade.getArea();


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

        detalhesItem.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                detalhesController.usarDadosRecebidos(nomeAtividade,descricao,dataInFormat,dataFnFormat,area,responsavel);


                Main.mudarTela ("detalhes");
            }
        });
        editarItem.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                System.out.println("oi");
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

    private Pane findNearestPanel(double x, double y,Pane atividade) {
        try {
            double distanceToPanel1 = calculateDistance(x, y, paneAfazer);
            double distanceToPanel2 = calculateDistance(x, y, paneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, paneConcluidas);

            double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));

            if (minDistance == distanceToPanel1) {
                atividade.setStyle("-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");

                return anchorPanefazer;

            } else if (minDistance == distanceToPanel2) {
                atividade.setStyle("-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");

                return anchorPaneAndamento;

            } else {
                atividade.setStyle("-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");

                return anchorPaneConcluidas;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private double calculateDistance(double x, double y, Pane panel) {
        if (panel == null) {
            // Adicione um tratamento adequado quando panel é nulo
            return Double.MAX_VALUE; // Ou outro valor representando uma "distância infinita"
        }

        double panelCenterX = panel.getLayoutX() + panel.getWidth() / 2;
        double panelCenterY = panel.getLayoutY() + panel.getHeight() / 2;
        return Math.sqrt(Math.pow(x - panelCenterX, 2) + Math.pow(y - panelCenterY, 2));
    }
}