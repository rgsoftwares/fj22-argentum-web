package br.com.caelum.argentum;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.factory.IndicadorFactory;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.GeradorModeloGrafico;
import br.com.caelum.argentum.modelo.IndicadorAbertura;
import br.com.caelum.argentum.modelo.IndicadorFechamento;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ManagedBean
@SessionScoped
public class ArgentumBean {

	private List<Negociacao> negociacoes;
	
	private ChartModel modeloGrafico;
	
	private String titulo;
	
	private String nomeIndicador;
	
	private String nomeMedia;
	
	public void preparaDados() {
		
		ClienteWebService cliente = new ClienteWebService();
		this.negociacoes = cliente.getNegociacoes();
		
		List<Candle> candles = new CandleFactory().constroiCandles(this.negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 2, serie.getTotal() - 1);
		
		IndicadorFactory indicadorFactory = new IndicadorFactory(getNomeIndicador(), getNomeMedia());
		
		gerador.plotaIndicador(indicadorFactory.getIndicador());
		
		this.modeloGrafico = gerador.getModeloGrafico();
		
	}
	
	public List<Negociacao> getNegociacoes() {		
		return this.negociacoes;		
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeIndicador() {
		return nomeIndicador;
	}

	public void setNomeIndicador(String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}	
	
}
