package controlador;

import java.util.ArrayList;
import java.util.List;

import entidade.Pedido;

public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();

    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public Pedido receberPedido(int indice) {

        if (indice >= 0 && indice < pedidos.size()) {
            return pedidos.remove(indice);
        }

        return null;
    }

    public boolean possuiPedidos() {
        return !pedidos.isEmpty();
    }
}
