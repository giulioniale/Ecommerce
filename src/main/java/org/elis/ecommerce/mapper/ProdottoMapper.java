package org.elis.ecommerce.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Sottocategoria;
import org.springframework.stereotype.Component;

@Component
public class ProdottoMapper {

//	@Autowired
//	SottocategoriaMapper mapperSotto;
	
	public ProdottoDtoResponse toDTO(Prodotto p) {
		if(p==null)return null;
		ProdottoDtoResponse pDTO = new ProdottoDtoResponse();
		
		pDTO.setIdProdotto(p.getIdProdotto());
		pDTO.setNome(p.getNome());
		pDTO.setDescrizione(p.getDescrizione());
		pDTO.setPrezzo(p.getPrezzo());
		pDTO.setMarca(p.getMarca().getNome());
		pDTO.setQuantita(p.getQuantita());
		pDTO.setSottocategoria(p.getSottocategoria().stream()
				.map(Sottocategoria :: getNome)
				.collect(Collectors.toList()));
//		pDTO.setSottocategoria(mapperSotto.listToDTO(p.getSottocategoria()));
//		Map<Long, String> sottocat = p.getSottocategoria().stream()
//				.collect(Collectors.toMap(s->s.getId(), s->s.getNome()));
		pDTO.setIva(p.getIva());
		pDTO.setNomeVenditore(p.getVenditore().getNome());
		pDTO.setCancellato(p.getCancellato());;
		
		return pDTO;
	}
	
	public List<ProdottoDtoResponse> listToDTO(List<Prodotto> p){
		if(p==null)return null;
		return p.stream().map(this::toDTO).toList();
	}
}
