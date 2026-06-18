package controlador;

import java.util.ArrayList;
import java.util.List;

import compras.Compra;
import entidade.Pedido;

public class Pedidocontroller {

    private List<Pedido> pedidos = new ArrayList<>();
    Compra compra = new Compra(null, null, null, null);

    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public Pedido receberPedido(int indice) {

        if (indice >= 0 && indice < pedidos.size()) {
            return compra.pedidos.remove(indice);
        }

        return null;
    }

    public boolean possuiPedidos() {
        return !pedidos.isEmpty();
    }
}
