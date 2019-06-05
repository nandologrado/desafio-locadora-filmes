package br.com.moviestore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.moviestore.model.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

	@Query(value="SELECT l FROM Locacao l "
			   + "where l.usuario.email = :pemail and l.filme.titulo = :ptitulo and l.dtRetorno is null ")
	Optional<Locacao> findFilmeLocado(@Param("pemail") String email,
			                @Param("ptitulo") String titulo);
}
