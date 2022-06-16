package com.projetopi.expenditurecontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.projetopi.expenditurecontrol.models.Usuario;
import com.projetopi.expenditurecontrol.repository.UsuarioRepository;

@Controller
public class ExpenditureController implements WebMvcConfigurer{

	@Autowired
	private UsuarioRepository ur;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "index";
	}

	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin() {
		return "signin";
	}

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home() {
		return "home";
	}

	@GetMapping(value="/signup")
	public String signup() {
		return "signup";
	}
  
	@PostMapping(value="/signup")
	public String cadNewUser(@Valid Usuario usuario, Model model) {
		
		try {
			ur.save(usuario);
		} catch(Exception ex){
			if(ex.getClass().equals(TransactionSystemException.class))
				model.addAttribute("errorMessage1", "Senha inválida! (deve conter entre 8 e 20 dígitos)");
			else
				model.addAttribute("errorMessage2", "Usuário já existente!");
			return "signup";
		}
		return "redirect:/index";
	}

	@PostMapping(value="/signin")
	public String signinUser() {
		return "redirect:/signin";
	}
}