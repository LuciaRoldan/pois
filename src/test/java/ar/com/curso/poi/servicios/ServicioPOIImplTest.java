package ar.com.curso.poi.servicios;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;

import ar.com.curso.poi.modelo.POI;

public class ServicioPOIImplTest {
	
	@Test
	public void deberiaObtenerUnObjetoNoNulo() {
		
		ServicioPOIImpl servicio = new ServicioPOIImpl();
		List<POI> resultado = servicio.obtenerPOIs("cafeterias");
		
		assertThat(resultado).isNotNull();
	}
	
	@Test
	public void deberiaObtenerUnaListaDePOISConAlMenosUnElemento(){
		
		ServicioPOIImpl servicio = new ServicioPOIImpl();
		List<POI> resultado = servicio.obtenerPOIs("cafeterias");
		
		assertEquals(resultado.get(0).getClass(), POI.class);
	}
	
	@Test
	public void deberiaObtenerLaCapaCafeteriaCon3Elementos() {
		
		ServicioPOIImpl servicio = new ServicioPOIImpl();
		List<POI> cafeterias = servicio.obtenerPOIs("cafeterias");
		
		assertEquals(cafeterias.size(), 3);
	}

}
