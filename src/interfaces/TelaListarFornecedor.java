package interfaces;

import java.util.List;

import entidade.Fornecedor;

public class TelaListarFornecedor {
		public void listarFornecedor(List<Fornecedor> fornecedores) {
			int i = 0;
			for(Fornecedor fornecedor : fornecedores) {
				System.out.print(i++);
				System.out.print(", ");
				System.out.println(fornecedor);
			}
		}
}
