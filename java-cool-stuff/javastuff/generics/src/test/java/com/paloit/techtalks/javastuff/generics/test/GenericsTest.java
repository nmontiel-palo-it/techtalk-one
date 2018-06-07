package com.paloit.techtalks.javastuff.generics.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.paloit.techtalks.javastuff.generics.Box;
import com.paloit.techtalks.javastuff.generics.Utils;

import model.Hijo;
import model.Nieto;
import model.Padre;

import com.paloit.techtalks.javastuff.generics.OrderedPair;
import com.paloit.techtalks.javastuff.generics.Pair;

public class GenericsTest {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testOne() {
		
		//Indicamos el tipo en la instancia
		Box<Integer> boxOne = new Box<Integer>();
		
		//El compilador infiere el tipo
		Box<Double> boxTwow = new Box<>();
		Box<?> boxThree = new Box<>();
		
		//Si no se invoca el tipo es Raws (no valida datos)
		Box boxFour = new Box();
		
		//Multiples con herencia
		Pair<Integer, String> entityOne = new OrderedPair<>(1, "MyValue");
		Pair<Integer, String> entityTwo = new OrderedPair<>(1, "MyValue");
		Pair<Integer, String> entityThree = new OrderedPair<>(2, "MyValue2");
		
		//Ya infiere los tipos
		boolean oneComp = Utils.compare(entityOne, entityTwo);
		boolean oneTwo = Utils.compare(entityOne, entityThree);
		
		logger.info(" Comparation [{}] [{}]", oneComp, oneTwo);
		
		
	}
	
	@Test
	public void testTwo() {
		String dataString = "My String";
		Double dataDouble = 2d;
		
		Utils.isValidType(dataString);
		
		//Fail if not is the type
		//LittleBox.isValidType(dataDouble);
		
		
	}
	
	
	@Test
	public void testThree() {
		
		List<? extends Number> data = new ArrayList<>();
	//	data.add(new Double());
		
		List<? super Number> data2 = new ArrayList<>();		
		data2.add(new Integer(1));

		
		
	}
	
	
	public void superBoundedTest() {
		
		List<? super Hijo> data = new ArrayList<>();
		
		//data.add(new Padre());
		data.add(new Hijo());
		data.add(new Nieto());
		
	}
	
	
	public void lowerBoundedTest() {
		
		List<? extends Hijo> data = new ArrayList<>();
		
	}
	

}
