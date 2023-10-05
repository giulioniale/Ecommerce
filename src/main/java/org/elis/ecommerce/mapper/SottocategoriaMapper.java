package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.SottocategoriaDtoResponse;
import org.elis.ecommerce.model.Sottocategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SottocategoriaMapper {

	@Autowired
	ProdottoMapper mapperProdotto;
	
	public SottocategoriaDtoResponse toDTO(Sottocategoria s) {
		if(s==null)return null;
		SottocategoriaDtoResponse sDTO = new SottocategoriaDtoResponse();
		
		sDTO.setIdSottocategoria(s.getId());
		sDTO.setNome(s.getNome());
		if(s.getProdotto()!=null) {
			sDTO.setProdotti(mapperProdotto.listToDTO(s.getProdotti()));
		}
		sDTO.setNomeCategoria(s.getCategoria().getNome());
		
		return sDTO;
	}
	
	public List<SottocategoriaDtoResponse> listToDTO(List<Sottocategoria> s){
		if(s==null)return null;
		return s.stream().map(this::toDTO).toList();
	}
}
