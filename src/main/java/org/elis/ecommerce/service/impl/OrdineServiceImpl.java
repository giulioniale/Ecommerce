package org.elis.ecommerce.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.elis.ecommerce.dto.request.OrdineDtoRequest;
import org.elis.ecommerce.dto.request.RigaDordineDtoRequest;
import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.exception.OrdineException;
import org.elis.ecommerce.model.Ordine;
import org.elis.ecommerce.model.Prodotto;
import org.elis.ecommerce.model.RigaDordine;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.repository.OrdineRepository;
import org.elis.ecommerce.repository.RigaDordineRepository;
import org.elis.ecommerce.repository.UtenteRepository;
import org.elis.ecommerce.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	OrdineRepository ordineRepo;
	@Autowired
	UtenteRepository utenteRepo;
	@Autowired
	RigaDordineRepository rigaRepo;
	
	@Override
	public Optional<Ordine> aggiungiOrdine(OrdineDtoRequest request) {
		if(request != null) {
			Optional<Ordine> carrelloOpt=ordineRepo.findOrdineByCliente_IdUtenteAndDataInvioOrdineIsNull(request.getIdCiente());
			if(carrelloOpt.isPresent()) {
				Ordine carrello=carrelloOpt.get();
				carrello.setDataInvioOrdine(LocalDateTime.now());
				carrello=ordineRepo.save(carrello);
				return Optional.of(carrello);
			}
			//Ordine ordine = new Ordine(utenteRepo.findById(request.getIdCiente()), request.getDataInvioOrdine());
		}
		return Optional.empty();
	}

	@Override
	public Optional<Ordine> aggiungiRigaDordine(Utente utente, Prodotto prodotto, int quantita) {
		Optional<Ordine> o=ordineRepo.findOrdineByCliente_IdUtenteAndDataInvioOrdineIsNull(utente.getIdUtente());
		Ordine ordine=null;
		List<RigaDordine> lista = null;
		if(o.isEmpty()) {
			ordine=new Ordine();  //Ordine(Utente,RigaDordine, LocalDateTime)
			ordine.setCliente(utente);
		}else {
			ordine=o.get();
		}
		lista = ordine.aggiungiProdotto(prodotto, quantita);
		ordine.setRighe(lista);
		ordineRepo.save(ordine);
//		RigaDordine riga = new RigaDordine(prodotto, quantita);
//		riga.setOrdine(ordine);
//		rigaRepo.save(riga);
		return Optional.of(ordine);
	}

	@Override
	public void deleteById(long id) {
		ordineRepo.findById(id).get().setCancellato(true);
		
	}

	@Override
	public void deleteRigadordineById(long id) {
		rigaRepo.deleteById(id);
	}

	@Override
	public List<Ordine> findAll() {
		List<Ordine> ordini = ordineRepo.findAll();
		return ordini;
	}

	@Override
	public Ordine findById(long id) {
		return ordineRepo.findById(id).get();
	}

	@Override
	public Ordine findCarrello(Utente utente) {
		Ordine o = ordineRepo.findOrdineByCliente_IdUtenteAndDataInvioOrdineIsNull(utente.getIdUtente())
				.orElseThrow(()->new DatiNonTrovatiException(utente.getIdUtente(), "Nessun ordine trovato"));
		return o;
	}

	@Override
	public Ordine confermaCarrello(Utente utente) {
		Ordine o = ordineRepo.findOrdineByCliente_IdUtenteAndDataInvioOrdineIsNull(utente.getIdUtente())
				.orElseThrow(()->new DatiNonTrovatiException(utente.getIdUtente(), "Nessun ordine trovato"));
		if(o.getRighe() != null && o.getRighe().size()>0) {
			for(RigaDordine r:o.getRighe()) {
				if(r.getProdotto().getQuantita()< r.getQuantita()) {
					throw new OrdineException(o, "La quantità da ordinare dell'articolo: "
								+r.getProdotto().getNome()+ "è superiore della disponibilità");
				}
			}
			o.setDataInvioOrdine(LocalDateTime.now());
			ordineRepo.save(o);
			return o;
		}else {
			throw new OrdineException(o, "Nessun articolo inserito");
		}

	}

	@Override
	public List<Ordine> findAllOrdineByIdCliente(long idCliente) {
		List<Ordine> ordini = ordineRepo.findAllOrdineByCliente_IdUtente(idCliente);
		return ordini;
	}

	@Override
	public List<Ordine> findAllOrdineByDataInvioOrdine(LocalDateTime dataInvioOrdine) {
		List<Ordine> ordini = ordineRepo.findAllOrdineByDataInvioOrdine(dataInvioOrdine);
		return ordini;
	}

	@Override
	public void rimuoviRigaDordine(RigaDordineDtoRequest request, Utente u) {
		Ordine o = findCarrello(u);
		RigaDordine rigaRichiesta = o.getRiga(request.getIdProdotto());
		List<RigaDordine> righe = o.getRighe();
		righe.removeIf(r->r.getProdotto().getId()==request.getIdProdotto());
		o.setRighe(righe);
		ordineRepo.save(o);
		rigaRepo.deleteById(rigaRichiesta.getIdRigaOrdine());
	}

	@Override
	public double calcolaPrezzoTotale(Ordine o) {
		return o.getRighe().stream().mapToDouble(r->r.prezzoTotRiga()).sum();
	}




	


}
