package br.com.caelum.argentum.modelo;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;

public class GeradorModeloGrafico {

	private CartesianChartModel modeloGrafico;
	private int fim;
	private int comeco;
	private SerieTemporal serie;

	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new CartesianChartModel();
	}
	
	public void plotaIndicador(Indicador indicador) {
	
		LineChartSeries chartSerie = new LineChartSeries(indicador.toString());
		
		for ( int i=comeco; i<=fim; i++ ) {			
			double valor = indicador.calcula(i, serie);
			chartSerie.set(i, valor);			
		}
		
		this.modeloGrafico.addSeries(chartSerie);
		
	}
	
	public ChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}
	
}