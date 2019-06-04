package br.com.moviestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="filme")
public class Filme implements Serializable {

	private static final long serialVersionUID = 4732067422355563269L;

	@Id
    @Column(name="id_filme")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfilme;

    @NotNull
    @Column(nullable = false)
    private String titulo;

    @NotNull
    @Column(nullable = false)
    private String diretor;

    @NotNull
    @Column(name = "qt_copias",nullable = false)
    private int qtCopias;

    public Long getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(Long idfilme) {
        this.idfilme = idfilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getQtCopias() {
        return qtCopias;
    }

    public void setQtCopias(int qtCopias) {
        this.qtCopias = qtCopias;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme)) return false;

        Filme filme = (Filme) o;

        if (!idfilme.equals(filme.idfilme)) return false;
        if (!titulo.equals(filme.titulo)) return false;
        return diretor.equals(filme.diretor);
    }

    @Override
    public int hashCode() {
        int result = idfilme.hashCode();
        result = 31 * result + titulo.hashCode();
        result = 31 * result + diretor.hashCode();
        return result;
    }

	@Override
	public String toString() {
		return "Filme [idfilme=" + idfilme + ", titulo=" + titulo + ", diretor=" + diretor + ", qtCopias=" + qtCopias
				+ "]";
	}
}
