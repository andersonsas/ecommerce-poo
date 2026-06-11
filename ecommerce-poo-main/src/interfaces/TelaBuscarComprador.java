package interfaces;

import java.util.List;

import controlador.CompradorController;
import entidade.Comprador;
import util.Input;

public class TelaBuscarComprador {
    private CompradorController compradorController;

    public TelaBuscarComprador(CompradorController compradorController) {
        this.compradorController = compradorController;
    }

    public List<Comprador> buscarComprador() {
        System.out.print("Informe nome ou CPF/CNPJ para busca: ");
        String chave = Input.get();
        return compradorController.buscarCompradores(chave);
    }
}