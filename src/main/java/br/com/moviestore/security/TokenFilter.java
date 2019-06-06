package br.com.moviestore.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

      
        String header = req.getHeader("Authorization");

        if(header == null || !header.startsWith("Bearer ")){
            throw new ServletException("Token inválido");
        }

        String token = header.substring(7);

        try {
            Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
        }catch(SignatureException e){
            throw new ServletException("Token inválido");
        }

        chain.doFilter(request, response);
    }
}
