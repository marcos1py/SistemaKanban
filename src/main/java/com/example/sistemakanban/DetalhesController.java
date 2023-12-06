package com.example.sistemakanban;


import com.example.sistemakanban.classes.Atividade;
import com.example.sistemakanban.classes.Ação;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

private int cont;
private int total;
double progresso;
    public double getPorcentagemProgresso() {
        return porcentagemProgresso;
    }
    public CheckBox newcheckBox(String idAtividade, String acao, Ação açaoReal){
        CheckBox checkBox = new CheckBox();
        checkBox.setText("Atividade " + idAtividade + ": " + acao);
        grafico2.getData().clear();
        cont= 0;
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            // Sua ação personalizada aqui
            System.out.println("Ação para " + acao + " da Atividade " + idAtividade + " selecionada: " + newValue);

            // Adicione sua lógica personalizada aqui
            if (newValue) {
                cont++;
                System.out.println("CheckBox marcado");
                açaoReal.setFeito("marcado");
            } else {
                cont--;
                System.out.println("CheckBox desmarcado");
                açaoReal.setFeito("desmarcado");
            }

            // Atualizar o progresso no gráfico 2
            updateGrafico2Progresso();


            System.out.println("Total " + total);
            System.out.println("Progresso " + progresso);
        });

        return checkBox;
    }

    private void updateGrafico2Progresso() {
        double percentualMarcado = cont * 100.0 / total;

        porcentagemProgresso = percentualMarcado;


        double percentualDesmarcado = 100.0 - percentualMarcado;



        PieChart.Data sliceMarcado = new PieChart.Data("Feito", percentualMarcado);
        PieChart.Data sliceDesmarcado = new PieChart.Data("Andamento", percentualDesmarcado);

        // Limpar os dados antigos
        grafico2.getData().clear();
        // Adicionar os novos dados
        grafico2.getData().addAll(sliceMarcado, sliceDesmarcado);

        sliceMarcado.getNode().setStyle("-fx-pie-color: #33a02c;");
        sliceDesmarcado.getNode().setStyle("-fx-pie-color: #1f78b4;");
    }
    private double porcentagemProgresso;

    public void receberDadosCheckBox(String nomeAtividade, int idDaAtividade1, ObservableList<String> listaAcao) {
        labelNomeAtividade.setText(nomeAtividade);
        idDaAtividade.setText(String.valueOf(idDaAtividade1));

        vboxPaneAçao.getChildren().clear();

        Atividade minhaAtividade = atividadeController.getAtividadeById(idDaAtividade1);
        double marcado = 0.0;
        double desmarcado = 0.0;

        for (Ação acao : minhaAtividade.getAções()) {
            if (acao.getfeito() == "marcado") {
                CheckBox acaoTemporaria = newcheckBox(String.valueOf(idDaAtividade1), String.valueOf(acao.getNome()), acao);
                acaoTemporaria.setSelected(true);
                vboxPaneAçao.getChildren().add(acaoTemporaria);
                marcado++;
            } else {
                CheckBox acaoTemporaria = newcheckBox(String.valueOf(idDaAtividade1), String.valueOf(acao.getNome()), acao);
                acaoTemporaria.setSelected(false);
                vboxPaneAçao.getChildren().add(acaoTemporaria);
                desmarcado++;
            }
        }

        // Atualizar o total com a soma de marcados e desmarcados
        total = (int) (marcado + desmarcado);

        // Atualizar o progresso no gráfico 2
        cont = (int) marcado; // Ajustar cont para o número inicial de marcados
        updateGrafico2Progresso();
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
        cont = 0;
    }
    @FXML
    public void Btnvoltar(ActionEvent event) {


        atividadeController.receberPorcentagem(idDaAtividade.getId(), porcentagemProgresso);

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
        PieChart.Data slice1 = new PieChart.Data("Andamento", 75.00);
        PieChart.Data slice2 = new PieChart.Data("Feito", 25.0);


        grafico2.getData().addAll(slice1, slice2);

        // Definir cores diretamente
        slice1.getNode().setStyle("-fx-pie-color: #1f78b4;");
        slice2.getNode().setStyle("-fx-pie-color: #33a02c;");
        grafico2.setLegendVisible(false);    }


}
