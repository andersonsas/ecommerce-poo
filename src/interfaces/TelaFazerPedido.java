package interfaces;

import controlador.CompradorController;
import controlador.FornecedorController;
import controlador.ProdutoController;
import entidade.Pedido;
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

    public Pedido fazerNovoPedido(){
        Pedido pedido = new Pedido();

        System.out.println("-----FAZER PEDIDO-----");

        TelaBuscarComprador tlbc = new TelaBuscarComprador(compradorController);

        List<Comprador> compradores;

        while(true){
        	
        	compradores = tlbc.buscarComprador();

            if(!compradores.isEmpty()){
                break;
            }

            System.out.println("Comprador não encontrado!");
            System.out.println("Digite novamente.");
        }
        int i =0;

        for(i = 0; i < compradores.size(); i++) {

            System.out.println(i + " - " + compradores.get(i).getNome());
        }

        System.out.print("Escolha o comprador: ");
        int opComprador = Integer.parseInt(Input.get());

         pedido.setComprador(compradores.get(opComprador));

        //escolher produto

        TelaBuscaProduto tlbp = new TelaBuscaProduto(produtoController);

        List<Produto> produtos;
        
        while(true){

        	produtos = tlbp.buscarProduto();

            if(!produtos.isEmpty()){
                break;
            }

            System.out.println("Produto não encontrado!");
            System.out.println("Digite novamente.");
        }

        for(i = 0; i < produtos.size(); i++) {

            System.out.println(i + " - " + produtos.get(i).getDescricao());
        }

        System.out.print("Escolha o produto: ");
        int opProduto = Integer.parseInt(Input.get());

        pedido.setProduto(produtos.get(opProduto));

        System.out.print("Quantidade: ");
        pedido.setQuantidade(Integer.parseInt(Input.get()));


        //escolher fornecedor

        TelaBuscarFornecedor tlbf = new TelaBuscarFornecedor(fornecedorController);

        List<Fornecedor> fornecedores;
        
        while(true){

            fornecedores = tlbf.buscarFornecedor();

            if(!fornecedores.isEmpty()){
                break;
            }

            System.out.println("Fornecedor não encontrado!");
            System.out.println("Digite novamente.");
        }

        for(i = 0; i < fornecedores.size(); i++) {

            System.out.println(i + " - " + fornecedores.get(i).getNome());
        }

        System.out.print("Escolha o fornecedor: ");

        int opFornecedor = Integer.parseInt(Input.get());

        pedido.setFornecedor(fornecedores.get(opFornecedor));


        System.out.println("===== PEDIDO FEITO =====");

        System.out.println("Comprador: " + pedido.getComprador().getNome());

        System.out.println("Fornecedor: " + pedido.getFornecedor().getNome());

        System.out.println("Produto: " + pedido.getProduto().getDescricao());

        System.out.println("Quantidade: " + pedido.getQuantidade());

        System.out.println("Preço: " + pedido.getProduto().getPreco());


        return pedido;


    }
}
