package org.elis.ecommerce.service;

import java.util.List;

import org.elis.ecommerce.dto.request.MarcaDtoRequest;
import org.elis.ecommerce.model.Marca;

public interface MarcaService {
	
	public Marca aggiungiMarca(String nome);
	public Marca updateMarca(MarcaDtoRequest request);
	public boolean deleteMarcaById(long id);
	public boolean deleteMarcaByNome(String nome);
	
	public List<Marca> getAllMarche();
	public Marca findMarcaByNome(String nome);
	public Marca findMarcaById(long id);
	
	
}
