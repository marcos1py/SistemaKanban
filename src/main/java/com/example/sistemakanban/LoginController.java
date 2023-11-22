package com.example.sistemakanban;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane principal;

    @FXML
    void btnLogin(ActionEvent event) {
        HelloApplication.mudarTela("empresas");
    }

}
