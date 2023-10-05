package org.elis.ecommerce.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private double prezzo;
	@Column(nullable = false)
	private int quantita;
	@Column(nullable = false)
	private IVA iva;
	
	@ManyToOne
	@JoinColumn(name="idMarca")
	private Marca marca;
	@ManyToMany(mappedBy="prodotti")
	private List<Sottocategoria> sottocategorie;
	@ManyToOne
	@JoinColumn(name="id_venditore",nullable = false)
	private Utente venditore;
	@Column(nullable = false)
	private boolean cancellato = false;
	
	
	
	public Prodotto() {}
	
	public Prodotto(String nome, String descrizione, double prezzo, Marca marca,List<Sottocategoria> sottocategorie, int quantita, IVA iva,
			Utente venditore) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.marca = marca;
		this.sottocategorie= sottocategorie;
		this.quantita = quantita;
		this.iva = iva;
		this.venditore = venditore;
	}

	public Prodotto clone() {
		Prodotto p=new Prodotto();
		p.setIdProdotto(id);
		p.setNome(nome);
		p.setDescrizione(descrizione);
		p.setPrezzo(prezzo);
		p.setMarca(marca);
		p.setQuantita(quantita);
		p.setIva(iva);
		p.setVenditore(venditore);
		return p;
	}
	
	public long getIdProdotto() {
		return id;
	}
	
	public void setIdProdotto(long idProdotto) {
		this.id = idProdotto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public List<Sottocategoria> getSottocategoria() {
		return sottocategorie;
	}
	
	public void setSottocategoria(List<Sottocategoria> sottocategoria) {
		this.sottocategorie = sottocategoria;
	}
	
	public IVA getIva() {
		return iva;
	}
	
	public void setIva(IVA iva) {
		this.iva = iva;
	}
	
	public Utente getVenditore() {
		return venditore;
	}
	
	public void setVenditore(Utente venditore) {
		this.venditore = venditore;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Sottocategoria> getSottocategorie() {
		return sottocategorie;
	}

	public void setSottocategorie(List<Sottocategoria> sottocategorie) {
		this.sottocategorie = sottocategorie;
	}

	public boolean getCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		return id == other.id;
	}
	
	public void deleteSottocategoriaFromProdotto(long id) {
		List<Sottocategoria> sottocatProd = getSottocategoria();
		sottocatProd.removeIf(s->s.getId()==id);
		this.sottocategorie=sottocatProd;
	}
}
