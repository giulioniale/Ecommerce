package org.elis.ecommerce.facade;

import java.util.List;
import org.elis.ecommerce.dto.request.LoginDtoRequest;
import org.elis.ecommerce.dto.request.ProdottoDtoRequest;
import org.elis.ecommerce.dto.request.SottocategoriaDtoRequest;
import org.elis.ecommerce.dto.response.CategoriaDtoResponse;
import org.elis.ecommerce.dto.response.ProdottoDtoResponse;
import org.elis.ecommerce.dto.response.SottocategoriaDtoResponse;
import org.elis.ecommerce.dto.response.UtenteDtoResponse;
import org.elis.ecommerce.mapper.CategoriaMapper;
import org.elis.ecommerce.mapper.MarcaMapper;
import org.elis.ecommerce.mapper.ProdottoMapper;
import org.elis.ecommerce.mapper.SottocategoriaMapper;
import org.elis.ecommerce.mapper.UtenteMapper;
import org.elis.ecommerce.model.Categoria;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Sottocategoria;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.service.CategoriaService;
import org.elis.ecommerce.service.MarcaService;
import org.elis.ecommerce.service.ProdottoService;
import org.elis.ecommerce.service.SottocategoriaService;
import org.elis.ecommerce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class VenditoreControllerFacade {
	
	@Autowired
	UtenteService utenteServ;
	@Autowired
	ProdottoService prodottoServ;
	@Autowired
	SottocategoriaService sottocatServ;
	@Autowired
	CategoriaService categoriaServ;
	@Autowired
	MarcaService marcaServ;
	@Autowired
	UtenteMapper mappedUtente;
	@Autowired
	ProdottoMapper mapperProdotto;
	@Autowired
	SottocategoriaMapper mapperSottocategoria;
	@Autowired
	CategoriaMapper mapperCategoria;
	@Autowired
	GenericFacade facadeGeneric;
	@Autowired
	MarcaMapper mapperMarca;
	
	
	public UtenteDtoResponse findVenditore(LoginDtoRequest login){
		Utente u = utenteServ.findByEmail(login.getEmail());
		return mappedUtente.toDTO(u);
	}
//	--------------------------------CATEGORIA--------------------------------
	public CategoriaDtoResponse aggiungiCategoria(String nome){
		Categoria c = categoriaServ.saveCategoria(nome);
		return mapperCategoria.toDTO(c);
	}
	
	public CategoriaDtoResponse findCategoriaById(long id ){
		Categoria c = categoriaServ.findById(id);
		return mapperCategoria.toDTO(c);
	}
	
	public List<CategoriaDtoResponse> findAllCategoria(){
		List<Categoria> c = categoriaServ.findAll();
		return mapperCategoria.listToDTO(c);
	}
	
	public String deleteCategoriaById(long id){
		if(categoriaServ.deleteById(id)) {
			return "Categoria rimosa con successo";
		}
		return "";
	}
	
	public String deleteCategoriaByNome(String nome){
		if(categoriaServ.deleteByNome(nome)) {
			return "Categoria rimosa con successo";
		}
		return "";
	}
//	--------------------------------SOTTOCATEGORIA--------------------------------

	public SottocategoriaDtoResponse aggiungiSottocategoria(SottocategoriaDtoRequest request){
		Sottocategoria s = sottocatServ.aggiungiSottocategoria(request);
		return mapperSottocategoria.toDTO(s);
	}
	
	public List<SottocategoriaDtoResponse> findAllSottocategoria(){
		List<Sottocategoria> s = sottocatServ.findAll();
		return mapperSottocategoria.listToDTO(s);
	}


//	--------------------------------PRODOTTO--------------------------------
	public ProdottoDtoResponse aggiungiProdotto(ProdottoDtoRequest p, UsernamePasswordAuthenticationToken token){
		Utente u = (Utente) token.getPrincipal();
		Prodotto p1 = prodottoServ.aggiungiProdotto(p, u);
			
		return mapperProdotto.toDTO(p1) ;
	}
	
	public String deleteProdottoById(long id){
		if(prodottoServ.deleteProdottoById(id)) {
			return "Prodotto rimosso con sucesso";
		}
		return "Prodotto non trovato";
	}
	
	public ProdottoDtoResponse findProdottoByIdAndUtente(long id, UsernamePasswordAuthenticationToken token){
		Utente u = (Utente)token.getPrincipal();
		Prodotto p = prodottoServ.findProdottoByIdAndVenditore_IdUtente(id, u.getIdUtente());
		return mapperProdotto.toDTO(p);
	}
	
	public ProdottoDtoResponse findProdottoByNomeAndIDUtente(String nome, UsernamePasswordAuthenticationToken token){
		Utente u = (Utente)token.getPrincipal();
		Prodotto p = prodottoServ.findByNomeAndIdVenditore(nome, u.getIdUtente());
		return mapperProdotto.toDTO(p);
	}
	
	public List<ProdottoDtoResponse> findAllProdottiByIdUtente(UsernamePasswordAuthenticationToken token){
		Utente u = (Utente)token.getPrincipal();
		List<Prodotto> prodotti = prodottoServ.findAllProdottiByVenditore_Id(u.getIdUtente());
		return mapperProdotto.listToDTO(prodotti);
	}
	
}
