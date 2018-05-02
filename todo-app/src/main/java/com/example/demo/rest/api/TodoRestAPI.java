package com.example.demo.rest.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ITodoDataAccess;
import com.example.demo.model.Todo;

@RestController
public class TodoRestAPI {
	
	@Autowired
	private ITodoDataAccess dao;
	
	@GetMapping("/todo")
	public ResponseEntity<List<Todo>> findAll(){
		return new ResponseEntity<List<Todo>>(dao.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/todo")
	public ResponseEntity<String> addTodo(@RequestBody Todo todo){
		dao.save(todo);
		return new ResponseEntity<String>("added",HttpStatus.CREATED);
	}

	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> findById(@PathVariable("id") int id){
		Optional<Todo> todo=dao.findById(id);
		return new ResponseEntity<Todo>(todo.get(),HttpStatus.OK);
	}
	
	@PutMapping("/todo/{id}")
	public ResponseEntity<String> updateTodo(@PathVariable("id") int id,@RequestBody Todo todo){
		Optional<Todo> existingTodo= dao.findById(id);
		System.out.println(existingTodo.get());
		BeanUtils.copyProperties(todo, existingTodo.get());
		dao.save(existingTodo.get());
		return new ResponseEntity<String>("updated",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable("id") int id){
		dao.deleteById(id);;
		return new ResponseEntity<>("deleted",HttpStatus.OK);
	}

}
