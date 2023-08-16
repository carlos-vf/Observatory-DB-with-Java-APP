package observatorio.presentation;

import fundamentos.Menu;

public class PersonasMenu {

	PersonasMenuOperations pmo = new PersonasMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * M�todo run al que se llama desde el exterior para lanzar el men�
	 */
	public void run() {
		
		int option;
		//Creamos un men� e insertamos las opciones
		Menu personasMenu = new Menu("Men� de gesti�n de las personas");
		personasMenu.insertaOpcion("A�ade persona", 1);
		personasMenu.insertaOpcion("Muestra personas", 2);
		personasMenu.insertaOpcion("Actualiza persona", 3);
		personasMenu.insertaOpcion("Elimina persona", 4);
		personasMenu.insertaOpcion("Salir del men� de personas",99);
		
		//Mientras no se seleccione la opci�n de salir del men�, se contin�a en el men�
		do {
			option = personasMenu.leeOpcion(); //se lee la opci�n seleccionada del men�
			this.optionAction(option); //llamamos al m�todo para ejecutar la opci�n seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el men�
		personasMenu.cierra();
		
	}
	
	/**
	 * M�todo que maneja con un switch la opci�n seleccionada en el men�
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
