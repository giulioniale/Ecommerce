package org.elis.ecommerce.security;

import org.elis.ecommerce.exception.DatiNonTrovatiException;
import org.elis.ecommerce.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfigurazione {
	
	@Autowired
	UtenteRepository utenteRepo;
	
	@Bean
	public UserDetailsService detailService() {
		return username->utenteRepo.findUtenteByEmail(username)
				.orElseThrow(()-> new DatiNonTrovatiException(username, "Utente non trovato"));
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setPasswordEncoder(encoder());
		dap.setUserDetailsService(detailService());
		return dap;
	}

}
