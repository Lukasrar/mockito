package main;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LinhaPedidoServiceTest {
	
	private LinhaDePedido linhaDePedido;
	
	@Mock
	private Produto produto;
	
	
	@Before
	public void initLinhaPedidoServiceTest() {
		MockitoAnnotations.initMocks(this);
		linhaDePedido = new LinhaDePedido(produto, 1);
	}
	
	@Test
	public void linhaPedidoComUmProduto() {
		Mockito.when(produto.obterPreco(1)).thenReturn(100.00);
		Assertions.assertEquals(linhaDePedido.calcularPreco(), 100.00);
	}
}
