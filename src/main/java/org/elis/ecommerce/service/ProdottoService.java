package org.elis.ecommerce.service;

import java.util.List;

import org.elis.ecommerce.dto.request.ProdottoDtoRequest;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Utente;

public interface ProdottoService {
	
	public Prodotto aggiungiProdotto(ProdottoDtoRequest request, Utente u);
	public boolean deleteProdottoById(long id);
	
	public Prodotto findProdottoById(long id);
	public List<Prodotto> findAllProdotti();
	public List<Prodotto> findByNome(String nome);
	public List<Prodotto> findBySottocategoria_Id(long id);
	public List<Prodotto> findAllProdottiByVenditore_Id(long id);
	public List<Prodotto> findByMarca(String marca);
	public Prodotto findByNomeAndIdVenditore(String nome, long id_venditore);
	public Prodotto findProdottoByIdAndVenditore_IdUtente(long id, long id_venditore);
	
}
