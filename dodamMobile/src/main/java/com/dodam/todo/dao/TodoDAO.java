package com.dodam.todo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dodam.todo.dto.TodoDTO;

@Mapper
public interface TodoDAO {

	// Todo 추가
	public int insertTodo(TodoDTO dto);
	
	// Todo 1개
	public List<TodoDTO> selectOneTodo(int todoid);
	
	// Todo 리스트
	public List<TodoDTO> todoList(String connection_id);
	
	// Todo 수정
	public int updateTodo(TodoDTO dto);
	
	// Todo 삭제
	public int deleteTodo(int todoid);
}
