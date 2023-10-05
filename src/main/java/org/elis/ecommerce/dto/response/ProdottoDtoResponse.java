package org.elis.ecommerce.dto.response;

import java.util.List;

import org.elis.ecommerce.model.IVA;

public class ProdottoDtoResponse {
	private long idProdotto;
	private String nome;
	private String descrizione;
	private double prezzo;
	private String marca;
	private int quantita;
	private List<String> sottocategoria;
	private IVA iva;
	private String nomeVenditore;
	private boolean cancellato;
	
	
	
	
	public ProdottoDtoResponse() {
	}
	
	public long getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(long idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public IVA getIva() {
		return iva;
	}
	public void setIva(IVA iva) {
		this.iva = iva;
	}

	public List<String> getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(List<String> sottocategoria) {
		this.sottocategoria = sottocategoria;
	}

	public String getNomeVenditore() {
		return nomeVenditore;
	}

	public void setNomeVenditore(String nomeVenditore) {
		this.nomeVenditore = nomeVenditore;
	}

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}
	
	
}
