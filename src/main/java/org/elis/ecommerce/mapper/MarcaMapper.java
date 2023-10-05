package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.MarcaDtoResponse;
import org.elis.ecommerce.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcaMapper {
	
	@Autowired
	ProdottoMapper mapperProdotto;
	
	public MarcaDtoResponse toDTO(Marca m) {
		if(m==null)return null;
		MarcaDtoResponse mDTO = new MarcaDtoResponse();
		
		mDTO.setIdMarca(m.getIdMarca());
		mDTO.setNome(m.getNome());
		mDTO.setProdotti(mapperProdotto.listToDTO(m.getProdotti()));
		
		return mDTO;
	}
	
	public List<MarcaDtoResponse> listToDTO(List<Marca> m){
		if(m==null)return null;
		return m.stream().map(this::toDTO).toList();
	}
}
