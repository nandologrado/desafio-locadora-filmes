package br.com.moviestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moviestore.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	List<Filme> findByTitulo(String titulo);

}
