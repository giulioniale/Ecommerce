package org.elis.ecommerce.service.impl;

import java.util.List;

import org.elis.ecommerce.dto.request.RegistrazioneDtoRequest;
import org.elis.ecommerce.dto.request.UtenteDtoRequest;
import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.exception.DatiNonValidiException;
import org.elis.ecommerce.model.Ruolo;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.repository.UtenteRepository;
import org.elis.ecommerce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteRepository utenteRepo;

	@Override
	public List<Utente> findAll() {
		List<Utente> utenti = utenteRepo.findAll();
		if(!utenti.isEmpty()) {
			return utenti;
		}
		return null;
	}

	@Override
	public Utente findByMailAndPsw(String email, String password) {
		Utente u = utenteRepo.findUtenteByEmailAndPassword(email, password)
				.orElseThrow(()->new DatiNonTrovatiException(email, "Non è stato trovato nessun utente con questi dati"));
		return u;
	}

	@Override
	public Utente aggiungiUtente(RegistrazioneDtoRequest request, Ruolo ruolo) {
		Utente u=utenteRepo.findUtenteByEmail(request.getEmail()).orElse(null);
		if(u!=null) {
			throw new DatiNonValidiException(request, "Esiste gia un utente con questi dati");
		}
		Utente utente = new Utente(request.getNome(),
				request.getCognome(),request.getEmail(),request.getPassword());
		utente.setRuolo(ruolo);
		utenteRepo.save(utente);
		return utente;
	}

	@Override
	public Utente aggiungiAdmin(RegistrazioneDtoRequest r) {
		Utente utente = aggiungiUtente(r, Ruolo.ADMIN);
		return utente;
	}

	@Override
	public Utente aggiungiVenditore(RegistrazioneDtoRequest r) {
		Utente utente= aggiungiUtente(r,Ruolo.VENDITORE);
		return utente;
	}

	@Override
	public Utente aggiungiCliente(RegistrazioneDtoRequest r) {
		Utente utente = aggiungiUtente(r,Ruolo.UTENTE);
		return utente;
	}

	@Override
	public Utente login(String email, String password) {
		Utente u = utenteRepo.findUtenteByEmailAndPassword(email, password)
				.orElseThrow(()->new DatiNonTrovatiException(email, "Login non riuscito, dati inseriti non validi"));
			return u;
	}


	public boolean updateUtente(UtenteDtoRequest u) {
		return false;
	}

	@Override
	public boolean deleteById(long id) {
		utenteRepo.findById(id).orElseThrow(()->new DatiNonTrovatiException(id, "Nessun utente trovato con ID " +id))
		.setCancellato(true);
		return true;
	}

	@Override
	public boolean deleteByEmail(String email) {
		utenteRepo.findUtenteByEmail(email)
				.orElseThrow(()->new DatiNonTrovatiException(email, "Nessun utente trovato con mail " +email))
				.setCancellato(true);
		return true;
	}

	@Override
	public Utente findById(long id) {
		return utenteRepo.findById(id)
				.orElseThrow(()->new DatiNonTrovatiException(id, "Nessun utente trovato con questo ID"));
	}

	@Override
	public Utente findByEmail(String mail) {
		return utenteRepo.findUtenteByEmail(mail)
				.orElseThrow(()->new DatiNonTrovatiException(mail, "Nessun utente trovato con questa mail"));
	}

	@Override
	public Utente findUtenteByIndirizzo_id(long id) {
		return utenteRepo.findUtenteByIndirizzi_id(id)
				.orElseThrow(()->new DatiNonTrovatiException(id, "Nessun utente trovato con questo indirizzo"));
	}



}
