package ar.com.curso.poi.kata.tdd;

public class Cerradura {

	private int clave;
	private int cantidadDeFallos;
	private boolean cerrada;
	
    public Cerradura(int clave, int cantidadDeFallos) {
    	this.clave = clave;
    	this.cantidadDeFallos = cantidadDeFallos;
    };
    
    public int getClave() {
    	return this.clave;
    }
    
    public int getCantidadDeFallos() {
    	return this.cantidadDeFallos;
    }
    
    public boolean abrir(int clave) {
    	this.cerrada = false;
    	return this.clave == clave;
    }
    
    public void cerrar() {
    	this.cerrada = true;
    }
    
    public boolean estaCerrada() {
    	return this.cerrada;
    }
    
    public boolean estaAbierta() {
    	return !this.cerrada;
    }
}
