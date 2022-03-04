package practica3_segundaEVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class DatosPrueba {
	public static void lecturaEscritura1(String fichero) {
		// para poder leer un archivo hay que crear un objeto de clase file con la ruta
		// del archivo
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			Formatter escribir = new Formatter("C:\\Users\\Gestor\\Desktop\\Programacion"
					+ "\\Practica_3_eva2\\Tarea1DatosPrueba\\pruebas-10.txt");
			for (int i = 0; i <= 10; i++) {
				String linea = f.nextLine();
				escribir.format(linea + "\n"); // almacena en el archivo formatter el String
				escribir.flush(); // vuelca el contenido del String en el archivo
			}
			escribir.close(); // cerramos el formatter
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}

	public static void lecturaEscritura2(String fichero) {
		// para poder leer un archivo hay que crear un objeto de clase file con la ruta
		// del archivo
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			Formatter escribir = new Formatter("C:\\Users\\Gestor\\Desktop\\Programacion"
					+ "\\Practica_3_eva2\\Tarea1DatosPrueba\\pruebas-2000.txt");
			// bucle para recorrer el fichero de texto
			for (int i = 0; i <= 2000; i++) {
				String linea = f.nextLine(); // lee palabra por palabra
				escribir.format(linea + "\n"); // almacena en el archivo formatter el String
				escribir.flush(); // vuelca el contenido del String en el archivo
				// cerramos el formatter
			}
			escribir.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}
}
