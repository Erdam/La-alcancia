package erdam.ej5.laAlcancia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import erdam.ej5.laAlcancia.mundo.Alcancia;
/**
 * Clase usada para verificar que los métodos de la clase Alcancia estén correctamente implementados.
 */
public class AlcanciaTest {
	//------- A T R I B U T O S -------//
	private Alcancia alcancia;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Crea una alcancía vacía.
     */
	private void setupEscenario1()
	{
		alcancia = new Alcancia();
		
	}
	//--------- M É T O D O S  D E  P R U E B A ----------//
	/**
	 * Prueba 1: Se encarga de verificar el método alcancía. <br>
	 * <b>Métodos a probar</b> <br>
	 * alcancía <br>
	 * estado de la alcancía <br>
	 * si la alcancía está rota <br>
	 * <b>Prueba 1:</b><br>
	 * se construye la alcancía correctamente
	 */
	@Test
	public void testInicializar()
	{
		setupEscenario1();
		assertEquals("Después de crearse la alcancía no puede estar rota.", 0, alcancia.getEstado());
        String mensaje = alcancia.darEstadoDeAlcancia();
        String mensajeEsperado = "La alcancía tenía: \n 0 moneda(s) de $50 \n " +
        		 				"0 moneda(s) de $100 \n 0 moneda(s) de $200 \n " +
        		 			    "0 moneda(s) de $500 \n 0 moneda(s) de $1000 \n" +
        		 			    " Para un total de $0 pesos.";
		assertEquals("La alcancía debería estar vacía", mensajeEsperado, mensaje);
	}
	/**
	 * Prueba 2: Se encarga de verificar el método de agregar moneda. <br> 
	 * <b> Métodos a probar</b><br>
	 * agregarMoneda50<br>
	 * agregarMoneda100<br>
	 * agregarMoneda200<br>
	 * agregarMoneda500<br>
	 * agregarMoneda1000<br>
	 * getNumeroMoneda50<br>
	 * getNumeroMoneda100<br>
	 * getNumeroMoneda200<br>
	 * getNumeroMoneda500<br>
	 * getNumeroMoneda1000<br>
	 * <b>Prueba 2:</b><br>
	 * se agregan moneda de las diferentes denominaciones
	 */
	@Test
	public void testAgregarMonedas()
	{
		setupEscenario1();
		alcancia.agregarMoneda50();
		alcancia.agregarMoneda100();
		alcancia.agregarMoneda100();
		alcancia.agregarMoneda100();
		alcancia.agregarMoneda200();
		alcancia.agregarMoneda500();
		alcancia.agregarMoneda500();
		alcancia.agregarMoneda500();
		alcancia.agregarMoneda500();
		alcancia.agregarMoneda1000();
		alcancia.agregarMoneda1000();
		assertEquals("Debería haber una moneda de $50", 1, alcancia.getNumeroMoneda50() );
		assertEquals("Debería haber tres moneda de $100", 3, alcancia.getNumeroMoneda100() );
		assertEquals("Debería haber una moneda de $200", 1, alcancia.getNumeroMoneda200() );
		assertEquals("Debería haber cuatro moneda de $500", 4, alcancia.getNumeroMoneda500() );
		assertEquals("Debería haber dos moneda de $1000", 2, alcancia.getNumeroMoneda1000() );
	}
	/**
	 * Prueba 3: Se encarga de verificar el método romper alcancía. <br> 
	 * <b> Métodos a probar</b><br> 
	 * getEstado<br>
	 * romperAlcancia<br>
	 * <b>Prueba 3:</b><br>
	 * se rompe la alcancía vacía
	 */
	
	@Test
	public void testRomperAlcancia()
	{
		setupEscenario1();
		assertEquals("La alcancía no está rot,a así que debería valer 0 ", 0, alcancia.getEstado());
		alcancia.romperAlcancia();
		assertEquals("La alcancía está rota, así que debería valer 1 ", 1, alcancia.getEstado());
		
		
	}
    /**
     * Prueba 4: Método que se encarga de verificar el método darEstadoDeAlcancia(). <br>
     * <b> Métodos a probar: </b> <br>
     * darEstadoDeAlcancia()<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Había monedas en la alcancía.
     */
	@Test
	public void testDarEstado()
	{
		setupEscenario1();
		alcancia.agregarMoneda500();
		String mensaje         = alcancia.darEstadoDeAlcancia();
		String mensajeEsperado = "La alcancía tenía: \n 0 moneda(s) de $50 \n " +
 				"0 moneda(s) de $100 \n 0 moneda(s) de $200 \n " +
 			    "1 moneda(s) de $500 \n 0 moneda(s) de $1000 \n" +
 			    " Para un total de $500 pesos.";
		
		assertEquals("La alcancía no esta vacía", mensajeEsperado, mensaje);
	}
}
