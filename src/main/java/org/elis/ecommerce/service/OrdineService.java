 package org.elis.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.dto.request.OrdineDtoRequest;
import org.elis.ecommerce.dto.request.RigaDordineDtoRequest;
import org.elis.ecommerce.model.Ordine;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Utente;

public interface OrdineService {
	
	public Optional<Ordine> aggiungiOrdine(OrdineDtoRequest request);
	public Optional<Ordine> aggiungiRigaDordine(Utente utente, Prodotto prodotto,int quantita);
	public void rimuoviRigaDordine(RigaDordineDtoRequest request, Utente u);
	public void deleteById(long id);
	public void deleteRigadordineById(long id);
	public double calcolaPrezzoTotale(Ordine o);
	
	public List<Ordine> findAll();
	public Ordine findById(long id);
	public Ordine findCarrello(Utente utente);
	public Ordine confermaCarrello(Utente utente);
	public List<Ordine> findAllOrdineByIdCliente(long idCliente);
	public List<Ordine> findAllOrdineByDataInvioOrdine(LocalDateTime dataInvioOrdine);
//	public List<Ordine> findAllOrdineByGreaterThenDataInvioOrdine(LocalDateTime dataInvioOrdine);
//	public List<Ordine> findAllOrdineByLessThenDataInvioOrdine(LocalDateTime dataInvioOrdine);

	
	
}
