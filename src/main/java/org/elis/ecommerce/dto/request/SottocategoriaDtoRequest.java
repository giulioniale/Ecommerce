package org.elis.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SottocategoriaDtoRequest {

	private long idSottocategoria;
	
	@NotBlank
	private String nome;
	
	private long idCategoria;
	
	
	
	public long getIdSottocategoria() {
		return idSottocategoria;
	}
	public void setIdSottocategoria(long idSottocategoria) {
		this.idSottocategoria = idSottocategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
