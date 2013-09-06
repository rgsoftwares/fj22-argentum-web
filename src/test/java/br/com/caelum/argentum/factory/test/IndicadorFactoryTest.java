package br.com.caelum.argentum.factory.test;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.argentum.factory.IndicadorFactory;
import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;

public class IndicadorFactoryTest {

	@Test
	public void testMontaAbertura() {
		
		String nomeIndicador = "IndicadorAbertura";
		
		IndicadorFactory indicadorFactory = new IndicadorFactory(nomeIndicador, null);
		
		Indicador indicador = indicadorFactory.getIndicador();
		
		Assert.assertTrue(indicador instanceof IndicadorAbertura);
		
	}
	
}
