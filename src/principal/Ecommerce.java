package principal;

import compras.Compra;
import controlador.ClienteController;
import controlador.CompradorController;
import controlador.ProdutoController;
import interfaces.TelaListarProdutos;
import interfaces.TelaMenuPrincipal;
import vendas.Venda;

// cadastrarMoveis ✅
// cadastrarComprador ✅
// cadastrarCliente (maria) ✅ 
// cadastrarPedido (anderson)
// fazerPedido (mary)
// produtoController
// cadastrarFornecedor (nicolas)
// comprarProduto (anderson)

public class Ecommerce {
	
	
	public static void main(String[] args) {
		TelaMenuPrincipal tmp = new TelaMenuPrincipal();
		
		
		ProdutoController produtoController = new ProdutoController();
		CompradorController compradorController = new CompradorController();
		ClienteController clienteController = new ClienteController();
		
		Compra compra = new Compra(produtoController, compradorController);
		Venda venda = new Venda(produtoController, clienteController);
		
		int opcao = 0;
		
		do {
			opcao = tmp.menuPrincipal();
			
			switch (opcao) {
			case 1:
				compra.cadastrarProduto();
				break;
			case 2:
				venda.consultarProduto();
				break;
			case 3:
				produtoController.listarProdutos();
				break;
			case 4:
				compra.cadastrarComprador();
				break;
			case 5:
				compra.listarCompradores();
				break;
			case 6:
				compra.buscarComprador();
				break;
			case 7:
				venda.cadastrarCliente();
				break;
			case 8:
				venda.consultarCliente();
				break;
			case 0:
				return;
			}
		} while (opcao > 0 && opcao < 8);
	}
}
