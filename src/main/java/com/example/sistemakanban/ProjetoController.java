package com.example.sistemakanban;
import com.example.sistemakanban.classes.GeraPane;
import com.example.sistemakanban.classes.Projeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.util.List;


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
    @FXML
    private Pane dashboard;

    @FXML
    private Region nav;

    @FXML
    private Pane nav1;

    @FXML
    private Label title;

    @FXML
    private TextArea txtAreaDesc;

    @FXML
    private TextField txtFieldProjNome;
    private double offsetX;
    private double offsetY;
    double x = 0, y = 0;
    int contagem;
    int eixoY = 0;
    GeraPane novoPane = new GeraPane();
    @FXML
    private void initialize() {
        mexerPane(atividade1);
        mexerPane(atividade2);
        mexerPane(atividade3);

    }
    @FXML
    private AnchorPane addPane;
    List<Pane> listaProjetos = novoPane.getListaProjetos();



    @FXML
    void novoProjBtn(ActionEvent event) {

        addPane.setVisible(true);
        deixarBorrado();

    }

    @FXML
    void cancelarBtn(ActionEvent event) {

        addPane.setVisible(false);
        limparBorrado();
    }


    int numeroID2 = 0;
    @FXML
    void confirmarBtn(ActionEvent event) {

        GeraPane gerador = new GeraPane();

        Projeto meuProjeto = new Projeto( ) ;

        meuProjeto.setTitulo(txtFieldProjNome.getText());
        numeroID2 += 1;
        meuProjeto.setId(numeroID2);


        Pane teste = gerador.newProject(meuProjeto);

        anchorPaneConcluidas.getChildren().add(teste);




        addPane.setVisible(false);
        limparBorrado();

    }


    @FXML
    void datePickFim(ActionEvent event) {

    }

    @FXML
    void datePickInicio(ActionEvent event) {

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
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY(),atividade);

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

    private void deixarBorrado() {
        BoxBlur boxBlur = new BoxBlur(5, 5, 2); // Ajuste os parâmetros conforme necessário
        paneAndamento.setEffect(boxBlur);
        scrollpaneAndamento.setEffect(boxBlur);
        paneConcluidas.setEffect(boxBlur);
        scrollpaneConcluidas.setEffect(boxBlur);
        paneAfazer.setEffect(boxBlur);
        scrollpaneAfazer.setEffect(boxBlur);
        nav.setEffect(boxBlur);
        dashboard.setEffect(boxBlur);
        nav1.setEffect(boxBlur);
        title.setEffect(boxBlur);
    }
    public void limparBorrado() {
        DropShadow dropShadow = new DropShadow();


        paneAndamento.setEffect(dropShadow);
        paneConcluidas.setEffect(dropShadow);
        paneAfazer.setEffect(dropShadow);

        scrollpaneConcluidas.setEffect(null);
        scrollpaneAndamento.setEffect(null);
        scrollpaneAfazer.setEffect(null);

        nav.setEffect(null);
        dashboard.setEffect(dropShadow);
        nav1.setEffect(null);
        title.setEffect(null);
    }


    private Pane findNearestPanel(double x, double y,Pane projeto) {
        try {

            double distanceToPanel1 = calculateDistance(x, y, paneAfazer);
            double distanceToPanel2 = calculateDistance(x, y, paneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, paneConcluidas);


            double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));





            if (minDistance == distanceToPanel1) {
                projeto.setStyle("-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");

                return anchorPanefazer;

            } else if (minDistance == distanceToPanel2) {
                projeto.setStyle("-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");

                return anchorPaneAndamento;

            } else {
                projeto.setStyle("-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");

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

}