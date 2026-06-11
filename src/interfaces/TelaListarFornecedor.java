package interfaces;

import java.util.List;

import entidade.Fornecedor;

public class TelaListarFornecedor {
		public void listarFornecedor(List<Fornecedor> fornecedores) {
			for(Fornecedor fornecedor : fornecedores) {
				System.out.println(fornecedor);
			}
		}
}
