package observatorio.persistenceLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import observatorio.domain.Persona;

public class PersonasDataMapper {

	
	/** metodo que actualiza el periodo de actividad de una persona
	 * @param idPersona id de la persona que cambia de estado
	 * @param actividad id de la actividad
	 * @param fechaInicio fecha de inicio del estado
	 * @param fechaFin fecha de fin del estado de actividad
	 * @param estadoPersona estado de actividad que se quiere añadir a la persona
	 * @return true si se ha actualizado el nuevo estado con exito, false si se ha producido algun error
	 */
	public boolean actualizaPersonal(String idPersona, String actividad, Date fechaInicio, Date fechaFin, String estadoPersona) {
		
		Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.cambioEstadoPersona(?, ?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("idPersona", idPersona); //damos valor al parámetro @idPersona del procedimiento
	    	cstmt.setString("actividad", actividad); //damos valor al parámetro @actividad del procedimiento
	    	cstmt.setString("estadoPersona", estadoPersona); //damos valor al parámetro @estadoPersona del procedimiento
	    	cstmt.setDate("fechaInicio", fechaInicio); //damos valor al parámetro @fechaInicio del procedimiento
	    	cstmt.setDate("fechaFin", fechaFin);
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrat la observacion");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
		
	}
	
	
	/** método que muestra los datos de estado de todas o una persona concreta
	 * @param persona id de la persona de la que se quiere saber el estado o null si se quieren saber de todas
	 * @return lista de los datos de la persona con sus estados correspondientes
	 */
	public List<Persona> selectPersonal(String persona) {
		Connection con = SqlServerConnectionManager.getConnection(); //Creamos una nueva conexión con la BD
		List<Persona> personas = null; //Inicializamos la variable a retornar
		try {
			Statement selectStm = con.createStatement(); //Creamos un nuevo statement
			String selectStmText;
			if (persona != null) {
				selectStmText = "SELECT * FROM dbo.consultaEstadoPersona ("+ persona +")"; //Construimos el SELECT
			} else {
				selectStmText = "SELECT * FROM dbo.consultaEstadoPersona ()"; //Construimos el SELECT
			}
			ResultSet results = selectStm.executeQuery(selectStmText); //Le proporcionamos como parámetro al statement el SELECT y lo ejecutamos
			personas = this.resultSetPersona(results); //Utilizamos el método auxiliar para guardar a los alumnos retornados en una lista
			selectStm.close(); //Cerramos el statement
		} catch (SQLException e) {
			System.out.println("Excepcion al recoger las observaciones pedidas");
			e.printStackTrace();
		}
		return personas;
	}
	
	
	/** método que transforma el resultado de un select en una lista de objetos de tipo persona
	 * @param results resultado del select
	 * @return lista de objetos de tipo persona
	 */
	private List<Persona> resultSetPersona(ResultSet results) {
		List<Persona> personas = new LinkedList<Persona>();
		
		String id = null;
		String nif = null;
		String nombre = null;
		String apellido1 = null;
		String apellido2 = null;
		String estado = null;
		Date fechaNacimiento = null;
		Date fechaRegistro = null;
		Date fechaInicio = null;
		Date fechaFin = null;
		
		try {
			//Recorremos las filas retornadas en el resultset
			while (results.next()) { //Cuando retorne false significa que no hay más elementos
				nif = results.getString("p.nif"); 
				nombre = results.getString("p.nombre"); 
				apellido1 = results.getString("p.apellido1"); 
				apellido2 = results.getString("p.apellido2");
				estado = results.getString("e.estado");
				fechaNacimiento = results.getDate("p.fechaNacimiento");
				fechaRegistro = results.getDate("p.fechaRegistro");
				fechaInicio = results.getDate("e.fechaInicio");
				fechaFin = results.getDate("e.fechaFin");
				//Construimos un nuevo objeto de la Clase Persona y lo añadimos a la lista
				Persona pers = new Persona(id, nif, nombre, apellido1, apellido2, fechaNacimiento, fechaRegistro);
				pers.anhadeEstado(estado, fechaInicio, fechaFin);
				personas.add(pers);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} // try
		
		return personas;
	}


	/** método de llamada al procedimiento registroPersonal que introduce una nueva persona a la base de datos
	 * @param pers objeto de tipo persona que contiene todos los atributos de la persona
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadePersonal(Persona pers) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroPersonal(?, ?, ?, ?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("id", pers.id()); //damos valor al parámetro @id del procedimiento
	    	cstmt.setString("nif", pers.nif()); //damos valor al parámetro @nif del procedimiento
	    	cstmt.setString("nombre", pers.nombre()); //damos valor al parámetro @nombre del procedimiento
	    	cstmt.setString("apellido1", pers.apellido1()); //damos valor al parámetro @apellido1 del procedimiento
	    	cstmt.setString("apellido2", pers.apellido2());
	    	cstmt.setDate("fechaNacimiento", pers.fechaNacimiento()); //damos valor al parámetro @fechaNacimiento del procedimiento
	    	cstmt.setDate("fechaRegistro", pers.fechaRegistro());
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrat la observacion");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método que elimina una persona de la base de datos
	 * @param pers id de lapersona que se quiere eliminar
	 * @return true si todo fue bien, false si sucedió algo incorrecto
	 */
	public boolean eliminaPersonal(String pers) {
		String deleteStmText = "DELETE FROM Persona WHERE id = " + pers + ""; //Construye la instrucción delete
		//Usa el método estático "executeSqlStatement" para ejecutar la instrucción
		//Si retorna true, es que la ejecución fue correcta (sin errores). Si retorna false, es que sucedió algún error.
		return SqlServerConnectionManager.executeSqlStatement(deleteStmText, "Excepción al borrar a la persona con id " + pers);
	}
}
