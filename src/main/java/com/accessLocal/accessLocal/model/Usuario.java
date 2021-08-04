package com.accessLocal.accessLocal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
@Table(name ="usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	@Size(min = 5 , max = 1000)
	private String nomeCompleto;
	
	@Email
	@NotNull
	@NotBlank
	@Size(min = 5 , max = 1000)
	private String emailUsuario;
	
	@NotNull
	@NotBlank
	@Size(min = 5 , max = 1000)
	private String senhaUsuario;
	
	//@ManyToOne
	//@JsonIgnoreProperties("/usuario")
	//private Post post;
	
	
	public long getIdUsuario() {
		return id;
	}

	public void setIdUsuario(long idUsuario) {
		this.id = idUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	
	
	
	

}
