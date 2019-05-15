package ar.com.curso.poi.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Respuesta {
	
	private POI poi;
	private String mensaje;
	
	public void setPoi(POI poi) {
		this.poi = poi;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public POI getPoi() {
		
		return poi;
	}
	public String getMensaje() {
		
		return mensaje;
	}
}