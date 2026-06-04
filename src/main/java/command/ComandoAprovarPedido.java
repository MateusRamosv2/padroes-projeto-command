package command;

public class ComandoAprovarPedido implements Comando {
    private PedidoERP pedido;

    public ComandoAprovarPedido(PedidoERP pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        this.pedido.aprovar();
    }

    @Override
    public void desfazer() {
        this.pedido.reverterAprovacao();
    }
}