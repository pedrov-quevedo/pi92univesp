package com.projetopi.expenditurecontrol.controller;

import java.security.Principal;
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
import com.projetopi.expenditurecontrol.models.Movement;
import com.projetopi.expenditurecontrol.models.Usuario;
import com.projetopi.expenditurecontrol.repository.MovementRepository;
import com.projetopi.expenditurecontrol.repository.UsuarioRepository;

@Controller
public class ExpenditureController implements WebMvcConfigurer{

	@Autowired
	private UsuarioRepository ur;

	@Autowired
	private MovementRepository mr;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/signin").setViewName("signin");
		registry.addViewController("/signup").setViewName("signup");
		registry.addViewController("/index").setViewName("index");
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "index";
	}

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String login_success(Model model, Principal principal) {
		String loggedUser = principal.getName();

		Iterable<Movement> all = mr.findAllByUsuario(loggedUser);
		model.addAttribute("loggedUser", "Bem vindo(a), " + loggedUser);
		model.addAttribute("movements", all);
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

	@PostMapping(value = "/home/cadMovement")
	public String formCadCurriculo(Movement movement, Principal principal, Model model) {
		String usuario = principal.getName();
		movement.setUsuario(usuario);
		mr.save(movement);
		model.addAttribute("loggedUser", "Bem vindo(a), " + usuario);
		return "redirect:/home";
	}

	@RequestMapping("/logout")
	public String logout(){
		return "redirect:/logout";
	}
}