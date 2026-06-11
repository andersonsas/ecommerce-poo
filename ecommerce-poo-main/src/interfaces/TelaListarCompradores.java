package interfaces;

import java.util.List;

import entidade.Comprador;

public class TelaListarCompradores {
    public void listarCompradores(List<Comprador> compradores) {
        if (compradores == null || compradores.isEmpty()) {
            System.out.println("Nenhum comprador encontrado.");
            return;
        }
        for (Comprador c : compradores) {
            System.out.println("-------------------------");
            System.out.println("Código: " + c.getCodigo());
            System.out.println("CPF/CNPJ: " + c.getCpfcnpj());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Endereço: " + c.getEndereco());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Email: " + c.getEmail());
        }
    }
}