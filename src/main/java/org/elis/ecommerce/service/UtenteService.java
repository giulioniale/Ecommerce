package org.elis.ecommerce.service;

import java.util.List;

import org.elis.ecommerce.dto.request.RegistrazioneDtoRequest;
import org.elis.ecommerce.model.Ruolo;
import org.elis.ecommerce.model.Utente;

public interface UtenteService {
	

	public Utente aggiungiUtente(RegistrazioneDtoRequest r, Ruolo ruolo);
	public Utente aggiungiAdmin(RegistrazioneDtoRequest r);
	public Utente aggiungiVenditore(RegistrazioneDtoRequest r);
	public Utente aggiungiCliente(RegistrazioneDtoRequest r);
	public Utente login(String mail, String password);
	public boolean deleteById(long id);
	public boolean deleteByEmail(String email);
	
	public Utente findById(long id);
	public Utente findByEmail(String mail);
	public List<Utente> findAll();
	public Utente findByMailAndPsw(String email, String password); 
	public Utente findUtenteByIndirizzo_id(long id);
//	Utente aggiungiUtente(Utente u);

}
