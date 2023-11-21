package com.example.sistemakanban.classes;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class GeraPane {
    private Pane novoProjeto;
    private String tituloProj;
    private String descProj;
    private String area;
    private String responsavel;
    List<Pane> listaProjetos = new ArrayList<>();


    public GeraPane(){

    }



    public void addProjeto(Projeto projeto) {
        System.out.println();
//Pane novoProjeto = newProject(projeto.getTitulo(), projeto.getDescricao());
       // projeto.setPane(novoProjeto);
        //listaProjetos.add(novoProjeto);
    }

    public void removerProjeto(Projeto projeto) {
        listaProjetos.remove(projeto.getPane());
    }
    public List<Pane> getListaProjetos() {
        return listaProjetos;
    }
    public void setTituloProj(String tituloProj) {
        this.tituloProj = tituloProj;
    }

    public void setDescProj(String descProj) {
        this.descProj = descProj;
    }

    public String getDescProj() {
        return descProj;
    }

    public Pane getNovoProjeto() {
        return novoProjeto;
    }

    public String getTituloProj() {
        return tituloProj;
    }

    public void setNovoProjeto(Pane novoProjeto) {
        this.novoProjeto = novoProjeto;
    }
    public void addProjeto(Pane novoProjeto){
        listaProjetos.add(novoProjeto);
    }
    public void removerProjeto(Pane novoProjeto){
        listaProjetos.remove(novoProjeto);
    }
    public Pane newProject(Projeto  meuProjeto){
        int eixoY = 0;
        int contagem = 0;
        if (contagem == 0){
            eixoY = 70;
        }
        else {
            eixoY += 110;
        }
        contagem += 1;
        String nomePane = "projeto "+contagem;
        novoProjeto = new Pane();
        novoProjeto.setPrefSize(318, 104);
        novoProjeto.setStyle("-fx-border-color: black black black #0038FF; -fx-background-color: #fff; -fx-border-width: 1 1 1 10px;");
        novoProjeto.setLayoutX(15);
        novoProjeto.setLayoutY(eixoY);

        String tituloProj =  meuProjeto.getTitulo();

        Label labelTituloCard = new Label(tituloProj+" "+contagem);
        labelTituloCard.setLayoutX(22.0);
        labelTituloCard.setLayoutY(3.0);

        Label labelDescriçãoCard = new Label(descProj);
        labelDescriçãoCard.setLayoutX(23.0);
        labelDescriçãoCard.setLayoutY(27.0);
        labelDescriçãoCard.setPrefWidth(222.0);
        labelDescriçãoCard.setPrefHeight(29.0);
        labelDescriçãoCard.setWrapText(true);
        labelDescriçãoCard.setFont(new Font(9.0));





        // Adicione o novo nome como um identificador à nova Pane
        novoProjeto.setId(nomePane);

        // Adicione os Labels à Pane
        novoProjeto.getChildren().addAll(labelTituloCard, labelDescriçãoCard);




        return novoProjeto;
    }

}
