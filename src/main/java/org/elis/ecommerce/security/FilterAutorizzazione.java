package org.elis.ecommerce.security;

import java.io.IOException;

import org.elis.ecommerce.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterAutorizzazione extends OncePerRequestFilter{

	@Autowired
	GestoreToken tokenP;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)throws ServletException, IOException {
		
		String header=request.getHeader("Authorization");			//riprendo l'header che ha come chiave Authorization
		if(header!=null && header.startsWith("Bearer ")) {			//se esiste e rispetta la convenzione che inzia per Bearer è un token JWT
			String token =header.substring(7);						//tolgo dalla stringa "Bearer " e lascio solo il token
			Utente u=tokenP.prendiUtenteDaToken(token);				//adesso che ho il token prendo da esso l'utente che ha effettuato la login
			
			//se non sono mai passato per questo metodo non avrò ancora settato nessuna autorizzazione
			if(SecurityContextHolder.getContext().getAuthentication()==null&&
					tokenP.tokenAncoraValido(token)) {//se il token è ancora valido creo un oggetto per gestire le autorizzazioni che ha l'utente
														//questo oggetto ha bisogno di 3 cose per esser creato ma di norma due sono alternative
				UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(u,null,u.getAuthorities());
						//"u"--->la prima cosa di cui ha bisono è il "principal" ovvero l'utente che effettua la login
						//"null"--->la seconda cosa che potremmo passargli sono le credenziali di accesso nel nostro caso useremo le autorizzazioni quini non le usiamo
						//"u.getAuthorities()"--->l'ultima cosa che gli andremo a passare è la lista di autorizzazioni in base ai ruoli che ha quell'utente
						
				//oltre ai parametri passati dal costruttore setto al nostro oggetto
				//anche la request in modo da "capire" quale servizio stiamo chiamando
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);		//finito di creare il tutto lo setto al contesto della chiamata
			}
		}
		filterChain.doFilter(request, response);			//a prescidere da tutto gli dico di passare al punto successivo
	}

}
