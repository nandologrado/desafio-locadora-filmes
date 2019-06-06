package br.com.moviestore.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moviestore.entity.Filme;
import br.com.moviestore.entity.Locacao;
import br.com.moviestore.entity.Usuario;
import br.com.moviestore.repository.FilmeRepository;
import br.com.moviestore.repository.LocacaoRepository;
import br.com.moviestore.repository.UsuarioRepository;

@Service
public class LocacaoService {
	
	@Autowired
	LocacaoRepository locacaoRepository;
	
	@Autowired
	FilmeRepository filmeRespository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Locacao manterFilme(String titulo, String email) {
		
		Locacao locacaoExistente = locacaoRepository.findFilmeLocado(email, titulo);
		
		if (!(locacaoExistente == null)) {
			Filme filme = locacaoExistente.getFilme();		
			filme.setQtCopias(filme.getQtCopias()+1);
			locacaoExistente.setDtRetorno(new Date());
			return locacaoRepository.save(locacaoExistente);
		} else {	
			Usuario usuario = usuarioRepository.findByEmail(email);	
			Filme filme = filmeRespository.findByTitulo(titulo);
		
			if (usuario !=null && filme !=null && filme.getQtCopias()>0) {
				Locacao locacao = new Locacao();	
				locacao.setFilme((filme));
				locacao.setUsuario(usuario);
				locacao.setDtLocacao(new Date());		
				filme.setQtCopias(filme.getQtCopias()-1);
				
				return locacaoRepository.save(locacao);
			}
		}
		
		return null;
	}
}
