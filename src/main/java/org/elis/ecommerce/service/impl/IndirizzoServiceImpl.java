package org.elis.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.dto.request.IndirizzoDtoRequest;
import org.elis.ecommerce.model.Indirizzo;
import org.elis.ecommerce.repository.IndirizzoRepository;
import org.elis.ecommerce.repository.UtenteRepository;
import org.elis.ecommerce.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndirizzoServiceImpl implements IndirizzoService {
	
	@Autowired
	IndirizzoRepository indirizzoRepo;
	@Autowired
	UtenteRepository utenteRepo;
	
	@Override
	public Indirizzo saveIndirizzo(IndirizzoDtoRequest request) {
		
		if(request != null && indirizzoRepo.findIndirizzoByIndirizzo1(request.getIndirizzo1()).isEmpty()) {
			Indirizzo indirizzo = new Indirizzo(request.getIndirizzo1(), request.getProvincia(),request.getCap(),
					request.getNumeroTelefono(), request.getComune(),request.getNome(),utenteRepo.findById(request.getIdUtente()).get());
			indirizzo = indirizzoRepo.save(indirizzo);
			return indirizzo;
		}
		return null;
	}

	@Override
	public Indirizzo updateIndirizzo(IndirizzoDtoRequest request) {
		if(request==null)return null;
		Optional<Indirizzo> indirizzo = indirizzoRepo.findById(request.getIdIndirizzo());
		if(indirizzo.isPresent()) {
			Indirizzo i = indirizzo.get();
			i.setIndirizzo1(request.getIndirizzo1());
			i.setProvincia(request.getProvincia());
			i.setCap(request.getCap());
			i.setNumeroTelefono(request.getNumeroTelefono());
			i.setComune(request.getComune());
			i.setNome(request.getNome());
			indirizzoRepo.save(i);
			return i;
		}
		return null;
	}

	@Override
	public void deleteById(long id) {
		indirizzoRepo.deleteById(id);
		
	}

	@Override
	public Indirizzo findById(long id) {
		return indirizzoRepo.findById(id).get();
	}

	@Override
	public Indirizzo findByNomeAndUtente_Id(String nome, Long idUtente) {
		return indirizzoRepo.findIndirizzoByNomeAndUtente_IdUtente(nome, idUtente).get();
	}

	@Override
	public List<Indirizzo> findAll() {
		List<Indirizzo> indirizzi = indirizzoRepo.findAll();
		return indirizzi;
	}

	@Override
	public List<Indirizzo> findAllByComune(String comune) {
		List<Indirizzo> indirizzi = indirizzoRepo.findAllIndirizzoByComune(comune).get();
		return indirizzi;
	}

	@Override
	public List<Indirizzo> findAllByProvincia(String provincia) {
		List<Indirizzo> indirizzi = indirizzoRepo.findAllIndirizzoByProvincia(provincia).get();
		return indirizzi;
	}

	@Override
	public List<Indirizzo> findByNumeroDiTelefono(String numeroTelefono) {
		List<Indirizzo> indirizzi = indirizzoRepo.findAllIndirizzoByNumeroTelefono(numeroTelefono).get();
		return indirizzi;
	}


}
