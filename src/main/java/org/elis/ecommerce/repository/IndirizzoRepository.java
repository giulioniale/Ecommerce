package org.elis.ecommerce.repository;


import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.model.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long>{
	
	public Optional<Indirizzo> findIndirizzoByNomeAndUtente_IdUtente(String nome, Long idUtente); //TODO da controllare con antonio
	public Optional<List<Indirizzo>> findAllIndirizzoByComune(String comune);
	public Optional<List<Indirizzo>> findAllIndirizzoByProvincia(String provincia);
	public Optional<List<Indirizzo>> findAllIndirizzoByNumeroTelefono(String numeroTelefono);
	
	public Optional<Indirizzo> findIndirizzoByIndirizzo1(String indirizzo1);
	public Optional<Indirizzo> findIndirizzoByIndirizzo2(String indirizzo2);
	
	
}
