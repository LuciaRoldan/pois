package ar.com.curso.poi.kata.tdd;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class CerraduraTest {
	
	@Test
	public void crearCerraduraConClaveYCantidadDeFallos() {
		Cerradura c = new Cerradura(1234, 3);
		assertThat(c).isNotNull();
		assertThat(c.getCantidadDeFallos()).isEqualTo(3);
		assertThat(c.getClave()).isEqualTo(1234);
	}
	
	@Test
	public void crearOtraCerraduraConClaveYCantidadDeFallos() {
		Cerradura c = new Cerradura(1235, 5);
		assertThat(c).isNotNull();
		assertThat(c.getCantidadDeFallos()).isEqualTo(5);
		assertThat(c.getClave()).isEqualTo(1235);
	}
	
	@Test
	public void abrirConLaClaveCorrectaAbre() {
		Cerradura c = new Cerradura(1235, 5);
		assertThat(c.abrir(1235)).isTrue();
	}
	
	@Test
	public void abrirConLaClaveIncorrectaNoAbre() {
		Cerradura c = new Cerradura(1235, 5);
		assertThat(c.abrir(1234)).isFalse();
	}
	
	@Test
	public void cerrarCierra() {
		Cerradura c = new Cerradura(1235, 5);
		c.cerrar();
		assertThat(c.estaCerrada()).isTrue();
	}
	
	@Test
	public void noCerrarNoCierra() {
		Cerradura c = new Cerradura(1235, 5);
		c.abrir(1235);
		assertThat(c.estaCerrada()).isFalse();
	}
	
	@Test
	public void alCerrarNoQuedaAbierta() {
		Cerradura c = new Cerradura(1234, 2);
		c.cerrar();
		assertThat(c.estaAbierta()).isFalse();
	}
	
	@Test
	public void alAbrirQuedaAbierta() {
		Cerradura c = new Cerradura(1235, 5);
		c.abrir(1235);
		assertThat(c.estaAbierta()).isTrue();
	}
}
