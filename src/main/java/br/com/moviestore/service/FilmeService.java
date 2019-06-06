package br.com.moviestore.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moviestore.entity.Filme;
import br.com.moviestore.exception.FilmeNotFoundException;
import br.com.moviestore.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	FilmeRepository filmeRespository;
	
	public Filme buscarPorTitulo(String titulo){
		Filme filme = filmeRespository.findByTitulo(titulo);
		if (filme == null) {
			throw new FilmeNotFoundException();
		}
		
		return filme;
	}
	
	public Collection<Filme> buscarDisponives(){
		
		List<Filme> filme = filmeRespository.findDisponiveis();
		if (filme == null || filme.isEmpty()) {
			throw new FilmeNotFoundException();
		}
		return filme;
	}
}
