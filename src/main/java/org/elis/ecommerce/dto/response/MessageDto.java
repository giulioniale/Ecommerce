package org.elis.ecommerce.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public class MessageDto {
	private String errore;
	private int codice;
	private LocalDateTime data;
	private Object requestObj;
	
	
	
	public MessageDto(String errore, int codice) {
		this.errore = errore;
		this.codice = codice;
		this.data = LocalDateTime.now();
	}
	
	
	public MessageDto(String errore, int codice, Object requestObj) {
		this(errore,codice);
		this.requestObj = requestObj;
	}


	public MessageDto(int value, Map<String, String> map) {
		this.codice=value;
		this.requestObj=map;
		data=LocalDateTime.now();
		
	}


	public String getErrore() {
		return errore;
	}
	public void setErrore(String errore) {
		this.errore = errore;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Object getRequestObj() {
		return requestObj;
	}
	public void setRequestObj(Object requestObj) {
		this.requestObj = requestObj;
	}
	
	
	
	
}
