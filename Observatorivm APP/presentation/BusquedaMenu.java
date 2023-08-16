package observatorio.presentation;

import fundamentos.Menu;
/**
 * Clase para generar el menú de busqueda de objetos
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class BusquedaMenu {
	
	BusquedaMenuOperations bmo = new BusquedaMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * Método run al que se llama desde el exterior para lanzar el menú
	 */
	public void run() {
		
		int option;
		//Creamos un menú e insertamos las opciones
		Menu objetoMenu = new Menu("Menú de gestión de los objetos");
		objetoMenu.insertaOpcion("Búsqueda por tipo", 1);
		objetoMenu.insertaOpcion("Búsqueda por nombre", 1);
		objetoMenu.insertaOpcion("Búsqueda por magnitud", 1);
		objetoMenu.insertaOpcion("Búsqueda por descubridor", 1);
		objetoMenu.insertaOpcion("Búsqueda por equipamiento utilizado", 1);
		objetoMenu.insertaOpcion("Salir del menú de búsqueda de objetos astronómicos",99);
		
		//Mientras no se seleccione la opción de salir del menú, se continúa en el menú
		do {
			option = objetoMenu.leeOpcion(); //se lee la opción seleccionada del menú
			this.optionAction(option); //llamamos al método para ejecutar la opción seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el menú
		objetoMenu.cierra();
		
	}
	
	/**
	 * Método que maneja con un switch la opción seleccionada en el menú
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			bmo.buscaPorTipo(); //operación para buscar por tipo de objeto
			break;
			
		case 2:
			bmo.buscaPorNombre(); //operación para buscar por nombre
			break;
		
		case 3:
			bmo.buscaPorMagnitud(); //operación para buscar por magnitud
			break;
			
		case 4:
			bmo.buscaPorDescubridor(); //operación para buscar por descubridor
			break;
			
		case 5:
			bmo.buscaPorEquipamiento(); //operación para buscar por equipamiento
			break;

		default:
			break;
		
		}
	}

}
