package org.elis.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrdine;
	
	@Column(nullable = false)
	private boolean cancellato = false;
	
	@OneToMany(mappedBy = "ordine", cascade = {CascadeType.PERSIST, CascadeType.MERGE, })
	private List<RigaDordine> righe;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Utente cliente;
	private LocalDateTime dataInvioOrdine;
	
	
	
	public Ordine() {}
	
	public Ordine(Utente cliente,RigaDordine riga, LocalDateTime dataInvioOrdine, double prezzoTotale) {
		this.cliente = cliente;
		this.righe.add(riga);
		this.dataInvioOrdine = dataInvioOrdine;
	}

	public long getIdOrdine() {
		return idOrdine;
	}
	
	public void setIdOrdine(long idOrdine) {
		this.idOrdine = idOrdine;
	}
	
	public List<RigaDordine> getRighe() {
		return righe;
	}
	
	public void setRighe(List<RigaDordine> righe) {
		this.righe = righe;
	}
	
	public Utente getCliente() {
		return cliente;
	}
	
	public void setCliente(Utente cliente) {
		this.cliente = cliente;
	}
	
	public LocalDateTime getDataInvioOrdine() {
		return dataInvioOrdine;
	}
	
	public void setDataInvioOrdine(LocalDateTime dataInvioOrdine) {
		this.dataInvioOrdine = dataInvioOrdine;
	}
	
	
	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	public List<RigaDordine> aggiungiProdotto(Prodotto p, int quantita) {
		if(this.righe==null)righe=new ArrayList<>();
		RigaDordine r = new RigaDordine();
		r=getRiga(p.getIdProdotto());
		if(r==null) {
			r=new RigaDordine(p, quantita);
			r.setOrdine(this);
			this.righe.add(r);
		}else if(p.getQuantita()>(r.getQuantita()+quantita)){
			r.setQuantita(r.getQuantita()+quantita);
		}
		return this.righe;
	}
	
	public RigaDordine getRiga(long idProdotto) {
		RigaDordine r = righe.stream()
		.filter(r1->r1.getProdotto().getIdProdotto()==idProdotto)
		.findFirst().orElse(null);
		return r;
	}
	
}
