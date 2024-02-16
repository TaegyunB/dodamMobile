package com.dodam.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dodam.todo.dto.RequestDTO;
import com.dodam.todo.dto.TodoDTO;
import com.dodam.todo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService service;
	
	//Todo 추가
	@PostMapping("/insertTodo")
	public ResponseEntity<String> insertTodo(@RequestBody RequestDTO rdto){
		TodoDTO tdto = rdto.getTdto();
		String connection_id = rdto.getLdto().getConnection_id();
		
		tdto.setConnection_id(connection_id);
		service.insertTodo(tdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Todo 1개
	@GetMapping("/selectOneTodo/{todoid}")
	public ResponseEntity<List<TodoDTO>> selectOneTodo(@PathVariable("todoid") int todoid){
		List<TodoDTO> selectOneTodo = service.selectOneTodo(todoid);
		return new ResponseEntity<>(selectOneTodo, HttpStatus.OK);
	}
	
	// Todo 리스트 가져오기
	@GetMapping("/todoList/{connection_id}")
	public ResponseEntity<List<TodoDTO>> todoList(@PathVariable("connection_id") String connection_id){
		List<TodoDTO> todoList = service.todoList(connection_id);
		return new ResponseEntity<>(todoList, HttpStatus.OK);
	}
	
	// Todo 수정
	@PutMapping("/updateTodo")
	public ResponseEntity<String> updateTodo(@RequestBody RequestDTO rdto){
		TodoDTO tdto = rdto.getTdto();
		String connection_id = rdto.getLdto().getConnection_id();
		
		tdto.setConnection_id(connection_id);
		service.updateTodo(tdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Todo 삭제
	@DeleteMapping("/deleteTodo/{todoid}")
	public ResponseEntity<String> deleteTodo(@PathVariable("todoid") int todoid){
		service.deleteTodo(todoid);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
}
