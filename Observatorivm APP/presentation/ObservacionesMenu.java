package observatorio.presentation;

import fundamentos.Menu;

public class ObservacionesMenu {

	ObservacionesMenuOperations omo = new ObservacionesMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * Método run al que se llama desde el exterior para lanzar el menú
	 */
	public void run() {
		
		int option;
		//Creamos un menú e insertamos las opciones
		Menu observacionesMenu = new Menu("Menú de gestión de las observaciones");
		observacionesMenu.insertaOpcion("Añade observacion", 1);
		observacionesMenu.insertaOpcion("Muestra observaciones", 2);
		observacionesMenu.insertaOpcion("Salir del menú de observaciones",99);
		
		//Mientras no se seleccione la opción de salir del menú, se continúa en el menú
		do {
			option = observacionesMenu.leeOpcion(); //se lee la opción seleccionada del menú
			this.optionAction(option); //llamamos al método para ejecutar la opción seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el menú
		observacionesMenu.cierra();
		
	}
	
	/**
	 * Método que maneja con un switch la opción seleccionada en el menú
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			omo.anhadeObservacion(); //operación para insertar una nueva observacion
			break;
			
		case 2:
			omo.selectObservacion(); //operación para mostrar observaciones
			break;
		
		default:
			break;
			
		
		}
	}
	
}
