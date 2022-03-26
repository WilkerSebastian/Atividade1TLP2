package com.abaraogomes.wgtlp.controller;

import javax.validation.Valid;

import com.abaraogomes.wgtlp.orm.Jogo;
import com.abaraogomes.wgtlp.repository.JogoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JogoController {
 
    @Autowired
	JogoRepository jogoRepository;

    @RequestMapping("/powergomes.com")
    public String  homeJogo(Model model){

        model.addAttribute("jogos" , jogoRepository.findAll());

        return "home";

    }

    @RequestMapping("/powergomes.com/lista")
	public String listarJogo(Model model) {
		model.addAttribute("jogos", jogoRepository.findAll());
		
		return "lista";		
	}
	 
	@GetMapping("/powergomes.com/adicionar")
	public String adicionarJogo(Model model) {
		model.addAttribute("jogo", new Jogo());
		return "formularioJogo";
	}
	
	@PostMapping("/salvar")
	public String salvarJogo(@Valid Jogo jogo, BindingResult result) {
		if (result.hasErrors()) {
			return "formularioJogo";
		}
		jogoRepository.save(jogo);
		return "redirect:/powergomes.com/lista";
	}


}
