package com.paloit.techtalks.javastuff.generics;

public class Utils {

	// Definimos los tipos a nivel de metodo
	public static <K, V> Boolean compare(Pair<K, V> entitiOne, Pair<K, V> entityTwo) {
		return entitiOne.getKey().equals(entityTwo.getKey()) && entitiOne.getValue().equals(entityTwo.getValue());
	}

	// Limitando los tpos que puden ser usads
	public static <U extends String> Boolean isValidType(U entity) {
		return true;
	}

}
