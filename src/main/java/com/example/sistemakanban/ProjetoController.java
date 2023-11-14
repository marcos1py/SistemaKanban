package com.example.sistemakanban;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ProjetoController {
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
    private AnchorPane princial;
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
    private Label labelDataInicio1;
    private double offsetX;
    private double offsetY;
    double x = 0, y = 0;
    int contagem;
    int eixoY = 0;
    @FXML
    private void initialize() {
        mexerPane(atividade1);
        mexerPane(atividade2);
        mexerPane(atividade3);
    }

    private void mexerPane(Pane atividade) {


        atividade.setOnMousePressed(event -> {
            System.out.println("Oi");


            offsetX = event.getSceneX() - atividade.getLayoutX();
            offsetY = event.getSceneY() - atividade.getLayoutY();

        });
        // Adicione um evento de arrastar o mouse
        atividade.setOnMouseDragged(event -> {
            System.out.println("Oi2");

            atividade.setLayoutX(event.getSceneX() - offsetX);
            atividade.setLayoutY(event.getSceneY() - offsetY);

        });

        // Adicione um evento de soltar o mouse
        atividade.setOnMouseReleased(event -> {
            System.out.println("Oi3");


            atividade.toFront();
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY());

            // Check if atividade is already a child of a panel and remove it if so
            if (atividade.getParent() != null) {
                ((Pane) atividade.getParent()).getChildren().remove(atividade);
            }
            double espaçamento = 0;
            if (nearestPanel != null) {
                nearestPanel.getChildren().add(atividade);

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
                spacing += 108;
            }
        }
    }



    private Pane findNearestPanel(double x, double y) {
        try {

            double distanceToPanel1 = calculateDistance(x, y, paneAfazer);
            double distanceToPanel2 = calculateDistance(x, y, paneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, paneConcluidas);


            double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));




            if (minDistance == distanceToPanel1) {
                System.out.println("painel1");
                return anchorPanefazer;
            } else if (minDistance == distanceToPanel2) {
                System.out.println("painel2");
                return anchorPaneAndamento;
            } else {
                System.out.println("painel3");
                return anchorPaneConcluidas;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private double calculateDistance(double x, double y, Pane panel) {
        double panelCenterX = panel.getLayoutX() + panel.getWidth() / 2;
        double panelCenterY = panel.getLayoutY() + panel.getHeight() / 2;
        return Math.sqrt(Math.pow(x - panelCenterX, 2) + Math.pow(y - panelCenterY, 2));
    }


    private Pane createNewAtividade() {
        // Create a new Pane for the activity


        if (contagem == 0){
            eixoY = 70;
        }
        else {
            eixoY += 110;
        }
        contagem += 1;
        String nomePane = "atividade" + contagem;

        //eixoX += 15;

        Pane novaAtividade = new Pane();
        novaAtividade.setPrefSize(318, 104);
        novaAtividade.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novaAtividade.setLayoutX(15);
        novaAtividade.setLayoutY(eixoY);


        Label labelTituloCard = new Label("Fazer a limpeza da sala"+contagem);
        labelTituloCard.setLayoutX(22.0);
        labelTituloCard.setLayoutY(3.0);

        Label labelDescriçãoCard = new Label("TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO ");
        labelDescriçãoCard.setLayoutX(23.0);
        labelDescriçãoCard.setLayoutY(27.0);
        labelDescriçãoCard.setPrefWidth(222.0);
        labelDescriçãoCard.setPrefHeight(29.0);
        labelDescriçãoCard.setWrapText(true);
        labelDescriçãoCard.setFont(new Font(9.0));



        // Adicione o novo nome como um identificador à nova Pane
        novaAtividade.setId(nomePane);

        // Adicione os Labels à Pane
        novaAtividade.getChildren().addAll(labelTituloCard, labelDescriçãoCard);

        return novaAtividade;
    }
}