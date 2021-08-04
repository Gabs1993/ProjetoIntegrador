package com.accessLocal.accessLocal.controller;
/**
 * Controller Post / Criaçao 02/08/2021
 * Todos os direitos reservados Acsses Local
 *
 * Version Beta 1.0
 * 
 * @autor Felipe Augusto
 * @autor Gabriel Conceição
 * @autora Regina Rodrigues
 * @autora Debora Cristina
 * @Mathues Moreira
 */


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

import com.accessLocal.accessLocal.model.Post;
import com.accessLocal.accessLocal.repository.postagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class controllerPost {

	@Autowired
	private postagemRepository repository;
	
	/**
	 * 
	 * @return no lugar do listpost ele vai retornar uma lista vazia e caso seja verdadeiro ele retornara com o status 204 caso nao status 200
	 */
	@GetMapping
	public ResponseEntity<Object> buscarTudo () {
		List<Post> listPost = repository.findAll();
		
		if (listPost.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listPost);
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
	public ResponseEntity<Post> GetById (@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Este metodo realizando a busca por post/categoriaEstabelecimento
	 * @param usamos como parametro o categoriaEstabelecimento que o PathVariable irá realizar a busca
	 * @return utilizamos o metodo findAllByCategoriaEstabelecimento para realizar a buca somente do categoriaEstabelecimento
	 * @author
	 */
	@GetMapping("/post/{categoriaEstabelecimento}")
	public ResponseEntity<List<Post>> GetByEstabelecimento(@PathVariable String categoriaEstabelecimento){
		return ResponseEntity.ok(repository.findAllByCategoriaEstabelecimentoContainingIgnoreCase(categoriaEstabelecimento));
	}

	/**
	 * 	
	 * @param 'Post' que serve para postarmos algumas informaçoes.
	 * @return com o status ok e vai salvar as informacoes que estiverem dentro do parametro post
	 */
	@PostMapping
	public ResponseEntity<Post> post (@RequestBody Post Post){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Post));
		
	}
	/**
	 * Este metodo serve para atualizarmos ou editarmos algumas informacoes
	 * @param Usamos o RequestBody para puxar todas as informacoes do post que e o nosso parametro
	 * @return vai retornar com o status ok e salvar tambem as informoes que serao atualizadas
	 */
	@PutMapping("/put")
	public ResponseEntity<Post> put (@RequestBody Post post){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(post));
	
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

