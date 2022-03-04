package practica3_segundaEVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
	/**
	 * pre:
	 * post: en este ejercicio java se nos pasa un fichero del que extraeremos los datos que se necesiten
	 * en esta clase tenemos el menu en el que podemos elegir que hacer escribiendo 1 para ver los datos
	 * de prueba, un 2 para contar los usos, 3 para contar los usos por usuario y un 4 para cerrar el 
	 * programa
	 */

	public static void main(String []args) {
		String ruta1 = "C:\\Users\\Gestor\\Desktop\\Programacion\\Practica_3_eva2\\usos-16.csv";
		String ruta2 = "C:\\Users\\Gestor\\Desktop\\Programacion\\Practica_3_eva2\\usos-17.csv";
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al portal de datos de Bizi Zaragoza");
		System.out.println("¿Que desea hacer?");
		System.out.println("1 Ver los datos de prueba");
		System.out.println("2 Contar los usos");
		System.out.println("3 Contar los usos por usuario");
		System.out.println("4 Cerrar el programa");
		while (true) {
			int Opcion = sc.nextInt();
			if (Opcion == 1) {
				DatosPrueba.lecturaEscritura1(ruta1);
				DatosPrueba.lecturaEscritura2(ruta2);
			}
			else if(Opcion == 2) {
				ContarUsos.lectura();
			}
			else if(Opcion == 3) {
				UsosUsuario.lectura();
			}
			else if(Opcion == 4) {
				System.out.println("Adios tenga un buen dia");
				break;
			}
			else {
				System.out.println("Elija entre 1, 2, 3 y 4 por favor");
			}
		}

	}
}
