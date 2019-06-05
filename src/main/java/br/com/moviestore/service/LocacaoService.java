package br.com.moviestore.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moviestore.model.Filme;
import br.com.moviestore.model.Locacao;
import br.com.moviestore.model.Usuario;
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
	
	public Locacao locarFilme(String titulo, String email) {
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);	
		Optional<Filme> filme = filmeRespository.findByTitulo(titulo);
	
		if (usuario.get() !=null && filme.get() !=null) {
			Locacao locacao = new Locacao();	
			locacao.setFilme((filme.get()));
			locacao.setUsuario(usuario.get());
			locacao.setDtLocacao(new Date());
			
			filme.get().setQtCopias(filme.get().getQtCopias()-1);
			
			return locacaoRepository.save(locacao);
		}
		
		return null;
	}
	
	/**
	 * O metodo locar e devolver poderia ser feito em um método
	 * */
	public Locacao devolverFilme(String titulo, String email) {
		
		Optional<Locacao> locacao = locacaoRepository.findFilmeLocado(email, titulo);
	
		if (locacao.get() != null) {
			Filme filme = locacao.get().getFilme();		
			filme.setQtCopias(filme.getQtCopias()+1);
			locacao.get().setDtRetorno(new Date());
			return locacaoRepository.save(locacao.get());
		}
		
		return null;
	}
}
