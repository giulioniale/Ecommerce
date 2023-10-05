package org.elis.ecommerce.security;

import org.elis.ecommerce.model.Ruolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class GestionePath {

	@Autowired
	AuthenticationProvider provider;
	
	@Autowired
	FilterAutorizzazione filter;
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception{
		http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/genericController/**").permitAll()
			.requestMatchers("/adminController/**").hasRole(Ruolo.ADMIN.getRuolo())
			.requestMatchers("/utenteController/**").hasAnyRole(Ruolo.UTENTE.getRuolo(),Ruolo.ADMIN.getRuolo())
			.requestMatchers("/venditoreController/**").hasAnyRole(Ruolo.ADMIN.getRuolo(),Ruolo.VENDITORE.getRuolo())
			.anyRequest().permitAll()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authenticationProvider(provider)
			.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
}
