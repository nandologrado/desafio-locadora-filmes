package br.com.moviestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moviestore.entity.Usuario;
import br.com.moviestore.exception.UsuarioExistException;
import br.com.moviestore.repository.UsuarioRepository;
import br.com.moviestore.util.CodificaSenha;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {

		Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (usuarioExistente == null) {
			usuario.setSenha(CodificaSenha.codifca(usuario.getSenha()));
			return usuarioRepository.save(usuario);
		} else {
			throw new UsuarioExistException();
		}
	}
	
	public Optional<Usuario> buscarPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Usuario buscarEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
}
