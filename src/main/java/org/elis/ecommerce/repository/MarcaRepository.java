package org.elis.ecommerce.repository;


import org.elis.ecommerce.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

	public Marca findMarcaByNome(String nome);
	
	
	
}
