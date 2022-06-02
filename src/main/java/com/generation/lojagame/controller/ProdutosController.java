package com.generation.lojagame.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagame.model.Produtos;

import com.generation.lojagame.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	

	
	@GetMapping
	public ResponseEntity<List<Produtos>> getall(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Produtos> postProdutos(@Valid @RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProdutos(@PathVariable Long id) {
		java.util.Optional<Produtos> resposta = produtosRepository.findById(id);
		if (resposta.isPresent()) {
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		produtosRepository.deleteById(id);
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putPostagem(@Valid @RequestBody Produtos produtos){
		if(produtos.getId() == null)
		return ResponseEntity.badRequest().build();
		return produtosRepository.findById(produtos.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produtos)))
				.orElse(ResponseEntity.notFound().build());
				
		
	}


	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<Produtos>> getByPrecoMenor(@PathVariable BigDecimal preco)
	{
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.findByPrecoGreaterThan(preco));
	}
	
	@GetMapping("/preco_menor/{preco}")
	public ResponseEntity<List<Produtos>> getByPrecoMaior(@PathVariable BigDecimal preco)
	{
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.findByPrecoLessThan(preco));
	}
}
