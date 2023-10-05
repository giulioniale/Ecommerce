package org.elis.ecommerce.exception;

public class OrdineException extends RuntimeException {
	private Object request;
	
	public OrdineException(Object o, String message) {
		super(message);
		request=o;
	}

	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}
	
	
}
