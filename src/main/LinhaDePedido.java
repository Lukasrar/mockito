package main;

public class LinhaDePedido {
	
	private Produto produto;
	private int quantidade;

	public LinhaDePedido(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
		
	public double calcularPreco() {
		return produto.obterPreco(this.quantidade);
	}
}
