package org.elis.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CategoriaDtoRequest {
	
	@Positive(message="devi inserire una ID maggiore di 0")
	private long id;
	
	@NotBlank(message="devi inserire un nome alla categoria")
	private String nome;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
