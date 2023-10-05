package org.elis.ecommerce.dto.request;

import org.elis.ecommerce.model.Ruolo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegistrazioneDtoRequest {

	@NotBlank(message= "Devi inserire un nome")
	private String nome;
	
	@NotBlank(message= "Devi inserire un cognome")
	private String cognome;
	
	@NotBlank(message= "Devi inserire una mail")
	@Email(message= "Devi inserire una mail valida")
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message= "Devi inserire una password valida")
	private String password;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message= "Devi reinserire una password valida")
	private String passwordRipetuta;
	
	private Ruolo ruolo;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRipetuta() {
		return passwordRipetuta;
	}
	public void setPasswordRipetuta(String passwordRipetuta) {
		this.passwordRipetuta = passwordRipetuta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
