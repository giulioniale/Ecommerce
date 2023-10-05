package org.elis.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MarcaDtoRequest {
	
	@Min(value = 1, message= "Devi inserire una ID Marca maggiore di 0")
	private long idMarca;
	
	@NotBlank (message= "Devi inserire un nome")
	private String nome;
	

	
	public long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(long idMarca) {
		this.idMarca = idMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
