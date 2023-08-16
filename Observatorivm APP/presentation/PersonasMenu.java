package observatorio.presentation;

import fundamentos.Menu;

public class PersonasMenu {

	PersonasMenuOperations pmo = new PersonasMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * Método run al que se llama desde el exterior para lanzar el menú
	 */
	public void run() {
		
		int option;
		//Creamos un menú e insertamos las opciones
		Menu personasMenu = new Menu("Menú de gestión de las personas");
		personasMenu.insertaOpcion("Añade persona", 1);
		personasMenu.insertaOpcion("Muestra personas", 2);
		personasMenu.insertaOpcion("Actualiza persona", 3);
		personasMenu.insertaOpcion("Elimina persona", 4);
		personasMenu.insertaOpcion("Salir del menú de personas",99);
		
		//Mientras no se seleccione la opción de salir del menú, se continúa en el menú
		do {
			option = personasMenu.leeOpcion(); //se lee la opción seleccionada del menú
			this.optionAction(option); //llamamos al método para ejecutar la opción seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el menú
		personasMenu.cierra();
		
	}
	
	/**
	 * Método que maneja con un switch la opción seleccionada en el menú
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			pmo.anhadePersonal();
			break;
			
		case 2:
			pmo.selectPersonal();
			break;
		
		case 3:
			pmo.actualizaPersonal();
			break;
		
		case 4:
			pmo.eliminaPersonal();
			break;
		
		default:
			break;
			
		
		}
	}
	
}
