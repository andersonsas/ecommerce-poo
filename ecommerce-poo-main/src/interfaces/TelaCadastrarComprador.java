package interfaces;

import entidade.Comprador;
import util.Input;

public class TelaCadastrarComprador {

    public Comprador cadastrarNovoComprador() {
        Comprador c = new Comprador();
        System.out.println("CADASTRO DE COMPRADOR");
        System.out.print("Informe o Código: ");
        try {
            c.setCodigo(Integer.parseInt(Input.get()));
        } catch (NumberFormatException e) {
            c.setCodigo(0);
        }
        System.out.print("Informe o CPF/CNPJ: ");
        c.setCpfcnpj(Input.get());
        System.out.print("Informe o Nome: ");
        c.setNome(Input.get());
        System.out.print("Informe o Endereço: ");
        c.setEndereco(Input.get());
        System.out.print("Informe o Telefone: ");
        c.setTelefone(Input.get());
        System.out.print("Informe o Email: ");
        c.setEmail(Input.get());
        return c;
    }
}