package br.com.moviestore.service;

import br.com.moviestore.model.Usuario;
import br.com.moviestore.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AutenticacaoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public String autenticarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioAutenticado = usuarioRepository.findByEmail(usuario.getEmail());


        /**
         * O logout é feito automaticamente depois de 5 minutos
         * */
        String token = Jwts.builder().
                setSubject(usuarioAutenticado.get().getNome()).
                signWith(SignatureAlgorithm.HS512, "secret").
                setExpiration(new Date(System.currentTimeMillis()+5*1000)).
                compact();

        return token;

    }
}
