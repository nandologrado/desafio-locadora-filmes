package br.com.moviestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = -511113482333149861L;

	@Id
    @Column(name="id_locacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlocacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_filme", nullable=false)
    private Filme filme;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtLocacao;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtDevolucao;

    public Long getIdlocacao() {
        return idlocacao;
    }

    public void setIdlocacao(Long idlocacao) {
        this.idlocacao = idlocacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getDtLocacao() {
        return dtLocacao;
    }

    public void setDtLocacao(Date dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locacao)) return false;

        Locacao locacao = (Locacao) o;

        if (!idlocacao.equals(locacao.idlocacao)) return false;
        if (!usuario.equals(locacao.usuario)) return false;
        if (!filme.equals(locacao.filme)) return false;
        if (!dtLocacao.equals(locacao.dtLocacao)) return false;
        return dtDevolucao.equals(locacao.dtDevolucao);
    }

    @Override
    public int hashCode() {
        int result = idlocacao.hashCode();
        result = 31 * result + usuario.hashCode();
        result = 31 * result + filme.hashCode();
        result = 31 * result + dtLocacao.hashCode();
        result = 31 * result + dtDevolucao.hashCode();
        return result;
    }

	@Override
	public String toString() {
		return "Locacao [idlocacao=" + idlocacao + ", usuario=" + usuario + ", filme=" + filme + ", dtLocacao="
				+ dtLocacao + ", dtDevolucao=" + dtDevolucao + "]";
	}
}
