package org.elis.ecommerce.dto.request;


public class IndirizzoDtoRequest {
	private long idIndirizzo;
	private String indirizzo1;
	private String indirizzo2;
	private String provincia;
	private String cap;
	private String numeroTelefono;
	private String comune;
	private String nome;
	private long idUtente;
	public long getIdIndirizzo() {
		return idIndirizzo;
	}
	public void setIdIndirizzo(long idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}
	public String getIndirizzo1() {
		return indirizzo1;
	}
	public void setIndirizzo1(String indirizzo1) {
		this.indirizzo1 = indirizzo1;
	}
	public String getIndirizzo2() {
		return indirizzo2;
	}
	public void setIndirizzo2(String indirizzo2) {
		this.indirizzo2 = indirizzo2;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	
	
}
