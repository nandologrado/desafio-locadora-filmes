package br.com.moviestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.moviestore.model.Usuario;
import br.com.moviestore.service.UsuarioService;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

	@Autowired 
	UsuarioService usuarioService;
	
	@RequestMapping(
			method=RequestMethod.POST, value="/cadastro", 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarCliente(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.salvarUsuario(usuario), HttpStatus.CREATED);
	}
	
	
	
}
