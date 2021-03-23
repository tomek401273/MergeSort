package com.merge.sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

	public static void main(String[] args) throws IOException {
		
//		Path filepath = Paths.get ("C://Users//jmaciejewski//Desktop//Studia WZ//4 Semestr//Podstawy programowania//Laby//popro-srodowisko-win7-64//eclipse-workspace//MergeSort//src//main//resources//test.txt");
//		Path tofile = Paths.get ("MergeSort//src//main//main//resources//test.txt");
		Path filepath = Paths.get ("src/main/resources/test.txt");

		List <String>lines=Files.lines(filepath).collect(Collectors.toList());
		
		//System.out.println("" +lines.size());
	for (int i=0; i<lines.size();i++)	{
		
		String l=lines.get(i);
		System.out.println("Lista: " +l);
	}
	}

}
