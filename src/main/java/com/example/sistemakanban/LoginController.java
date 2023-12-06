package com.example.sistemakanban;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane principal;
    @FXML
    private TextField usuarioTextField;

    @FXML
    private Label avisoSenhaErrada;

    @FXML
    private PasswordField  senhaPasswordField;
    @FXML
    void btnLogin(ActionEvent event) {
        String usuarioCorreto = "adm";
        String senhaCorreta = "adm";

        String usuarioDigitado = usuarioTextField.getText();
        String senhaDigitada = senhaPasswordField.getText();

        if (usuarioCorreto.equals(usuarioDigitado) && senhaCorreta.equals(senhaDigitada)) {
            Main.mudarTela("empresas");
        } else {
            // Lógica para lidar com credenciais incorretas (por exemplo, exibir uma mensagem de erro)
            avisoSenhaErrada.setOpacity(1);
        }
    }
}
