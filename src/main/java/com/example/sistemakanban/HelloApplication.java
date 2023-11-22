package com.example.sistemakanban;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
private static Scene detalhes;
    private static Stage stage;
    private static Scene projetos;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;


        FXMLLoader fxmlLoaderProjeto = new FXMLLoader(HelloApplication.class.getResource("Projetos.fxml"));
        projetos = new Scene(fxmlLoaderProjeto.load());








        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detalhes.fxml"));
        detalhes = new Scene(fxmlLoader.load());

        primaryStage.setTitle("Hello!");
        primaryStage.setScene(projetos);

        // Maximize a janela, mas permita que a barra de tarefas seja visível
        primaryStage.setMaximized(true);

        primaryStage.show();
    }
    public static void mudarTela(String scr){
        switch (scr){
            case "atividades":
                stage.setScene(detalhes);
                break;
            case "alo":
                stage.setScene(projetos);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
