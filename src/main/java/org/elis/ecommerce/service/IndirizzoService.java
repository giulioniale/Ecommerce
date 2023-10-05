package org.elis.ecommerce.service;

import java.util.List;

import org.elis.ecommerce.dto.request.IndirizzoDtoRequest;
import org.elis.ecommerce.model.Indirizzo;

public interface IndirizzoService {
	
	public Indirizzo saveIndirizzo(IndirizzoDtoRequest request);
	public Indirizzo updateIndirizzo(IndirizzoDtoRequest request);
	public void deleteById(long id);
	
	public Indirizzo findById(long id);
	public Indirizzo findByNomeAndUtente_Id(String nome, Long idUtente); //TODO da controllare con antonio
	public List<Indirizzo> findAll();
	public List<Indirizzo> findAllByComune(String comune);
	public List<Indirizzo> findAllByProvincia(String provincia);
	public List<Indirizzo> findByNumeroDiTelefono(String numeroDiTelefono);
	
}
