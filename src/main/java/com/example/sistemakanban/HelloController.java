package com.example.sistemakanban;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


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
    private AnchorPane kanbanPanel11;

    @FXML
    private Pane kanbanPanel2;

    @FXML
    private Pane atividade1;



    private double offsetX;
    private double offsetY;
    private Pane currentPanel;

    private void atualizarLabels() {
        labelDescriçaoCard.setText("Nova Descrição");
        labelDataInicio.setText("Nova Data de Início");
        labelTituloCard.setText("Novo Título");
        labelStatus.setText("Novo Status");
        labelDataFim.setText("Nova Data de Fim");
        LabelResponsavel.setText("Novo Responsável");
    }

    @FXML
    public void initialize() {

        atividade1.setOnMouseClicked(event -> {

            System.out.println("Clique detectado no Pane!");
        });
     // Adicione um evento de pressionar o mouse para iniciar o arrastar e soltar

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
            System.out.println("teste2");
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

    }

    private Pane findNearestPanel(double x, double y) {
        double distanceToPanel1 = calculateDistance(x, y, kanbanPanel1);
        double distanceToPanel2 = calculateDistance(x, y, kanbanPanel2);
        double distanceToPanel3 = calculateDistance(x, y, kanbanPanel3);

        double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));

        if (minDistance == distanceToPanel1) {
            return kanbanPanel1;
        } else if ( minDistance == distanceToPanel2) {
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
