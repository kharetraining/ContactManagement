/**
 * 
 */
package com.customer.contact.service;

import java.util.List;
import com.customer.contact.model.Contact;

/**
 * @author akhalesh
 *
 * Class represent service layer of application and provides interaction methods to web layer.
 */
public interface ContactService {
	
	public List<Contact> getContacts();
	
	public void saveContact(Contact customer);
	
	public java.util.Optional<Contact> findById(long id);
	
	public Contact updateContact(long id, Contact customer);
	
	public void deleteById(long id);

}
