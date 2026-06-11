package interfaces;

import entidade.Fornecedor;

import util.Input;

public class TelaCadastrarFornecedor {
	
	
	public Fornecedor cadastrarNovoFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		System.out.println("CADASTRO DE Fornecedor");
		System.out.print("Informe o cnpj do fornecedor: ");
		fornecedor.setCpfcnpj(Input.get());
		System.out.print("Informe o nome do fornecedor: ");
		fornecedor.setNome(Input.get());
		System.out.print("Informe o endereco do fornecedor: ");
		fornecedor.setEndereco(Input.get());
		System.out.print("Informe o telefone do fornecedor: ");
		fornecedor.setTelefone(Input.get());
		System.out.print("Informe o email do fornecedor: ");
		fornecedor.setEmail(Input.get());
				
		return fornecedor;
	}
	
}
