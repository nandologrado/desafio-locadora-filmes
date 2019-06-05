package br.com.moviestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moviestore.model.Usuario;
import br.com.moviestore.repository.UsuarioRepository;
import br.com.moviestore.util.CodificaSenha;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {

		Optional<Usuario> u = usuarioRepository.findByEmail(usuario.getEmail());
		if (u.get() == null) {
			usuario.setSenha(CodificaSenha.codifca(usuario.getSenha()));
			return usuarioRepository.save(usuario);
		}
		return null;

	}
	
	public Optional<Usuario> buscarPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> buscarEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
	
}
