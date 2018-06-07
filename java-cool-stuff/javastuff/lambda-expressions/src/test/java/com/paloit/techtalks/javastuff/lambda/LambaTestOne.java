package com.paloit.techtalks.javastuff.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Pruebas unitarias para programacion con lambda
 * 
 * @author nmontielh
 *
 */

public class LambaTestOne {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void exampleOne() {
		// Ejemplo sin paso de parametros
		logger.debug("Ejemplo sin paso de parametros");
		Runnable r1 = () -> logger.info("HEllo!!");
		r1.run();

	}

	@Test
	public void exampleTwo() {
		// Ejemplo con funcionalidad compleja
		logger.debug("Ejemplo sin paso de parametros + funcionalidad compleja");
		Runnable r2 = () -> {
			for (int i = 0; i < 10; i++) {
				logger.debug("Hello!! {}", i);
			}
		};

		r2.run();
	}

	@Test
	public void exampleThree() {

		// Creamos la lista
		List<Task> tasks = createTask();

		logger.debug("Ejemplo con paso de parametros + funcionalidad simple");
		logger.info("Befor sort");
		print(tasks);
		// Se infiere el tipo
		Collections.sort(tasks, (t1, t2) -> t1.getPriority().compareTo(t2.getPriority()));
		logger.debug("After sort");
		print(tasks);

	}

	@Test
	public void exampleFour() {

		logger.debug("Ejemplo con un metodo custom con paso de una funcion");
		Function<String, Integer> funtion = parameter -> parameter.length();

		Integer tamanio = tamanio("es una prueba!!", funtion);

		logger.info("tamanio {}", tamanio);

	}

	/**
	 * Metodo que se le pasa una funcion y un solo para,etro
	 * 
	 * @param input
	 * @param codeFunction
	 * @return
	 */
	private int tamanio(String input, Function<String, Integer> codeFunction) {

		return codeFunction.apply(input);

	}

	/**
	 * metodo de utileria que solo crea una lista de tareas
	 * 
	 * @return
	 */
	private List<Task> createTask() {
		List<Task> tasks = new ArrayList<>();

		tasks.add(new Task(1, 2, "Task 1"));
		tasks.add(new Task(2, 2, "Task 2"));
		tasks.add(new Task(3, 1, "Task 3"));
		tasks.add(new Task(4, 3, "Task 4"));
		tasks.add(new Task(5, 4, "Task 5"));

		return tasks;
	}

	/**
	 * Utileria que solo imprime un arreglo
	 * 
	 * @param tasks
	 */
	private void print(List<Task> tasks) {
		for (Task task : tasks) {
			logger.info("task {}", task);
		}
	}

}
