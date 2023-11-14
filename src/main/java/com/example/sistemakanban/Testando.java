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

import java.io.File;
import java.util.List;

public class Testando {
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
    private AnchorPane anchorPaneConcluidas;

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
    @FXML
    private void initialize() {
        setDragAndDropHandlers(atividade1);
        setDragAndDropHandlers(atividade2);
        arrastaItens(atividade3);
        setFileDragAndDropHandler(atividade1);
    }

    private void setFileDragAndDropHandler(Node node) {
        node.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != node && event.getDragboard().hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        node.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasFiles()) {
                    success = true;
                    List<File> files = db.getFiles();
                    // Faça algo com os arquivos aqui, se necessário
                    for (File file : files) {
                        System.out.println("Arquivo: " + file.getAbsolutePath());
                    }
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });
    }
    public void arrastaItens ( Pane  figuras ) {
        figuras.setOnMousePressed ( new EventHandler< MouseEvent >( ) {
            @Override
            public void handle ( MouseEvent mouseEvent ) {
                x = figuras.getLayoutX ( ) - mouseEvent.getSceneX ( );
                y = figuras.getLayoutY ( ) - mouseEvent.getSceneY ( );
                figuras.setCursor ( Cursor.CROSSHAIR );
            }
        } );
        figuras.setOnMouseReleased ( new EventHandler < MouseEvent > ( ) {
            @Override
            public void handle ( MouseEvent mouseEvent ) {
                figuras.setCursor ( Cursor.HAND );
            }
        } );
        figuras.setOnMouseDragged ( new EventHandler < MouseEvent > ( ) {
            @Override
            public void handle ( MouseEvent mouseEvent ) {
                figuras.setLayoutX ( mouseEvent.getSceneX ( ) + x );
                figuras.setLayoutY ( mouseEvent.getSceneY ( ) + y );
            }
        } );
    }

    private void setDragAndDropHandlers(Pane atividade) {

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
            System.out.println("teste2");
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY());

            // Check if atividade is already a child of a panel and remove it if so
            if (atividade.getParent() != null) {
                ((Pane) atividade.getParent()).getChildren().remove(atividade);
            }

            if (nearestPanel != null) {
                nearestPanel.getChildren().add(atividade);
                atividade.setLayoutX(15);
                atividade.setLayoutY(70);
                currentPanel = nearestPanel;
            }
        });
    }

    private Pane findNearestPanel(double x, double y) {
        try {
            double distanceToPanel1 = calculateDistance(x, y, anchorPanefazer);
            double distanceToPanel2 = calculateDistance(x, y, anchorPaneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, anchorPaneConcluidas);

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

    private double calculateDistance(double x, double y, AnchorPane panel) {
        double panelCenterX = panel.getLayoutX() + panel.getWidth() / 2;
        double panelCenterY = panel.getLayoutY() + panel.getHeight() / 2;
        return Math.sqrt(Math.pow(x - panelCenterX, 2) + Math.pow(y - panelCenterY, 2));
    }
}