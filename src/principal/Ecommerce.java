package principal;

import compras.Compra;
import controlador.FornecedorController;
import controlador.ProdutoController;
import interfaces.TelaMenuPrincipal;
import vendas.Venda;
import Fornecedor.Fornecedor;

public class Ecommerce {
	
	
	public static void main(String[] args) {
		TelaMenuPrincipal tmp = new TelaMenuPrincipal(); 
		
		ProdutoController produtoController = new ProdutoController();
		FornecedorController fornecedorController = new FornecedorController();
		
		Fornecedor fornecedor =  new Fornecedor(fornecedorController);
		Compra compra = new Compra(produtoController);
		Venda venda = new Venda(produtoController);
	
		
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
				fornecedor.cadastrarFornecedor();
				break;
			case 4:
				fornecedor.buscarFornecedor();
				break;
			case 5:
				break;
			}
		} while (opcao < 5);
	}

}
