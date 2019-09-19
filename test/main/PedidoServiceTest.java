package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest {
	
	private Pedido pedido;
	
	@Mock
	private Cliente cliente;
	
	@Mock
	private LinhaDePedido linhaDePedido;
	
	
	@Before
	public void initPedidoService() {
		MockitoAnnotations.initMocks(this);
		pedido = new Pedido(linhaDePedido, cliente);
	}
	
	@Test
	public void pedidoSemDesconto() {
		Mockito.when(linhaDePedido.calcularPreco()).thenReturn(100.00);
		Mockito.when(cliente.getPercentualDesconto()).thenReturn(0.0);
		Assertions.assertEquals(pedido.calcularPreco(), 100.00);
	}
	
	@Test
	public void pedidoComDezPorcentoDesconto() {
		Mockito.when(linhaDePedido.calcularPreco()).thenReturn(100.00);
		Mockito.when(cliente.getPercentualDesconto()).thenReturn(10.0);
		Assertions.assertEquals(pedido.calcularPreco(), 90.00);
	}
	
	@Test
	public void pedidoComDescontoNegativo() {
		Mockito.when(linhaDePedido.calcularPreco()).thenReturn(100.00);
		Mockito.when(cliente.getPercentualDesconto()).thenReturn(-10.0);
		Assertions.assertEquals(pedido.calcularPreco(), 100.00);
	}
	
	@Test
	public void pedidoComMaisDeCemPorcento() {
		Mockito.when(linhaDePedido.calcularPreco()).thenReturn(100.00);
		Mockito.when(cliente.getPercentualDesconto()).thenReturn(200.0);
		Assertions.assertEquals(pedido.calcularPreco(), 0.0);
	}
	
	@Test
	public void testDummie() {
		Assert.assertEquals(1, 1);
	}	
}
