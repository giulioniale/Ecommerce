package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.IndirizzoDtoResponse;
import org.elis.ecommerce.model.Indirizzo;
import org.springframework.stereotype.Component;

@Component
public class IndirizzoMapper {
	
	public IndirizzoDtoResponse toDTO(Indirizzo i) {
		if(i==null)return null;
		IndirizzoDtoResponse iDTO = new IndirizzoDtoResponse();
		iDTO.setId(i.getId());
		iDTO.setIndirizzo1(i.getIndirizzo1());
		iDTO.setIndirizzo2(i.getIndirizzo2());
		iDTO.setProvincia(i.getProvincia());
		iDTO.setCap(i.getCap());
		iDTO.setNumeroTelefono(i.getNumeroTelefono());
		iDTO.setComune(i.getComune());
		iDTO.setNome(i.getNome());
		iDTO.setUtente(i.getUtente().getEmail());
		
		return iDTO;
	}
	
	public List<IndirizzoDtoResponse> listToDTO(List<Indirizzo> i){
		if(i==null)return null;
		return i.stream().map(this::toDTO).toList();
	}
}
