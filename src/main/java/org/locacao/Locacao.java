package org.locacao;

import java.util.Observable;

public class Locacao extends Observable {

    private Integer data;
    private Integer preco;
    private String carro;

    public Locacao(Integer data, Integer preco, String carro) {
        this.data = data;
        this.preco = preco;
        this.carro = carro;
    }

    public void alugado() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "data=" + data +
                ", preco=" + preco +
                ", carro='" + carro + '\'' +
                '}';
    }
}
