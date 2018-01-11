package com.patriciocontreras.sistemausuarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.patriciocontreras.sistemausuarios.constant.ViewConstant;
import com.patriciocontreras.sistemausuarios.model.ContacModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.CONTACTS;
	}

	//se crea metodo get que capture contactform
	@GetMapping("/contactform")
	private String redirectContactForm(Model model) {
		model.addAttribute("contactModel", new ContacModel());
		return ViewConstant.CONTACT_FORM;
	}
	//ContactModel corresponde al th de object de contactForm
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContacModel contactModel,
			Model model) {
		LOG.info("METHOD: addContact -- PARAMS: " + contactModel .toString());
		model.addAttribute("result", 1);
		return  ViewConstant.CONTACTS;
	}
	
}
