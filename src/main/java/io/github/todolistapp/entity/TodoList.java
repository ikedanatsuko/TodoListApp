package io.github.todolistapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(name = "todolist")
public class TodoList {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "deadline")
	private Date deadline;
	
	public TodoList() {
	}
	
	public TodoList(String title, Date deadline) {
		this.title = title;
		this.deadline = deadline;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
}
