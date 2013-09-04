package br.com.caelum.argentum.modelo;

import java.util.List;

public class SerieTemporal {

	private final List<Candlestick> candles;

	public SerieTemporal(List<Candlestick> candles) {
		this.candles = candles;
	}

	public Candlestick getCandle(int i) {
		return candles.get(i);
	}
	
	public int getTotal() {
		return this.candles.size();
	}
	
}
