package observatorio.presentation;

import fundamentos.Menu;

public class ObservacionesMenu {

	ObservacionesMenuOperations omo = new ObservacionesMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * M�todo run al que se llama desde el exterior para lanzar el men�
	 */
	public void run() {
		
		int option;
		//Creamos un men� e insertamos las opciones
		Menu observacionesMenu = new Menu("Men� de gesti�n de las observaciones");
		observacionesMenu.insertaOpcion("A�ade observacion", 1);
		observacionesMenu.insertaOpcion("Muestra observaciones", 2);
		observacionesMenu.insertaOpcion("Salir del men� de observaciones",99);
		
		//Mientras no se seleccione la opci�n de salir del men�, se contin�a en el men�
		do {
			option = observacionesMenu.leeOpcion(); //se lee la opci�n seleccionada del men�
			this.optionAction(option); //llamamos al m�todo para ejecutar la opci�n seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el men�
		observacionesMenu.cierra();
		
	}
	
	/**
	 * M�todo que maneja con un switch la opci�n seleccionada en el men�
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			omo.anhadeObservacion(); //operaci�n para insertar una nueva observacion
			break;
			
		case 2:
			omo.selectObservacion(); //operaci�n para mostrar observaciones
			break;
		
		default:
			break;
			
		
		}
	}
	
}
