package org.elis.ecommerce.facade;

import java.util.List;

import org.elis.ecommerce.dto.request.RigaDordineDtoRequest;
import org.elis.ecommerce.dto.response.OrdineDtoResponse;
import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.mapper.OrdineMapper;
import org.elis.ecommerce.mapper.ProdottoMapper;
import org.elis.ecommerce.mapper.RigadDordineMapper;
import org.elis.ecommerce.mapper.UtenteMapper;
import org.elis.ecommerce.model.Ordine;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.service.OrdineService;
import org.elis.ecommerce.service.ProdottoService;
import org.elis.ecommerce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UtenteControllerFacade {
	@Autowired
	UtenteService utenteServ;
	@Autowired
	OrdineService ordineServ;
	@Autowired
	ProdottoService prodottoServ;
	@Autowired
	UtenteMapper mapperUtente;
	@Autowired
	RigadDordineMapper mapperRiga;
	@Autowired
	OrdineMapper mapperOrdine;
	@Autowired
	ProdottoMapper mapperProdotto;

	
	
	public OrdineDtoResponse aggiungiRiga(RigaDordineDtoRequest request, UsernamePasswordAuthenticationToken token){
		Utente u = (Utente)token.getPrincipal();
		Prodotto p = prodottoServ.findProdottoById(request.getIdProdotto());
		Ordine ordine = ordineServ.aggiungiRigaDordine(u, p, request.getQuantita()).get();
		return mapperOrdine.toDTO(ordine);
	}
	
	public OrdineDtoResponse visualizzaCarrello(UsernamePasswordAuthenticationToken token){
		Ordine o = ordineServ.findCarrello((Utente)token.getPrincipal());
		return mapperOrdine.toDTO(o);
	}
	
	public OrdineDtoResponse confermaOrdine(UsernamePasswordAuthenticationToken token){
		Utente u = (Utente)token.getPrincipal();
		Ordine o = ordineServ.confermaCarrello(u);
		o.setRighe(null);
		return mapperOrdine.toDTO(o);
	}
	
	public OrdineDtoResponse rimuoviRiga(RigaDordineDtoRequest request, UsernamePasswordAuthenticationToken token){
		Utente u = (Utente)token.getPrincipal();
		Ordine o = ordineServ.findCarrello(u);
		ordineServ.rimuoviRigaDordine(request, u);
		return mapperOrdine.toDTO(o);
	}
	
	public List<ProdottoDtoResponse> getAllProdotti(UsernamePasswordAuthenticationToken token){
		List<Prodotto> prodotti = prodottoServ.findAllProdotti().stream()
				.filter(p->p.getCancellato()==false).toList();
		return mapperProdotto.listToDTO(prodotti);
	}
	
	public List<ProdottoDtoResponse> findProdottoByNome(String nome){
		List<Prodotto> p = prodottoServ.findByNome(nome);
		return mapperProdotto.listToDTO(p);
	}
}
