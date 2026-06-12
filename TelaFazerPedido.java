package interfaces;

import compra.CompradorController;
import controllers.FornecedorController;
import controllers.ProdutoController;
import entidade.Compra;
import entidade.Comprador;
import entidade.Fornecedor;
import entidade.Produto;
import util.Input;
import java.util.List;


public class TelaFazerPedido {

    private CompradorController compradorController;
    private ProdutoController produtoController;
    private FornecedorController fornecedorController;

    public TelaFazerPedido(CompradorController compradorController, ProdutoController produtoController, FornecedorController fornecedorController) {
        this.compradorController = compradorController;
        this.produtoController = produtoController;
        this.fornecedorController = fornecedorController;
    }

    public Compra fazerNovoPedido(){
        Compra compra = new Compra();

        System.out.println("-----FAZER PEDIDO-----");

        TelaBuscarComprador tlbc = new TelaBuscarComprador(compradorController);

        List<Comprador> compradores = tlbc.buscarComprador();

        int i =0;

        for(i = 0; i < compradores.size(); i++) {

            System.out.println(i + " - " + compradores.get(i).getNome());
        }

        System.out.print("Escolha o comprador: ");
        int opComprador = Integer.parseInt(Input.get());

        compra.setComprador(compradores.get(opComprador));

        //escolher produto

        TelaBuscaProduto tlbp = new TelaBuscaProduto(produtoController);

        List<Produto> produtos = tlbp.buscarProduto();

        for(i = 0; i < produtos.size(); i++) {

            System.out.println(i + " - " + produtos.get(i).getDescricao());
        }

        System.out.print("Escolha o produto: ");
        int opProduto = Integer.parseInt(Input.get());

        compra.setProduto(produtos.get(opProduto));

        System.out.print("Quantidade: ");
        compra.setQuantidade(Integer.parseInt(Input.get()));

        System.out.print("Preço: ");
        compra.setPreco(Float.parseFloat(Input.get()));

        //escolher fornecedor

        TelaBuscarFornecedor tlbf = new TelaBuscarFornecedor(fornecedorController);

        List<Fornecedor> fornecedores = tlbf.buscarFornecedor();

        for(i = 0; i < fornecedores.size(); i++) {

            System.out.println(i + " - " + fornecedores.get(i).getNome());
        }

        System.out.print("Escolha o fornecedor: ");

        int opFornecedor = Integer.parseInt(Input.get());

        compra.setFornecedor(fornecedores.get(opFornecedor));

        System.out.print("Data do pedido: ");
        compra.setDataPedido(Input.get());

        System.out.print("Previsão de entrega: ");
        compra.setPrevisaoEntrega(Input.get());


        System.out.println("===== PEDIDO FEITO =====");

        System.out.println("Comprador: " + compra.getComprador().getNome());

        System.out.println("Fornecedor: " + compra.getFornecedor().getNome());

        System.out.println("Produto: " + compra.getProduto().getDescricao());

        System.out.println("Quantidade: " + compra.getQuantidade());

        System.out.println("Preço: " + compra.getPreco());

        System.out.println("Data Pedido: " + compra.getDataPedido());

        System.out.println("Previsão Entrega: " + compra.getPrevisaoEntrega());

        return compra;


    }
}
