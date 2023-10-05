package org.elis.ecommerce.dto.request;

import java.util.List;

import org.elis.ecommerce.model.Ruolo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UtenteDtoRequest {
	@NotBlank(message="devi inserire un ID valido")
	private long idUtente;
	@NotBlank(message="devi inserire un nome valido")
	private String nome;
	@NotBlank(message="devi inserire un cognome valido")
	private String cognome;
	@NotBlank(message="la mail non può essewre vuota")
	@Email(message="devi inserire una mail valida")
	private String email;
	@NotBlank(message="la password non può essewre vuota")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message="devi inserire una password valida")
	private String password;
	private List<String> indirizzi;
	@NotBlank
	private Ruolo ruolo;
	
	
	
	
	public long getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
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
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public List<String> getIndirizzi() {
		return indirizzi;
	}
	public void setIndirizzi(List<String> indirizzi) {
		this.indirizzi = indirizzi;
	}
	
	
	
}
