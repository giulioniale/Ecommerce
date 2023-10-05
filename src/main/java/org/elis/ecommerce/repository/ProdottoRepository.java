package org.elis.ecommerce.repository;

import java.util.List;

import org.elis.ecommerce.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
	
	public Prodotto findProdottoByNomeAndVenditore_IdUtente(String nome, long id_venditore);
	public Prodotto findProdottoByIdAndVenditore_IdUtente(long id, long id_venditore);
	public List<Prodotto> findAllProdottoByNome(String nome);
	public List<Prodotto> findAllProdottoByVenditore_IdUtente(long id_venditore);
	public List<Prodotto> findAllProdottoByMarca(String marca);
	@Query(nativeQuery = true, value="SELECT * FROM Prodotto as p Join sottocategoria_prodotto as s on p.id = s.idProdotto "
			+ "WHERE s.idSottocategoria= :idSottocategoria")
	public List<Prodotto> findAllProdottoBySottocategoria_IdSottocategoria (long idSottocategoria);
	
}
