package com.example.sistemakanban;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.List;

public class DetalhesController {

    private ProjetoController projetoController;

    @FXML
    private AnchorPane anchorPaneAçao;

    // Método para configurar o controlador da tela ProjetoController
    public void setProjetoController(ProjetoController projetoController) {
        this.projetoController = projetoController;
    }
    public CheckBox newcheckBox(Object ação){
        CheckBox checkBox = new CheckBox();
        checkBox.setText((String) ação);

        return checkBox;
    }
    public void receberDadosCheckBox(ObservableList lista) {
        for (Object acao : lista) {
            System.out.println(acao);
            CheckBox açaoTemporaria = newcheckBox(acao);
            anchorPaneAçao.getChildren().add(açaoTemporaria);

        }
    }

    // Método para utilizar os dados recebidos do ProjetoController
    public void usarDadosRecebidos(String tituloDoProjeto, String descriçãoDoProjeto,String inicio, String fim,String area, String responsavel) {
        labelArea.setText(area);
        labelResponsavel.setText(responsavel);
        labelInicio.setText(inicio);
        labelFim.setText(fim);
        atv1.setText(tituloDoProjeto);
        txtArea.setText(descriçãoDoProjeto);
    }
    @FXML
    public void Btnvoltar(ActionEvent event) {

        Main.mudarTela("atividades");
    }
    @FXML
    private AnchorPane principal;

    @FXML
    private Label atv1;
    @FXML
    private Pane nav;
    @FXML
    private TextArea txtArea;
    @FXML
    private PieChart grafico1;
    @FXML
    private PieChart grafico2;
    @FXML
    private Label labelFim;
    @FXML
    private Label labelArea;
    @FXML
    private Label labelResponsavel;

    @FXML
    private Label labelInicio;
    @FXML
    private void initialize() {
        // Configurar dados do gráfico
        PieChart.Data slice1 = new PieChart.Data("andamento", 75.0);
        PieChart.Data slice2 = new PieChart.Data("concluido", 25.0);

        PieChart.Data slice3 = new PieChart.Data("andamento", 75.0);
        PieChart.Data slice4 = new PieChart.Data("concluido", 25.0);

        grafico1.getData().addAll(slice3, slice4);
        grafico2.getData().addAll(slice1, slice2);

        // Outras inicializações, se necessário
    }


}
