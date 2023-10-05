package org.elis.ecommerce.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String indirizzo1;
	private String indirizzo2;
	@Column(nullable = false)
	private String provincia;
	@Column(nullable = false)
	private String cap;
	@Column(nullable = false)
	private String numeroTelefono;
	@Column(nullable = false)
	private String comune;
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="idUtente")
	private Utente utente;
	
	
	
	
	public Indirizzo(){}
	
	public Indirizzo(String indirizzo1, String provincia, String cap, String numeroTelefono, String comune, String nome,
			Utente utente) {
		this.indirizzo1 = indirizzo1;
		this.provincia = provincia;
		this.cap = cap;
		this.numeroTelefono = numeroTelefono;
		this.comune = comune;
		this.nome = nome;
		
		this.utente = utente;
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Utente getUtente() {
		return utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cap, comune, indirizzo1, indirizzo2, nome, numeroTelefono, provincia, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indirizzo other = (Indirizzo) obj;
		return Objects.equals(cap, other.cap) && Objects.equals(comune, other.comune)
				&& Objects.equals(indirizzo1, other.indirizzo1) && Objects.equals(indirizzo2, other.indirizzo2)
				&& Objects.equals(nome, other.nome) && Objects.equals(numeroTelefono, other.numeroTelefono)
				&& Objects.equals(provincia, other.provincia) && Objects.equals(utente, other.utente);
	}
	
}
