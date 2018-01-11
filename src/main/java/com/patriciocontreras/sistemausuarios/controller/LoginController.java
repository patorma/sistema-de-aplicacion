package com.patriciocontreras.sistemausuarios.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.patriciocontreras.sistemausuarios.constant.ViewConstant;
import com.patriciocontreras.sistemausuarios.model.UserCredential;

@Controller
public class LoginController {
	// para mostrar mensajes log para la gestion de errores
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	//otro getmapping para capturar la peticion anterior
	//este metodo suelta una vista
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="error2", required=false) String error2,
			@RequestParam(name="logout", required=false) String logout){
		model.addAttribute("error", error);
		model.addAttribute("logout",logout);
		model.addAttribute("error2",error2);
		LOG.info("METHOD: showLoginForm() -- PARAMS: error= " + error +",logout: " +logout + "error2= " + error2);
		model.addAttribute("userCredentials", new UserCredential());
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	//se encarga de direccionar a la vista de invitado del sistema
	@GetMapping("/vistapublica")
	public String showVista(Model model,
			@RequestParam(name="invitado", required=false) String invitado) {
		LOG.info("METHOD: showVista() -- PARAMS: invitado= " + invitado);
		model.addAttribute("invitado",invitado);
		LOG.info("Redirect vista invitado");
		return ViewConstant.VISTA_PUBLICA;
	}
	
	//se encarga del formulario login, para entre comillas autentificarse
	//comprueba el user y password
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential){
		LOG.info("METHOD: loginCheck() -- PARAMS: " + userCredential.toString());
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOG.info("Returning to contacts view");
			return ViewConstant.CONTACTS;
		}
		if(userCredential.getUsername().equals("") && userCredential.getPassword().equals("") ) {
			return "redirect:/login?error2";
		}
		
		LOG.info("Redirect to login?error");
		return "redirect:/login?error";
	}
}
