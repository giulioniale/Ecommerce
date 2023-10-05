package org.elis.ecommerce.facade;

import org.elis.ecommerce.dto.request.LoginDtoRequest;
import org.elis.ecommerce.dto.request.RegistrazioneDtoRequest;
import org.elis.ecommerce.dto.response.MarcaDtoResponse;
import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.exception.DatiNonValidiException;
import org.elis.ecommerce.mapper.MarcaMapper;
import org.elis.ecommerce.mapper.UtenteMapper;
import org.elis.ecommerce.model.Marca;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.security.GestoreToken;
import org.elis.ecommerce.service.MarcaService;
import org.elis.ecommerce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class GenericFacade {
	
	@Autowired
	UtenteService utenteServ;
	@Autowired
	MarcaService marcaServ;
	@Autowired
	GestoreToken tokenP;
	@Autowired
	UtenteMapper mapperUtente;
	@Autowired
	MarcaMapper mapperMarca;
	
	public String login(LoginDtoRequest request) {
		Utente u = utenteServ.login(request.getEmail(), request.getPassword());
		return tokenP.generaToken(u);
	}
	
	public UtenteDtoResponse getUtenteLoggato(UsernamePasswordAuthenticationToken token){
		Utente u=(Utente)token.getPrincipal();
		return mapperUtente.toDTO(u);
	}
	
	public UtenteDtoResponse aggiungiCliente(RegistrazioneDtoRequest request){
		Utente utente = utenteServ.aggiungiCliente(request);
		return mapperUtente.toDTO(utente);
	}
	
	public UtenteDtoResponse creaVenditore(RegistrazioneDtoRequest request){
		Utente u = utenteServ.aggiungiVenditore(request);
		return mapperUtente.toDTO(u);
	}
//	--------------------------------MARCA--------------------------------
	
	public MarcaDtoResponse findMarcaById(long id) {
		if(id<1)throw new DatiNonValidiException(id, "inserire un ID maggiore di 0");
		Marca m = marcaServ.findMarcaById(id);
		return mapperMarca.toDTO(m);
	}
	
	public MarcaDtoResponse findMarcaByNome(String nome) {
		if(nome==null || nome.isBlank())throw new DatiNonValidiException(nome, "Il campo nome non può essere vuoto");
		Marca m = marcaServ.findMarcaByNome(nome);
		return mapperMarca.toDTO(m);
	}

}
