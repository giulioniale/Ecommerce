package org.elis.ecommerce.controller.generic;

import org.elis.ecommerce.dto.request.LoginDtoRequest;
import org.elis.ecommerce.dto.request.RegistrazioneDtoRequest;
import org.elis.ecommerce.dto.response.MarcaDtoResponse;
import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.facade.GenericFacade;
import org.elis.ecommerce.mapper.UtenteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/genericController")
public class GenericController {
	
	@Autowired
	GenericFacade facadeGeneric;
	@Autowired
	UtenteMapper mapperUtente;
	
//	--------------------------------UTENTE--------------------------------
	@GetMapping(value="/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDtoRequest request) {
		String s= facadeGeneric.login(request);
		return ResponseEntity.status(HttpStatus.OK).header("Authorization", s).build() ;
	}
	
	@GetMapping(value="/aggiungiUtente")
	public ResponseEntity<UtenteDtoResponse> creaUtente(@Valid @RequestBody RegistrazioneDtoRequest registrazione){
		return ResponseEntity.ok(facadeGeneric.aggiungiCliente(registrazione));
	}
	
	@GetMapping(value="/aggiungiVenditore")
	public ResponseEntity<UtenteDtoResponse> creaVenditore(@Valid @RequestBody RegistrazioneDtoRequest request){
		
		return ResponseEntity.ok(facadeGeneric.creaVenditore(request));
	}
	
	@PostMapping("/getUtente")
	public ResponseEntity<UtenteDtoResponse> getUtenteLoggato(UsernamePasswordAuthenticationToken token){
		return ResponseEntity.ok(facadeGeneric.getUtenteLoggato(token));
	}
	
//	--------------------------------MARCA--------------------------------

	@GetMapping(value="/findMarcaById")
	public ResponseEntity<MarcaDtoResponse> findMarcaById(@RequestParam(value="id") long id){
		return ResponseEntity.ok(facadeGeneric.findMarcaById(id));
	}
	
	@GetMapping(value="/findMarcaByNome")
	public ResponseEntity<MarcaDtoResponse> findMarcaBynome(@RequestParam(value="nome")String nome){
		return ResponseEntity.ok(facadeGeneric.findMarcaByNome(nome));
	}

}
