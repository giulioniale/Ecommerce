package org.elis.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RigaDordineDtoRequest{
	@NotBlank(message= "Devi inserire un ID Prodotto")
	@Min(value =1, message= "Devi inserire un ID maggiore di 0")
	private long idProdotto;
	@NotBlank(message= "Devi inserire una quiantità")
	@Positive(message= "Devi inserire una quantità positiva")
	private int quantita;
	
	
	

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
	
}
