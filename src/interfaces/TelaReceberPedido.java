package interfaces;

import java.util.List;
import java.util.Scanner;

import entidade.Pedido;

public class TelaReceberPedido {

    private Scanner scanner = new Scanner(System.in);

    public int selecionarPedido(List<Pedido> pedidos) {

        System.out.println("\n--- RECEBER PEDIDO ---");

        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos pendentes.");
            return -1;
        }

        for (int i = 0; i < pedidos.size(); i++) {

            Pedido p = pedidos.get(i);

            System.out.println("[" + i + "] Produto: "
                    + p.getProduto().getDescricao()
                    + " | Quantidade: " + p.getQuantidade()
                    + " | Comprador: " + p.getComprador().getNome());
        }

        System.out.println("\nDigite o número do pedido recebido");
        System.out.println("(-1 para cancelar)");
        System.out.print("Opção: ");

        return scanner.nextInt();
    }
}
