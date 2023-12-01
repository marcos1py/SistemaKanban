package com.example.sistemakanban.classes;

import com.example.sistemakanban.AtividadeController;
import com.example.sistemakanban.ProjetoController;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Validador {



    private static final String REGEX_NOME = "[a-zA-Z]+";

    private AtividadeController atividadeController;

    public void validaData(DatePicker inicioDefinido, DatePicker fimDefinido) {
        Projeto projeto = new Projeto();


        LocalDate inicio = inicioDefinido.getValue();
        LocalDate fim = fimDefinido.getValue();

        if(projeto.getInicioDefinido().isAfter(inicio) || projeto.getFimDefinido().isBefore(fim)){
            System.out.println("NO");
        }else {
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
    }

    public static boolean validarNome(String nome) {
        return nome.matches(REGEX_NOME);
    }
    private Set<String> nomesAtividades = new HashSet<>();
    private boolean validarNome1(String nome) {
        return !nomesAtividades.contains(nome);
    }







}
