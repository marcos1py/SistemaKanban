package com.example.sistemakanban;
import com.example.sistemakanban.classes.Atividade;

import com.example.sistemakanban.classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.parse;


public class AtividadeController {
    private GeraPane geraPane;
    private DetalhesController detalhesController;

    @FXML
    private Label idTotalProjetos;
    @FXML
    private Label idTotalAndamento;
    @FXML
    private Label idTotalConcluido;

    @FXML
    private Label idTotalAfazer;

    public void setDetalhesController(DetalhesController detalhesController) {
        this.detalhesController = detalhesController;
    }
    private ProjetoController projetoController;


    public void setProjetoController(ProjetoController projetoController) {
        this.projetoController = projetoController;
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
    private Label labelNomeProjeto;

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
    private Pane nav1;

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
    private Pane nav;

    @FXML
    private Pane dashbord;
    @FXML
    private Label labelDataInicio1;
    private double offsetX;
    private double offsetY;
    double x = 0, y = 0;
    int contagem;
    int eixoY = 0;
    private AtividadeController atividadeController;
    private EmpresasController empresasController;
    @FXML
    private TextField responsavelID;
    @FXML
    private TextField nomeID;
    @FXML
    private TextArea descriçaoInput;
    @FXML
    private ListView<Ação> listaAçoes;

    @FXML
    private ListView<String> listaAçoesData;
    @FXML
    private TextField açaoInput;
    @FXML
    private DatePicker inicioDefinidoAçao;
    @FXML
    private DatePicker fimDefinidoAçao;
    @FXML
    private DatePicker inicioDefinido;
    @FXML
    private DatePicker fimDefinido;
    @FXML
    private ListView<String> listaAçoesDataFn;
    @FXML
    private Label labelErro;
    @FXML
    public static Pane cardDeletar;
    @FXML
    private Pane cardDeletar1;
    @FXML
    private AnchorPane addPane;
    int numeroID = 0;
    int cont = 0;
    int total =0;
    private ObservableList<Ação> açoes;

    private ObservableList<String> dataFn;
    @FXML
    void btnVoltarprojetos(ActionEvent event) {
        Main.mudarTela("projetos");
    }

    @FXML
    private Label idDaProjeto;
    @FXML
    private Label labelInicio;
    @FXML
    private Label labelFim;
    public void usarDadosRecebidosProjeto(String nomeProjeto, int idDaProjeto1, LocalDate inicio, LocalDate fim) {


        labelNomeProjeto.setText("Projeto "+nomeProjeto);
        idDaProjeto.setText(String.valueOf(idDaProjeto1));
        labelFim.setText(String.valueOf(fim));
        labelInicio.setText(String.valueOf(inicio));


        anchorPanefazer.getChildren().clear();
        anchorPaneAndamento.getChildren().clear();
        anchorPaneConcluidas.getChildren().clear();

        Projeto meuProjeto = projetoController.getProjetoById(idDaProjeto1);

        if (meuProjeto != null) {
            for (Atividade atividade : meuProjeto.getAtividades()) {
                System.out.println("Atividade: " + atividade);

                if (atividade.getStatus() == "afazer"){
                    Pane newPane = newAtividade(atividade,meuProjeto);
                    mexerPane(newPane,atividade);
                    atividade.setStatus("afazer");
                    newPane.setStyle("-fx-background-color: #fff ;-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");
                    anchorPanefazer.getChildren().add(newPane);

                }
                if (atividade.getStatus() == "andamento"){
                    Pane newPane = newAtividade(atividade,meuProjeto);
                    mexerPane(newPane,atividade);
                    newPane.setStyle("-fx-background-color: #fff ;-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");
                    anchorPaneAndamento.getChildren().add(newPane);
                    atividade.setStatus("andamento");
                }
                if (atividade.getStatus() == "concluido"){
                    Pane newPane = newAtividade(atividade,meuProjeto);
                    mexerPane(newPane,atividade);
                    newPane.setStyle("-fx-background-color: #fff ;-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");
                    anchorPaneConcluidas.getChildren().add(newPane);
                    atividade.setStatus("concluido");

                }
            }
        }
        reorganizarAtividades(anchorPanefazer);
        reorganizarAtividades(anchorPaneAndamento);
        reorganizarAtividades(anchorPaneConcluidas);
        countActivities();
    }


    private ObservableList<String> dataIn;

    public void validador(LocalDate inicio, LocalDate fim) {

        if (inicio != null && fim != null) {
            if (inicio.isAfter(fim)) {
                System.out.println("nao");
            } else {
                System.out.println("Valido");
            }
        } else {
            System.out.println("Coloca as duas");
        }
    }

    @FXML
    void novoProjBtn(ActionEvent event) {
        addPane.setVisible(true);
        deixarBorrado();
    }
    @FXML
    void cancelarBtn(ActionEvent event) {
        addPane.setVisible(false);
        açoes.clear();
        dataFn.clear();
        dataIn.clear();
        limpaBorrado();
    }
    public static void ativarBtnDelet(){
        btnDeletar();
    }

    @FXML
    public static void btnDeletar() {
        cardDeletar.setVisible(true);
    }

    private void deixarBorrado() {
        BoxBlur boxBlur = new BoxBlur(5, 5, 2); // Ajuste os parâmetros conforme necessário
        System.out.println(paneAndamento.getEffectiveNodeOrientation());
        paneAndamento.setEffect(boxBlur);
        scrollpaneAndamento.setEffect(boxBlur);
        paneConcluidas.setEffect(boxBlur);
        scrollpaneConcluidas.setEffect(boxBlur);
        paneAfazer.setEffect(boxBlur);
        scrollpaneAfazer.setEffect(boxBlur);
        nav.setEffect(boxBlur);
        dashbord.setEffect(boxBlur);
        nav1.setEffect(boxBlur);
        labelNomeProjeto.setEffect(boxBlur);
    }
    private void limpaBorrado() {
        DropShadow dropShadow = new DropShadow();

        paneAndamento.setEffect(dropShadow);
        paneConcluidas.setEffect(dropShadow);
        paneAfazer.setEffect(dropShadow);

        scrollpaneConcluidas.setEffect(null);
        scrollpaneAndamento.setEffect(null);
        scrollpaneAfazer.setEffect(null);

        nav.setEffect(null);
        dashbord.setEffect(dropShadow);
        nav1.setEffect(null);
        labelNomeProjeto.setEffect(null);
    }
    private List<Atividade> listaAtividade = new ArrayList<>();


    public Atividade getAtividadeById(int id) {

        for (Atividade atividade : listaAtividade) {
            System.out.println("++++++++++++===");
            System.out.println(atividade.getNome());
            System.out.println(atividade.getId());
            System.out.println("++++++++++++===");

            if (atividade.getId() == id) {
                System.out.println(atividade.getId());
                return atividade;
            }
        }
        return null;
    }
    public void initialize() {
        dataIn = FXCollections.observableArrayList();
        açoes = FXCollections.observableArrayList();
        dataFn = FXCollections.observableArrayList();
        listaAçoes.setItems(açoes);
        listaAçoesData.setItems(dataIn);
        listaAçoesDataFn.setItems(dataFn);

        // Limpa o anchorPane antes de adicionar novas atividades
        anchorPanefazer.getChildren().clear();
        Validador.mskNumero(nomeID, 60);
        Validador.mskNumero(responsavelID, 40);
        Validador.mskNumero(açaoInput, 40);


    }
    int numeroIDAçao;
    public void btnAddAçao(ActionEvent event) {
        Ação addação = new Ação();

        LocalDate inicio = inicioDefinidoAçao.getValue();
        LocalDate fim = fimDefinidoAçao.getValue();
        if(inicio == null || fim == null || açaoInput.getText() == null){
            System.out.println("por favor corrija");
            addação.setNome(açaoInput.getText());
            addação.setDataInicio(inicio);
            addação.setDataFim(fim);
            numeroIDAçao += 1;
            addação.setId(numeroIDAçao);

            System.out.println(addação.getId());

            String dataFnFormat = fim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String dataInFormat = inicio.format((DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            Ação novaAção = new Ação();
            novaAção.setNome(açaoInput.getText());
            novaAção.setDataInicio(inicioDefinidoAçao.getValue());
            novaAção.setDataFim(fimDefinidoAçao.getValue());

            açoes.add(addação);
            dataFn.add(dataFnFormat);
            dataIn.add(dataInFormat);


            total++;

        }else{
            labelErroCampos.setVisible(true);
            }

        }




//@FXML
//private Projeto meuprojeto = new Projeto();

    public void cancelarDelet(ActionEvent event) {
        cardDeletar.setVisible(false);
        nomeID.clear();
        responsavelID.clear();
        descriçaoInput.clear();
        inicioDefinido.setValue(null);
        fimDefinido.setValue(null);
        labelErroCampos.setVisible(false);
        labelErroData.setVisible(false);
    }
    boolean valido;
    public  boolean validaData(LocalDate inicioAtv, LocalDate fimAtv, String inicio, String fim) {
        //Projeto projeto = new Projeto();

        System.out.println(inicio);
        System.out.println(fim);
        LocalDate inicioProj = parse(inicio);
        LocalDate fimProj = parse(fim);


            if (inicioAtv != null || fimAtv != null) {
                if (inicioProj.isAfter(inicioAtv)) {
                    System.out.println("NAO");
                    return false;
                } else if(fimProj.isBefore(fimAtv)) {
                    System.out.println("nao");
                    return false;

                }else{
                    System.out.println("marcos");
                    return true;
                }
            } else {

                return false;

            }
        }

    int count = 0;
    public void btnAddAtividade(ActionEvent event) {

        Atividade atividade = new Atividade();
        Projeto meuprojeto = new Projeto();

        numeroID += 1;
        atividade.setId(numeroID);

        atividade.setNome(nomeID.getText());
        atividade.setInícioDefinido(inicioDefinido.getValue());
        atividade.setFimDefinido(fimDefinido.getValue());
        atividade.setResponsavel(responsavelID.getText());
        atividade.setDescrição(descriçaoInput.getText());
        //atividade.setAções(açaoInput.getText());

        if(!nomeID.getText().equals("") && !responsavelID.getText().equals("") && !descriçaoInput.getText().equals("")) {
            if (validaData(atividade.getInícioDefinido(), atividade.getFimDefinido(), labelInicio.getText(), labelFim.getText())) {
                meuprojeto.adicionarAtividade(atividade);
                System.out.println("=============");

                int idProjetoSelecionada = Integer.parseInt(idDaProjeto.getText());
                if (projetoController != null) {
                    System.out.println(idProjetoSelecionada);
                    meuprojeto = projetoController.getProjetoById(idProjetoSelecionada);
                    if (meuprojeto != null) {
                        atividade.setProjeto(meuprojeto);
                        System.out.println("Projeto: " + meuprojeto.getTitulo());
                        System.out.println("Atividade:" + meuprojeto.getAtividades());
                        for (Atividade a : meuprojeto.getAtividades()) {
                            System.out.println("  ´´´´´´- " + a.getAções());
                        }
                        System.out.println("ID: " + idProjetoSelecionada);
                    } else {
                        System.err.println("Empresa não encontrada com o ID: " + idProjetoSelecionada);
                    }
                } else {
                    System.err.println("EmpresasController não está definido.");
                }
                System.out.println("=============");

                meuprojeto.addAtividade(atividade);
                listaAtividade.add(atividade);
                atividade.setAções(FXCollections.observableArrayList(açoes));
                // Convertendo a lista de Ação para uma lista de String
                ObservableList<String> stringsAcoes = FXCollections.observableArrayList();
                for (Ação acao : açoes) {
                    stringsAcoes.add(acao.toString());

                }

// Chamando o método com a lista de strings
                //detalhesController.receberDadosCheckBox(atividade.getNome(), atividade.getId(), stringsAcoes);

                Pane newPane = newAtividade(atividade, meuprojeto);
                mexerPane(newPane, atividade);
                anchorPanefazer.getChildren().add(newPane);
                reorganizarAtividades(anchorPanefazer);
                reorganizarAtividades(anchorPaneAndamento);
                reorganizarAtividades(anchorPaneConcluidas);
                countActivities();
                addPane.setVisible(false);
                açoes.clear();
                dataFn.clear();
                dataIn.clear();
                limpaBorrado();
                nomeID.clear();
                responsavelID.clear();
                descriçaoInput.clear();
                inicioDefinido.setValue(null);
                fimDefinido.setValue(null);
                labelErroCampos.setVisible(false);
                labelErroData.setVisible(false);
            } else {
                labelErroData.setVisible(true);
                labelErroCampos.setVisible(false);
            }
        }else{
            labelErroCampos.setVisible(true);
            labelErroData.setVisible(false);

        }
    }
    @FXML
    private Label labelErroCampos;
    @FXML
    private Label labelErroData;
    private void mexerPane(Pane atividade, Atividade atividade1) {


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
            Pane nearestPanel = findNearestPanel(event.getSceneX(), event.getSceneY(),atividade,atividade1);

            // Check if atividade is already a child of a panel and remove it if so
            if (atividade.getParent() != null) {
                ((Pane) atividade.getParent()).getChildren().remove(atividade);
            }
            if (nearestPanel != null) {
                nearestPanel.getChildren().add(atividade);
                System.out.println(nearestPanel);

                reorganizarAtividades(anchorPanefazer);
                reorganizarAtividades(anchorPaneAndamento);
                reorganizarAtividades(anchorPaneConcluidas);
                countActivities();
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
                double teste =  panel.getHeight();
                teste =+ spacing;
                panel.setPrefHeight(teste);
                spacing += 108;

            }
        }
    }
    @FXML
    private ProgressIndicator idProgreçoIndicador;
    private void countActivities() {
        int afazerCount = countActivitiesInPane(anchorPanefazer);
        int andamentoCount = countActivitiesInPane(anchorPaneAndamento);
        int concluidoCount = countActivitiesInPane(anchorPaneConcluidas);

        int totalActivities = afazerCount + andamentoCount + concluidoCount;

        double progress = (double) concluidoCount / totalActivities; // Calculate progress as a percentage

        idTotalProjetos.setText(String.valueOf(totalActivities));
        idTotalAfazer.setText(String.valueOf(afazerCount));
        idTotalAndamento.setText(String.valueOf(andamentoCount));
        idTotalConcluido.setText(String.valueOf(concluidoCount));

        idProgreçoIndicador.setProgress(progress); // Set the progress indicator

        System.out.println("Total de Atividades: " + totalActivities);
        System.out.println("Progresso: " + (int)(progress * 100) + "%");
    }

    private int countActivitiesInPane(Pane panel) {
        return (int) panel.getChildren().filtered(node -> node instanceof Pane).size();
    }
    private Map<String, Boolean> estadoCheckBoxes = new HashMap<>();

    @FXML
    void btnVoltar(ActionEvent event) {
        Main.mudarTela("atividades");
    }
    public Pane newAtividade(Atividade atividade, Projeto projeto) {
        atividade.setStatus("afazer");
        int contagem = 0;
        contagem = atividade.getId();


        contagem += 1;

        String nomeAtividade = atividade.getNome();
        LocalDate dataInicio = atividade.getInícioDefinido();
        dataInicio = inicioDefinido.getValue();
        String dataInFormat = dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataFim = atividade.getFimDefinido();
        dataInicio = fimDefinido.getValue();
        String dataFnFormat = dataFim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String responsavel = atividade.getResponsavel();
        String descricao = atividade.getDescrição();
        String area = atividade.getArea();


        int atividadeID1 =  atividade.getId();
        String atividadeID = ""+atividadeID1;

        //eixoX += 15;



        Pane novaAtividade = new Pane();
        novaAtividade.setPrefSize(318, 104);
        novaAtividade.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novaAtividade.setLayoutX(3);
        novaAtividade.setLayoutY(eixoY);



        Label labelTituloCard = new Label(nomeAtividade);
        labelTituloCard.setLayoutX(22.0);
        labelTituloCard.setLayoutY(3.0);

        Label labelDescriçãoCard = new Label(descricao);
        labelDescriçãoCard.setLayoutX(30.0);
        labelDescriçãoCard.setLayoutY(20);
        labelDescriçãoCard.setPrefWidth(222.0);
        labelDescriçãoCard.setPrefHeight(29.0);
        labelDescriçãoCard.setWrapText(true);
        labelDescriçãoCard.setFont(new Font(9.0));


        Label labelInicio = new Label("Início: " +dataInFormat);//+ dataInicio.toString());
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


        MenuButton menuButton = new MenuButton("");
        menuButton.setLayoutX(284.0);
        menuButton.setLayoutY(4.0);
        menuButton.setStyle("-fx-background-color: 0; -fx-cursor: hand;");

// Adicione a imagem à ImageInput do MenuButton
        ImageInput imageInput = new ImageInput();
        Image minhaImagem3pontos = new Image(getClass().getResourceAsStream("/Imagens/3pontos.png"));
        imageInput.setSource(minhaImagem3pontos);
        menuButton.setEffect(imageInput);

// Adicione itens ao MenuButton
        MenuItem detalhesItem = new MenuItem("Detalhes");
        MenuItem editarItem = new MenuItem("Editar");
        MenuItem deletarItem = new MenuItem("Deletar");

        detalhesItem.setOnAction (new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                detalhesController.usarDadosRecebidos(nomeAtividade,descricao,dataInFormat,dataFnFormat,responsavel);
                // Convertendo a lista de Ação para uma lista de String
                ObservableList<String> stringsAcoes = FXCollections.observableArrayList();
                ObservableList<Ação> listaAcoes = FXCollections.observableArrayList();

                for (Ação acao : açoes) {
                    stringsAcoes.add(acao.toString());
                    listaAcoes.add(acao);
                }

                // Chamando o método com a lista de strings

                detalhesController.receberDadosCheckBox(atividade.getNome(), atividade.getId(), stringsAcoes);
                for (int i = 0; i < stringsAcoes.size(); i++) {
                    String acaoStr = stringsAcoes.get(i);
                    Ação açaoReal = listaAcoes.get(i);

                    CheckBox checkBox = detalhesController.newcheckBox(String.valueOf(atividade.getId()), acaoStr, açaoReal);
                    estadoCheckBoxes.put(acaoStr, checkBox.isSelected());
                    System.out.println(checkBox.isSelected());
                }

                Main.mudarTela ("detalhes");
            }
        });
        editarItem.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                System.out.println("oi");
                addPane.setVisible(true);


            }
        });
        deletarItem.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                System.out.println("");
                ((Pane) novaAtividade.getParent()).getChildren().remove(novaAtividade);
                projeto.removerAtividades(atividade);
                countActivities();
            }
        });
        menuButton.getItems().addAll(detalhesItem, editarItem, deletarItem);


        // Adicione os Labels à Pane
        novaAtividade.getChildren().addAll(labelTituloCard, labelDescriçãoCard, labelInicio, labelFim, labelStatus, menuButton,labelResponsavel);

        return novaAtividade;
    }

    private Pane findNearestPanel(double x, double y,Pane atividade, Atividade atividade1) {
        try {

            double distanceToPanel1 = calculateDistance(x, y, paneAfazer);
            double distanceToPanel2 = calculateDistance(x, y, paneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, paneConcluidas);
            double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));

            if (minDistance == distanceToPanel1) {
                atividade.setStyle("-fx-background-color: #fff ;-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");
                Projeto meuProjeto = projetoController.getProjetoById(Integer.parseInt(idDaProjeto.getText()));

                atividade1.setStatus("afazer");
                return anchorPanefazer;

            } else if (minDistance == distanceToPanel2) {
                atividade.setStyle("-fx-background-color: #fff ;-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");
                Projeto meuProjeto = projetoController.getProjetoById(Integer.parseInt(idDaProjeto.getText()));

                atividade1.setStatus("andamento");
                return anchorPaneAndamento;

            } else {
                atividade.setStyle("-fx-background-color: #fff ;-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");
                Projeto meuProjeto = projetoController.getProjetoById(Integer.parseInt(idDaProjeto.getText()));

                atividade1.setStatus("concluido");
                return anchorPaneConcluidas;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Pane findNearestPanel2(double x, double y,Pane atividade) {
        try {
            double distanceToPanel1 = calculateDistance(x, y, paneAfazer);
            double distanceToPanel2 = calculateDistance(x, y, paneAndamento);
            double distanceToPanel3 = calculateDistance(x, y, paneConcluidas);

            double minDistance = Math.min(distanceToPanel1, Math.min(distanceToPanel2, distanceToPanel3));

            if (minDistance == distanceToPanel1) {
                atividade.setStyle("-fx-background-color: #fff ;-fx-border-color: black black black #0038FF;-fx-border-width: 1 1 1 10px;");

                return anchorPanefazer;

            } else if (minDistance == distanceToPanel2) {
                atividade.setStyle("-fx-background-color: #fff ;-fx-border-color:  black black black #ffc700;-fx-border-width: 1 1 1 10px;");

                return anchorPaneAndamento;

            } else {
                atividade.setStyle("-fx-background-color: #fff ;-fx-border-color:   black black black #41fa00;-fx-border-width: 1 1 1 10px;");

                return anchorPaneConcluidas;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private double calculateDistance(double x, double y, Pane panel) {
        if (panel == null) {
            // Adicione um tratamento adequado quando panel é nulo
            return Double.MAX_VALUE; // Ou outro valor representando uma "distância infinita"
        }

        double panelCenterX = panel.getLayoutX() + panel.getWidth() / 2;
        double panelCenterY = panel.getLayoutY() + panel.getHeight() / 2;
        return Math.sqrt(Math.pow(x - panelCenterX, 2) + Math.pow(y - panelCenterY, 2));
    }
}