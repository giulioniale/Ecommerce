package org.elis.ecommerce.repository;

import java.util.Optional;

import org.elis.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Optional<Categoria> findCategoriaByNome(String nome);
	public Optional<Categoria> deleteCategoriaByNome(String nome);
//	public List<Categoria> findAllCategoria();
//	public Optional<Categoria> findCategoriaById(long id);
//	public Categoria saveCategoria(Categoria c);
//	public Categoria updateCategoria(Categoria c);
//	public void deleteCategoriaById(int id);
	
}
