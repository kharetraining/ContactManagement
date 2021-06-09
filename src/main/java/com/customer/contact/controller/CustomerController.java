/**
 * 
 */
package com.customer.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.contact.model.Contact;
import com.customer.contact.service.ContactService;

/**
 * @author akhalesh
 * 
 * CustomerController represent web layer of store activity and provides way of transmission methods into store to get customer contact informations.
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ContactService customerService;
	/**
	 * Method fetch all contacts form stores.
	 * @param model
	 * @return list of Contact
	 */
	@GetMapping("/contacts")
	public String getContacts(Model model) {
		model.addAttribute("contacts", customerService.getContacts());
		return "contactlist";
	}
		
	/**
	 * Controller method to open add customer page.
	 * @param model
	 * @return
	 */
	@RequestMapping("/addContact")
	public String openCreateContact(Model model) {
		model.addAttribute("command", new Contact());
		return "addcontact";
	}
	
	/** 
	 * Controller method to save new contact into store.
	 * @param contact
	 * @return
	 */
	@PostMapping("/addContact")
	public String addContact(@ModelAttribute("contact") Contact contact) {
		customerService.saveContact(contact);
		return "redirect:/customer/contacts";
	}
	
	/**
	 * Controller method to open edit page of existing Contact.
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatecontact/{id}")
	public String editContact(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("command", customerService.findById(id).orElse(null));
		return "updatecontact";
	}
	
	/**
	 * Method provide update feature to update contact details.
	 * @param customerId
	 * @param contact
	 * @return
	 */
	@RequestMapping( value="/update/{id}", method=RequestMethod.POST)
	public String updatecontact(@ModelAttribute("contact") Contact contact, @PathVariable long id) {
		customerService.updateContact(id, contact);
		return "redirect:/customer/contacts";
	}
	
	/**
	 * Method provide delete feature using specific contactId.
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteContact/{id}")
	public String deteteContact(@PathVariable long id) {
		customerService.deleteById(id);
		return "redirect:/customer/contacts";
	}
}
