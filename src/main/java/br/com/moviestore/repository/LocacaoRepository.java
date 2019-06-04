package br.com.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moviestore.model.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

}
