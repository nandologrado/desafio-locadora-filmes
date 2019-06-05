package br.com.moviestore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.moviestore.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	Optional<Filme> findByTitulo(String titulo);
	
	@Query(value="SELECT f FROM Filme f where f.qtCopias > 0")
	List<Filme> findDisponiveis();

}
