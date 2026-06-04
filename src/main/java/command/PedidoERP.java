package command;

public class PedidoERP {
    private int numeroPedido;
    private String status;

    public PedidoERP(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.status = "CRIADO";
    }

    public String getStatus() {
        return status;
    }


    public void aprovar() {
        this.status = "APROVADO";
    }

    public void reverterAprovacao() {
        this.status = "CRIADO";
    }

    public void faturar() {
        this.status = "FATURADO";
    }

    public void reverterFaturamento() {
        this.status = "APROVADO";
    }
}
