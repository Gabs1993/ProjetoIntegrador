package com.accessLocal.accessLocal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accessLocal.accessLocal.model.Usuario;
import com.accessLocal.accessLocal.repository.usuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class controllerUsuario {
	
	@Autowired
	private usuarioRepository repository;
	
	/**
	 * 
	 * @return no lugar do listuser ele vai retornar uma lista vazia e caso seja verdadeiro ele retornara com o status 204 caso nao status 200
	 */
	@GetMapping
	public ResponseEntity<Object> buscarTudo () {
		List<Usuario> listUser = repository.findAll();
		
		if (listUser.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listUser);
		}
		
	}
	
	/** 
	 * Este metodo serve para buscar informacoes no banco de dados pelo id.
	 * @param  O caminho {id} serve para a notação PathVariable identificar qual informacao foi digitada. 
	 * @return  iremos retornar o id pelo findbyid
	 * @version  1.0
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	/**
	 * Este metodo realizando a busca por usuario/nomeCompleto
	 * @param usamos como parametro o nomeCompleto que o PathVariable irá realizar a busca
	 * @return utilizamos o metodo findAllByNomeCompleto para realizar a busca somente do nome
	 * @author
	 */
	@GetMapping("/usuario/{nomeCompleto}")
	public ResponseEntity<List<Usuario>> GetByNome(@PathVariable String nomeCompleto){
		return ResponseEntity.ok(repository.findAllByNomeCompletoContainingIgnoreCase(nomeCompleto));
	
	}
	/**
	 * 	
	 * @param 'Post' que serve para postarmos algumas informaçoes.
	 * @return com o status ok e vai salvar as informacoes que estiverem dentro do parametro usuario
	 */
	@PostMapping
	public ResponseEntity<Usuario> post (@RequestBody Usuario Usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Usuario));
		
	}
	/**
	 * Este metodo serve para atualizarmos ou editarmos algumas informacoes
	 * @param Usamos o RequestBody para puxar todas as informacoes do usuario que e o nosso parametro
	 * @return vai retornar com o status ok e salvar tambem as informoes que serao atualizadas
	 */
	@PutMapping("/put")
	public ResponseEntity<Usuario> put (@RequestBody Usuario Usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Usuario));
		
	}
	/**
	 * 
	 * @param id e o metedo serve para a delecao seja ele por id ou usuario.
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}


}
