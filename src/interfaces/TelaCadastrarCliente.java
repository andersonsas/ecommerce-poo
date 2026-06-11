package interfaces;
 
import entidade.Cliente;
import util.Input;
 
public class TelaCadastrarCliente {
 
    public Cliente cadastrarNovoCliente() {
        Cliente cliente = new Cliente();
        System.out.println("CADASTRO DE CLIENTE");
        System.out.print("Informe o Código: ");
        
        String codigoTexto = Input.get();
        int codigoInt = Integer.parseInt(codigoTexto);
        cliente.setCodigo(codigoInt);
        
        System.out.print("Informe o CPF/CNPJ: ");
        cliente.setCpfcnpj(Input.get());
        System.out.print("Informe o Nome: ");
        cliente.setNome(Input.get());
        System.out.print("Informe o Endereço: ");
        cliente.setEndereco(Input.get());
        System.out.print("Informe o Telefone: ");
        cliente.setTelefone(Input.get());
        System.out.print("Informe o E-mail: ");
        cliente.setEmail(Input.get());
        return cliente;
    }
}