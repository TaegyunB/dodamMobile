package com.dodam.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodam.todo.dao.TodoDAO;
import com.dodam.todo.dto.TodoDTO;

@Service
public class TodoService {

	@Autowired
	TodoDAO dao;
	
	// Todo 추가
	public int insertTodo(TodoDTO dto) {
		return dao.insertTodo(dto);
	}
	
	// Todo 리스트
	public List<TodoDTO> todoList(String connection_id){
		return dao.todoList(connection_id);
	}
	
	// Todo 수정
	public int updateTodo(TodoDTO dto) {
		return dao.updateTodo(dto);
	}
}
