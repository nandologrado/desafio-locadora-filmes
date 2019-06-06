package br.com.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moviestore.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);

}
