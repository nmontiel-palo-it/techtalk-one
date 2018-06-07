package com.paloit.techtalks.javastuff.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.paloit.techtalks.javastuff.streams.model.Task;

public class StreamTestCase {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testOne() {

		// Creamos elementos
		List<String> lista = Arrays.asList("uno", "dos", "tres", "cuatro");

		lista.stream() // creamos el stream
				.findFirst() // hacemos una operacion inmutable
				.ifPresent(System.out::println); // Operacion final

	}

	@Test(enabled = false)
	public void testTwo() {

		IntStream.range(1, 10) // Remplaza el loop
				.forEach(System.out::println);

	}

	@Test
	public void testThree() {

		// 1. Elementos
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// 2. hacemos el pipeline y la cpmputacion sobre los elementos
		List<Integer> resultado = numeros.stream() // 3. creamos el stream
				.map(n -> 10 * n + 1) // aplicamos una funcion a este metodo
				.collect(Collectors.toList()); // Regresamos una reduccion mutable

		// entregamos el maximo
		resultado.stream().map(n -> n) // aplicamos una funcin de transformacion
				.filter(s -> {
					return s > 50;
				}) // aplicamos un fltrado
				.forEach(System.out::println); // terminamos con la funcion

	}

	@Test
	public void testFour() {

		List<Integer> numeros = Arrays.asList(9, 4, 6, 8, 23, 1, 2, 79, 4);
		numeros.stream().sorted((s1, s2) -> {
			return s1.compareTo(s2);
		}) // operacion stateful
				.filter(s -> {
					return s > 50;
				}).forEach(s -> logger.info("dato[{}]", s));

	}

	@Test
	public void testCollector() {
		// transforma el stream a un list, map o set
		List<Integer> numeros = Arrays.asList(9, 4, 6, 8, 23, 1, 2, 79, 4);

		List<Integer> resultado = numeros.stream().
				filter(s -> {return s < 20;}) //filtramos
				.sorted((s1, s2) -> {return s1.compareTo(s2);})//ordenamos
				.map(s -> s*10) //Le aplicamos funcion
				.collect(Collectors.toList());//obtenemos

		logger.info("Filtrados [{}]", resultado);

	}

	@Test
	public void testAgregators() {

		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, 1, "uno"));
		tasks.add(new Task(2, 2, "dos"));
		tasks.add(new Task(3, 2, "tres"));
		tasks.add(new Task(4, 1, "cuatro"));
		tasks.add(new Task(5, 5, "cinco"));

		// Creamos un suppier de los streams para hacer varios usos
		Supplier<Stream<Task>> taskSupplier = () -> tasks.stream();

		// Agrupamos por prioridad
		Map<Integer, List<Task>> taskByPriority = tasks.stream() // creamos el stream
				.collect(Collectors.groupingBy(p -> p.getPriority()));

		// imprimimos
		taskByPriority.forEach((priority, tareas) -> logger.info(" data [{}] [{}]", priority, tareas));

		// Hacemos operaciones
		Double pri = taskSupplier.get().collect(Collectors.averagingInt(p -> p.getPriority()));
		logger.info(" priority [{}]", pri);

		IntSummaryStatistics sum = taskSupplier.get().collect(Collectors.summarizingInt(p -> p.getPriority()));
		logger.info("[{}]", sum);

	}

	@Test
	public void testFlatMap() {

		// map, solo mapea a 1 solo objeto
		// flatMap transforma 1 objeto a varios

		// creamos tareas
		List<Task> tasks = new ArrayList<>();
		IntStream.range(1, 10) // creamos un rango
				.forEach(i -> {
					tasks.add(new Task(i, i + 2, "task" + i));
				});

		// Pendiemte el flatMap

	}

	@Test
	public void testRedue() {

		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, 1, "uno"));
		tasks.add(new Task(2, 2, "dos"));
		tasks.add(new Task(3, 2, "tres"));
		tasks.add(new Task(4, 1, "cuatro"));
		tasks.add(new Task(5, 5, "cinco"));

		// Combina todos los elementos en 1 solo
		// Nos traemos la mazima prioridad
		Optional<Task> resultado = tasks.stream()
				.reduce((task1, task2) -> task1.getPriority() > task2.getPriority() ? task1 : task2);
		
		logger.info("Task [{}]", resultado);
		

	}

}
