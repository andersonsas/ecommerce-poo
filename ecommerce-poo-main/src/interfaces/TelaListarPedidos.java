package interfaces;

import java.util.Scanner;
import java.util.List;

import entidade.Pedido;

public class TelaListarPedidos {

    private Scanner scanner = new Scanner(System.in);

    public int listarPedidos(List<Pedido> pedidos) {

        System.out.println("\n--- LISTAR PEDIDOS ---");

        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos pendentes.");
            return 0;
        }

        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);

            System.out.println("[" + i + "] Produto: "
                    + p.getProduto().getDescricao()
                    + " | Qtd: " + p.getQuantidade()
                    + " | Comprador: " + p.getComprador().getNome());
        }

        System.out.println("\n1 - Receber Pedido");
        System.out.println("0 - Voltar ao Menu Principal");
        System.out.print("Opção: ");

        return scanner.nextInt();
    }

}