package io.github.todolistapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.todolistapp.entity.Todo;
import io.github.todolistapp.entity.TodoList;
import io.github.todolistapp.service.EncomiumService;
import io.github.todolistapp.service.TodoListService;
import io.github.todolistapp.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoListService todoListService;
	
	@Autowired
	private EncomiumService encomiumService;
	
	@RequestMapping(value = "/todolist/{listId}/edit", method = RequestMethod.GET)
	public String editTodolist(Model model, @ModelAttribute("message") String message,
			@PathVariable("listId") int listId) {
		TodoList todoList = todoListService.getTodolistById(listId);
		model.addAttribute("todoList", todoList);

		List<Todo> todosByList = todoService.getTodosByList(listId);
		model.addAttribute("todosByList", todosByList);

		model.addAttribute("finishTodo", new Todo());

		if (message.isEmpty()) {
			model.addAttribute("message", "あと" + todoService.getUndoCount(listId) + "個で終わり！");
		} else {
			model.addAttribute("message", message);
		}

		return "todo";
	}
	
	@RequestMapping(value = "/todo/{todoId}", method = RequestMethod.GET)
	public String editTodo(Model model, @PathVariable("todoId") int todoId) {
		model.addAttribute("selectId", todoId);
		
		return "todo";
	}
	
	@RequestMapping(value = "todolist/{listId}/todo/create", method = RequestMethod.POST)
	public String createTodo(Model model, @ModelAttribute Todo todo, @PathVariable("listId") int listId) {
		todoService.addTodo(todo);
		todoService.bindList(todo, listId);
		
		return "redirect:/todolist/{listId}/edit";
	}
	
	@RequestMapping(value = "todolist/{listId}/todo/{todoId}/finish", method = RequestMethod.POST)
	public String finish(Model model, RedirectAttributes redirectAttributes, @ModelAttribute Todo todo, @PathVariable("todoId") int todoId, @PathVariable("listId") int listId){
		todoService.finish(todoService.getTodoById(todoId));
		redirectAttributes.addFlashAttribute("message", encomiumService.getRandomMessage());
		
		return "redirect:/todolist/{listId}/edit";
	}
 }
