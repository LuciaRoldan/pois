package pois;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ar.com.curso.poi.modelo.POI;
import ar.com.curso.poi.servicios.ServicioPOIImpl;

public class RealidadAumentada {

	@Test
	public void existeLaCapaDeRA() {
		
		ServicioPOIImpl servicio = new ServicioPOIImpl();
		List<POI> capaRealidadAumentada = servicio.obtenerPOIs("Realidad aumentada");
		
		assertThat(capaRealidadAumentada).isNotNull();
	}
	
	@Test
	public void existenPOISDeRealidadAumentada() {
		
		ServicioPOIImpl servicio = new ServicioPOIImpl();
		List<POI> capaRealidadAumentada = servicio.obtenerPOIs("Realidad aumentada");
		
		assertThat(capaRealidadAumentada.size() > 0).isTrue();
	}
	
	@Test
	public void elPrimerPOIDeRAEsLasCuartetas() {
		
		ServicioPOIImpl servicio = new ServicioPOIImpl();
		List<POI> capaRealidadAumentada = servicio.obtenerPOIs("Realidad aumentada");
		
		assertEquals("Café de los angelitos" , capaRealidadAumentada.get(0).getNombre());
	}

}
