package br.com.moviestore;

import br.com.moviestore.security.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocadoraFilmesApplication {

	@Bean
	public FilterRegistrationBean filtroJwt(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/restrito/*");
		return frb;
	};

	public static void main(String[] args) {
		SpringApplication.run(LocadoraFilmesApplication.class, args);
	}



}
