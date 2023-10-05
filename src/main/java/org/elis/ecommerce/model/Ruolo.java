package org.elis.ecommerce.model;


public enum Ruolo {
	ADMIN("ADMIN"),
	VENDITORE("VENDITORE"),
	UTENTE("UTENTE");
	
	private String ruolo;
	
	private Ruolo(String s) {
		ruolo=s;
	}
	
	public String getRuolo() {
		return ruolo;
	}
}
