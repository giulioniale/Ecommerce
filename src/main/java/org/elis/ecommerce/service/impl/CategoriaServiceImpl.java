package org.elis.ecommerce.service.impl;

import java.util.List;

import org.elis.ecommerce.dto.request.CategoriaDtoRequest;
import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.exception.DatiNonValidiException;
import org.elis.ecommerce.model.Categoria;
import org.elis.ecommerce.repository.CategoriaRepository;
import org.elis.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepo;

	@Override
	public Categoria saveCategoria(String nome) {
		if(nome==null || nome.isBlank())
			throw new DatiNonValidiException(nome, "Dati inseriti non validi");
		if(categoriaRepo.findCategoriaByNome(nome).isEmpty()) {
			Categoria categoria = new Categoria(nome);
			categoria = categoriaRepo.save(categoria);
			return categoria;
		}
		return null;
	}

	@Override
	public Categoria updateCategoria(CategoriaDtoRequest request) {
		Categoria c=categoriaRepo.findById(request.getId())
				.orElseThrow(()->new DatiNonTrovatiException(request, "Nessuna categoria trovata con ID " +request.getId()));
		c.setNome(request.getNome());
		c=categoriaRepo.save(c);
		return c;
	}

	@Override
	public boolean deleteById(long id) {
		Categoria c = categoriaRepo.findById(id).orElseThrow(()->new DatiNonTrovatiException(id, "Nessuna categoria trovata con ID "+id));
		c.setCancellato(true);
		categoriaRepo.save(c);
		return true;
	}

	@Override
	public boolean deleteByNome(String nome) {
		Categoria c = categoriaRepo.findCategoriaByNome(nome).orElseThrow(()->new DatiNonTrovatiException(nome, "Nessuna categoria trovata"));
		c.setCancellato(true);
		categoriaRepo.save(c);
		return true;
	}

	@Override
	public Categoria findByNome(String nome) {
		Categoria categoria = categoriaRepo.findCategoriaByNome(nome).orElseThrow(()->new DatiNonTrovatiException(nome, "Nessuna categoria trovata"));
		return categoria;
	}

	@Override
	public Categoria findById(long id) {
		Categoria categoria = categoriaRepo.findById(id).orElseThrow(()->new DatiNonTrovatiException(id, "Nessuna categoria trovata"));
		return categoria;
	}

	@Override
	public List<Categoria> findAll() {
		List<Categoria> categorie = categoriaRepo.findAll();
		return categorie;
	}

	

	
}
