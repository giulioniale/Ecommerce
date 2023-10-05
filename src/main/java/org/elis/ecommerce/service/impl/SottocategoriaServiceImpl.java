package org.elis.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.dto.request.SottocategoriaDtoRequest;
import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.exception.DatiNonValidiException;
import org.elis.ecommerce.model.Categoria;
import org.elis.ecommerce.model.Sottocategoria;
import org.elis.ecommerce.repository.CategoriaRepository;
import org.elis.ecommerce.repository.ProdottoRepository;
import org.elis.ecommerce.repository.SottocategoriaRepository;
import org.elis.ecommerce.service.SottocategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SottocategoriaServiceImpl implements SottocategoriaService {
	@Autowired
	SottocategoriaRepository sottoCatRepo;
	@Autowired
	CategoriaRepository categoriaRepo;
	@Autowired
	ProdottoRepository prodottoRepo;

	@Override
	public Sottocategoria aggiungiSottocategoria(SottocategoriaDtoRequest request) {
		if(request.getNome()==null || request.getIdCategoria()<0 || request.getNome().isBlank()) {
			throw new DatiNonValidiException(request, "Dati inseriti non validi");
		}
		Categoria categoria = categoriaRepo.findById(request.getIdCategoria())
				.orElseThrow(()->new DatiNonTrovatiException(request, "Nessuna categoria trovata"));
		if(sottoCatRepo.findSottocategoriaByNome(request.getNome()).isEmpty()) {
			Sottocategoria sottoCategoria = new Sottocategoria(request.getNome(), categoria);
			sottoCategoria = sottoCatRepo.save(sottoCategoria);
			return sottoCategoria;
		}
		return null;
	}

	@Override
	public Sottocategoria updateSottocategoria(SottocategoriaDtoRequest request) {
		if(request==null)return null;
		Optional<Sottocategoria> sottoCat=sottoCatRepo.findById(request.getIdCategoria());
		if(sottoCat.isPresent()) {
			Sottocategoria sC=sottoCat.get();
			sC.setNome(request.getNome());
			sC.setCategoria(categoriaRepo.findById(request.getIdCategoria()).get());
			sC=sottoCatRepo.save(sC);
			return sC;
		}
		return null;
	}
	
	@Override
	public void deleteSottocategoriaById(SottocategoriaDtoRequest request) {
		sottoCatRepo.findById(request.getIdSottocategoria()).get().setCancellato(true);
	}

	@Override
	public List<Sottocategoria> findAll() {
		return sottoCatRepo.findAll();
	}

	@Override
	public Sottocategoria findById(long id) {
		return sottoCatRepo.findById(id).get();
	}

	@Override
	public Sottocategoria findByNome(String nome) {
		return sottoCatRepo.findSottocategoriaByNome(nome).get();
	}

	@Override
	public Sottocategoria findByCategoria_Id(long id) {
		return sottoCatRepo.findSottocategoriaByCategoria_Id(id).get();
	}

	@Override
	public List<Sottocategoria> findAllByProdotto_Id(long idProdotto) {
		return sottoCatRepo.findAllSottocategoriaByProdotti_Id(idProdotto);
	}

	@Override
	public List<Sottocategoria> findAllSottocategoriaById(List<Long> id) {
		return sottoCatRepo.findAllById(id);
	}

	@Override
	public List<Sottocategoria> findAllById(List<Long> id) {
		return sottoCatRepo.findAllById(id);
	}
	

	
}
