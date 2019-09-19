package main;

public class Pedido {
	
	private LinhaDePedido linhaDePedido;
	private Cliente cliente;
	
	public Pedido(LinhaDePedido linhaDePedido, Cliente cliente) {
		this.linhaDePedido = linhaDePedido;
		this.cliente = cliente;
	}
	
	public double calcularPreco() {
		double valorInicial = linhaDePedido.calcularPreco();
		double porcDesconto = cliente.getPercentualDesconto();
		
		if( porcDesconto <= 0 ) {
			return valorInicial;
		}
		if ( porcDesconto >= 100) {
			return 0.0;
		}
		return valorInicial * (1 - porcDesconto / 100);
	}
}
