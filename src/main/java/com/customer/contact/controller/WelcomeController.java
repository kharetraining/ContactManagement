/**
 * 
 */
package com.customer.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author akhalesh
 * Controller to redirect on customer Contact list.
 */
@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage() {
        return "redirect:/customer/contacts";
    }

}
