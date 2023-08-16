package observatorio.presentation;

import java.sql.Date;
import java.util.List;

import fundamentos.Lectura;
import fundamentos.Mensaje;
import observatorio.business.PersonaBusiness;
import observatorio.domain.Persona;

public class PersonasMenuOperations {
	
	private PersonasMenu menu;

	public PersonasMenuOperations(PersonasMenu personasMenu) {
		this.menu = personasMenu;
	}

	public void anhadePersonal() {
		//Creamos una ventana de lectura para leer los datos a insertar
		Lectura lec = new Lectura ("Proporciona los datos de la persona a insertar");
		lec.creaEntrada("id", "id");
		lec.creaEntrada("nif", "nif");
		lec.creaEntrada("nombre", "nombre");
		lec.creaEntrada("apellido1", "apellido1");
		lec.creaEntrada("apellido2", "apellido2");
		lec.creaEntrada("fecha de nacimiento", "22-05-2021");
		lec.creaEntrada("fecha de registro", "22-05-2021");
		lec.esperaYCierra();//espera a que introduzcamos el valor y pulsemos el botón
		
		//Leemos los datos de fechas como String
		String fechaNacimientoString = lec.leeString("fecha de nacimiento");
		Date fechaNacimiento;
		String fechaRegistroString = lec.leeString("fecha de registro");
		Date fechaRegistro;
		
		fechaNacimiento = Date.valueOf(fechaNacimientoString);
		fechaRegistro = Date.valueOf(fechaRegistroString);
	
		//Usamos el método de la capa de negocio para insertar al alumno. Retorna true si se insertó con éxito
		boolean success = new PersonaBusiness().anhadePersonal(lec.leeString("id"), lec.leeString("nif"), lec.leeString("nombre"),lec.leeString("apellido1"),
				lec.leeString("apellido2"), fechaNacimiento, fechaRegistro);
		
		//String para mostrar
		String txt;
		
		//Si el método de negocio retornó true, la observacion se insertó correctamente. Sino, mostramos error.
		if(success) txt = "Éxito al insertar la persona";
		else txt="Error al inserta la persona. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		//Escribimos el mensaje por pantalla
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
				
		
	}

	public void selectPersonal() {
		Lectura lec = new Lectura ("Proporciona el id de la persona");
		lec.creaEntrada("Id de la persona", 0); 
		lec.esperaYCierra(); //espera a que introduzcamos el valor y pulsemos el botón
		//Leemos el id introducido
		String persona = lec.leeString("Id de la persona");
		
		//Crea una lista de alumnos y llama al método de la capa de negocio
		List<Persona> personas = new PersonaBusiness().selectPersonal(persona);
		String txt = new String(); //String a escribir
				
		//Para cada alumno retornado lo guarda en la variable txt con un salto de línea
		for(Persona p: personas) {
			txt=txt+p.toString()+"\n";
			
		}
				
		//Escribimos por pantalla los datos de los alumnos retornados
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void actualizaPersonal() {
		Lectura lec = new Lectura ("Proporciona los datos de la persona a actualizar");
		lec.creaEntrada("id", "id");
		lec.creaEntrada("actividad", "actividad");
		lec.creaEntrada("estado", "estado");
		lec.creaEntrada("fecha de inicio", "22-05-2021");
		lec.creaEntrada("fecha de fin", "22-05-2021");
		lec.esperaYCierra();//espera a que introduzcamos el valor y pulsemos el botón
		
		//Leemos los datos de fechas como String
		String fechaInicioString = lec.leeString("fecha de inicio");
		Date fechaInicio;
		String fechaFinString = lec.leeString("fecha de fin");
		Date fechaFin;
		
		fechaInicio = Date.valueOf(fechaInicioString);
		fechaFin = Date.valueOf(fechaFinString);
	
		boolean success = new PersonaBusiness().actualizaPersonal(lec.leeString("id"), lec.leeString("actividad"), fechaInicio, fechaFin, lec.leeString("estado"));
		
		//String para mostrar
		String txt;
		
		//Si el método de negocio retornó true, la observacion se insertó correctamente. Sino, mostramos error.
		if(success) txt = "Éxito al actualizar la persona";
		else txt="Error al actualizar la persona. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		//Escribimos el mensaje por pantalla
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

	public void eliminaPersonal() {
		
		Lectura lec = new Lectura ("Proporciona los datos de la observacion a insertar");
		lec.creaEntrada("id", "id");
		lec.esperaYCierra();//espera a que introduzcamos el valor y pulsemos el botón
		
		boolean success = new PersonaBusiness().eliminaPersonal(lec.leeString("id"));
		
		//String para mostrar
		String txt;
		
		//Si el método de negocio retornó true, la observacion se insertó correctamente. Sino, mostramos error.
		if(success) txt = "Éxito al eliminar la persona";
		else txt="Error al eliminar la persona. Comprueba que los datos sean correctos y que se cumplan todas las restricciones de la tabla";
		
		//Escribimos el mensaje por pantalla
		Mensaje msg = new Mensaje();
		msg.escribe(txt);
		
	}

}
