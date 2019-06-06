package br.com.moviestore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioExistException extends RuntimeException{
	
	private static final long serialVersionUID = -384034777775807994L;

	public UsuarioExistException() {
        super();
    }
}
