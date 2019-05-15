package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.Capa;
import ar.com.curso.poi.modelo.POI;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

public class CalculadorDeDistanciaTest {
	
	@Test
	public void testDistanciaNula() {
		
		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI ubicacionActual = new POI(30D, 40D, "Mi casa", "Casa");
		
		Double distancia = calculadorDeDistancia.calcularDistancia(poi, ubicacionActual);
		assertThat(distancia).isEqualTo(0.0);

	}
	
	@Test
	public void testDistancia() {
		
		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI ubicacionActual = new POI(10D, 10D, "Mi casa", "Casa");
		
		Double distancia = calculadorDeDistancia.calcularDistancia(poi, ubicacionActual);
		assertThat(distancia).isEqualTo(36.055, offset(0.1));

	}
	
	@Test
	public void alPedirElPOIMascercanoSiElMapaEstaVacioDeberiaObtenerNulo() {
		
		POI oficinaRivadavia = new POI(54.38, 38.45, "oficina Rivadavia", "Sala de capacitacion");
		
		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		POI masCercano = calculadorDeDistancia.obtenerMasCercano(new Capa("mi capa"), oficinaRivadavia);
		
		assertThat(masCercano).isNull();
	}
	
	@Test
	public void deberiaObtenerElPOIMasCercano() {
		
		Capa cafeterias = new Capa("Cafeterias");
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI cafeteriaSuperCercana = new POI(10D, 10D, "Mi casa", "Casa");
		POI ubicacionActual = new POI(10D, 10D, "Mi casa", "Casa");
		cafeterias.agregar(poi);
		cafeterias.agregar(cafeteriaSuperCercana);		
		
		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		POI masCercano = calculadorDeDistancia.obtenerMasCercano(cafeterias, ubicacionActual);
		
		assertEquals(cafeteriaSuperCercana, masCercano);
	}
}
