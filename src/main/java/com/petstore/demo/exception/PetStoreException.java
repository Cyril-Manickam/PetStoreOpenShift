package com.petstore.demo.exception;

public class PetStoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547801283324034607L;
	
	public PetStoreException() {
		super();
	}

	public PetStoreException(final String message) {
		super(message);
	}

}
