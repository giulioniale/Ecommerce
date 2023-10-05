package org.elis.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrdineDtoRequest{
	
	@NotBlank(message= "Devi inserire una ID Cliente")
	@Min(value = 1, message= "Devi inserire una ID maggiore di 0")
	private long idCiente;
	


	public long getIdCiente() {
		return idCiente;
	}

	public void setIdCiente(long idCiente) {
		this.idCiente = idCiente;
	}

	
	
}
