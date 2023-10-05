package org.elis.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine, Long>{
	
	public List<Ordine> findAllOrdineByCliente_IdUtente(long idCliente);
	public List<Ordine> findAllOrdineByDataInvioOrdine(LocalDateTime dataInvioOrdine);
	public Optional<Ordine> findOrdineByCliente_IdUtenteAndDataInvioOrdineIsNull(long idCliente);
	
	
}
