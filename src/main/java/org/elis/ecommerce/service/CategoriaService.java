package org.elis.ecommerce.service;

import java.util.List;

import org.elis.ecommerce.dto.request.CategoriaDtoRequest;
import org.elis.ecommerce.model.Categoria;

public interface CategoriaService {
	
	public Categoria saveCategoria(String Nome);
	public Categoria updateCategoria(CategoriaDtoRequest request);
	public boolean deleteById(long id);
	public boolean deleteByNome(String nome);
	
	public Categoria findByNome(String nome);
	public Categoria findById(long id);
	public List<Categoria> findAll();
	
	
}
