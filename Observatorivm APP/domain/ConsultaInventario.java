package observatorio.domain;

public class ConsultaInventario {
	
	private String nombreTubo;
	private String idTubo;
	private String estadoTubo;
	
	private String nombreMontura;
	private String idMontura;
	private String estadoMontura;
	
	private String nombreOcular;
	private String idOculat;
	private String estadoOcular;
	
	// Constructor
	public ConsultaInventario(String nombreTubo, String idTubo, String estadoTubo, String nombreMontura,
			String idMontura, String estadoMontura, String nombreOcular, String idOculat, String estadoOcular) {
		super();
		this.setNombreTubo(nombreTubo);
		this.setIdTubo(idTubo);
		this.setEstadoTubo(estadoTubo);
		this.setNombreMontura(nombreMontura);
		this.setIdMontura(idMontura);
		this.setEstadoMontura(estadoMontura);
		this.setNombreOcular(nombreOcular);
		this.setIdOculat(idOculat);
		this.setEstadoOcular(estadoOcular);
	}

	public String getNombreTubo() {
		return nombreTubo;
	}

	public void setNombreTubo(String nombreTubo) {
		this.nombreTubo = nombreTubo;
	}

	public String getIdTubo() {
		return idTubo;
	}

	public void setIdTubo(String idTubo) {
		this.idTubo = idTubo;
	}

	public String getEstadoTubo() {
		return estadoTubo;
	}

	public void setEstadoTubo(String estadoTubo) {
		this.estadoTubo = estadoTubo;
	}

	public String getNombreMontura() {
		return nombreMontura;
	}

	public void setNombreMontura(String nombreMontura) {
		this.nombreMontura = nombreMontura;
	}

	public String getIdMontura() {
		return idMontura;
	}

	public void setIdMontura(String idMontura) {
		this.idMontura = idMontura;
	}

	public String getEstadoMontura() {
		return estadoMontura;
	}

	public void setEstadoMontura(String estadoMontura) {
		this.estadoMontura = estadoMontura;
	}

	public String getNombreOcular() {
		return nombreOcular;
	}

	public void setNombreOcular(String nombreOcular) {
		this.nombreOcular = nombreOcular;
	}

	public String getIdOculat() {
		return idOculat;
	}

	public void setIdOculat(String idOculat) {
		this.idOculat = idOculat;
	}

	public String getEstadoOcular() {
		return estadoOcular;
	}

	public void setEstadoOcular(String estadoOcular) {
		this.estadoOcular = estadoOcular;
	}
	
	
}
