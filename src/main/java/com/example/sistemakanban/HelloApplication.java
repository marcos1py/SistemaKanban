package com.example.sistemakanban;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Scene detalhes;
    private static Stage stage;
    private static Scene projetos;

    private static Scene atividades;

    private static Scene empresas;

    private static Scene login;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;


        FXMLLoader fxmlLoaderProjeto = new FXMLLoader(HelloApplication.class.getResource("Projetos.fxml"));
        projetos = new Scene(fxmlLoaderProjeto.load());

        FXMLLoader fxmlLoaderDetalhes = new FXMLLoader(HelloApplication.class.getResource("detalhes.fxml"));
        detalhes = new Scene(fxmlLoaderDetalhes.load());

        FXMLLoader fxmlLoaderEmpresas = new FXMLLoader(HelloApplication.class.getResource("empresas.fxml"));
        empresas = new Scene(fxmlLoaderEmpresas.load());

        FXMLLoader fxmlLoaderAtividades = new FXMLLoader(HelloApplication.class.getResource("Atividades.fxml"));
        atividades = new Scene(fxmlLoaderAtividades.load());

        FXMLLoader fxmlLoaderLogin = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        login = new Scene(fxmlLoaderLogin.load());

        primaryStage.setTitle("Confia");

        Image icon = new Image(getClass().getResourceAsStream("/Imagens/icone deletar.png"));


        primaryStage.getIcons().add(icon);


        primaryStage.setScene(atividades);


        primaryStage.setMaximized(true);

        primaryStage.show();
    }
    public static void mudarTela(String scr){


        switch (scr) {
            case "detalhes" -> {

                stage.setScene(detalhes);
            }
            case "projetos" -> {

                stage.setScene(projetos);
            }
            case "empresas" -> {

                stage.setScene(empresas);
            }
            case "atividades" -> {

                stage.setScene(atividades);
            }
            case "login" -> {

                stage.setScene(login);

            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}