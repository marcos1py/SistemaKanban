package com.example.sistemakanban;


import com.example.sistemakanban.classes.Atividade;
import com.example.sistemakanban.classes.Ação;
import com.example.sistemakanban.classes.Projeto;
import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, Boolean> estadoCheckBoxes = new HashMap<>();
private int cont;
private int total;
double progresso;

    public CheckBox newcheckBox(String idAtividade, String acao){
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Atividade " + idAtividade + ": " + acao);

        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {

            // Sua ação personalizada aqui
            System.out.println("Ação para " + acao + " da Atividade " + idAtividade + " selecionada: " + newValue);

            // Adicione sua lógica personalizada aqui
            if (newValue) {
                cont++;
                System.out.println("CheckBox marcado");
                estadoCheckBoxes.put(acao,true);
                // Adicione mais lógica aqui, se necessário
            } else {
                cont--;
                System.out.println("CheckBox desmarcado");
                estadoCheckBoxes.put(acao,false);
                System.out.println("mmmmmmmm"+acao);

            }
            progresso = ((double) cont /total)*100;

            System.out.println("Total"+total);
            System.out.println("alooo"+progresso);


        });

        return checkBox;
    }

    public void receberDadosCheckBox(String nomeAtividade, int idDaAtividade1, ObservableList<String> listaAcao) {
        labelNomeAtividade.setText(nomeAtividade);
        idDaAtividade.setText(String.valueOf(idDaAtividade1));

        vboxPaneAçao.getChildren().clear();

        Atividade minhaAtividade = atividadeController.getAtividadeById(idDaAtividade1);

        for (Ação acao : minhaAtividade.getAções()) {
            System.out.println("-------hk----" + acao.getNome());
            CheckBox acaoTemporaria = newcheckBox(String.valueOf(idDaAtividade1), String.valueOf(acao.getNome()));

            // Restaurar o estado da CheckBox se já existir na lista
            if (listaAcao.contains(acao.getNome())) {
                acaoTemporaria.setSelected(true);
            }

            vboxPaneAçao.getChildren().add(acaoTemporaria);
            total++;


            System.out.println("Total"+total);




        }


    }








    @FXML
    private Label labelNomeAtividade;
    @FXML
    private Label idDaAtividade;
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
    private  PieChart grafico1;
    @FXML
    private  PieChart grafico2;
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
       PieChart.Data slice1 = new PieChart.Data("andamento", 75.00);
       PieChart.Data slice2 = new PieChart.Data("andamento", 25.0);

        PieChart.Data slice3 = new PieChart.Data("andamento", 75.0);
        PieChart.Data slice4 = new PieChart.Data("concluido", 25.0);

        grafico1.getData().addAll(slice3, slice4);
        grafico2.getData().addAll(slice1,slice2);

        // Outras inicializações, se necessário
    }


}
