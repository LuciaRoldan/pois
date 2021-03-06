package ar.com.curso.poi.accept.definiciones;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class POIMasCercanoStepDef {

    private String url;
    private String urlBase;
    private String port;
    private String respuestaJson;
    private String latitud;
    private String longitud;

    public POIMasCercanoStepDef(){
        port = System.getProperty("servlet.port", "8080");
        urlBase = "http://localhost:" + port + "/pois-app";
    }

    @Dado("que estoy en (.*) y (.*)")
    public void estoy_en_una_latitud_y_longitud(String latitud, String longitud){
        this.latitud = latitud;
        this.longitud = longitud;

    }

    @Cuando("pido el POI mas cercano del servicio (.*)")
    public void pido_los_puntos_mas_cercanos(String servicio) throws Exception {
        url = urlBase +"/poiMasCercano/" + servicio + "/" + latitud + "/" + longitud;
        respuestaJson = this.obtenerContenidoRespuesta(url);
    }

    @Entonces("el servicio devuelve solo (.*)")
    public void el_servicio_devuelve_el_nombre_de_un_poi(String poiEsperado){
        assertThat(respuestaJson).contains(poiEsperado);
    }
    
    @Entonces("^el servicio devuelve el mensaje \"([^\"]*)\"$")
    public void el_servicio_devuelve_el_mensaje(String mensaje) throws Throwable {
    	assertThat(respuestaJson).contains(mensaje);
    }
    
    @Entonces("^el servicio no devuelve un POI$")
    public void el_servicio_no_devuelve_un_POI() throws Throwable {
    	assertFalse(respuestaJson.contains("<poi>"));
    }


    private String obtenerContenidoRespuesta(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        return new BufferedReader( new InputStreamReader( connection.getInputStream() ) ).readLine();
    }
}
