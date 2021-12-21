package erdam.ej5.laAlcancia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import erdam.ej5.laAlcancia.mundo.Alcancia;
/**
 * Clase usada para verificar que los m�todos de la clase Alcancia est�n correctamente implementados.
 */
public class AlcanciaTest {
	//------- A T R I B U T O S -------//
	private Alcancia alcancia;
	//--------- E S C E N A R I O S ----------//
    /**
     * Escenario 1: Crea una alcanc�a vac�a.
     */
	private void setupEscenario1()
	{
		alcancia = new Alcancia();
		
	}
	//--------- M � T O D O S  D E  P R U E B A ----------//
	/**
	 * Prueba 1: Se encarga de verificar el m�todo alcanc�a. <br>
	 * <b>M�todos a probar</b> <br>
	 * alcanc�a <br>
	 * estado de la alcanc�a <br>
	 * si la alcanc�a est� rota <br>
	 * <b>Prueba 1:</b><br>
	 * se construye la alcanc�a correctamente
	 */
	@Test
	public void testInicializar()
	{
		setupEscenario1();
		assertEquals("Despu�s de crearse la alcanc�a no puede estar rota.", 0, alcancia.getEstado());
        String mensaje = alcancia.darEstadoDeAlcancia();
        String mensajeEsperado = "La alcanc�a ten�a: \n 0 moneda(s) de $50 \n " +
        		 				"0 moneda(s) de $100 \n 0 moneda(s) de $200 \n " +
        		 			    "0 moneda(s) de $500 \n 0 moneda(s) de $1000 \n" +
        		 			    " Para un total de $0 pesos.";
		assertEquals("La alcanc�a deber�a estar vac�a", mensajeEsperado, mensaje);
	}
	/**
	 * Prueba 2: Se encarga de verificar el m�todo de agregar moneda. <br> 
	 * <b> M�todos a probar</b><br>
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
		assertEquals("Deber�a haber una moneda de $50", 1, alcancia.getNumeroMoneda50() );
		assertEquals("Deber�a haber tres moneda de $100", 3, alcancia.getNumeroMoneda100() );
		assertEquals("Deber�a haber una moneda de $200", 1, alcancia.getNumeroMoneda200() );
		assertEquals("Deber�a haber cuatro moneda de $500", 4, alcancia.getNumeroMoneda500() );
		assertEquals("Deber�a haber dos moneda de $1000", 2, alcancia.getNumeroMoneda1000() );
	}
	/**
	 * Prueba 3: Se encarga de verificar el m�todo romper alcanc�a. <br> 
	 * <b> M�todos a probar</b><br> 
	 * getEstado<br>
	 * romperAlcancia<br>
	 * <b>Prueba 3:</b><br>
	 * se rompe la alcanc�a vac�a
	 */
	
	@Test
	public void testRomperAlcancia()
	{
		setupEscenario1();
		assertEquals("La alcanc�a no est� rot,a as� que deber�a valer 0 ", 0, alcancia.getEstado());
		alcancia.romperAlcancia();
		assertEquals("La alcanc�a est� rota, as� que deber�a valer 1 ", 1, alcancia.getEstado());
		
		
	}
    /**
     * Prueba 4: M�todo que se encarga de verificar el m�todo darEstadoDeAlcancia(). <br>
     * <b> M�todos a probar: </b> <br>
     * darEstadoDeAlcancia()<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hab�a monedas en la alcanc�a.
     */
	@Test
	public void testDarEstado()
	{
		setupEscenario1();
		alcancia.agregarMoneda500();
		String mensaje         = alcancia.darEstadoDeAlcancia();
		String mensajeEsperado = "La alcanc�a ten�a: \n 0 moneda(s) de $50 \n " +
 				"0 moneda(s) de $100 \n 0 moneda(s) de $200 \n " +
 			    "1 moneda(s) de $500 \n 0 moneda(s) de $1000 \n" +
 			    " Para un total de $500 pesos.";
		
		assertEquals("La alcanc�a no esta vac�a", mensajeEsperado, mensaje);
	}
}
