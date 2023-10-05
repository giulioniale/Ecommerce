package org.elis.ecommerce.dto.response;


public class RigaDordineDtoResponse {
	
	private String mail;
	private long idProdotto;
	private int quantita;
	
	
	
	public RigaDordineDtoResponse() {
	}
	
	public long getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(long idProdotto) {
		this.idProdotto = idProdotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
}
