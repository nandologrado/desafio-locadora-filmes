package br.com.moviestore.controller;

import br.com.moviestore.entity.Usuario;
import br.com.moviestore.service.AutenticacaoService;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @RequestMapping(
            method= RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse autenticarUsuario(@RequestBody Usuario usuario) throws ServletException{
        return new LoginResponse(autenticacaoService.autenticarUsuario(usuario));
    }

    private class LoginResponse{
        public String token;
        public LoginResponse(String token){
            this.token=token;
        }
    }
}
