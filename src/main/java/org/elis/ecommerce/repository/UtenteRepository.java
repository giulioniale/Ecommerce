package org.elis.ecommerce.repository;

import java.util.Optional;

import org.elis.ecommerce.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long>{

	public Optional<Utente> findUtenteByEmailAndPassword(String email, String password);
	public Optional<Utente> findUtenteByEmail(String email);
	public void deleteByEmail(String email);
	public Optional<Utente> findUtenteByIndirizzi_id(long id);
//	public List<Utente> findAll();
//	public Utente saveUtente(Utente u);
//	public Utente updateUtente(Utente u);
//	public void deleteById(int id);
	
}
