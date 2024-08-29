package org.example;

import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void inscreverNoProjeto(Projeto projeto) {
        projeto.addObserver(this);
    }

    @Override
    public void update(Observable projeto, Object arg1) {
        this.ultimaNotificacao = this.nome + ", atualização realizada no " + projeto.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}

