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
		usuario.setSenha(CodificaSenha.codifca(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> buscarPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
}
