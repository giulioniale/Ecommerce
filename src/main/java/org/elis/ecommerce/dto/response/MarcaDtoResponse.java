package org.elis.ecommerce.dto.response;

import java.util.List;

public class MarcaDtoResponse {
	private long idMarca;
	private String nome;
	private List<ProdottoDtoResponse> prodotti;
	
	public MarcaDtoResponse() {
	}

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

	public List<ProdottoDtoResponse> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<ProdottoDtoResponse> prodotti) {
		this.prodotti = prodotti;
	}
	
	
}
