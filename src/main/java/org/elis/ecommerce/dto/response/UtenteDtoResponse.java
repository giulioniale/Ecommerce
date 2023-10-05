package org.elis.ecommerce.dto.response;

import java.util.List;
import org.elis.ecommerce.model.Ruolo;

public class UtenteDtoResponse {
	
	private long idUtente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Ruolo ruolo;
	private List<IndirizzoDtoResponse> indirizzi;
	private List<OrdineDtoResponse> ordini;
	
	
	
	
	public UtenteDtoResponse() {
	}
	
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public List<IndirizzoDtoResponse> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(List<IndirizzoDtoResponse> indirizzi) {
		this.indirizzi = indirizzi;
	}

	public List<OrdineDtoResponse> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<OrdineDtoResponse> ordini) {
		this.ordini = ordini;
	}
	
	
	
}
