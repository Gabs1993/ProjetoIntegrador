package com.accessLocal.accessLocal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Realizamos a notação Entity e a table para a criacao do banco de dados e a criacao da tabela 
 * @author Gabriel/Debora/Regina/Matheus/Felipe
 *
 */

@Entity
@Table(name = "Post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPost;
	
	@NotNull
	@Size(min = 5 , max = 1000)
	private String categoriaEstabelecimento;
	
	@NotNull
	@Size(min = 5 , max = 1000)
	private String tipoEstabelecimento;
	
	@NotNull
	@BatchSize(size= 1)
	private int avalicao;
	
	@NotNull
	@Size(min = 5 , max = 1000)
	private String comentario;
	
	@ManyToOne
	@JsonIgnoreProperties("post")
	private Tema tema;
	
	//@OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL)
	//@JsonIgnoreProperties("usuario")
	//private Usuario usuario;
	
	

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}

	public String getCategoriaEstabelecimento() {
		return categoriaEstabelecimento;
	}

	public void setCategoriaEstabelecimento(String categoriaEstabelecimento) {
		this.categoriaEstabelecimento = categoriaEstabelecimento;
	}

	public String getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(String tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public int getAvalicao() {
		return avalicao;
	}

	public void setAvalicao(int avalicao) {
		this.avalicao = avalicao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
