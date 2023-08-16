package observatorio.presentation;

import fundamentos.Menu;

public class InventarioMenu {

	InventarioMenuOperations imo = new InventarioMenuOperations(this); //objeto de la clase que contiene las operaciones para manejar las acciones seleccionadas en el menu
	
	/**
	 * M�todo run al que se llama desde el exterior para lanzar el men�
	 */
	public void run() {
		
		int option;
		//Creamos un men� e insertamos las opciones
		Menu inventarioMenu = new Menu("Men� de gesti�n del inventario");
		
		inventarioMenu.insertaOpcion("Consulta inventario", 1);
		
		inventarioMenu.insertaOpcion("A�ade equipamiento", 2);
		inventarioMenu.insertaOpcion("Actualiza estado del equipamiento", 3);
		
		inventarioMenu.insertaOpcion("A�ade montura", 4);
		inventarioMenu.insertaOpcion("A�ade tipo de montura", 5);
		inventarioMenu.insertaOpcion("Elimina montura", 6);
		
		inventarioMenu.insertaOpcion("A�ade tubo �ptico", 7);
		inventarioMenu.insertaOpcion("A�ade tipo de tubo �ptico", 8);
		inventarioMenu.insertaOpcion("Elimina tubo �ptico", 9);
		
		inventarioMenu.insertaOpcion("A�ade oculares", 10);
		inventarioMenu.insertaOpcion("Elimina oculares", 11);
		
		inventarioMenu.insertaOpcion("Salir del men� de personas",99);
		
		//Mientras no se seleccione la opci�n de salir del men�, se contin�a en el men�
		do {
			option = inventarioMenu.leeOpcion(); //se lee la opci�n seleccionada del men�
			this.optionAction(option); //llamamos al m�todo para ejecutar la opci�n seleccionada
		}while(option!=99);
		
		//Al salir del bucle se cierra el men�
		inventarioMenu.cierra();
		
	}
	
	/**
	 * M�todo que maneja con un switch la opci�n seleccionada en el men�
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
