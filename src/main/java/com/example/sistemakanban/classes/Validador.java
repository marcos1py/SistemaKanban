package com.example.sistemakanban.classes;

import com.example.sistemakanban.AtividadeController;
import com.example.sistemakanban.ProjetoController;
import javafx.application.Platform;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.time.LocalDate.parse;

public class Validador {



    private static final String REGEX_NOME = "[a-zA-Z]+";

    private AtividadeController atividadeController;

    public  void validaData(LocalDate inicioAtv, LocalDate fimAtv, String inicio, String fim) {
        //Projeto projeto = new Projeto();

        System.out.println(inicio);
        System.out.println(fim);
        LocalDate inicioProj = parse(inicio);
        LocalDate fimProj = parse(fim);

        if(inicioProj.isAfter(inicioAtv) || fimProj.isBefore(fimAtv)){
            System.out.println("NO");
        }else {
            if (inicioAtv != null || fimAtv != null) {
                if (inicioAtv.isAfter(fimAtv)) {
                    System.out.println("O inicio é depois do começo");
                } else {
                    System.out.println("Valido");
                }
            } else {
                System.out.println("Alguma data nula");
            }
        }
    }

    public static boolean validarNome(String nome) {
        return nome.matches(REGEX_NOME);
    }
    private Set<String> nomesAtividades = new HashSet<>();
    private boolean validarNome1(String nome) {
        return !nomesAtividades.contains(nome);
    }



    private static void limiteTamanhoCampo(TextField txtfield, Integer tamanho) {
        txtfield.textProperty().addListener((observableValue, valorAntigo, novoValor) -> {
            if (novoValor == null || novoValor.length() > tamanho) {
                txtfield.setText(valorAntigo);
            }
        });
    }

    private static void posicionarCursor(TextField txtfield) {
        Platform.runLater(() -> {
            if (txtfield.getText().length() != 0) {
                txtfield.positionCaret(txtfield.getText().length());
            }
        });
    }

    public static void  mskNumero(TextField txtfield,int tamanho) {
        Validador.limiteTamanhoCampo(txtfield, tamanho);
        txtfield.lengthProperty().addListener((observable, valorAntigo, valorNovo) -> {
            String textoDigitado = txtfield.getText();
            textoDigitado = textoDigitado.replaceAll("[^a-zA-Z0-9]", "");
            txtfield.setText(textoDigitado);
            Validador.posicionarCursor(txtfield);
        });
    }
    public static void  mskLetra(TextField txtfield, int tamanho) {
        Validador.limiteTamanhoCampo(txtfield, tamanho);
        txtfield.lengthProperty().addListener((observable, valorAntigo, valorNovo) -> {
            String textoDigitado = txtfield.getText();
            textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
            txtfield.setText(textoDigitado);
            Validador.posicionarCursor(txtfield);
        });
    }
}




