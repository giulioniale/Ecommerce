package org.elis.ecommerce.dto.response;

import org.elis.ecommerce.model.Indirizzo;

public class IndirizzoDtoResponse {

	private long id;
	private String indirizzo1;
	private String indirizzo2;
	private String provincia;
	private String cap;
	private String numeroTelefono;
	private String comune;
	private String descrizione;
	private String utente;
	private String nome;


	public IndirizzoDtoResponse() {
		super();
	}


	public IndirizzoDtoResponse(Indirizzo indirizzo) {
		super();
		this.id = indirizzo.getId();
		this.indirizzo1 = indirizzo.getIndirizzo1();
		this.indirizzo2 = indirizzo.getIndirizzo2();
		this.provincia = indirizzo.getProvincia();
		this.cap = indirizzo.getCap();
		this.numeroTelefono = indirizzo.getNumeroTelefono();
		this.comune = indirizzo.getComune();
		this.descrizione = indirizzo.getNome();
		this.utente = indirizzo.getUtente().getEmail();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
