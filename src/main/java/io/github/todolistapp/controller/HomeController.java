package io.github.todolistapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.todolistapp.entity.Todo;
import io.github.todolistapp.entity.TodoList;
import io.github.todolistapp.service.TodoListService;
import io.github.todolistapp.service.TodoService;

@Controller
public class HomeController {

	@Autowired
	private TodoListService todoListService;

	@Autowired
	private TodoService todoService;

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
