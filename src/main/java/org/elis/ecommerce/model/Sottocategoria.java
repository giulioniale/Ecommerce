package org.elis.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Sottocategoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSottocategoria;
	private String nome;
	@Column(nullable = false)
	private boolean cancellato = false;
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	@ManyToMany
	@JoinTable(name="sottocategoria_prodotto",
				joinColumns=@JoinColumn(name="idSottocategoria"),
				inverseJoinColumns=@JoinColumn(name="idProdotto"))
	private List<Prodotto> prodotti;
	
	
	
	
	public Sottocategoria() {
	}

	public Sottocategoria(String nome, Categoria categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}

	public long getId() {
		return idSottocategoria;
	}
	
	public void setId(long id) {
		this.idSottocategoria = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Prodotto> getProdotto() {
		return prodotti;
	}
	
	public void setProdotto(List<Prodotto> prodotto) {
		this.prodotti = prodotto;
	}
	
	
	public long getIdSottocategoria() {
		return idSottocategoria;
	}

	public void setIdSottocategoria(long idSottocategoria) {
		this.idSottocategoria = idSottocategoria;
	}

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public void aggiungiProdotto(Prodotto p) {
		if(prodotti==null)prodotti=new ArrayList<>();
		if(prodotti.stream().anyMatch(p1->p1.getIdProdotto()==p.getIdProdotto()))
			return;
		prodotti.add(p);
		
	}
	
}
