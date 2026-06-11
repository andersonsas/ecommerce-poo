package controlador;

import java.util.List;
import java.util.ArrayList;

import entidade.Fornecedor;


public class FornecedorController {
	
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	
	public void cadastrarFornecedor(Fornecedor fornecedor){
          fornecedores.add(fornecedor);
	}
	
	public List<Fornecedor> buscarFornecedor(String chave) {
		if (chave == "" || chave.isEmpty() || chave == null) return fornecedores;
		
		List<Fornecedor> fornecedorBusca = new ArrayList<Fornecedor>();
		
		String chaveMin = chave.toLowerCase();
		
		for(Fornecedor fornecedor : fornecedores) {
			if(fornecedor instanceof Fornecedor) {
				if(fornecedor.getNome().contains(chaveMin) || 
					fornecedor.getCpfcnpj().contains(chaveMin)){
						fornecedorBusca.add(fornecedor);
					} 
			}
		}
		return fornecedorBusca;
	}
	
}
