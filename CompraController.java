package compra;

import controllers.FornecedorController;
import controllers.ProdutoController;
import entidade.Compra;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class CompraController {//fornecedor
    private List<Compra> compras = new ArrayList<Compra>();
    private ProdutoController produtoController;
    private CompradorController compradorController;
    private FornecedorController fornecedorController;

    public CompraController(ProdutoController produtoController, CompradorController compradorController, FornecedorController fornecedorController){

        this.produtoController = produtoController;
        this.compradorController = compradorController;
        this.fornecedorController = fornecedorController;
    }

    public void cadastrarComprador(){
        TelaCadastrarComprador tlcc = new TelaCadastrarComprador();
        compradorController.cadastrarComprador(tlcc.cadastrarNovoComprador());
    }
    public void listarCompradores() {
        TelaListarCompradores tlc = new TelaListarCompradores();
        tlc.listarCompradores(compradorController.listarCompradores());
    }

    public void cadastrarFornecedor(){
        TelaCadastroFornecedor tcf = new TelaCadastroFornecedor();
        fornecedorController.cadastrarFornecedor(tcf.cadastrarNovoFornecedor());
    }

    public void cadastrarCompra(Compra compra){

        compras.add(compra);
    }

    public void cadastrarProduto(){
        TelaSelecionarTipoProduto tstp = new TelaSelecionarTipoProduto();
        produtoController.cadastrarProduto(tstp.selecionarProduto());
    }

    public void fazerPedido(){
        TelaFazerPedido tfp = new TelaFazerPedido(compradorController, produtoController, fornecedorController);

        Compra compra = tfp.fazerNovoPedido();

        cadastrarCompra(compra);
    }

    public void receberPedido(){}

    public void cadastrarLivro(){
        TelaCadastrarLivro tcl = new TelaCadastrarLivro();
        produtoController.cadastrarProduto(tcl.cadastrarNovoLivro());
    }

   public void cadastrarMoveis(){}

    public void listarPedido(){}


}
