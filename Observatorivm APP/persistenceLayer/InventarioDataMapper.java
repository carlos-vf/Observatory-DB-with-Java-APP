package observatorio.persistenceLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import observatorio.domain.Montura;
import observatorio.domain.Oculares;
import observatorio.domain.TubosOpticos;
import observatorio.domain.ConsultaInventario;
import observatorio.domain.Equipamiento;

public class InventarioDataMapper {

	/** método de llamada al procedimiento registroMontura que añade una nueva montura al inventario
	 * @param montura objeto de tipo montura que contiene todos los atributos de la montura
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeMontura(Montura montura) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroMontura(?, ?, ?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("id", montura.getId()); //damos valor al parámetro @id del procedimiento
	    	cstmt.setBoolean("motorizada", montura.isMotorizada()); //damos valor al parámetro @motorizada del procedimiento
	    	cstmt.setString("marca", montura.getMarca()); //damos valor al parámetro @marca del procedimiento
	    	cstmt.setString("modelo", montura.getModelo()); //damos valor al parámetro @modelo del procedimiento
	    	cstmt.setString("tipoMontura", montura.getTipoMontura()); //damos valor al parámetro @tipoMontura del procedimiento
	    	cstmt.setString("estadoEquipamiento", montura.getEstadoEquipamiento()); //damos valor al parámetro @estadoEquipamiento del procedimiento
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar la Montura");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método de llamada al procedimiento registroTubo que añade una nueva montura al inventario
	 * @param montura objeto de tipo TuboOptico que contiene todos los atributos del tubo
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeTubosOpticos(TubosOpticos tubo) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroTubo(?, ?, ?, ?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("idTubo", tubo.getId()); //damos valor al parámetro @id del procedimiento
	    	cstmt.setFloat("apertura", tubo.getApertura()); //damos valor al parámetro @apertura del procedimiento
	    	cstmt.setFloat("longitudFocal", tubo.getLongitudFocal()); //damos valor al parámetro @longitudFocal del procedimiento
	    	cstmt.setString("tipoTuboOptico", tubo.getTipoTuboOptico()); //damos valor al parámetro @tipoTuboOptico del procedimiento
	    	cstmt.setString("marca", tubo.getMarca()); //damos valor al parámetro @marca del procedimiento
	    	cstmt.setString("modelo", tubo.getModelo()); //damos valor al parámetro @modelo del procedimiento	 
	    	cstmt.setString("estadoEquipamiento", tubo.getEstadoEquipamiento()); //damos valor al parámetro @estadoEquipamiento del procedimiento
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar el Tubo Óptico");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método de llamada al procedimiento registroOcular que añade un nuevo ocular al inventario
	 * @param oculares objeto de tipo Oculares que contiene todos los atributos del ocular
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeOculares(Oculares ocular) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroOcular(?, ?, ?, ?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("idOcular", ocular.getId()); //damos valor al parámetro @idOcular del procedimiento
	    	cstmt.setFloat("apertura", ocular.getApertura()); //damos valor al parámetro @apertura del procedimiento
	    	cstmt.setFloat("longitudFocal", ocular.getLongitudFocal()); //damos valor al parámetro @longitudFocal del procedimiento
	    	cstmt.setFloat("campoVision", ocular.getCampoVision()); //damos valor al parámetro @campoVision del procedimiento
	    	cstmt.setString("marca", ocular.getMarca()); //damos valor al parámetro @marca del procedimiento
	    	cstmt.setString("modelo", ocular.getModelo()); //damos valor al parámetro @modelo del procedimiento	 
	    	cstmt.setString("estadoEquipamiento", ocular.getEstadoEquipamiento()); //damos valor al parámetro @estadoEquipamiento del procedimiento
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar el Ocular");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método de llamada al procedimiento registroEquipamimento que crea un equipamiento a partir de 3 instrumentos.
	 * @param equi objeto de tipo Equipamiento que contiene todos los atributos del equipamiento
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeEquipamiento(Equipamiento equi) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroEquipamiento(?, ?, ?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("idEquip", equi.getId()); //damos valor al parámetro @idEquip del procedimiento
	    	cstmt.setString("idTubo", equi.getIdTubo()); //damos valor al parámetro @idTubo del procedimiento
	    	cstmt.setString("idOcular", equi.getIdOcular()); //damos valor al parámetro @idOcular del procedimiento
	    	cstmt.setString("idMontura", equi.getIdMontura()); //damos valor al parámetro @idMontura del procedimiento
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar el Equipamiento");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método de llamada al procedimiento registroTipoTubo que registra un nuevo tipo de Tubo Óptico
	 * @param equi objeto de tipo Equipamiento que contiene todos los atributos del equipamiento
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeTipoTubo(String id, String nombre) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroTipoTubo(?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("nombre", nombre); //damos valor al parámetro @nombre del procedimiento
	    	cstmt.setString("id", id);
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar el Tipo de Tubo");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método de llamada al procedimiento registroTipoTubo que registra un nuevo tipo de Tubo Óptico
	 * @param equi objeto de tipo Equipamiento que contiene todos los atributos del equipamiento
	 * @return true si se ha añadido correctamente y false si se ha producido algun error al añadir
	 */
	public boolean anhadeTipoMontura(String id, String nombre) {
		
	    Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.registroTipoMontura(?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("nombre", nombre); //damos valor al parámetro @nombre del procedimiento
	    	cstmt.setString("id", id);
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al registrar el Tipo de Montura");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
	
	/** método que deacataloga una montura
	 * @param montura id de la montura que se quiere descatalogar
	 * @return true si todo fue bien, false si sucedió algo incorrecto
	 */
	public boolean descatalogaMontura(String montura) {
		String deleteStmText = "DELETE FROM Montura WHERE id = '" + montura + "'"; //Construye la instrucción delete
		//Usa el método estático "executeSqlStatement" para ejecutar la instrucción
		//Si retorna true, es que la ejecución fue correcta (sin errores). Si retorna false, es que sucedió algún error.
		return SqlServerConnectionManager.executeSqlStatement(deleteStmText, "Excepción al descatalogar la Montura con id " + montura);
	}
	
	/** método que deacataloga un Tubo Óptico
	 * @param tubo id de la montura que se quiere descatalogar
	 * @return true si todo fue bien, false si sucedió algo incorrecto
	 */
	public boolean descatalogaTubo(String tubo) {
		String deleteStmText = "DELETE FROM TubosOpticos WHERE id = '" + tubo + "'"; //Construye la instrucción delete
		//Usa el método estático "executeSqlStatement" para ejecutar la instrucción
		//Si retorna true, es que la ejecución fue correcta (sin errores). Si retorna false, es que sucedió algún error.
		return SqlServerConnectionManager.executeSqlStatement(deleteStmText, "Excepción al descatalogar el Tubo Óptico con id " + tubo+"");
	}
	
	/** método que deacataloga un Ocular
	 * @param ocular id de la montura que se quiere descatalogar
	 * @return true si todo fue bien, false si sucedió algo incorrecto
	 */
	public boolean descatalogaOcular(String ocular) {
		String deleteStmText = "DELETE FROM Oculares WHERE id = '" + ocular + "'"; //Construye la instrucción delete
		//Usa el método estático "executeSqlStatement" para ejecutar la instrucción
		//Si retorna true, es que la ejecución fue correcta (sin errores). Si retorna false, es que sucedió algún error.
		return SqlServerConnectionManager.executeSqlStatement(deleteStmText, "Excepción al descatalogar el Ocular con id " + ocular);
	}
	

	/** metodo que anhade un estado al equipamiento
	 * @param idEquip id del equipo
	 * @param nombre nuevo estado del equipo
	 * @return true si se ha actualizado el nuevo estado con exito, false si se ha producido algun error
	 */
	public boolean anhadeEstadoEquipamimento(String id, String nombre) {
		
		Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.procEstadoEquipamiento(?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("id", id); //damos valor al parámetro @id del procedimiento
	    	cstmt.setString("nombre", nombre); //damos valor al parámetro @nombre del procedimiento
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al añadir el estado");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}

	
	/**
	 * Metodo privado de apoyo. Recibe un ResultSet de un objeto resultado de una busqueda
	 * y devuelve un objeto ConsultaInventario con los datos del ResultSet
	 * @param results
	 * @return
	 */
	private ConsultaInventario processConsultaInventario(ResultSet results) {

		ConsultaInventario result = null;
		try {
			String nombreTubo = results.getString("NombreTubo");
			String idTubo = results.getString("idTubo");
			String estadoTubo = results.getString("estadoTubo");
			
			String nombreMontura = results.getString("nombreMontura");
			String idMontura = results.getString("idMontura");
			String estadoMontura = results.getString("estadoOcular");
			
			String nombreOcular = results.getString("NombreOcular");
			String idOcular = results.getString("idOcular");
			String estadoOcular = results.getString("estadoOcular");

			result = new ConsultaInventario(nombreTubo, idTubo, estadoTubo, nombreMontura, idMontura, 
					estadoMontura, nombreOcular, idOcular, estadoOcular);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
	/**
	 * Consulta de todos los objetos del inventario
	 * @return una lista con los objetos encontrados
	 */
	public List<ConsultaInventario> consultaInventario () {

		List<ConsultaInventario> result = new LinkedList<ConsultaInventario>();
		Connection con = SqlServerConnectionManager.getConnection();
		try {
			Statement selectStm = con.createStatement();
			String selectStmText = "SELECT * FROM dbo.consultaEquipamiento()";
			ResultSet results = selectStm.executeQuery(selectStmText);
			while(results.next()) {
				result.add(this.processConsultaInventario(results));
			}
			selectStm.close();
		} catch (SQLException e) {
			System.out.println("Excepcion al consultar el inventario");
			e.printStackTrace();
		}
		return result;
	}
	
	
	/** metodo que actualiza el estado de un equipo
	 * @param idEquip id del equipo
	 * @param nombre nuevo estado del equipo
	 * @return true si se ha actualizado el nuevo estado con exito, false si se ha producido algun error
	 */
	public boolean actualizaEstadoEquipamimento(String idEquip, String nombre) {
		
		Connection con = SqlServerConnectionManager.getConnection(); //creamos una nueva conexión con la BD
	    
	    try {
	    	CallableStatement cstmt = null; //se crea un Callable Statement para ejecutar el procedimiento
	    	
	    	//prepara el String con la llamada al método, usando call
	    	cstmt = con.prepareCall(
	                "{call dbo.procCambiaEstado(?, ?)}"); //tantas ? como parámetros de entrada y/o salida tiene el procedimiento
	    	cstmt.setString("idEquipamiento", idEquip); //damos valor al parámetro @idEquipamiento del procedimiento
	    	cstmt.setString("nombreEstado", nombre); //damos valor al parámetro @nombreEstado del procedimiento
	    	cstmt.execute(); //ejecutamos el procedimiento
	        return true;
		} catch (SQLException e) {
			System.out.println("Error al cambiar el estado del equipamiento");
			e.printStackTrace();
			return false; //si se produce cualquier tipo de excepción SQL, retornamos directamente false
		}
	}
	
}
