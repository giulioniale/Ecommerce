package org.elis.ecommerce.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMarca;
	@Column(nullable = false, unique=true)
	private String nome;
	@Column(nullable = false)
	private boolean cancellato = false;
	
	@OneToMany(mappedBy = "marca")
	private List<Prodotto> prodotti;
	
	
	
	
	public Marca() {}
	
	public Marca(String nome) {
		this.nome = nome;
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
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}
	
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(nome, other.nome);
	}
	

	
}
