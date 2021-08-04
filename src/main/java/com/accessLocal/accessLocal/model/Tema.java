package com.accessLocal.accessLocal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Realizamos a notação Entity e a table para a criacao do banco de dados e a criacao da tabela 
 * @author Gabriel/Debora/Regina/Matheus/Felipe
 *
 */

@Entity
@Table(name = "tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTema;
	
	 
	@NotNull
	@NotBlank
	@Size(min = 2 , max = 50)
	private String tipoUsuario;
	
	
	@Size(min = 2 , max = 90)
	private String tipoDeficiencia;
	
	
	@Size(min = 1 , max = 100000)
	private String experienciaUsuario;
	
	
	@OneToMany(mappedBy = "tema" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Post> post;
	

	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getExperienciaUsuario() {
		return experienciaUsuario;
	}

	public void setExperienciaUsuario(String experienciaUsuario) {
		this.experienciaUsuario = experienciaUsuario;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	

	
	

}
	
	
	
	
