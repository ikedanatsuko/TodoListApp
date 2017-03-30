package io.github.todolistapp.dao;

import java.util.List;

import io.github.todolistapp.entity.Todo;
import io.github.todolistapp.entity.TodoList;

public interface TodoListDao {
	
	public TodoList getTodolistById(int id);
	
	public List<TodoList> getAllTodolist();
	
	public void updateTodolist(TodoList todolist);
	
	public void addTodolist(TodoList todolist);
	
	public void removeTodolist(TodoList todoList);
}
