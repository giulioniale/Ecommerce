package org.elis.ecommerce.mapper;

import java.util.List;

import org.elis.ecommerce.dto.response.CategoriaDtoResponse;
import org.elis.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

	@Autowired
	SottocategoriaMapper mapperSottocategoria;
	
	public CategoriaDtoResponse toDTO(Categoria c) {
		if(c==null)return null;
		CategoriaDtoResponse cDTO = new CategoriaDtoResponse();
		cDTO.setId(c.getId());
		cDTO.setNome(c.getNome());
		cDTO.setSottocategoria(mapperSottocategoria.listToDTO(c.getSottocategoria()));
		
		return cDTO;
	}
	
	public List<CategoriaDtoResponse> listToDTO(List<Categoria> categorie){
		if(categorie==null)return null;
		return categorie.stream().map(this::toDTO).toList();
	}
}
