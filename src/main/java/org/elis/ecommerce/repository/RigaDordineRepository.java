package org.elis.ecommerce.repository;

import java.util.List;

import org.elis.ecommerce.model.RigaDordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RigaDordineRepository extends JpaRepository<RigaDordine, Long> {

	public List<RigaDordine> findRigaDordineByOrdine_IdOrdine(long idOrdine);
	public RigaDordine findRigaDordineByProdotto_Id(long id);
	
	
}
