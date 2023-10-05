package org.elis.ecommerce.dto.request;

import java.util.List;

import org.elis.ecommerce.model.IVA;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdottoDtoRequest {
	
	
	@NotBlank(message= "Devi inserire un nome")
	private String nome;
	
	@NotBlank(message= "Devi inserire una descrizione")
	private String descrizione;
	
	@Positive(message= "Il prezzo deve essere positivo")
	private double prezzo;
	
	@Min(value = 1, message= "Devi inserire una ID maggiore di 0")
	private long idMarca;
	
	
	private List<Long> idSottocategorie;
	

	@Min(value = 1, message= "Devi inserire una quantità maggiore di 0")
	private int quantita;
	
	@NotNull
	private IVA iva;

	
	
	
	
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
	public long getMarca() {
		return idMarca;
	}
	public void setMarca(long idMarca) {
		this.idMarca = idMarca;
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
	public List<Long> getIdSottocategorie() {
		return idSottocategorie;
	}
	public void setIdSottocategorie(List<Long> idSottocategorie) {
		this.idSottocategorie = idSottocategorie;
	}
	
	
}
