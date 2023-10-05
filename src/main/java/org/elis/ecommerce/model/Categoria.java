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
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nome;
	@OneToMany(mappedBy = "categoria")
	private List<Sottocategoria> sottocategoria;
	@Column(nullable = false)
	private boolean cancellato = false;
	
	
	
	public Categoria() {}	
	
	public Categoria(String nome) {
		this.nome = nome;
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
	public List<Sottocategoria> getSottocategoria() {
		return sottocategoria;
	}
	public void setSottocategoria(List<Sottocategoria> sottocategoria) {
		this.sottocategoria = sottocategoria;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
	
}