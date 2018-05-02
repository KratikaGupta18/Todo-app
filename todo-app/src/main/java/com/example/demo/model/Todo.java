package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
public class Todo {

	@Id
	private int todoId;
	private String title;
	private boolean completed;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(int todoId, String title, boolean completed) {
		this.todoId = todoId;
		this.title = title;
		this.completed = completed;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Todo [todoId=");
		builder.append(todoId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", completed=");
		builder.append(completed);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
