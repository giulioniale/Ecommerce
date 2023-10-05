package org.elis.ecommerce.dto.response;

import java.util.List;

public class SottocategoriaDtoResponse {
	
	private long idSottocategoria;
	private String nome;
	private String nomeCategoria;
	private List<ProdottoDtoResponse> prodotti;
	
	
	public SottocategoriaDtoResponse() {
	}
	
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
	

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<ProdottoDtoResponse> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<ProdottoDtoResponse> prodotti) {
		this.prodotti = prodotti;
	}
	
}
