package observatorio.presentation;

import java.util.List;

import observatorio.business.BusquedaBusiness;
import observatorio.domain.ObjetoBusqueda;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Clase que contiene las operaciones a realizar cuando se selecciona una opción
 * en el menú de objetos
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class BusquedaMenuOperations {

	private BusquedaMenu bm; //menu al que referencia

	/**
	 * Constructor. Se le pasa el menú.
	 * @param menu
	 */
	public BusquedaMenuOperations(BusquedaMenu menu) {
		
		this.bm = menu;
	}

	public void buscaPorTipo() {

		Lectura lec = new Lectura ("Proporciona el tipo de los objetos a buscar");
		lec.creaEntrada("Tipo", "tipo");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorTipo(lec.leeString("Tipo"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}

	public void buscaPorNombre() {

		Lectura lec = new Lectura ("Proporciona el nombre del/los objeto(s) a buscar");
		lec.creaEntrada("Nombre", "nombre");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorNombre(lec.leeString("Nombre"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}

	public void buscaPorMagnitud() {

		Lectura lec = new Lectura ("Proporciona la magnitud de los objetos a buscar");
		lec.creaEntrada("Magnitud", "magnitud");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorMagnitud(lec.leeString("Magnitud"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}

	public void buscaPorDescubridor() {

		Lectura lec = new Lectura ("Proporciona el descubridor de los objetos a buscar");
		lec.creaEntrada("Descubridor", "descubridor");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorDescubridor(lec.leeString("Descubridor"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}

	public void buscaPorEquipamiento() {
		
		Lectura lec = new Lectura ("Proporciona el id del equipamiento utilizado en el descubrimiento de los objetos a buscar");
		lec.creaEntrada("Equipamiento", "equipamiento");
		lec.esperaYCierra();

		List<ObjetoBusqueda> objetosEncontrados = new BusquedaBusiness().buscaObjetosPorEquipamiento(lec.leeString("Equipamiento"));
		String txt = new String();
		
		for(ObjetoBusqueda o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}

	/*
	 * Metodo que transforma el resultado de un select en una lista de objetos de tipo objeto
	 * @param results resultado del select
	 * @return lista de objetos de tipo persona
	 *
	private List<ObjetoBusqueda> resultSetObjetoBusqueda(ResultSet results) {
		List<ObjetoBusqueda> objetos = new LinkedList<ObjetoBusqueda>();

		String nombre = null;
		String constelacion = null;
		String descripcion = null;
		double tamanho = (Double) null;
		double magnitud = (Double) null;
		String id = null;
		double ar = (Double) null;
		double dec = (Double) null;
		String tipoObjeto = null;
		String descubridor = null;
		String montura = null;
		String ocular = null;
		String tubo = null;

		try {
			//Recorremos las filas retornadas en el resultset
			while (results.next()) { //Cuando retorne false significa que no hay m�s elementos
				nombre = results.getString("NombreObjeto");
				constelacion = results.getString("NombreObjeto");
				//Construimos un nuevo objeto de la Clase Persona y lo a�adimos a la lista
				Persona pers = new Persona(id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro);
				pers.anhadeEstado(estado, fechaInicio, fechaFin);
				personas.add(pers);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} // try

		return personas;
	}
	*/

}
