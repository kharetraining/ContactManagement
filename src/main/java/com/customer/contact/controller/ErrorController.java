/**
 * 
 */
package com.customer.contact.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author akhalesh
 *
 * Exception handler to handle exception.
 */
@Controller("error")
public class ErrorController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception exception) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("exception", exception.getLocalizedMessage());
		model.addObject("url", request.getRequestURL());
		model.setViewName("error");
		return model;
	}

}
