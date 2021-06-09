/**
 * 
 */
package com.customer.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.customer.contact.exception.ContactSystemException;
import com.customer.contact.model.Contact;
import com.customer.contact.repository.ContactRepository;
import com.sun.el.stream.Optional;

/**
 * @author akhalesh
 * Class provides implementation to all ContactService methods.
 */
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repository;

	/* (non-Javadoc)
	 * @see com.customer.contact.service.CustomerService#getContacts(org.springframework.ui.ModelMap)
	 */
	@Override
	public List<Contact> getContacts() {
		return repository.findAll();
	}

	@Override
	public void saveContact(Contact contact) {
		repository.save(contact);
	}

	@Override
	public java.util.Optional<Contact> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public Contact updateContact(long id, Contact contact) {
		Contact updatedContact = repository.findById(id).orElse(null);
		updatedContact.setFirstName(contact.getFirstName());
		updatedContact.setLastName(contact.getLastName());
		updatedContact.setEmail(contact.getEmail());
		updatedContact.setPhoneNumber(contact.getPhoneNumber());
		if(!updatedContact.isStatus()) {
			throw new ContactSystemException("Not allowed to update as contact is disabled from system.");
		}
		updatedContact.setStatus(contact.isStatus());
		return repository.save(updatedContact);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

}
