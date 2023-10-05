package org.elis.ecommerce.exception;

public class DatiNonTrovatiException extends RuntimeException {
	
	private Object request;

	public DatiNonTrovatiException(Object o, String message) {
		super(message);
		request = o;
	}

	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}
}
