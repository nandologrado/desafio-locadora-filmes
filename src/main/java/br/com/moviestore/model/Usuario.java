package br.com.moviestore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -5627393233691018720L;

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotNull
	@Column(name="nome_usuario", nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String email;
	
	@NotNull
	@Column(nullable = false)
	private String senha;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Usuario)) return false;
		Usuario usuario = (Usuario) o;
		if (!idUsuario.equals(usuario.idUsuario)) return false;
		if (!nome.equals(usuario.nome)) return false;
		if (!email.equals(usuario.email)) return false;
		return senha.equals(usuario.senha);
	}

	@Override
	public int hashCode() {
		int result = idUsuario.hashCode();
		result = 31 * result + nome.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + senha.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
