package command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GerenciadorDeComandosTest {

    GerenciadorDeComandos gerenciador;
    PedidoERP pedido;

    @BeforeEach
    void setUp() {
        gerenciador = new GerenciadorDeComandos();
        pedido = new PedidoERP(1001); // Pedido nasce como "CRIADO"
    }

    @Test
    void deveAprovarPedido() {
        Comando aprovar = new ComandoAprovarPedido(pedido);
        gerenciador.executarComando(aprovar);


    }

    @Test
    void deveFaturarPedido() {

        Comando aprovar = new ComandoAprovarPedido(pedido);
        Comando faturar = new ComandoFaturarPedido(pedido);

        gerenciador.executarComando(aprovar);
        gerenciador.executarComando(faturar);

        assertEquals("FATURADO", pedido.getStatus());
    }

}