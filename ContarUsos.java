package practica3_segundaEVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContarUsos {
	/**
	 * pre:
	 * post: en esta clase leemos el fichero que pasemos por consola y contamos los usos 
	 * totales, los usos circulares, es decir los que se cogen y se dejan en la misma
	 * estacion de bici y los translados, esos datos se almacenaran en un arrayList 
	 */
	public static void lectura() {
		int usos = 0;
		int usosCirculares = 0;
		int usosTranslados = 0;
		//C:\\Users\\Gestor\\Desktop\\Programacion\\Practica_3_eva2\\usos-16.csv
		//C:\\Users\\Gestor\\Desktop\\Programacion\\Practica_3_eva2\\usos-17.csv
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame la ruta + nombre del fichero: ");
		// C:\Users\Gestor\Desktop\Programacion\ejercicioClase\ejercicioClase.txt
		String fichero = entrada.nextLine();
		// pasamos la ruta al metodo de lectura
		//para poder leer un archivo hay que crear un objeto de clase file con la ruta del archivo 
		File file = new File(fichero);
		try {
			Scanner f = new Scanner(file);
			f.nextLine(); // Saltar cabecera
			// bucle para recorrer el fichero de texto 
			while(f.hasNextLine()) {
				String linea = f.nextLine(); 
				String [] linesep = linea.split(";"); 
				int id = Integer.parseInt(linesep[0]);
				String fechaRetirada = linesep[1];
				int estacionRetirada = Integer.parseInt(linesep[2]);
				String fechaDev = linesep[3];
				int estacionDev = Integer.parseInt(linesep[4]);
				// creamos un nuevo objeto usuario
				UsoBizi usuario = new UsoBizi(id, fechaRetirada, estacionRetirada, fechaDev, estacionDev);
				if(usuario.getEstacionRetirada() == usuario.getEstacionDev()) {
					usosCirculares++;
				}
				else {
					usosTranslados++;
				}
			}
			usos = usosCirculares + usosTranslados;
			f.close();
			System.out.println("El numero de usos totales es " + usos);
			System.out.println("El numero de usos circulares es " + usosCirculares);
			System.out.println("El numero de usos Translados es " + usosTranslados);

		} catch(FileNotFoundException e) {
			System.out.println("El fichero no ha podido ser abierto.");
		}
	}
}
