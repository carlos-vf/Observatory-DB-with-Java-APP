package observatorio.presentation;

import fundamentos.Menu;

public class InventarioMenu {

	InventarioMenuOperations imo = new InventarioMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * Método run al que se llama desde el exterior para lanzar el menú
	 */
	public void run() {
		
		int option;
		//Creamos un menú e insertamos las opciones
		Menu inventarioMenu = new Menu("Menú de gestión del inventario");
		
		inventarioMenu.insertaOpcion("Consulta inventario", 1);
		
		inventarioMenu.insertaOpcion("Añade equipamiento", 2);
		inventarioMenu.insertaOpcion("Actualiza estado del equipamiento", 3);
		
		inventarioMenu.insertaOpcion("Añade montura", 4);
		inventarioMenu.insertaOpcion("Añade tipo de montura", 5);
		inventarioMenu.insertaOpcion("Elimina montura", 6);
		
		inventarioMenu.insertaOpcion("Añade tubo óptico", 7);
		inventarioMenu.insertaOpcion("Añade tipo de tubo óptico", 8);
		inventarioMenu.insertaOpcion("Elimina tubo óptico", 9);
		
		inventarioMenu.insertaOpcion("Añade oculares", 10);
		inventarioMenu.insertaOpcion("Elimina oculares", 11);
		
		inventarioMenu.insertaOpcion("Salir del menú de personas",99);
		
		//Mientras no se seleccione la opción de salir del menú, se continúa en el menú
		do {
			option = inventarioMenu.leeOpcion(); //se lee la opción seleccionada del menú
			this.optionAction(option); //llamamos al método para ejecutar la opción seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el menú
		inventarioMenu.cierra();
		
	}
	
	/**
	 * Método que maneja con un switch la opción seleccionada en el menú
	 * @param option
	 */
	private void optionAction(int option) {
		switch(option) {
		case 1:
			imo.consultaInventario();
			break;
			
		case 2:
			imo.anhadeEquipamiento();
			break;
		
		case 3:
			imo.actualizaEstadoEquipamiento();
			break;
		
		case 4:
			imo.anhadeMontura();
			break;
			
		case 5:
			imo.anhadeTipoMontura();
			break;

		case 6:
			imo.descatalogaMontura();
			break;
			
		case 7:
			imo.anhadeTubosOpticos();
			break;
			
		case 8:
			imo.anhadeTipoTubo();
			break;
			
		case 9:
			imo.descatalogaTubo();
			break;
			
		case 10:
			imo.anhadeOculares();
			break;
			
		case 11:
			imo.descatalogaOcular();
			break;

		default:
			break;
			
		
		}
	}
	
}
