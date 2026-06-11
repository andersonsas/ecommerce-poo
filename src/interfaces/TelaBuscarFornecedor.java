package interfaces;

import java.util.List;
import entidade.Fornecedor;
import util.Input;
import controlador.FornecedorController;

public class TelaBuscarFornecedor {
	private FornecedorController fornecedorController;
	
	public TelaBuscarFornecedor(FornecedorController fornecedorController) {
		this.fornecedorController = fornecedorController;
	}
	
	public List<Fornecedor> buscarFornecedor(){
		System.out.println("Digite o nome ou cnpj do fornecedor:");
		return fornecedorController.buscarFornecedor(Input.get());
	}
}
