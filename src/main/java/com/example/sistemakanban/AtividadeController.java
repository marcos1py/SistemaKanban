package com.example.sistemakanban;
import com.example.sistemakanban.classes.Atividade;
import com.example.sistemakanban.classes.Empresa;
import com.example.sistemakanban.classes.GeraPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.List;


public class AtividadeController {
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
        if (atividade1 != null) {
            mexerPane(atividade1);
        }
        if (atividade2 != null) {
            mexerPane(atividade2);
        }
        if (atividade3 != null) {
            mexerPane(atividade3);
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
    private Pane cardDeletar;
    @FXML
    private AnchorPane addPane;
    @FXML
    void novoProjBtn(ActionEvent event) {
        addPane.setVisible(true);
    }
    @FXML
    void cancelarBtn(ActionEvent event) {
        addPane.setVisible(false);
        limpaBorrado();
    }
    @FXML
    private void btnDeletar() {
        cardDeletar.setVisible(true);
        deixarBorrado();
    }
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
        cardDeletar.setVisible(false);

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
        limpaBorrado();
    }
    int numeroID = 0;
    public void btnAddAtividade(ActionEvent event) {

        Atividade atividade = new Atividade();
        GeraPane gerador = new GeraPane();

        numeroID += 1;
        atividade.setId(numeroID);

        atividade.setNome(nomeID.getText());
        atividade.setInícioDefinido(inicioDefinido.getValue());
        atividade.setFimDefinido(fimDefinido.getValue());
        atividade.setResponsavel(responsavelID.getText());
        atividade.setDescrição(descriçaoInput.getText());
        //atividade.setAções(açaoInput.getText());


        Pane newPane = gerador.newAtividade(atividade);

        anchorPanefazer.getChildren().add(newPane);


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