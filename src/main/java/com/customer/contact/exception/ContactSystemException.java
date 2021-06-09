/**
 * 
 */
package com.customer.contact.exception;

/**
 * @author akhalesh
 * 
 * Class provides custom exception handling to Customer contact system, contains constructors to display exception according to need.
 *
 */
public class ContactSystemException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public ContactSystemException(String str) {
		super(str);
	}

}
