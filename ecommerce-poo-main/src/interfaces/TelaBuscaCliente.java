package interfaces;

import java.util.List;
import controlador.ClienteController;
import entidade.Cliente;
import util.Input;

public class TelaBuscaCliente {
	
	private ClienteController clienteController;

	
	public TelaBuscaCliente(ClienteController clienteController) {
		this.clienteController = clienteController;
	}
	
	public List<Cliente> buscarCliente() {
		System.out.println("BUSCAR CLIENTE");
		System.out.print("Digite o nome (ou parte dele) para buscar: ");
		String termo = Input.get();
		
		return clienteController.buscarClientes(termo);
	}
}