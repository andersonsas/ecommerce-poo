package interfaces;

import java.util.List;

import entidade.Cliente;

public class TelaListarClientes {
	public void listarCliente(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
}