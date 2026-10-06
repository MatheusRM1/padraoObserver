package org.locacao;

import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void alugar(Locacao locacao) {
        locacao.addObserver(this);
    }

    public void update(Observable locacao) {
        this.ultimaNotificacao = this.nome + ", carro alugado " + locacao.toString();
    }
}
