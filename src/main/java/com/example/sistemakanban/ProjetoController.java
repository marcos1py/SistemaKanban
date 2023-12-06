package com.example.sistemakanban;
import com.example.sistemakanban.classes.Atividade;
import com.example.sistemakanban.classes.Empresa;
import com.example.sistemakanban.classes.GeraPane;
import com.example.sistemakanban.classes.Projeto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ProjetoController {
    private DetalhesController detalhesController;
    private GeraPane geraPane;
    private AtividadeController atividadeController;
    public void setAtividadeController(AtividadeController atividadeController) {
        this.atividadeController = atividadeController;
    }
    private EmpresasController empresasController;  // Adiciona esta linha
    public void setEmpresasController(EmpresasController empresasController) {
        this.empresasController = empresasController;
    }
    // Método para configurar o controlador da tela ProjetoController
    public void setDetalhesController(DetalhesController detalhesController) {
        this.detalhesController = detalhesController;
    }
    public void setGeraPane(GeraPane geraPane) {
        this.geraPane = geraPane;
    }


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
    private DatePicker datePickFim;

    @FXML
    private DatePicker datePickInicio;
    private List<Projeto> listaProjeto = new ArrayList<>();
    int numeroID = 0;
    public Projeto getProjetoById(int id) {

        for (Projeto projeto : listaProjeto) {

            if (projeto.getId() == id) {
                return projeto;
            }
        }
        return null;
    }
    int eixoYAFazer = 0;
    int eixoYAndamento = 0;
    int eixoYConcluido = 0;
    int cont = 0;
    public void usarDadosRecebidosEmpresa(String nomeEmpresa, int idDaEmpresa1) {

        title.setText("Projetos da empresa "+nomeEmpresa);
        idDaEmpresa.setText(String.valueOf(idDaEmpresa1));


        anchorPanefazer.getChildren().clear(); // Limpa os projetos existentes antes de adicionar novos
        anchorPaneAndamento.getChildren().clear(); // Limpa os projetos existentes antes de adicionar novos
        anchorPaneConcluidas.getChildren().clear(); // Limpa os projetos existentes antes de adicionar novos

        Empresa minhaEmpresa = empresasController.getEmpresaById(idDaEmpresa1);


        // Verifica se a empresa foi encontrada
        if (minhaEmpresa != null) {

            for (Projeto projeto : minhaEmpresa.getProjetos()) {

                if (projeto.getStatus() == "afazer"){


                    Pane newPane = newProject(projeto);
                    mexerPane(newPane,projeto);
                    projeto.setStatus("afazer");
                    newPane.setStyle("-fx-background-color: #fff ;-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");
                    newPane.setLayoutY(eixoY);
                    anchorPanefazer.getChildren().add(newPane);


                }
                if (projeto.getStatus() == "andamento"){
                    Pane newPane = newProject(projeto);
                    mexerPane(newPane,projeto);
                    newPane.setStyle("-fx-background-color: #fff ;-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");
                    newPane.setLayoutY(eixoYAndamento);
                    anchorPaneAndamento.getChildren().add(newPane);
                    projeto.setStatus("andamento");
                    eixoYAndamento+=110;


                }
                if (projeto.getStatus() == "concluido"){
                    Pane newPane = newProject(projeto);
                    mexerPane(newPane,projeto);
                    newPane.setStyle("-fx-background-color: #fff ;-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");
                    newPane.setLayoutY(eixoYConcluido);
                    anchorPaneConcluidas.getChildren().add(newPane);
                    projeto.setStatus("concluido");
                    eixoYConcluido+=110;

                }
            }
        }
    }

    @FXML
    private Label idDaEmpresa;
    @FXML
    private Label empresaNome;
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
    private TextField txtFieldResp;
    @FXML
    private void initialize() {
    }
    @FXML
    private AnchorPane addPane;
    @FXML
    private int count;

    @FXML
    void novoProjBtn(ActionEvent event) {

        addPane.setVisible(true);
        deixarBorrado();

    }
    @FXML
    void btnVoltar(ActionEvent event) {
        Main.mudarTela("empresas");
        System.out.println("alou"+eixoYAFazer);
        eixoY = 0;
        eixoYAndamento = 0;
        eixoYConcluido = 0;


    }
    @FXML
    void cancelarBtn(ActionEvent event) {

        addPane.setVisible(false);
        limparBorrado();
    }



    @FXML
    void confirmarBtn(ActionEvent event) {
        Projeto projeto = new Projeto();
        Empresa minhaEmpresa = new Empresa();

        numeroID += 1;
        projeto.setId(numeroID);

        projeto.setTitulo(txtFieldProjNome.getText());
        projeto.setInicioDefinido(datePickInicio.getValue());
        projeto.setFimDefinido(datePickFim.getValue());
        projeto.setResponsavel(txtFieldResp.getText());
        projeto.setDescricao(txtAreaDesc.getText());

        try {
            int idEmpresaSelecionada = Integer.parseInt(idDaEmpresa.getText());
            if (empresasController != null) {
                minhaEmpresa = empresasController.getEmpresaById(idEmpresaSelecionada);
                if (minhaEmpresa != null) {
                    projeto.setEmpresa(minhaEmpresa);
                    projeto.setStatus("Afazer");
                } else {
                    System.err.println("Empresa não encontrada com o ID: " + idEmpresaSelecionada);
                }
            } else {
                System.err.println("EmpresasController não está definido.");
            }
        } catch (NumberFormatException e) {
            System.err.println("O ID da empresa não é um número válido");
        }

            Pane newPane = newProject(projeto);
            minhaEmpresa.addProjeto(projeto);
            listaProjeto.add(projeto);

        anchorPanefazer.getChildren().add(newPane);
            mexerPane(newPane,projeto);
            addPane.setVisible(false);
            limparBorrado();
            count = (int) anchorPanefazer.getChildren().stream().filter(node -> node instanceof Pane).count();
        System.out.println("COUNT:"+count);
        reorganizarAtividades(anchorPanefazer);
        reorganizarAtividades(anchorPaneAndamento);
        reorganizarAtividades(anchorPaneConcluidas);



    }
    private void mexerPane(Pane atividade, Projeto projeto1) {


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
            atividade.toFront();
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY(),atividade,projeto1);


            // Check if atividade is already a child of a panel and remove it if so
            if (atividade.getParent() != null) {
                ((Pane) atividade.getParent()).getChildren().remove(atividade);
            }
            double espaçamento = 0;
            if (nearestPanel != null) {
                nearestPanel.getChildren().add(atividade);
                System.out.println("Anchorpane ="+nearestPanel);
                reorganizarAtividades(anchorPanefazer);
                reorganizarAtividades(anchorPaneAndamento);
                reorganizarAtividades(anchorPaneConcluidas);
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


    int contConcluido = 0;

    private Pane findNearestPanel(double x, double y,Pane projeto, Projeto projeto1) {
        try {



            double distanceToPanel1 = calculateDistance(x, y, paneAfazer);
            double distanceToPanel2 = calculateDistance(x, y, paneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, paneConcluidas);
            double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));

            if (minDistance == distanceToPanel1) {
                projeto.setStyle("-fx-background-color: #fff ;-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");
                Empresa minhaEmpresa = empresasController.getEmpresaById(Integer.parseInt(idDaEmpresa.getText()));
                System.out.println("BLALVALLALA");

                projeto1.setStatus("afazer");
                // Verifica se a empresa foi encontrada
                if (minhaEmpresa != null) {
                    int contAfazer = 0;
                    for (Projeto projetos : minhaEmpresa.getProjetos()) {
                        if (projetos.getStatus() == "afazer"){

                           count = (int) anchorPanefazer.getChildren().stream().filter(node -> node instanceof Pane).count();

                            System.out.println("Projetos que estao no afazer:"+projetos);
                        }
                    }
                }
                return anchorPanefazer;

            } else if (minDistance == distanceToPanel2) {
                projeto.setStyle("-fx-background-color: #fff ;-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");
                Empresa minhaEmpresa = empresasController.getEmpresaById(Integer.parseInt(idDaEmpresa.getText()));


                projeto1.setStatus("andamento");
                // Verifica se a empresa foi encontrada
                if (minhaEmpresa != null) {

                    for (Projeto projetos : minhaEmpresa.getProjetos()) {
                        if (projetos.getStatus() == "andamento"){

                                int aux = count;
                                count -= 1;


                                System.out.println("AaADADADADA "+count);
                                System.out.println("eixoY: "+eixoY);


                        }
                    }
                }
                return anchorPaneAndamento;

            } else {
                projeto.setStyle("-fx-background-color: #fff ;-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");
                Empresa minhaEmpresa = empresasController.getEmpresaById(Integer.parseInt(idDaEmpresa.getText()));


                projeto1.setStatus("concluido");
                // Verifica se a empresa foi encontrada
                if (minhaEmpresa != null) {

                    for (Projeto projetos : minhaEmpresa.getProjetos()) {
                        if (projetos.getStatus() == "concluido"){
                            projeto.layoutYProperty().addListener((observable,oldValue,newValue) ->{
                                System.out.println("Mudou con:"+eixoYConcluido);
                                eixoYAndamento -= 110;
                            });
                            System.out.println("concluida"+contConcluido);
                            System.out.println("Projetos que estao no concluido:"+projetos);
                        }
                    }
                }
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

    public Pane newProject(Projeto  meuProjeto){
        int contagem = 0;
        contagem = meuProjeto.getId();
        count = (int) anchorPanefazer.getChildren().stream().filter(node -> node instanceof Pane).count();


        meuProjeto.setStatus("afazer");

        String nomePane = "projeto "+contagem;



        Pane novoProjeto = new Pane();
        novoProjeto.setPrefSize(318, 104);
        novoProjeto.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novoProjeto.setLayoutX(15);
        novoProjeto.setLayoutY(eixoY);


        String tituloProj =  meuProjeto.getTitulo();
        LocalDate inicio = meuProjeto.getInicioDefinido();
        inicio = datePickInicio.getValue();
        String dataInFormat = inicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fim = meuProjeto.getFimDefinido();
        fim = datePickFim.getValue();
        String dataFnFormat = fim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String area = meuProjeto.getArea();
        String responsavel = meuProjeto.getResponsavel();
        String descrição = meuProjeto.getDescricao();


        Hyperlink labelTituloCard = new Hyperlink (tituloProj);
        labelTituloCard.setLayoutX(22.0);
        labelTituloCard.setLayoutY(3.0);
        labelTituloCard.setOnMouseClicked (new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent event) {
                atividadeController.usarDadosRecebidosProjeto(meuProjeto.getTitulo(), meuProjeto.getId(),meuProjeto.getInicioDefinido(),meuProjeto.getFimDefinido());

                Main.mudarTela("atividades");
            }
        });
        Label labelDescriçãoCard = new Label(descrição);
        labelDescriçãoCard.setLayoutX(23.0);
        labelDescriçãoCard.setLayoutY(27.0);
        labelDescriçãoCard.setPrefWidth(222.0);
        labelDescriçãoCard.setPrefHeight(29.0);
        labelDescriçãoCard.setWrapText(true);
        labelDescriçãoCard.setFont(new Font(9.0));

        Label labelInicio = new Label("Início: "+dataInFormat);//+ dataInicio.toString());
        labelInicio.setLayoutX(24.0);
        labelInicio.setLayoutY(53.0);

        Label labelFim = new Label("Fim: "+dataFnFormat); // + dataFim.toString());
        labelFim.setLayoutX(120.0);
        labelFim.setLayoutY(53.0);

        Label labelStatus = new Label("Status: Normal");
        labelStatus.setLayoutX(23.0);
        labelStatus.setLayoutY(65.0);

        Label labelResponsavel = new Label("Responsável: " + responsavel);
        labelResponsavel.setLayoutX(23.0);
        labelResponsavel.setLayoutY(80);

        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(245.0);
        progressIndicator.setLayoutY(31.0);
        progressIndicator.setPrefHeight(59.0);
        progressIndicator.setPrefWidth(40.0);
        progressIndicator.setProgress(0);

        // Adicione o novo nome como um identificador à nova Pane
        novoProjeto.setId(nomePane);

        // Adicione os Labels à Pane
        novoProjeto.getChildren().addAll(labelTituloCard, labelDescriçãoCard,labelInicio,labelFim,labelStatus,labelResponsavel,progressIndicator);

        return novoProjeto;
    }

}