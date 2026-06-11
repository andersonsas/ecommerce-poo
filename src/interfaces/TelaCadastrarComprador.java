package interfaces;

import entidade.Comprador;
import util.Input;

public class TelaCadastrarComprador {

    public Comprador cadastrarNovoComprador() {
        Comprador c = new Comprador();
        System.out.println("CADASTRO DE COMPRADOR");
        c.setCodigo(getCodigo("Informe o Código: "));
        c.setCpfcnpj(getTextoObrigatorio("Informe o CPF/CNPJ: "));
        c.setNome(getTextoObrigatorio("Informe o Nome: "));
        c.setEndereco(getTextoObrigatorio("Informe o Endereço: "));
        c.setTelefone(getTextoObrigatorio("Informe o Telefone: "));
        c.setEmail(getTextoObrigatorio("Informe o Email: "));
        return c;
    }

    private int getCodigo(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = Input.get();
            if (texto == null || texto.trim().isEmpty()) {
                System.out.println("Código é obrigatório. Tente novamente.");
                continue;
            }
            try {
                int codigo = Integer.parseInt(texto.trim());
                if (codigo <= 0) {
                    System.out.println("Código inválido. Informe um número inteiro maior que zero.");
                    continue;
                }
                return codigo;
            } catch (NumberFormatException e) {
                System.out.println("Código inválido. Informe um número inteiro válido.");
            }
        }
    }

    private String getTextoObrigatorio(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = Input.get();
            if (texto != null && !texto.trim().isEmpty()) {
                return texto.trim();
            }
            System.out.println("Este campo é obrigatório. Não pode ficar em branco.");
        }
    }
}