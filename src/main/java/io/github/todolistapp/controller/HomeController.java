package io.github.todolistapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.github.todolistapp.entity.TodoList;
import io.github.todolistapp.service.TodoListService;

@Controller
public class HomeController {

	@Autowired
	private TodoListService todoListService;

	@RequestMapping(value = { "/" })
	public String index(Model model) {
		List<TodoList> allTodolist = todoListService.getAllTodolist();
		model.addAttribute("allTodolist", allTodolist);

		return "index";
	}

	@RequestMapping(value = "/todolist/create", method = RequestMethod.POST)
	public String createTodolist(Model model, @ModelAttribute TodoList todoList) {
		todoListService.addTodolist(todoList);

		return "redirect:/";
	}

}
