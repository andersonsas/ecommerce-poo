package entidade;

public class Pedido {
	private String dataPedido;
	private String previsaoEntrega;
	private float quantidade;
	private Comprador comprador;
	private Produto produto;
	private Fornecedor fornecedor;
	
	public Pedido() {}
	
	public Pedido(String dataPedido, String previsaoEntrega, float quantidade, Comprador comprador, Produto produto, Fornecedor fornecedor) {
		this.dataPedido = dataPedido;
		this.previsaoEntrega = previsaoEntrega;
		this.quantidade = quantidade;
		this.comprador = comprador;
		this.produto = produto;
		this.fornecedor = fornecedor;
	}
	
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getPrevisaoEntrega() {
		return previsaoEntrega;
	}
	public void setPrevisaoEntrega(String previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
