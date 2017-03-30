package io.github.todolistapp.service;

import java.util.List;

import io.github.todolistapp.entity.Todo;

public interface TodoService {
	
	public Todo getTodoById(int id);
	
	public List<Todo> getTodosByList(int list_id);
	
	public List<Todo> getTodosByWord(String search_word);
	
	public int getUndoCount(int list_id);
	
	public void bindList(Todo todo, int list_id);
	
	public void finish(Todo todo);
	
	public void addTodo(Todo todo);
}
