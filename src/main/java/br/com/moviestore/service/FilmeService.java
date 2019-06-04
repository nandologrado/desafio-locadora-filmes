package br.com.moviestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moviestore.model.Filme;
import br.com.moviestore.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	FilmeRepository filmeRespository;
	
	public List<Filme> buscarPorTitulo(String titulo){
		return filmeRespository.findByTitulo(titulo);
	}

}
