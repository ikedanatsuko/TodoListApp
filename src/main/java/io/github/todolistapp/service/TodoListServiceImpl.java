package io.github.todolistapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.todolistapp.dao.TodoListDao;
import io.github.todolistapp.entity.TodoList;

@Service
public class TodoListServiceImpl implements TodoListService {
	
	@Autowired
	private TodoListDao todoListDao;
	
	public TodoList getTodolistById(int id) {
		return todoListDao.getTodolistById(id);
	}
	
	public List<TodoList> getAllTodolist() {
		return todoListDao.getAllTodolist();
	}
	
	@Transactional
	public void updateTodolist(TodoList todolist) {
		todoListDao.updateTodolist(todolist);
	}
	
	@Transactional
	public void addTodolist(TodoList todolist) {
		todoListDao.addTodolist(todolist);
	}
	
	@Transactional
	public void removeTodolist(TodoList todoList) {
		todoListDao.removeTodolist(todoList);
	}
}
