package br.com.moviestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.moviestore.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	Filme findByTitulo(String titulo);
	
	@Query(value="SELECT f FROM Filme f where f.qtCopias > 0 ORDER BY titulo")
	List<Filme> findDisponiveis();
}
