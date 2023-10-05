package org.elis.ecommerce.facade;


import java.util.List;

import org.elis.ecommerce.dto.request.RegistrazioneDtoRequest;
import org.elis.ecommerce.dto.response.MarcaDtoResponse;
import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.mapper.MarcaMapper;
import org.elis.ecommerce.mapper.ProdottoMapper;
import org.elis.ecommerce.mapper.UtenteMapper;
import org.elis.ecommerce.model.Marca;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.service.MarcaService;
import org.elis.ecommerce.service.ProdottoService;
import org.elis.ecommerce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminControllerFacade {

	@Autowired
	UtenteService utenteServ;
	@Autowired
	MarcaService marcaServ;
	@Autowired
	ProdottoService prodottoServ;
	@Autowired
	UtenteMapper mapperUtente;
	@Autowired
	MarcaMapper mapperMarca;
	@Autowired
	ProdottoMapper mapperProdotto;

	public UtenteDtoResponse creaAdmin(RegistrazioneDtoRequest request) {
		Utente u = utenteServ.aggiungiAdmin(request);
		return mapperUtente.toDTO(u);
	}

	
	public List<UtenteDtoResponse> findAllUtenti() {
		List<Utente> utenti = utenteServ.findAll();
		return mapperUtente.listToDTO(utenti);
	}
//	--------------------------------MARCA--------------------------------
	public MarcaDtoResponse aggiungiMarca(String nome) {
		Marca m = marcaServ.aggiungiMarca(nome);
		return mapperMarca.toDTO(m);
	}
	
	public String deleteMarcaById(long id) {
		if(marcaServ.findMarcaById(id)!=null) {
			marcaServ.deleteMarcaById(id);
			return "Marca cancellata con successo";
		}
		return "Marca con ID " +id+ " non trovata";
	}
	
	public String deleteMarcaByNome(String nome) {
		if(marcaServ.findMarcaByNome(nome)!=null) {
			marcaServ.deleteMarcaByNome(nome);
			return "Marca cancellata con successo";
		}
		return "Marca con nome " +nome+ " non trovata";
	}
	
//	--------------------------------PRODOTTO--------------------------------
	public List<ProdottoDtoResponse> findAllProdotti(){
		List<Prodotto> p = prodottoServ.findAllProdotti();
		return mapperProdotto.listToDTO(p);
	}
	
	public ProdottoDtoResponse findProdottoByID(long id){
		Prodotto p = prodottoServ.findProdottoById(id);
		return mapperProdotto.toDTO(p);
	}
}
