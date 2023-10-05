package org.elis.ecommerce.dto.response;

import java.util.List;

public class CategoriaDtoResponse {

	private long id;
	private String nome;
	private List<SottocategoriaDtoResponse> sottocategoria;

	public CategoriaDtoResponse() {
	}
	
	
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

	public List<SottocategoriaDtoResponse> getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(List<SottocategoriaDtoResponse> sottocategoria) {
		this.sottocategoria = sottocategoria;
	}
	
	
}
