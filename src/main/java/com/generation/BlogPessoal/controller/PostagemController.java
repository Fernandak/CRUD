package com.generation.BlogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.BlogPessoal.model.PostagemModel;
import com.generation.BlogPessoal.repository.PostagemRepository;

@RestController 
@RequestMapping("/postagem")
@CrossOrigin (origins = "*", allowedHeaders ="*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<PostagemModel>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@PostMapping
	public ResponseEntity <PostagemModel> post(@RequestBody PostagemModel postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
}


