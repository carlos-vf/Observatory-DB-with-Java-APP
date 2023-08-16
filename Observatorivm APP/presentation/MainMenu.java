package observatorio.presentation;

import fundamentos.*; //cargamos el paquete fundamentos

/**
 * Clase para la implementación del menú principal
 * de la aplicación.
 * 
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class MainMenu {

	/**
	 * Método run al que se llama desde el exterior para lanzar el menú
	 */
	public void run() {
		
		
		int option;
		
		//Menú para manejar las acciones
		Menu mainMenu = new Menu("Menú principal");
		mainMenu.insertaOpcion("Gestión de objetos", 1);
		mainMenu.insertaOpcion("Gestión de proyectos", 2);
		mainMenu.insertaOpcion("Gesti�n de inventario", 3);
		mainMenu.insertaOpcion("Gesti�n de personas", 4);
		mainMenu.insertaOpcion("Descubrimientos", 5);
		mainMenu.insertaOpcion("Gesti�n de observaciones", 6);		
		mainMenu.insertaOpcion("Salir de la aplicación", 99);
		
		//Mientras no se seleccione la opción de salir del menú, se continúa en el menú
		do {
			option = mainMenu.leeOpcion(); //se lee la opción seleccionada del menú
			this.optionAction(option); //llamamos al método para ejecutar la opción seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el menú
		mainMenu.cierra();
		
	}
	
	/**
	 * Método que maneja con un switch la opción seleccionada en el menú
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			new ObjetoMenu().run(); //lanzamos el menú de gestión de los objetos
			break;
		
		case 2:
			//new ProyectoMenu().run();
			break;
		
		case 3:
			new InventarioMenu().run();
			break;
		
		case 4:
			new PersonasMenu().run();
			break;
		
		case 5:
			//DESCUBRIMIENTO;
			break;
			
		case 6:
			new ObservacionesMenu().run();
			break;
			
		default:
			break;
			
		
		}
	}
}
