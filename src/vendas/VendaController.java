package vendas;

import java.util.ArrayList;
import java.util.List;

import entidade.Compra;
import entidade.Produto;
import entidade.Venda;
import controlador.ClienteController;
import controlador.ProdutoController;
import interfaces.TelaBuscaCliente;
import interfaces.TelaBuscaProduto;
import interfaces.TelaCadastrarCliente;
import interfaces.TelaListarClientes;
import interfaces.TelaListarProdutos;
import interfaces.TelaRealizarCompra;

public class VendaController {

	private List<Venda> vendas = new ArrayList<Venda>();

	private ProdutoController produtoController;
	private ClienteController clienteController;

	public VendaController (ProdutoController produtoController, ClienteController clienteController) {
		this.produtoController = produtoController;
		this.clienteController = clienteController;
	}

	public void cadastrarCliente () {
		TelaCadastrarCliente tcc = new TelaCadastrarCliente();
		clienteController.cadastrarCliente(tcc.cadastrarNovoCliente());
		System.out.println("Cliente cadastrado com sucesso!");
	}

	public void consultarCliente () {
		TelaBuscaCliente tbc = new TelaBuscaCliente(clienteController);
		TelaListarClientes tlc = new TelaListarClientes();
		tlc.listarCliente(tbc.buscarCliente());
	}

	public void consultarProduto () {
		TelaBuscaProduto tbp = new TelaBuscaProduto(produtoController);
		TelaListarProdutos tlp = new TelaListarProdutos();
		tlp.listarProdutos(tbp.buscarProduto());
	}

	public void comprarProduto () {
		// 1. Busca o produto pelo termo informado pelo cliente
		TelaBuscaProduto tbp = new TelaBuscaProduto(produtoController);
		List<Produto> produtosEncontrados = tbp.buscarProduto();

		// 2. Cliente seleciona o produto desejado e informa a quantidade
		TelaRealizarCompra trc = new TelaRealizarCompra();

		Produto produtoEscolhido = trc.selecionarProduto(produtosEncontrados);
		if (produtoEscolhido == null) {
			System.out.println("Compra cancelada.");
			return;
		}

		float quantidade = trc.informarQuantidade(produtoEscolhido);
		if (quantidade == -1) {
			System.out.println("Compra cancelada.");
			return;
		}

		// 3. Registra a venda
		Venda venda = new Venda();
		venda.setCodigo(vendas.size() + 1);
		venda.setProduto(produtoEscolhido);
		venda.setQuantidade(quantidade);
		venda.setStatus(Venda.cadastrada);

		vendas.add(venda);

		// 4. Baixa o estoque do produto
		produtoEscolhido.reduzirEstoque(quantidade);

		// 5. Confirma a operação para o cliente
		trc.exibirConfirmacao(produtoEscolhido, quantidade);

	}
}
