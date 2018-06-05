package com.paloit.techtalks.javastuff.lambda;

import java.io.Serializable;

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer priority;
	private String name;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Integer id, Integer priority, String name) {
		super();
		this.id = id;
		this.priority = priority;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", priority=" + priority + ", name=" + name + "]";
	}

}
