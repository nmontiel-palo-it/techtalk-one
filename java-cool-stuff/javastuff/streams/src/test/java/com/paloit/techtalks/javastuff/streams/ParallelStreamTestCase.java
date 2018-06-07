package com.paloit.techtalks.javastuff.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.paloit.techtalks.javastuff.streams.model.Task;

/**
 * el paralelismos incremenra el perfomance en runtime, los threads dependen de
 * los core de CPU del equipo
 * 
 * @author nmontielh
 *
 */
public class ParallelStreamTestCase {

	private final Logger logger  = LoggerFactory.getLogger(getClass());
	
	
	@Test
	public void testParallel() {

		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		
		//por default da 3, pero se puede modificar 
		//-Djava.util.concurrent.ForkJoinPool.common.parallelism=5
		logger.info("Nivel de paralelismo [{}]", commonPool.getParallelism());
		
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, 1, "uno"));
		tasks.add(new Task(2, 2, "dos"));
		tasks.add(new Task(3, 2, "tres"));
		tasks.add(new Task(4, 1, "cuatro"));
		tasks.add(new Task(5, 5, "cinco"));
		
		tasks.parallelStream().filter( s -> {logger.info("Filter [{}] [{}]", s, Thread.currentThread().getName()); return true;})
		.map( s-> {logger.info("Map [{}] [{}]", s, Thread.currentThread().getName()); return s.getPriority()*10;})
		.forEach(s -> logger.info("foreach [{}] [{}]", s, Thread.currentThread().getName()));
		
		
	}
	
	@Test
	public void testSecuence() {

		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		
		//por default da 3, pero se puede modificar 
		//-Djava.util.concurrent.ForkJoinPool.common.parallelism=5
		logger.info("Nivel de paralelismo [{}]", commonPool.getParallelism());
		
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, 1, "uno"));
		tasks.add(new Task(2, 2, "dos"));
		tasks.add(new Task(3, 2, "tres"));
		tasks.add(new Task(4, 1, "cuatro"));
		tasks.add(new Task(5, 5, "cinco"));
		
		tasks.stream().filter( s -> {logger.info("Filter [{}] [{}]", s, Thread.currentThread().getName()); return true;})
		.map( s-> {logger.info("Map [{}] [{}]", s, Thread.currentThread().getName()); return s.getPriority()*10;})
		.forEach(s -> logger.info("foreach [{}] [{}]", s, Thread.currentThread().getName()));
		
		
	}

}
