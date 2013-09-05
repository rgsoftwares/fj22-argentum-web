package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private Indicador outroIndicador;
	
	public MediaMovelPonderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) { 
		
		double soma = 0.0;
		int peso = 1;
		
		for ( int i=posicao-2; i<=posicao; i++ ) {
			soma += outroIndicador.calcula(posicao, serie) * peso;
			peso++;
		}
		
		return soma / 6;
		
	}
	
	@Override
	public String toString() {
		return "MMP de " + outroIndicador.toString();
	}
	
}
