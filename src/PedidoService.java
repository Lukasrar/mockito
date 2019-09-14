
public class PedidoService {

	
	private Cliente cliente;
	
	private Pedido pedido;
	
	public PedidoService(Cliente cliente, Pedido pedido) {
		super();
		this.cliente = cliente;
		this.pedido = pedido;
	}
	
	public Double getValorPedidoComDesconto() {
		double valorPedido = pedido.getValorPedido();
		return valorPedido - (valorPedido * cliente.getPercentualDesconto() / 100d);
		
	}
}
