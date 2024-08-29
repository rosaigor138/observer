package org.example;

import java.util.Observable;

public class Projeto extends Observable {

    private String nomeProjeto;
    private String descricao;
    private String status;

    public Projeto(String nomeProjeto, String descricao) {
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.status = "Iniciado";
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "nomeProjeto='" + nomeProjeto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
