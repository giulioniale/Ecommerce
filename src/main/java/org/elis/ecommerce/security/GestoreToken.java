package org.elis.ecommerce.security;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.elis.ecommerce.exception.DatiNonValidiException;
import org.elis.ecommerce.model.Utente;
import org.elis.ecommerce.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class GestoreToken {
	@Autowired
	UtenteRepository utenteRepo;
	
	private final String CHIAVE="404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

	private Key getKey() {
		byte[] b=Decoders.BASE64.decode(CHIAVE);
		return Keys.hmacShaKeyFor(b);
	}
	
	private Claims creaClaims(Utente u) {
		Claims c=Jwts.
				claims().
				setSubject(u.getEmail());
		c.put("ruolo", u.getRuolo());
		return c;
	}
	
	public String generaToken(Utente u) {
		long durataToken = 1000L*60*60*24*60;
		
		Claims c=creaClaims(u);					//creo il mio claims (ovvero il payload <<corpo>> del token)
		
		//inizio a creare il mio token tramite il builder della classe di utilitià Jwts
		String token=Jwts.builder()
					.setClaims(c)														//gli setto il Claims che ho creato in precedenza
					.setExpiration(new Date(System.currentTimeMillis()+durataToken))	//gli setto la data di scadenza alla data attuale più quanto voglio farlo durare
					.setIssuedAt(new Date(System.currentTimeMillis()))					//gli setto la data di creazione
					.signWith(getKey(),SignatureAlgorithm.HS256)						//firmo il tutto con la chiave "sicura" che ho creato prima
					//con il metodo compact vado a <<compattare>> tutte le informazioni
					//e converto il tutto in una stringa codificata
					.compact();
		return token;																	//ritorno il token generato
	}
	
	public Claims estraiClaimsDaToken(String token) {
		
		Claims c=Jwts.parserBuilder()				//parto dal metodo parseBuilder della classe di utilità JWTS
				.setSigningKey(getKey())			//e settando la chiave di validation (se hanno provato a modificare il token lancerà un'exception)
				.build()							//creo il parser
				.parseClaimsJws(token)				//e rimprendo partendo dal token
				.getBody();							//tutto il body del token, ovvero il claims
		return c;
	}
	
	public LocalDateTime prendiDataScadenza(String token) {
		
		Claims c=estraiClaimsDaToken(token);					//riprendo il Claims col metodo scritto sopra
		Date d=c.getExpiration();								//prendo da quel claims la data di scadenza (settata in creazione)
		//converto la data di scadenza da Date a LocalDateTime in modo che
		//sia più comoda da utilizzare all'interno del mio programma
		return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	public String prendiUsername(String token) {
		Claims c=estraiClaimsDaToken(token);
		return c.getSubject();
	}
	
	public Utente prendiUtenteDaToken(String token) {
		String mail=prendiUsername(token);
		Utente u=utenteRepo.findUtenteByEmail(mail)
				.orElseThrow(()->new DatiNonValidiException(token,"token fallato"));
		return u;
	}
	
	public boolean tokenAncoraValido(String token) {
		if(prendiDataScadenza(token).isBefore(LocalDateTime.now()))return false;
		Utente u=prendiUtenteDaToken(token);
		return u.isEnabled();
	}
	
	public String refreshToken(String token) {
		Utente u=prendiUtenteDaToken(token);
		return generaToken(u);
	}
}
