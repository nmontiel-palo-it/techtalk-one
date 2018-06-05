package com.paloit.techtalks.javastuff.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Pruebas unitarias para programacion lamnda
 * 
 * @author nmontielh
 *
 */
@Test
public class LambaTestOne {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@BeforeTest
	public void setup() {

	}

	@Test
	public void exampleOne() {
		// Ejemplo sin paso de parametros
		Runnable r1 = () -> logger.info("HEllo!!");
		r1.run();

	}

	@Test
	public void exampleTwo() {
		// Ejemplo con funcionalidad compleja
		Runnable r2 = () -> {
			for (int i = 0; i < 10; i++) {
				logger.info("Hello!! {}", i);
			}
		};

		r2.run();

	}

	@Test
	public void exampleTree() {

		// Creamos la lista
		List<Task> tasks = createTask();

		logger.info("Befor sort");
		print(tasks);
		Collections.sort(tasks, (Task t1, Task t2) -> t1.getPriority().compareTo(t2.getPriority()));
		logger.info("After sort");
		print(tasks);

	}

	private List<Task> createTask() {
		List<Task> tasks = new ArrayList<>();

		tasks.add(new Task(1, 2, "Task 1"));
		tasks.add(new Task(2, 2, "Task 2"));
		tasks.add(new Task(3, 1, "Task 3"));
		tasks.add(new Task(4, 3, "Task 4"));
		tasks.add(new Task(5, 4, "Task 5"));

		return tasks;
	}

	private void print(List<Task> tasks) {
		for (Task task : tasks) {
			logger.info("task {}", task);
		}
	}

}
