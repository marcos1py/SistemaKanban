package com.example.sistemakanban;


import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DetalhesController {

    @FXML
    private AnchorPane principal;

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


    }


}
