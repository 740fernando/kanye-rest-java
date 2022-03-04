package com.conselhosdokanyerest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conselhosdokanyerest.entities.User;
import com.conselhosdokanyerest.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> buscarTodos(){
		return ResponseEntity.ok(userService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> buscarPorId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(userService.buscarPorId(id));
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<User> inserir(@RequestBody User user){
		
		try {
			userService.inserir(user);
			return ResponseEntity.ok(user);
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user){
		userService.atualizar(id, user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		userService.deletar(id);
		return ResponseEntity.ok().build();
	}

}
