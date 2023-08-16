package observatorio.presentation;

import java.util.List;

import observatorio.business.ObjetoBusiness;
import observatorio.domain.Objeto;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Clase que contiene las operaciones a realizar cuando se selecciona una opción
 * en el menú de objetos
 * @author Grupo 3
 * @lastmodified 
 *
 */
public class ObjetosMenuOperations {

	private ObjetoMenu om; //menu al que referencia

	/**
	 * Constructor. Se le pasa el menú.
	 * @param menu
	 */
	public ObjetosMenuOperations(ObjetoMenu menu) {
		this.om = menu;
	}

	/**
	 * Método para introducir un nuevo objeto astronómico.
	 */
	public void registraObjeto() {

		Lectura lec = new Lectura ("Proporciona los datos del alumno a insertar");
		lec.creaEntrada("Id del objeto", "id");
		lec.creaEntrada("Nombre", "nombre");
		lec.creaEntrada("Coordenada AR", "AR (grados)");
		lec.creaEntrada("Coordenada DEC", "DEC (grados)");
		lec.creaEntrada("Tipo de objeto", "tipo");
		lec.creaEntrada("Constelacion", "constelacion");
		lec.creaEntrada("Descripcion", "descripcion");
		lec.creaEntrada("Tamanho", "tamanho (minutos de arco)");
		lec.creaEntrada("Magnitud", "magnitud");

		lec.esperaYCierra();

		try {

			boolean success = new ObjetoBusiness().newObjeto(lec.leeString("Id del objeto"), lec.leeDouble("Coordenada AR"),
					lec.leeDouble("Coordenada DEC"), lec.leeString("Descripcion"), lec.leeString("Tipo de objeto"), lec.leeString("Constelacion"),
					lec.leeString("Nombre"), lec.leeDouble("Tamanho"), lec.leeDouble("Magnitud"));

			String txt;

			if(success) txt = "Éxito al insertar al objeto";
			else txt="Error al inserta al objeto. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";

			Mensaje msg = new Mensaje();
			msg.escribe(txt);

		} catch(IllegalArgumentException e) {
			Mensaje msg = new Mensaje();
			msg.escribe("Error al insertar al objeto. Comprueba que los datos están en el formato adecuado");
			e.printStackTrace();
		}

	}

	/**
	 * Método para identificar objetos cercanos a unas coordenadas.
	 */
	public void identificaObjeto() {

		Lectura lec = new Lectura ("Proporciona las coordenadas del objeto a identificar.");
		lec.creaEntrada("Coordenada AR", "AR (grados)");
		lec.creaEntrada("Coordenada DEC", "DEC (grados)");
		lec.esperaYCierra();

		String objetosEncontrados = new ObjetoBusiness().identificaObjeto(lec.leeString("Coordenada AR"), lec.leeString("Coordenada DEC"));
		
		Mensaje msg = new Mensaje();
		msg.escribe(objetosEncontrados);

	}

	/**
	 * Método para consultar los objetos visibles en una constelacion.
	 */
	public void infoConstelacion() {
		Lectura lec = new Lectura ("Proporciona el id de la constelacion sobre la que quieres realizar la consulta.");
		lec.creaEntrada("ID de la constelacion", "id");
		lec.esperaYCierra();

		List<Objeto> objetosEncontrados = new ObjetoBusiness().infoConstelacion(lec.leeString("ID de la constelacion"));
		String txt = new String();

		for(Objeto o: objetosEncontrados) {
			txt=txt+o.toString()+"\n";
		}

		Mensaje msg = new Mensaje();
		msg.escribe(txt);
	}
}
