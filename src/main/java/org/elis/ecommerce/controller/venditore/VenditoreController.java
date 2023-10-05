package org.elis.ecommerce.controller.venditore;

import java.util.List;

import org.elis.ecommerce.dto.request.LoginDtoRequest;
import org.elis.ecommerce.dto.request.ProdottoDtoRequest;
import org.elis.ecommerce.dto.request.SottocategoriaDtoRequest;
import org.elis.ecommerce.dto.response.CategoriaDtoResponse;
import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.dto.response.SottocategoriaDtoResponse;
import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.exception.DatiNonValidiException;
import org.elis.ecommerce.facade.VenditoreControllerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/venditoreController")
public class VenditoreController {
	
	@Autowired
	VenditoreControllerFacade facadeVenditore;
	
	
	@GetMapping(value="/findVenditore")
	public ResponseEntity<UtenteDtoResponse> findVenditore(@Valid @RequestBody LoginDtoRequest login){
			return ResponseEntity.ok(facadeVenditore.findVenditore(login)) ;
	}
//	--------------------------------CATEGORIA--------------------------------
	@GetMapping(value="/aggiungiCategoria")
	public ResponseEntity<CategoriaDtoResponse> aggiungiCategoria(@Valid @RequestParam(value="nome")String nome){
		return ResponseEntity.ok(facadeVenditore.aggiungiCategoria(nome));
	}
	
	@GetMapping(value="/findCategoriaByID")
	public ResponseEntity<CategoriaDtoResponse> findCategorie(@Valid @RequestParam(value="id") long id ){
		if(id>0) {
			return ResponseEntity.ok(facadeVenditore.findCategoriaById(id));
		}
		throw new DatiNonValidiException(id, "Inserisci un numero maggiore di 0");
	}
	
	@GetMapping(value="/findAllCategoria")
	public ResponseEntity<List<CategoriaDtoResponse>> findAllCategoria(){
		return ResponseEntity.ok(facadeVenditore.findAllCategoria());
	}
	
	@GetMapping(value="/deleteCategoriaByID")
	public ResponseEntity<String> deleteCategoriaById(@RequestParam(value="id")long id){
		if(id>0) {
			return ResponseEntity.ok(facadeVenditore.deleteCategoriaById(id));
		}
		throw new DatiNonValidiException(id, "Inserisci un numero maggiore di 0");
	}
	
	@GetMapping(value="/deleteCategoriaByNome")
	public ResponseEntity<String> deleteCategoriaByNome(@RequestParam(value="nome")String nome){
		return ResponseEntity.ok(facadeVenditore.deleteCategoriaByNome(nome));
	}
	
	
//	--------------------------------SOTTOCATEGORIA--------------------------------
	@GetMapping(value="/aggiungiSottocategoria")
	public ResponseEntity<SottocategoriaDtoResponse> aggiungiSottocategoria(@Valid @RequestBody SottocategoriaDtoRequest request){
		return ResponseEntity.ok(facadeVenditore.aggiungiSottocategoria(request));
	}
	
	@GetMapping(value="/findAllSottocategoria")
	public ResponseEntity<List<SottocategoriaDtoResponse>> findAllSottocategoria(){
		return ResponseEntity.ok(facadeVenditore.findAllSottocategoria());
	}

	
//	--------------------------------PRODOTTO--------------------------------
	@GetMapping(value="/aggiungiProdotto")
	public ResponseEntity<ProdottoDtoResponse> aggiungiProdotto(@Validated @RequestBody ProdottoDtoRequest p, UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeVenditore.aggiungiProdotto(p, token)) ;
	}
	
	@GetMapping(value="/rimuoviProdotto")
	public ResponseEntity<String> deleteProdotto(@RequestParam(value="id") long id){
		return ResponseEntity.ok(facadeVenditore.deleteProdottoById(id));
	}
	
	@GetMapping(value="/findProdottoByIdAndUtente")
	public ResponseEntity<ProdottoDtoResponse> findProdottoByIdAndUtente(@RequestParam(value="id")long id, UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeVenditore.findProdottoByIdAndUtente(id, token));
	}
	
	@GetMapping(value="/findProdottoByNomeAndIDUtente")
	public ResponseEntity<ProdottoDtoResponse> findProdottoByNomeAndIDUtente(@RequestParam(value="nome")String nome, UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeVenditore.findProdottoByNomeAndIDUtente(nome, token));
	}
	
	@GetMapping(value="/findAllProdottiByIdUtente")
	public ResponseEntity<List<ProdottoDtoResponse>> findAllProdottiByIdUtente(UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeVenditore.findAllProdottiByIdUtente(token));
	}
	
	

}
