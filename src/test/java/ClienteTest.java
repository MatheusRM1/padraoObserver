package org.locacao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Locacao locacao = new Locacao(20231025, 150, "Fusca");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.alugar(locacao);
        locacao.alugado();

        assertEquals("Cliente 1, carro alugado Locacao{data=20231025, preco=150, carro='Fusca'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Locacao locacao = new Locacao(20231025, 150, "Fusca");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        cliente1.alugar(locacao);
        cliente2.alugar(locacao);
        locacao.alugado();

        assertEquals("Cliente 1, carro alugado Locacao{data=20231025, preco=150, carro='Fusca'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, carro alugado Locacao{data=20231025, preco=150, carro='Fusca'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Locacao locacao = new Locacao(20231025, 150, "Fusca");
        Cliente cliente = new Cliente("Cliente 1");

        locacao.alugado();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteLocacaoA() {
        Locacao locacaoA = new Locacao(20231025, 150, "Fusca");
        Locacao locacaoB = new Locacao(20231026, 200, "Gol");

        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        cliente1.alugar(locacaoA);
        cliente2.alugar(locacaoB);
        locacaoA.alugado();

        assertEquals("Cliente 1, carro alugado Locacao{data=20231025, preco=150, carro='Fusca'}", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }
}