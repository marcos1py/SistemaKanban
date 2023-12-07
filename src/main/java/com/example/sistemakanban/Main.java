package com.example.sistemakanban;

import com.example.sistemakanban.classes.GeraPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene detalhes;
    private static Stage stage;
    private static Scene projetos;
    private static Scene atividades;
    private static Scene empresas;
    private static Scene login;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        // Carregar FXML para ProjetoController
        FXMLLoader fxmlLoaderProjeto = new FXMLLoader(Main.class.getResource("Projetos.fxml"));
        projetos = new Scene(fxmlLoaderProjeto.load());
        ProjetoController projetoController = fxmlLoaderProjeto.getController();

        // Carregar FXML para DetalhesController
        FXMLLoader fxmlLoaderDetalhes = new FXMLLoader(Main.class.getResource("detalhes.fxml"));
        detalhes = new Scene(fxmlLoaderDetalhes.load());
        DetalhesController detalhesController = fxmlLoaderDetalhes.getController();

        // Configurar relacionamentos entre controladores
        detalhesController.setProjetoController(projetoController);
        projetoController.setDetalhesController(detalhesController);

        // Carregar FXML para EmpresasController
        FXMLLoader fxmlLoaderEmpresas = new FXMLLoader(Main.class.getResource("empresas.fxml"));
        empresas = new Scene(fxmlLoaderEmpresas.load());
        EmpresasController empresasController = fxmlLoaderEmpresas.getController();

        // Configurar relacionamentos entre controladores
        projetoController.setEmpresasController(empresasController);
        empresasController.setProjetoController(projetoController);



        // Carregar FXML para AtividadeController
        FXMLLoader fxmlLoaderAtividades = new FXMLLoader(Main.class.getResource("Atividades.fxml"));
        atividades = new Scene(fxmlLoaderAtividades.load());
        AtividadeController atividadeController = fxmlLoaderAtividades.getController();

        // Configurar relacionamentos entre controladores
        atividadeController.setDetalhesController(detalhesController);
        projetoController.setAtividadeController(atividadeController);
        detalhesController.setAtividadeController(atividadeController);

        atividadeController.setProjetoController(projetoController);

        // Carregar FXML para LoginController
        FXMLLoader fxmlLoaderLogin = new FXMLLoader(Main.class.getResource("Login.fxml"));
        login = new Scene(fxmlLoaderLogin.load());

        primaryStage.setTitle("Confia");

        Image icon = new Image(getClass().getResourceAsStream("/Imagens/logo.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.setScene(login);
        primaryStage.setMaximized(true);

        primaryStage.show();
    }

    public static void mudarTela(String scr) {
        switch (scr) {
            case "detalhes" -> stage.setScene(detalhes);
            case "projetos" -> stage.setScene(projetos);
            case "empresas" -> stage.setScene(empresas);
            case "atividades" -> stage.setScene(atividades);
            case "login" -> stage.setScene(login);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
