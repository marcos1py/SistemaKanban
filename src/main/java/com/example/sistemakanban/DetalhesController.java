package com.example.sistemakanban;


import com.example.sistemakanban.classes.Atividade;
import com.example.sistemakanban.classes.Ação;
import com.example.sistemakanban.classes.Projeto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class DetalhesController {

    private ProjetoController projetoController;

    @FXML
    private VBox vboxPaneAçao;
    private AtividadeController atividadeController;


    public void setAtividadeController(AtividadeController atividadeController) {
        this.atividadeController = atividadeController;
    }

    // Método para configurar o controlador da tela ProjetoController
    public void setProjetoController(ProjetoController projetoController) {
        this.projetoController = projetoController;
    }
    public CheckBox newcheckBox(String idAtividade, String acao){
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Atividade " + idAtividade + ": " + acao);

        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {

            System.out.println("Ação para " + acao + " da Atividade " + idAtividade + " selecionada: " + newValue);
        });

        return checkBox;
    }
    @FXML
    private Label labelNomeAtividade;
    @FXML
    private Label idDaAtividade;
    public void receberDadosCheckBox1(String idAtividade, ObservableList<String> lista) {
        vboxPaneAçao.getChildren().clear();

        for (String acao : lista) {
            System.out.println(acao);
            CheckBox acaoTemporaria = newcheckBox(idAtividade, acao);
            vboxPaneAçao.getChildren().add(acaoTemporaria);

        }}


    public void receberDadosCheckBox(String nomeAtividade, int idDaAtividade1, ObservableList<String> listaAçao) {
        labelNomeAtividade.setText(nomeAtividade);
        idDaAtividade.setText(String.valueOf(idDaAtividade1));

        vboxPaneAçao.getChildren().clear(); // Limpa os projetos existentes antes de adicionar novos

        Atividade minhaAtividade = atividadeController.getAtividadeById(idDaAtividade1);

        if (minhaAtividade != null) {
            for (Ação ação : minhaAtividade.getAções()) {
                System.out.println("-------hk----"+ação.getNome());
                CheckBox acaoTemporaria = newcheckBox(idDaAtividade.getId(), String.valueOf(ação.getNome()));
                vboxPaneAçao.getChildren().add(acaoTemporaria);
            }
        }
    }
    public void usarDadosRecebidos(String tituloDoProjeto, String descriçãoDoProjeto,String inicio, String fim, String responsavel) {
        labelResponsavel.setText(responsavel);
        labelInicio.setText(inicio);
        labelFim.setText(fim);
        labelNomeAtividade.setText(tituloDoProjeto);
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
