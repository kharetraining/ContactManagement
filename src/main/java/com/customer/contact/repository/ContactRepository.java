/**
 * 
 */
package com.customer.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.contact.model.Contact;

/**
 * @author akhalesh
 * 
 * Class represents database layer, provides all curd operations to manage Contacts flow into store.
 *
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
}
