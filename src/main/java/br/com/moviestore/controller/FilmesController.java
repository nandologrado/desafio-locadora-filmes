package br.com.moviestore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.moviestore.entity.Filme;
import br.com.moviestore.service.FilmeService;

@RestController
@RequestMapping({"/restrito"})
public class FilmesController {
	
	@Autowired
	FilmeService filmeService;
	
	@RequestMapping(
			method=RequestMethod.GET, value="/filme/lista-filmes",
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> listarFilmes(@RequestParam String titulo) {
		return new ResponseEntity<>(filmeService.buscarPorTitulo(titulo), HttpStatus.OK);
	}
	
	@RequestMapping(
			method=RequestMethod.GET, value="/filme/lista-filmes-disponiveis",
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Filme>> listarFilmes() {
		return new ResponseEntity<>(filmeService.buscarDisponives(), HttpStatus.OK);
	}

}
