package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtenteMapper {

	@Autowired
	IndirizzoMapper mapperIndirizzo;
	@Autowired
	OrdineMapper mapperOrdine;
	
	public UtenteDtoResponse toDTO(Utente u) {
		if(u==null)return null;
		UtenteDtoResponse utente = new UtenteDtoResponse();
	
		utente.setIdUtente(u.getIdUtente());
		utente.setNome(u.getNome());
		utente.setCognome(u.getCognome());
		utente.setEmail(u.getEmail());
		utente.setPassword(u.getPassword());
		utente.setRuolo(u.getRuolo());
		utente.setIndirizzi(mapperIndirizzo.listToDTO(u.getIndirizzi()));
		utente.setOrdini(mapperOrdine.listToDTO(u.getOrdini()));
		return utente;
	}
	
	public List<UtenteDtoResponse> listToDTO(List<Utente> utenti){
		if(utenti==null)return null;
		return utenti.stream().map(this::toDTO).toList();
	}
	
}
