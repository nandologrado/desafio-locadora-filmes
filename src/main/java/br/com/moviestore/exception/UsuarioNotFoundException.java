package br.com.moviestore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 6477040032440601414L;

	public UsuarioNotFoundException() {
        super();
    }
}
