package observatorio.presentation;

import fundamentos.Menu;
/**
 * Clase para generar el menú de gestión de objetos
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class ObjetoMenu {
	
	ObjetosMenuOperations omo = new ObjetosMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * Método run al que se llama desde el exterior para lanzar el menú
	 */
	public void run() {
		
		int option;
		//Creamos un menú e insertamos las opciones
		Menu objetoMenu = new Menu("Menú de gestión de los objetos");
		objetoMenu.insertaOpcion("Búsca un objeto", 1);
		objetoMenu.insertaOpcion("Registra un objeto", 2);
		objetoMenu.insertaOpcion("Identifica objeto",3);
		objetoMenu.insertaOpcion("Consulta información de constelación",4);
		objetoMenu.insertaOpcion("Salir del menú de objetos astronómicos",99);
		
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
			new BusquedaMenu().run(); //lanzamos el menú de busqueda
			break;
			
		case 2:
			omo.registraObjeto(); //operación para registrar un objeto
			break;
		
		case 3:
			omo.identificaObjeto(); //operación para identificar un objeto
			break;
			
		case 4:
			omo.infoConstelacion(); //operación para consultar los objetos visibles en una determinada constelacion
			break;
		
		default:
			break;
		
		}
	}

}
