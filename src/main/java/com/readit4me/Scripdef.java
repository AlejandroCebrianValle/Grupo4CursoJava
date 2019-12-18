package com.readit4me;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;


public class Scripdef {
	public static void analizar(String fichero) throws FileNotFoundException {
			lecturaFichero(fichero);
	}
	
	public static TreeMap <String,Integer> lecturaFichero(String nameFichero)
										throws FileNotFoundException {
		TreeMap<String,Integer> dicWords = new TreeMap<String, Integer>();
		File fichero = new File(nameFichero);
		System.out.println(nameFichero);
		Scanner lector = new Scanner(fichero);
		//String delimiters = "[-\\t,;.?!:@\\[\\](){}_*/]";
	//	String delimiters = "\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/";
		lector.useDelimiter("\\`|\\´|\\'|\\$|\\n|\\t|\\r|,|;|\\.|\\?|¿|¡|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/|\\u0020|\\>>|\\<<");
		while (lector.hasNext()){
			String palabra = lector.next();
		 //  palabra = palabra.replace(",", "");
		 //  palabra = palabra.replace(".", "");
			if (dicWords.get(palabra) == null){
				dicWords.put(palabra, 1);
			} else {
				dicWords.replace(palabra, dicWords.get(palabra) + 1);
			}
		}
		lector.close();
		return dicWords;
	}
}