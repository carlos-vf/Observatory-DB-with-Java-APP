package observatorio.presentation;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import fundamentos.Lectura;
import fundamentos.Mensaje;
import observatorio.business.ObservacionesBusiness;
import observatorio.domain.vistas.VistaObservacion;

public class ObservacionesMenuOperations {

	private ObservacionesMenu menu;
	
	public ObservacionesMenuOperations(ObservacionesMenu menu) {
		this.menu = menu;
	}

	public void anhadeObservacion() {
		//Creamos una ventana de lectura para leer los datos a insertar
		Lectura lec = new Lectura ("Proporciona los datos de la observacion a insertar");
		lec.creaEntrada("id", "id");
		lec.creaEntrada("persona", "persona");
		lec.creaEntrada("objeto", "objeto");
		lec.creaEntrada("equipamiento", "equipamiento");
		lec.creaEntrada("ar", 34.5);
		lec.creaEntrada("dec", 34.5);
		lec.creaEntrada("fecha de observacion", "22-05-2021");
		lec.esperaYCierra();//espera a que introduzcamos el valor y pulsemos el bot�n
		
		//Leemos los datos de fechas como String
		String fechaObservacionString = lec.leeString("fecha de observacion");
		Double arDouble = lec.leeDouble("ar");
		Double decDouble = lec.leeDouble("dec");
		Date fechaObservacion;
		BigDecimal ar;
		BigDecimal dec;
		
		fechaObservacion = Date.valueOf(fechaObservacionString);
		ar = BigDecimal.valueOf(arDouble);
		dec = BigDecimal.valueOf(decDouble);
	
		//Usamos el m�todo de la capa de negocio para insertar al alumno. Retorna true si se insert� con �xito
		boolean success = new ObservacionesBusiness().anhadeObservacion(lec.leeString("id"),lec.leeString("persona"),lec.leeString("objeto"),
				lec.leeString("equipamiento"), ar, dec, fechaObservacion);
		
		//String para mostrar
		String txt;
		
		//Si el m�todo de negocio retorn� true, la observacion se insert� correctamente. Sino, mostramos error.
		if(success) txt = "�xito al insertar la observaion";
		else txt="Error al inserta la observacion. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		//Escribimos el mensaje por pantalla
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void selectObservacion() {
		
		Lectura lec = new Lectura ("Proporciona el id de la persona");
		lec.creaEntrada("Id de la persona", 0); 
		lec.esperaYCierra(); //espera a que introduzcamos el valor y pulsemos el bot�n
		//Leemos el id introducido
		String persona = lec.leeString("Id de la persona");
		
		//Crea una lista de alumnos y llama al m�todo de la capa de negocio
		List<VistaObservacion> observaciones = new ObservacionesBusiness().selectObservaciones(persona);
		String txt = new String(); //String a escribir
				
		//Para cada alumno retornado lo guarda en la variable txt con un salto de l�nea
		for(VistaObservacion o: observaciones) {
			txt=txt+o.toString()+"\n";
			
		}
				
		//Escribimos por pantalla los datos de los alumnos retornados
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

}
