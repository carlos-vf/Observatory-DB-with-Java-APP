package observatorio.persistenceLayer;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import observatorio.domain.Observacion;
import observatorio.domain.vistas.VistaObservacion;
import observatorio.persistenceLayer.SqlServerConnectionManager;

public class ObservacionesDataMapper {

	/** método que da la visualizacion de la observacion
	 * @param persona persona de la que se quieren ver las observaciones o null en caso de que se quieran ver
	 * todas las observaciones que se encuentran en el log
	 * @return lista de observaciones que se querían ver
	 */
	public List<VistaObservacion> selectObservaciones(String persona) {
		Connection con = SqlServerConnectionManager.getConnection(); //Creamos una nueva conexión con la BD
		List<VistaObservacion> observaciones = null; //Inicializamos la variable a retornar
		try {
			Statement selectStm = con.createStatement(); //Creamos un nuevo statement
			String selectStmText;
			if (persona != null) {
				selectStmText = "SELECT * FROM vistaLogObservacion v INNER JOIN Persona p ON v.id = p.id WHERE p.id = " + persona + ""; //Construimos el SELECT
			} else {
				selectStmText = "SELECT * FROM vistaLogObservacion"; //Construimos el SELECT
			}
			ResultSet results = selectStm.executeQuery(selectStmText); //Le proporcionamos como parámetro al statement el SELECT y lo ejecutamos
			observaciones = resultSetObservaciones(results); //Utilizamos el método auxiliar para guardar a los alumnos retornados en una lista
			selectStm.close(); //Cerramos el statement
		} catch (SQLException e) {
			System.out.println("Excepcion al recoger las observaciones pedidas");
			e.printStackTrace();
		}
		return observaciones;
	}
	
	
	/** método que transforma un resultado de un select en una lista de objetos de tipo vista observacion
	 * @param results resultado del select
	 * @return lista de objetos de tipo vista observacion
	 */
	private List<VistaObservacion> resultSetObservaciones(ResultSet results) {
		List<VistaObservacion> observaciones = new LinkedList<VistaObservacion>(); //Lista de observaciones a retornar
		
		//Variables del método para almacenar los datos de cada observacion
		String nif = null;
		String objeto = null;
		String equipamiento = null;
		BigDecimal ar = null;
		BigDecimal dec = null;
		Date fechaObservacion = null;
		
		try {
			//Recorremos las filas retornadas en el resultset
			while (results.next()) { //Cuando retorne false significa que no hay más elementos
				nif = results.getString("p.nif"); //Sacamos el nif de la persona. Como es String, usarmo el método getString.
				objeto = results.getString("o.nombre"); //Sacamos el nombre del objeto. Para datos varchar o char usamos el método getString.
				equipamiento = results.getString("l.equipamiento"); //Sacamos el id del equipamiento usado
				ar = results.getBigDecimal("l.ar"); //Sacamos las coordenadas de la observación, se usa getBigDecimal
				dec = results.getBigDecimal("l.dec"); 
				fechaObservacion = results.getDate("l.fechaObservacion"); //Sacamos la fecha de observacion, como es datetime se usa getDate.
				//Construimos un nuevo objeto de la Clase VistaObservaciones y lo añadimos a la lista
				observaciones.add(new VistaObservacion(nif, objeto, equipamiento, ar, dec, fechaObservacion));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} // try
		
		return observaciones;
	}


	/** método de llamada al procedimiento procLogObservacion que introduce una nueva observacion al log
	 * @param obs objeto de tipo observacion donde se encuentran todos los atributos de la observacion
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeObservacion(Observacion obs) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.procLogObservacion(?, ?, ?, ?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("id", obs.id()); //damos valor al parámetro @id del procedimiento
	    	cstmt.setString("persona", obs.persona()); //damos valor al parámetro @persona del procedimiento
	    	cstmt.setString("objeto", obs.objeto()); //damos valor al parámetro @objeto del procedimiento
	    	cstmt.setString("equipamiento", obs.equipamiento()); //damos valor al parámetro @equipamiento del procedimiento
	    	cstmt.setBigDecimal("ar", obs.ar()); //damos valor al parámetro @ar del procedimiento
	    	cstmt.setBigDecimal("dec", obs.dec()); //damos valor al parámetro @dec del procedimiento
	    	cstmt.setDate("fechaObservacion", obs.fechaObservacion()); //damos valor al parámetro @fechaObservacion del procedimiento
	        cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrat la observacion");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
}
