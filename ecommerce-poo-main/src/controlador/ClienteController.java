package controlador;

import java.util.ArrayList;
import java.util.List;
import entidade.Cliente;

public class ClienteController {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void cadastrarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void atualizarCliente(Cliente clienteAtualizado) {
		
		for (int i = 0; i < clientes.size(); i++) {
	        Cliente clienteAtual = clientes.get(i);
	        
	        
	        if (clienteAtual.getCodigo() == clienteAtualizado.getCodigo()) {
	            clientes.set(i, clienteAtualizado);
	            return; 
	        }
		}
		
		System.out.println("Cliente com código " + clienteAtualizado.getCodigo() + " não foi encontrado.");
	}
	
	public List<Cliente> buscarClientes(String chave) {
		if (chave == null || chave.trim().isEmpty()) {
			return clientes;
		}
		
		List<Cliente> clientesBusca = new ArrayList<Cliente>();
		String chaveMin = chave.toLowerCase();
		
		for (Cliente cliente : clientes) {
			if (cliente.getNome().toLowerCase().contains(chaveMin)) {
				clientesBusca.add(cliente);
			}
		}
		
		return clientesBusca;
	}
}