package vendas;

import java.util.ArrayList;
import java.util.List;

import entidade.Compra;
import controlador.ClienteController;
import controlador.ProdutoController;
import interfaces.TelaBuscaCliente;
import interfaces.TelaBuscaProduto;
import interfaces.TelaCadastrarCliente;
import interfaces.TelaListarClientes;
import interfaces.TelaListarProdutos;

public class Venda {
	
	List<Compra> compras = new ArrayList<Compra>();
	
	private ProdutoController produtoController;
    private ClienteController clienteController;
	
    public Venda(ProdutoController produtoController, ClienteController clienteController) {
        this.produtoController = produtoController;
        this.clienteController = clienteController;
    }
	
    public void cadastrarCliente() {
        TelaCadastrarCliente tcc = new TelaCadastrarCliente();
        clienteController.cadastrarCliente(tcc.cadastrarNovoCliente());
        System.out.println("Cliente cadastrado com sucesso!");
    }
    
    public void consultarCliente() {
        TelaBuscaCliente tbc = new TelaBuscaCliente(clienteController);
        TelaListarClientes tlc = new TelaListarClientes();
        tlc.listarCliente(tbc.buscarCliente());
    }
	
	public void consultarProduto() {
		TelaBuscaProduto tbp = new TelaBuscaProduto(produtoController);
		TelaListarProdutos tlp = new TelaListarProdutos();
		tlp.listarProdutos(tbp.buscarProduto());
	}
	
	public void comprarProduto() {
		
	}
}
