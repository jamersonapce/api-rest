package com.jamerson.socialbooksapi.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Livro {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@JsonInclude(Include.NON_NULL)
	@Temporal(TemporalType.DATE)
	private Calendar publicacao;

	@JsonInclude(Include.NON_NULL)
	private String editora;

	@JsonInclude(Include.NON_NULL)
	private String resumo;

	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;

	public Livro() {
	}

	public Livro(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Calendar publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
