package Fornecedor;

import controlador.FornecedorController;
import interfaces.TelaCadastrarFornecedor;
import interfaces.TelaListarFornecedor;
import interfaces.TelaBuscarFornecedor;

public class Fornecedor {
	
	private FornecedorController fornecedorController;
	
	
	public Fornecedor(FornecedorController fornecedorController ){
		this.fornecedorController = fornecedorController;
	}
	
	public void cadastrarFornecedor() {
		TelaCadastrarFornecedor tcf = new TelaCadastrarFornecedor();
		fornecedorController.cadastrarFornecedor(tcf.cadastrarNovoFornecedor());
	}
	
	public void buscarFornecedor() {
		TelaBuscarFornecedor tbf = new TelaBuscarFornecedor(fornecedorController);
		TelaListarFornecedor tlf  = new TelaListarFornecedor();
		tlf.listarFornecedor(tbf.buscarFornecedor());
	}
	
	
}
