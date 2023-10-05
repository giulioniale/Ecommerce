package org.elis.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
public class RigaDordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRigaOrdine;
	@Column(nullable = false)
	private int quantita;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_prodotto", referencedColumnName="id", nullable = false),
        @JoinColumn(name="nome_prodotto", referencedColumnName="nome", nullable = false)})
	private Prodotto prodotto;
	
	@ManyToOne
	@JoinColumn(name="idOrdine")
	private Ordine ordine;
	
	
	
	
	public RigaDordine() {}

	public RigaDordine(Prodotto prodotto, int quantita) {
		this.prodotto = prodotto;
		this.quantita = quantita;
	}

	public long getIdRigaOrdine() {
		return idRigaOrdine;
	}
	
	public void setIdRigaOrdine(long idRigaOrdine) {
		this.idRigaOrdine = idRigaOrdine;
	}
	
	public Prodotto getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public Ordine getOrdine() {
		return ordine;
	}
	
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	public double prezzoTotRiga() {
		return this.getProdotto().getIva().calcolaPrezzoIvato(this.getProdotto().getPrezzo())*this.quantita;
	}
	
	
}
