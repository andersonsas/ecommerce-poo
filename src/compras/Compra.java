package compras;

import java.util.ArrayList;
import java.util.List;

import controlador.CompradorController;
import controlador.FornecedorController;
import controlador.ProdutoController;
import entidade.Comprador;
import entidade.Pedido;
import interfaces.TelaBuscarComprador;
import interfaces.TelaCadastrarComprador;
import interfaces.TelaCadastrarLivro;
import interfaces.TelaCadastrarMovel;
import interfaces.TelaFazerPedido;
import interfaces.TelaListarCompradores;
import interfaces.TelaSelecionarTipoProduto;

public class Compra {
	
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	private ProdutoController produtoController;
	private CompradorController compradorController;
	private FornecedorController fornecedorController;
	
	public Compra(ProdutoController produtoController, CompradorController compradorController, FornecedorController fornecedorController){
		this.produtoController = produtoController;
		this.compradorController = compradorController;
		this.fornecedorController = fornecedorController;
	}
	
	public void cadastrarComprador() {
		TelaCadastrarComprador tcc = new TelaCadastrarComprador();
		Comprador comprador = tcc.cadastrarNovoComprador();
		
		compradorController.cadastrarComprador(comprador);
		
		System.out.println("\nComprador cadastrado (simulado):");
		System.out.println("Código: " + comprador.getCodigo());
		System.out.println("CPF/CNPJ: " + comprador.getCpfcnpj());
		System.out.println("Nome: " + comprador.getNome());
		System.out.println("Endereço: " + comprador.getEndereco());
		System.out.println("Telefone: " + comprador.getTelefone());
		System.out.println("Email: " + comprador.getEmail());
	}
	
	public void buscarComprador() {
		TelaBuscarComprador tbc = new TelaBuscarComprador(compradorController);
		java.util.List<Comprador> resultado = tbc.buscarComprador();
		TelaListarCompradores tlc = new TelaListarCompradores();
		tlc.listarCompradores(resultado);
	}
	
	public void listarCompradores() { 
		TelaListarCompradores tlc = new TelaListarCompradores();
		tlc.listarCompradores(compradorController.listarCompradores());
	}
	
	public void cadastrarProduto() {
		TelaSelecionarTipoProduto tstp = new TelaSelecionarTipoProduto();
		produtoController.cadastrarProduto(tstp.selecionarProduto());
	}
	
	public void cadastrarFornecedor() {
		
	}
	
	public void cadastrarCompra(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void fazerPedido() {
		TelaFazerPedido tfp = new TelaFazerPedido(compradorController, produtoController, fornecedorController);

        Pedido pedido = tfp.fazerNovoPedido();

        cadastrarCompra(pedido);
	}
	
	public void receberPedido() {
		TelaReceberPedido trp = new TelaReceberPedido();

		int indice = trp.selecionarPedido(
				pedidoController.listarPedidos());

		if (indice == -1) {
			return;
		}

		Pedido pedidoRecebido =
				pedidoController.receberPedido(indice);

		if (pedidoRecebido != null) {

			pedidoRecebido.getProduto()
					.adicionarEstoque(
							pedidoRecebido.getQuantidade());

			System.out.println(
					"Pedido recebido com sucesso! Estoque atualizado.");

		} else {

			System.out.println("Pedido inválido.");
		}
	}
	
	public void cadastrarLivro() {
		TelaCadastrarLivro tcl = new TelaCadastrarLivro();
		produtoController.cadastrarProduto(tcl.cadastrarNovoLivro());
	}
	
	public void cadastrarMovel() {
		TelaCadastrarMovel tcm = new TelaCadastrarMovel();
		produtoController.cadastrarProduto(tcm.cadastrarNovoMovel());
	}
	
	public void listarPedidos() {
		
	}
}
