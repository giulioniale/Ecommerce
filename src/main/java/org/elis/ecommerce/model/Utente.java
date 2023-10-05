package org.elis.ecommerce.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utente implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUtente;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Ruolo ruolo;
	@Column(nullable = false)
	private boolean cancellato = false;
	
	@OneToMany(mappedBy = "utente")
	private List<Indirizzo> indirizzi;
	
	@OneToMany(mappedBy ="cliente")
	private List<Ordine> ordini;
	
	
	
	
	public Utente() {
	}

	public Utente(String nome, String cognome, String email, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}

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
	
	public List<Indirizzo> getIndirizzi() {
		return indirizzi;
	}
	
	public void setIndirizzi(List<Indirizzo> indirizzi) {
		this.indirizzi = indirizzi;
	}
	
	public Ruolo getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority("ROLE_"+ruolo.getRuolo());
		return List.of(sga);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
