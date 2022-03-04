package practica3_segundaEVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UsosUsuario {
	/**
	 * 
	 * post:
	 * pre: en esta clase de java vamos a leer el fichero enviado por escaner y mostraremos por pantalla
	 * el id de usuario, los movimientos circulares los traslados y el total, para luego ordenarlos de 
	 * maypr a menor y mostrar los 15 usuarios mas habituales.
	 */
	public static ArrayList<Datos> Ordenar(ArrayList<Datos> V) {
		/*
		 * ordenamos el arraylist de usuarios con el metodo de ordenacion burbuja y devolvemos 
		 * el array list ordenado
		 */
		Datos aux;
		for (int i = 0; i < V.size() - 1; i++) {
			for (int j = 0; j < V.size() - i - 1; j++) {
				if (V.get(j + 1).getTotal() > V.get(j).getTotal()) {
					aux = V.get(j + 1);
					V.set(j + 1, V.get(j));
					V.set(j, aux);
				}
			}
		}
		return V;
	}

	public static int Usuario(int id, ArrayList<Datos> V) {
		/*
		 * Busca un usuario en un array para poder sumar las veces que hace traslado o
		 * circular
		 */
		boolean encontrado = false;
		int i = 0;
		while (i < V.size() && !encontrado) {
			if (V.get(i).getId() == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static void lectura() {
		/*
		 * en este metodo leemos el fichero y calculamos el numero de traslados, rotaciones y totales
		 * oara añadirlo a un arrray list
		 */
		int rotacion = 0;
		int traslado = 0;
		int total = 0;

		// C:\\Users\\Gestor\\Desktop\\Programacion\\Practica_3_eva2\\usos-16.csv
		// C:\\Users\\Gestor\\Desktop\\Programacion\\Practica_3_eva2\\usos-17.csv
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame la ruta + nombre del fichero: ");
		// C:\Users\Gestor\Desktop\Programacion\ejercicioClase\ejercicioClase.txt
		String fichero = entrada.nextLine();
		// pasamos la ruta al metodo de lectura
		// para poder leer un archivo hay que crear un objeto de clase file con la ruta
		// del archivo
		File file = new File(fichero);
		/*
		 *  cramos un arraylist del objeto datos que tendra como parametros el id de usuario,
		 *  los movimientos circulares, los de translado y la suma de estos dando los totales
		 */
		ArrayList<Datos> datos = new ArrayList<Datos>();
		try {
			Scanner f = new Scanner(file);
			f.nextLine(); // Saltar cabecera
			// bucle para recorrer el fichero de texto
			while (f.hasNextLine()) {
				String linea = f.nextLine(); // lee palabra por palabra
				String[] linesep = linea.split(";");
				int id = Integer.parseInt(linesep[0]);
				int estacionRetirada = Integer.parseInt(linesep[2]);
				int estacionDev = Integer.parseInt(linesep[4]);
				
				int posicion = Usuario(id, datos); // Busca el id en el arraylist y te da la posicion del usuario o -1
				
				if (posicion >= 0) {
					if (estacionRetirada == estacionDev) { 
						/*
						 * si la posicion de retirada y devolucion es la misma, vamos a la clase datos
						 * cogemos los movimientos circulares y aumentamos en uno su valor lo actualizamos 
						 * en el objeto datos
						 */
						int ncirculares = datos.get(posicion).getCircular();
						ncirculares = ncirculares + 1;
						Datos d = new Datos(id, datos.get(posicion).getTraslados(), ncirculares);
						datos.set(posicion, d);
						/*
						 * sino el movimiento sera de traslado y por lo tanto ocurrira lo mismo pero en el 
						 * apartado de movimientos de traslacion
						 */
					} else {
						int ntraslados = datos.get(posicion).getTraslados();
						ntraslados = ntraslados + 1;
						Datos d = new Datos(id, ntraslados, datos.get(posicion).getCircular());
						datos.set(posicion, d);
					}
				} else {

					if (estacionRetirada == estacionDev) {
						Datos d = new Datos(id, 0, 1);
						datos.add(d);
					} else {
						Datos d = new Datos(id, 1, 0);
						datos.add(d);
					}
				}
			}
			for (int i = 0; i < datos.size(); i++) {
				total = datos.get(i).getCircular() + datos.get(i).getTraslados();
				Datos d = new Datos(datos.get(i).getId(), datos.get(i).getTraslados(), datos.get(i).getCircular(),
						total);
				datos.set(i, d);
			}
			datos = Ordenar(datos);
			System.out.println("Usuario " + "Rotaciones " + "Traslados " + "Total " );
			System.out.println("--------" + "-----------" + "----------" + "------");
			for (int i = 0; i < 15; i++) {
				System.out.println(" " + datos.get(i).getId() + "     " + datos.get(i).getCircular() + "    "
						+ datos.get(i).getTraslados() + "    " + datos.get(i).getTotal());
			}
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no ha podido ser abierto.");
		}
	}
}
