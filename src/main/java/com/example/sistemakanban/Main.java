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

        FXMLLoader fxmlLoaderProjeto = new FXMLLoader(Main.class.getResource("Projetos.fxml"));
        projetos = new Scene(fxmlLoaderProjeto.load());
        ProjetoController projetoController = fxmlLoaderProjeto.getController();

        FXMLLoader fxmlLoaderDetalhes = new FXMLLoader(Main.class.getResource("detalhes.fxml"));
        detalhes = new Scene(fxmlLoaderDetalhes.load());
        DetalhesController detalhesController = fxmlLoaderDetalhes.getController();

        detalhesController.setProjetoController(projetoController);
        projetoController.setDetalhesController(detalhesController);
        detalhesController.setProjetoController(projetoController);

        FXMLLoader fxmlLoaderEmpresas = new FXMLLoader(Main.class.getResource("empresas.fxml"));
        empresas = new Scene(fxmlLoaderEmpresas.load());

        FXMLLoader fxmlLoaderAtividades = new FXMLLoader(Main.class.getResource("Atividades.fxml"));
        atividades = new Scene(fxmlLoaderAtividades.load());
        AtividadeController atividadeController = fxmlLoaderAtividades.getController();
        atividadeController.setDetalhesController(detalhesController);

        FXMLLoader fxmlLoaderLogin = new FXMLLoader(Main.class.getResource("Login.fxml"));
        login = new Scene(fxmlLoaderLogin.load());

        primaryStage.setTitle("Confia");

        Image icon = new Image(getClass().getResourceAsStream("/Imagens/icone deletar.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.setScene(empresas);
        primaryStage.setMaximized(true);

        // Configurar controladores
        DetalhesController detalhesControllerInstance = fxmlLoaderDetalhes.getController();


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
