package org.elis.ecommerce.service;

import java.util.List;

import org.elis.ecommerce.dto.request.SottocategoriaDtoRequest;
import org.elis.ecommerce.model.Sottocategoria;

public interface SottocategoriaService {
	
	public Sottocategoria aggiungiSottocategoria(SottocategoriaDtoRequest request);
	public Sottocategoria updateSottocategoria(SottocategoriaDtoRequest request);
	public void deleteSottocategoriaById(SottocategoriaDtoRequest request);
	
	public List<Sottocategoria> findAll();
	public Sottocategoria findById(long id);
	public Sottocategoria findByNome(String nome);
	public Sottocategoria findByCategoria_Id(long id);
	public List<Sottocategoria> findAllByProdotto_Id(long idProdotto);
	public List<Sottocategoria> findAllSottocategoriaById(List<Long> id);
	public List<Sottocategoria> findAllById(List<Long> id);
}
