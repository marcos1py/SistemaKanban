package com.example.sistemakanban;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;




public class HelloController {
    @FXML
    private Pane kanbanPanel3;

    @FXML
    private Label labelDescriçaoCard;

    @FXML
    private Label labelDataInicio;

    @FXML
    private Label labelTituloCard;

    @FXML
    private Label labelStatus;

    @FXML
    private Label labelDataFim;

    @FXML
    private Label LabelResponsavel;
    @FXML
    private Pane kanbanPanel1;


    @FXML
    private Pane kanbanPanel2;

    @FXML
    private Pane atividade1;


    private double offsetX;
    private double offsetY;
    private Pane currentPanel;


    @FXML
    private Button adicionarButton;


    @FXML
    void adicionarButton(ActionEvent event) {

    }
    private void atualizarLabels() {
        labelDescriçaoCard.setText("Nova Descrição");
        labelDataInicio.setText("Nova Data de Início");
        labelTituloCard.setText("Novo Título");
        labelStatus.setText("Novo Status");
        labelDataFim.setText("Nova Data de Fim");
        LabelResponsavel.setText("Novo Responsável");
    }
    int contagem= 0;
    int eixoX = 15;
    int eixoY = 0;
    @FXML
    public void initialize() {

        atividade1.setOnMousePressed(event -> {

            offsetX = event.getSceneX() - atividade1.getLayoutX();
            offsetY = event.getSceneY() - atividade1.getLayoutY();

        });
        // Adicione um evento de arrastar o mouse
        atividade1.setOnMouseDragged(event -> {

            atividade1.setLayoutX(event.getSceneX() - offsetX);
            atividade1.setLayoutY(event.getSceneY() - offsetY);
        });

        // Adicione um evento de soltar o mouse
        atividade1.setOnMouseReleased(event -> {
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY());

            // Check if atividade1 is already a child of a panel and remove it if so
            if (atividade1.getParent() != null) {
                ((Pane) atividade1.getParent()).getChildren().remove(atividade1);
            }

            if (nearestPanel != null) {
                nearestPanel.getChildren().add(atividade1);
                atividade1.setLayoutX(15);
                atividade1.setLayoutY(70);
                currentPanel = nearestPanel;
            }
        });
        adicionarButton.setOnAction(event -> {
            Pane newAtividade = createNewAtividade(); // Create a new activity
            kanbanPanel1.getChildren().add(newAtividade); // Add the new activity to the first panel
        });
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

    private Pane findNearestPanel(double x, double y) {
        double distanceToPanel1 = calculateDistance(x, y, kanbanPanel1);
        double distanceToPanel2 = calculateDistance(x, y, kanbanPanel2);
        double distanceToPanel3 = calculateDistance(x, y, kanbanPanel3);

        double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));

        if (minDistance == distanceToPanel1) {
            return kanbanPanel1;
        } else if (minDistance == distanceToPanel2) {
            return kanbanPanel2;
        } else {
            return kanbanPanel3;
        }
    }

    private double calculateDistance(double x, double y, Pane panel) {
        double panelCenterX = panel.getLayoutX() + panel.getWidth() / 2;
        double panelCenterY = panel.getLayoutY() + panel.getHeight() / 2;
        return Math.sqrt(Math.pow(x - panelCenterX, 2) + Math.pow(y - panelCenterY, 2));
    }
}