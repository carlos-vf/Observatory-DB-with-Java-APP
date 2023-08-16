package observatorio.presentation;

import fundamentos.*; //cargamos el paquete fundamentos

/**
 * Clase para la implementaci贸n del men煤 principal
 * de la aplicaci贸n.
 * 
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class MainMenu {

	/**
	 * M茅todo run al que se llama desde el exterior para lanzar el men煤
	 */
	public void run() {
		
		
		int option;
		
		//Men煤 para manejar las acciones
		Menu mainMenu = new Menu("Men煤 principal");
		mainMenu.insertaOpcion("Gesti贸n de objetos", 1);
		mainMenu.insertaOpcion("Gesti贸n de proyectos", 2);
		mainMenu.insertaOpcion("Gesti髇 de inventario", 3);
		mainMenu.insertaOpcion("Gesti髇 de personas", 4);
		mainMenu.insertaOpcion("Descubrimientos", 5);
		mainMenu.insertaOpcion("Gesti髇 de observaciones", 6);		
		mainMenu.insertaOpcion("Salir de la aplicaci贸n", 99);
		
		//Mientras no se seleccione la opci贸n de salir del men煤, se contin煤a en el men煤
		do {
			option = mainMenu.leeOpcion(); //se lee la opci贸n seleccionada del men煤
			this.optionAction(option); //llamamos al m茅todo para ejecutar la opci贸n seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el men煤
		mainMenu.cierra();
		
	}
	
	/**
	 * M茅todo que maneja con un switch la opci贸n seleccionada en el men煤
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			new ObjetoMenu().run(); //lanzamos el men煤 de gesti贸n de los objetos
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
