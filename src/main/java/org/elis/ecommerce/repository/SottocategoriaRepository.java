package org.elis.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.model.Sottocategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SottocategoriaRepository extends JpaRepository<Sottocategoria, Long> {
	
	public Optional<Sottocategoria> findSottocategoriaById(long id);
	public Optional<Sottocategoria> findSottocategoriaByNome(String nome);
	public Optional<Sottocategoria> findSottocategoriaByCategoria_Id(long id);
	public List<Sottocategoria> findAllSottocategoriaByProdotti_Id(long idProdotto);
	
	
}
