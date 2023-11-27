package com.example.sistemakanban;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DetalhesController {

    private ProjetoController projetoController;

    // Método para configurar o controlador da tela ProjetoController
    public void setProjetoController(ProjetoController projetoController) {
        this.projetoController = projetoController;
    }

    // Método para utilizar os dados recebidos do ProjetoController
    public void usarDadosRecebidos(String tituloDoProjeto) {
        atv1.setText(tituloDoProjeto);

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
    private PieChart grafico1;
    @FXML
    private PieChart grafico2;
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
