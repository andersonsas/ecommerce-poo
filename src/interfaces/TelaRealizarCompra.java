package interfaces;

import java.util.List;

import entidade.Cliente;
import entidade.Produto;
import util.Input;

public class TelaRealizarCompra {

	public Cliente selecionarCliente (List<Cliente> clientes) {
		if (clientes == null || clientes.isEmpty()) {
			System.out.println("Nenhum cliente encontrado para o termo informado.");
			return null;
		}

		System.out.println("\nCLIENTES ENCONTRADOS:");
		for (int i = 0; i < clientes.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, clientes.get(i));
		}

		System.out.print("Selecione o número do cliente (0 para cancelar): ");
		int opcao = Integer.parseInt(Input.get());

		if (opcao == 0) return null;

		if (opcao < 1 || opcao > clientes.size()) {
			System.out.println("Opção fora do intervalo.");
			return null;
		}

		return clientes.get(opcao - 1);
	}

	public Produto selecionarProduto (List<Produto> produtos) {
		if (produtos == null || produtos.isEmpty()) {
			System.out.println("Nenhum produto encontrado para o termo informado.");
			return null;
		}

		System.out.println("\nPRODUTOS ENCONTRADOS:");
		for (int i = 0; i < produtos.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, produtos.get(i));
		}

		System.out.print("Selecione o número do produto desejado (0 para cancelar): ");
		int opcao;

		opcao = Integer.parseInt(Input.get());

		if (opcao == 0) return null;

		if (opcao < 1 || opcao > produtos.size()) {
			System.out.println("Opção fora do intervalo.");
			return null;
		}

		return produtos.get(opcao - 1);
	}

	public float informarQuantidade (Produto produto) {
		System.out.printf("%nProduto: %s%n", produto);
		System.out.printf("Estoque disponível: %.2f %s%n",
				produto.getQteEstoque(), produto.getUnidade());
		System.out.print("Informe a quantidade desejada (0 para cancelar): ");

		float quantidade;

		quantidade = Float.parseFloat(Input.get());

		if (quantidade == 0) return -1;

		if (quantidade < 0) {
			System.out.println("A quantidade não pode ser negativa.");
			return -1;
		}

		if (quantidade > produto.getQteEstoque()) {
			System.out.printf("Quantidade insuficiente em estoque. Disponível: %.2f%n",
					produto.getQteEstoque());
			return -1;
		}

		return quantidade;
	}

	/**
	 * Exibe o resumo da venda realizada.
	 */
	public void exibirConfirmacao (Produto produto, float quantidade) {
		System.out.println("\n=== COMPRA REALIZADA COM SUCESSO ===");
		System.out.printf("Produto  : %s%n", produto);
		System.out.printf("Qtd.     : %.2f %s%n", quantidade, produto.getUnidade());
		System.out.printf("Total    : R$ %.2f%n", produto.getPreco() * quantidade);
		System.out.println("====================================\n");
	}
}
