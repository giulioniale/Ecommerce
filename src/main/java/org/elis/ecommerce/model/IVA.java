package org.elis.ecommerce.model;

public enum IVA {
	QUATTRO(4),
	DIECI(10),
	VENTIDUE(22);
	
	private int iva;
	
	IVA (int iva){
		this.iva= iva;
	}
	
	public double calcolaPrezzoIvato(double prezzo) {
		return (prezzo*iva)/100+prezzo;
	}
}
