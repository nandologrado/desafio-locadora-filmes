package br.com.moviestore.service;

import br.com.moviestore.entity.Usuario;
import br.com.moviestore.exception.UsuarioNotFoundException;
import br.com.moviestore.exception.UsuarioPasswordException;
import br.com.moviestore.repository.UsuarioRepository;
import br.com.moviestore.util.CodificaSenha;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import javax.servlet.ServletException;

@Service
public class AutenticacaoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public String autenticarUsuario(Usuario usuario) throws ServletException {

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuario.getEmail());
        
        if (usuarioAutenticado == null) {
        	throw new UsuarioNotFoundException();
		}
        
        /**
         * O logout é feito automaticamente depois de 5 minutos
         * */
        
        if (CodificaSenha.codifca(usuario.getSenha()).equals(usuarioAutenticado.getSenha())) {
            String token = Jwts.builder().
                    setSubject(usuarioAutenticado.getNome()).
                    signWith(SignatureAlgorithm.HS512, "secret").
                    setExpiration(new Date(System.currentTimeMillis()+5*60*1000)).
                    compact();
            
            return token;
		} else {
			throw new UsuarioPasswordException();
		}
    }
}
