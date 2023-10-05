 package org.elis.ecommerce.controller.utente;


import java.util.List;

import org.elis.ecommerce.dto.request.RigaDordineDtoRequest;
import org.elis.ecommerce.dto.response.OrdineDtoResponse;
import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.facade.UtenteControllerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/utenteController")
public class UtenteController {
	
	@Autowired
	UtenteControllerFacade facadeUtente;

	
	@GetMapping(value="/aggiungiRiga")
	public ResponseEntity<OrdineDtoResponse> aggiungiRiga(@Valid @RequestBody RigaDordineDtoRequest request, UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeUtente.aggiungiRiga(request, token));
	}
	
	@GetMapping(value="/visualizzaCarrello")
	public ResponseEntity<OrdineDtoResponse> visualizzaCarrello(UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeUtente.visualizzaCarrello(token));
	}
	
	@GetMapping(value = "/confermaOrdine")
	public ResponseEntity<OrdineDtoResponse> confermaOrdine(UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeUtente.confermaOrdine(token));
	}
	
	@GetMapping(value ="/rimuoviRiga")
	public ResponseEntity<OrdineDtoResponse> rimuoviRiga(@Valid @RequestBody RigaDordineDtoRequest request, UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeUtente.rimuoviRiga(request, token));
	}
	
	@GetMapping(value="/visualizzaAllProdotti")
	public ResponseEntity<List<ProdottoDtoResponse>> getAllProdotti(UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeUtente.getAllProdotti(token));
	}
	
	@GetMapping(value="/findProdottoByNome")
	public ResponseEntity<List<ProdottoDtoResponse>> findProdottoByID(@RequestParam(value="nome")String nome){
		return ResponseEntity.ok(facadeUtente.findProdottoByNome(nome));
	}
}
