package org.elis.ecommerce.service.impl;

import java.util.List;

import org.elis.ecommerce.dto.request.MarcaDtoRequest;
import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.model.Marca;
import org.elis.ecommerce.repository.MarcaRepository;
import org.elis.ecommerce.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	MarcaRepository marcaRepo;
	
	@Override
	public List<Marca> getAllMarche() {
		List<Marca> marche = marcaRepo.findAll();
		return marche;
	}

	@Override
	public Marca findMarcaByNome(String nome) {
		Marca m= null;
		if((m=marcaRepo.findMarcaByNome(nome))==null) {
				throw new DatiNonTrovatiException(nome, "Nessuna marca trovata con nome  " +nome);
		}
		return m;
		}

	@Override
	public Marca findMarcaById(long id) {
		return marcaRepo.findById(id)
				.orElseThrow(()->new DatiNonTrovatiException(id, "Nessuna marca trovata con ID " +id));
	}

	@Override
	public Marca aggiungiMarca(String nome) {
		if(nome!=null && marcaRepo.findMarcaByNome(nome)==null) {
			Marca marca = new Marca(nome);
			marcaRepo.save(marca);
			return marca;
		}
		if(nome!=null && marcaRepo.findMarcaByNome(nome)!= null) {
			if(marcaRepo.findMarcaByNome(nome).isCancellato()) {
				Marca marca = marcaRepo.findMarcaByNome(nome);
				marca.setCancellato(false);
				marcaRepo.save(marca);
				return marca;
			}
		}
		return null;
	}

	@Override
	public Marca updateMarca(MarcaDtoRequest request) {
		Marca m = marcaRepo.findById(request.getIdMarca())
				.orElseThrow(()->new DatiNonTrovatiException(request, "Nessuna marca trovata con ID " +request.getIdMarca()));
		m.setNome(request.getNome());
		marcaRepo.save(m);
		return m;
	}

	@Override
	public boolean deleteMarcaById(long id) {
		Marca m = marcaRepo.findById(id)
				.orElseThrow(()->new DatiNonTrovatiException(id, "Nessuna marca trovata con ID " +id));
		m.setCancellato(true);
		marcaRepo.save(m);
		return true;
	}
	
	@Override
	public boolean deleteMarcaByNome(String nome) {
		Marca m = null;
		if((m = marcaRepo.findMarcaByNome(nome))==null){
				throw new DatiNonTrovatiException(nome, "Nessuna marca trovata con ID " +nome);
		}
		m.setCancellato(true);
		marcaRepo.save(m);
		return true;
	}


}
