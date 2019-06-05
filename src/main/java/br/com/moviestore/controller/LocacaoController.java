package br.com.moviestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.moviestore.model.Locacao;
import br.com.moviestore.service.LocacaoService;

@RestController
@RequestMapping({"/restrito"})
public class LocacaoController {
	
	@Autowired
	LocacaoService locacaoService;
	
	@RequestMapping(
			method=RequestMethod.POST, value="/locacao/loca-filme",
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locacao> locarFilme(@RequestParam String email, @RequestParam String titulo) {
		return new ResponseEntity<>(locacaoService.locarFilme(titulo, email), HttpStatus.CREATED);
	}
	
	@RequestMapping(
			method=RequestMethod.POST, value="/devolve-filme",
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Locacao> deveolverFilme(@RequestParam String email, @RequestParam String titulo) {
		return new ResponseEntity<>(locacaoService.devolverFilme(titulo, email), HttpStatus.OK);
	}

}
