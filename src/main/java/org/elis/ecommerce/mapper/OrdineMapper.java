package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.OrdineDtoResponse;
import org.elis.ecommerce.model.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdineMapper {

	@Autowired
	RigadDordineMapper mapperRiga;
	
	public OrdineDtoResponse toDTO(Ordine o) {
		if(o==null)return null;
		OrdineDtoResponse oDTO = new OrdineDtoResponse();
		
		oDTO.setIdOrdine(o.getIdOrdine());
		oDTO.setDataInvioOrdine(o.getDataInvioOrdine());
		oDTO.setIdCiente(o.getCliente().getIdUtente());
		oDTO.setRighe(mapperRiga.listToDTO(o.getRighe()));
		
		return oDTO;
	}
	
	public List<OrdineDtoResponse> listToDTO(List<Ordine> o){
		if(o==null)return null;
		return o.stream().map(this::toDTO).toList();
	}
}
