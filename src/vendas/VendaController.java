package vendas;

import java.util.ArrayList;
import java.util.List;

import entidade.Cliente;
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

	private List<Compra> vendas = new ArrayList<Compra>();

	private ProdutoController produtoController;
	private ClienteController clienteController;

	public VendaController (ProdutoController produtoController, ClienteController clienteController) {
		this.produtoController = produtoController;
		this.clienteController = clienteController;
	}

	public void listarClientes() {
		this.clienteController.listarClientes();
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
		TelaRealizarCompra trc = new TelaRealizarCompra();

		// Busca e seleciona o cliente que está realizando a compra
		TelaBuscaCliente tbc = new TelaBuscaCliente(clienteController);
		List<Cliente> clientesEncontrados = tbc.buscarCliente();

		Cliente clienteEscolhido = trc.selecionarCliente(clientesEncontrados);
		if (clienteEscolhido == null) {
			System.out.println("Compra cancelada.");
			return;
		}

		// Busca o produto pelo termo informado pelo cliente
		TelaBuscaProduto tbp = new TelaBuscaProduto(produtoController);
		List<Produto> produtosEncontrados = tbp.buscarProduto();

		// Cliente seleciona o produto desejado e informa a quantidade

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

		Compra compra = new Compra();
		compra.setCodigo(vendas.size() + 1);
		compra.setCliente(clienteEscolhido);
		compra.setProduto(produtoEscolhido);
		compra.setQuantidade(quantidade);
		compra.setStatus(Compra.cadastrada);

		vendas.add(compra);

		produtoEscolhido.reduzirEstoque(quantidade);

		trc.exibirConfirmacao(produtoEscolhido, quantidade);
	}
}
