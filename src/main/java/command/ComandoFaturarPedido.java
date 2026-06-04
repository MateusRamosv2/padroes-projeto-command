package command;

public class ComandoFaturarPedido implements Comando {
    private PedidoERP pedido;

    public ComandoFaturarPedido(PedidoERP pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        this.pedido.faturar();
    }

    @Override
    public void desfazer() {
        this.pedido.reverterFaturamento();
    }
}