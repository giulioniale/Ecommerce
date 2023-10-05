package org.elis.ecommerce.controller.admin;

import java.util.List;

import org.elis.ecommerce.dto.request.RegistrazioneDtoRequest;
import org.elis.ecommerce.dto.response.MarcaDtoResponse;
import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.facade.AdminControllerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/adminController")
public class AdminController {
	
	@Autowired
	AdminControllerFacade facadeAdmin;
	
	@GetMapping(value="/aggiungiAdmin")
	public ResponseEntity<UtenteDtoResponse> creaAdmin(@Valid @RequestBody RegistrazioneDtoRequest request){
		return ResponseEntity.ok(facadeAdmin.creaAdmin(request)) ;
	}
	
	@GetMapping(value="/listaUtenti")
	public ResponseEntity<List<UtenteDtoResponse>> findAllUtenti() {
		return ResponseEntity.ok(facadeAdmin.findAllUtenti()) ;
	}
	
//	--------------------------------MARCA--------------------------------
	@GetMapping(value="/aggiungiMarca")
	public ResponseEntity<MarcaDtoResponse> aggiungiMarca(@RequestParam(value="nome")String nome){
		return ResponseEntity.ok(facadeAdmin.aggiungiMarca(nome));
	}
	
	@GetMapping(value="/deleteMarcaById")
	public ResponseEntity<String> deleteMarcaById(@RequestParam(value="id") long id){
		return ResponseEntity.ok(facadeAdmin.deleteMarcaById(id));
	}
	
	@GetMapping(value="/deleteMarcaByNome")
	public ResponseEntity<String> deleteMarcaByNome(@RequestParam(value="nome")String nome){
		return ResponseEntity.ok(facadeAdmin.deleteMarcaByNome(nome));
	}
	
//	--------------------------------PRODOTTO--------------------------------
	@GetMapping(value="/findAllProdotti")
	public ResponseEntity<List<ProdottoDtoResponse>> findAllProdotti(){
		return ResponseEntity.ok(facadeAdmin.findAllProdotti());
	}
	
	@GetMapping(value="/findProdottoByID")
	public ResponseEntity<ProdottoDtoResponse> findProdottoByID(@RequestParam(value="id")long id){
		return ResponseEntity.ok(facadeAdmin.findProdottoByID(id));
	}
}
