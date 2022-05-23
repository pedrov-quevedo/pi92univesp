package com.projetopi.expenditurecontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExpenditureController {

	// @Autowired
	// private CurriculoRepository cr;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	// @RequestMapping(value = "/index", method = RequestMethod.POST)
	// public String formCadCurriculo(Curriculo curriculo) {
	// 	cr.save(curriculo);
	// 	return "redirect:/index";
	// }
}