package org.elis.ecommerce.service.impl;

import java.util.List;

import org.elis.ecommerce.dto.request.ProdottoDtoRequest;
import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.Sottocategoria;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.repository.MarcaRepository;
import org.elis.ecommerce.repository.ProdottoRepository;
import org.elis.ecommerce.repository.SottocategoriaRepository;
import org.elis.ecommerce.repository.UtenteRepository;
import org.elis.ecommerce.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	ProdottoRepository prodottoRepo;
	@Autowired
	UtenteRepository utenteRepo;
	@Autowired
	SottocategoriaRepository sottoCatRepo;
	@Autowired
	MarcaRepository marcaRepo;
	
	@Override
	public Prodotto aggiungiProdotto(ProdottoDtoRequest request, Utente u) {	
		List<Sottocategoria> sC = null;
		Prodotto p= null;
		if((p=prodottoRepo.findProdottoByNomeAndVenditore_IdUtente(request.getNome(), u.getIdUtente()))==null) {
			if((sC = sottoCatRepo.findAllById(request.getIdSottocategorie()))!=null) {
				Prodotto prodotto = new Prodotto(request.getNome(), request.getDescrizione(), request.getPrezzo(),
						marcaRepo.findById(request.getMarca()).get(),sC, request.getQuantita(),request.getIva(),u);
						prodotto.setCancellato(false);
				sC.forEach(s->s.aggiungiProdotto(prodotto));
				prodottoRepo.save(prodotto);
				return prodotto;
			}else {
				throw new DatiNonTrovatiException(request, "Nessuna sottocategoria trovata");
			}
		}else {
			p.setQuantita(p.getQuantita()+request.getQuantita());
			prodottoRepo.save(p);
			return p;
		}
	}

	@Override
	public boolean deleteProdottoById(long id) {
//		if (request!=null) {
//			Optional<Prodotto> prodotto = prodottoRepo.findById(request.getIdProdotto());
//			List<Sottocategoria> sottocategorie = prodotto.get().getSottocategoria();
//			if (prodotto!=null && sottocategorie!=null && !sottocategorie.isEmpty() && !prodotto.isEmpty()) {
//				for (Sottocategoria s : sottocategorie) {
//						List<Prodotto> prodottiDellaSottocategoria =  s.getProdotto();
//						prodottiDellaSottocategoria.removeIf(p -> p.getIdProdotto() == request.getIdProdotto());
//						s.setProdotto(prodottiDellaSottocategoria);;
//						sottoCatRepo.save(s);
//				}
//				List<Sottocategoria> sottocategorieConProdottoEsistente = sottoCatRepo.findAllSottocategoriaByProdotti_Id(request.getIdProdotto());
//				if (sottocategorieConProdottoEsistente==null) {
//					prodottoRepo.deleteById(request.getIdProdotto());//cancellato = true
//				}
//			}
//		}
		Prodotto p = prodottoRepo.findById(id)
				.orElseThrow(()->new DatiNonTrovatiException(id, "nessun prodotto trovato con ID " +id));
		if(p!=null) {
			p.setCancellato(true);
			prodottoRepo.save(p);
			return true;
		}
		return false;
	}

	@Override
	public Prodotto findProdottoById(long id) {
		return prodottoRepo.findById(id).get();
	}

	@Override
	public List<Prodotto> findAllProdotti() {
		return prodottoRepo.findAll();
	}

	@Override
	public List<Prodotto> findByNome(String nome) {
		return prodottoRepo.findAllProdottoByNome(nome);
	}

	@Override
	public List<Prodotto> findBySottocategoria_Id(long id) {
		return prodottoRepo.findAllProdottoBySottocategoria_IdSottocategoria(id);
	}

	@Override
	public List<Prodotto> findAllProdottiByVenditore_Id(long id) {
		return prodottoRepo.findAllProdottoByVenditore_IdUtente(id);
	}

	@Override
	public List<Prodotto> findByMarca(String marca) {
		return prodottoRepo.findAllProdottoByMarca(marca);
	}

	@Override
	public Prodotto findByNomeAndIdVenditore(String nome, long id_venditore) {
		return prodottoRepo.findProdottoByNomeAndVenditore_IdUtente(nome, id_venditore);
	}

	@Override
	public Prodotto findProdottoByIdAndVenditore_IdUtente(long id, long id_venditore) {
		Prodotto p = null;
		if((p=prodottoRepo.findProdottoByIdAndVenditore_IdUtente(id, id_venditore))==null) {
			throw new DatiNonTrovatiException(id, "Nessun prodotto trovato con ID " +id);
		}
		return p;
	}

	

}
