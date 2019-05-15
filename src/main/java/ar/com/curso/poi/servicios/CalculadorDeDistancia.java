package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.Capa;
import ar.com.curso.poi.modelo.POI;

public class CalculadorDeDistancia {

    public Double calcularDistancia(POI poi, POI ubicacionActual) {

        Double distancia = Math.sqrt((Math.pow((poi.getLatitud() - ubicacionActual.getLatitud()), 2)
            + Math.pow((poi.getLongitud() - ubicacionActual.getLongitud()), 2)));

        return distancia;
    }
    
    public POI obtenerMasCercano(Capa capa, POI ubicacionActual) {

    	POI masCercano = null;
    	Double distanciaMinima = 99999999.99;
    
    	for(POI poi : capa.getPOIs()) {

    		if(this.calcularDistancia(poi, ubicacionActual) < distanciaMinima) {
    		
    			masCercano = poi;
    			distanciaMinima = this.calcularDistancia(poi, ubicacionActual);
    		}
    	}
    	
    	return masCercano;
    }

}
