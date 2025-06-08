package com.proyectoSSS.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
	public static List<String> readLines(String filePathString) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePathString));
		return lines;
	}

	public static void exportText(String filePathString, String text) throws IOException {
		Files.write(Paths.get(filePathString), text.getBytes());
	}
	
	public static Path getFolderPath() {
		//se pone esto porque en vez de coger el proyecto coge una carpeta de eclipse
	    return Path.of(System.getProperty("user.dir"));
	}

}
