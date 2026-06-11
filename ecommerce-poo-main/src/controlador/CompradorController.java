package controlador;

import java.util.ArrayList;
import java.util.List;

import entidade.Comprador;

public class CompradorController {
    private List<Comprador> compradores = new ArrayList<Comprador>();

    public void cadastrarComprador(Comprador c) {
        compradores.add(c);
    }

    public List<Comprador> buscarCompradores(String chave) {
        if (chave == null || chave.isEmpty()) return compradores;
        List<Comprador> resultado = new ArrayList<Comprador>();
        String chaveMin = chave.toLowerCase();
        for (Comprador c : compradores) {
            if ((c.getNome() != null && c.getNome().toLowerCase().contains(chaveMin)) ||
                (c.getCpfcnpj() != null && c.getCpfcnpj().contains(chave))) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public List<Comprador> listarCompradores() {
        return compradores;
    }
}