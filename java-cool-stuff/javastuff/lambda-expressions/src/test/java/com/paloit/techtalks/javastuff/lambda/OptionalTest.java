package com.paloit.techtalks.javastuff.lambda;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class OptionalTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testOptional() {

		String nombre = "homero simpson";
		Optional<String> oNombre = Optional.of(nombre);
		
		String apodo = null;
		Optional<String> oApodo = Optional.ofNullable(apodo);
		
		logger.info("Nombre [{}] [{}]", oNombre.get(), oNombre.isPresent());
		
		//Si no esta presente (java.util.NoSuchElementException: No value present)
		logger.info("Apodo [{}] [{}]", oApodo.get(), oApodo.isPresent());		
		
	}
	
	@Test
	public void testOptionalTwo() {

		String apodo = null;
		Optional<String> oApodo = Optional.ofNullable(apodo);
		
		String aElse = oApodo.orElse("No tengo nada 8-(");
		String oElseFunction = oApodo.orElseGet( () -> "hago algo");

		//Si no esta presente (java.util.NoSuchElementException: No value present)
		logger.info("Apodo [{}]", aElse);
		logger.info("Apodo [{}]", oElseFunction);
				
	}

}
