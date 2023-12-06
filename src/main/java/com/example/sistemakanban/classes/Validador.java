package com.example.sistemakanban.classes;

import com.example.sistemakanban.AtividadeController;
import com.example.sistemakanban.ProjetoController;
import javafx.scene.control.DatePicker;

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







}
