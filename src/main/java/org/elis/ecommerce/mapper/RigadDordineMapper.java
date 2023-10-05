package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.RigaDordineDtoResponse;
import org.elis.ecommerce.model.RigaDordine;
import org.springframework.stereotype.Component;

@Component
public class RigadDordineMapper {
	
	public RigaDordineDtoResponse toDTO(RigaDordine r) {;
		if(r==null)return null;
		RigaDordineDtoResponse rDTO = new RigaDordineDtoResponse();
		
		rDTO.setIdProdotto(r.getProdotto().getIdProdotto());
		rDTO.setQuantita(r.getQuantita());
		
		return rDTO;
	}
	
	public List<RigaDordineDtoResponse> listToDTO(List<RigaDordine> r){
		if(r==null)return null;
		return r.stream().map(this::toDTO).toList();
	}
}
