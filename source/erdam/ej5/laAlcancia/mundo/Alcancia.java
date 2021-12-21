package erdam.ej5.laAlcancia.mundo;
/**
 * Clase que representa una alcanc�a.
 */
public class Alcancia {
	//------- A T R I B U T O S -------//
    /**
     * N�mero de monedas de $50 que hay en la alcanc�a.
     */
	private int numeroMoneda50;
    /**
     * N�mero de monedas de $10 que hay en la alcanc�a.
     */
	private int numeroMoneda100;
    /**
     * N�mero de monedas de $200 que hay en la alcanc�a.
     */
	private int numeroMoneda200;
    /**
     * N�mero de monedas de $500 que hay en la alcanc�a.
     */
	private int numeroMoneda500;
    /**
     * N�mero de monedas de $1000 que hay en la alcanc�a.
     */
	private int numeroMoneda1000;
    /**
     * Estado de la alcanc�a. <br>
     * 0 indica que no est� rota. <br>
     * 1 indica que est� rota.
     */
	private boolean estado;
	//----- C O N S T R U C T O R  -----//
    /**
     * Construye la alcanc�a. <br>
     * <b>post: </b> El n�mero de monedas de 50, n�mero de monedas de 100, n�mero de monedas de 200, n�mero de monedas de 500, n�mero de monedas de 1000 y el estado fueron
     * incializados en 0.
     */
	public Alcancia()
	{
		actualizar();
		estado             	= true;
		
	}
	//--------- M � T O D O S ----------//
    /**
     * Retorna el n�mero de monedas de $50 que hay en la alcanc�a.
     * @return N�mero de monedas de $50 en la alcanc�a.
     */
	public int getNumeroMoneda50() {
		return numeroMoneda50;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el n�mero de monedas de $100 que hay en la alcanc�a.
     * @return N�mero de monedas de $100 en la alcanc�a.
     */
	public int getNumeroMoneda100() {
		return numeroMoneda100;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el n�mero de monedas de $200 que hay en la alcanc�a.
     * @return N�mero de monedas de $200 en la alcanc�a.
     */
	public int getNumeroMoneda200() {
		return numeroMoneda200;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el n�mero de monedas de $500 que hay en la alcanc�a.
     * @return N�mero de monedas de $500 en la alcanc�a.
     */
	public int getNumeroMoneda500() {
		return numeroMoneda500;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el n�mero de monedas de $1000 que hay en la alcanc�a.
     * @return N�mero de monedas de $1000 en la alcanc�a.
     */
	public int getNumeroMoneda1000() {
		return numeroMoneda1000;
	}
	 //---------------------------------------------------//
    /**
     * Informa si la alcanc�a est� rota o no.
     * @return Retorna 1 si est� rota, 0 en caso contrario.
     */
	public boolean getEstado() {
		return estado;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el total de dinero que hay en la alcanc�a.
     * @return Total de dinero que hay en la alcanc�a.
     */
	public int calcularTotalDinero()
	{
		int total = (numeroMoneda50 * 50) +( numeroMoneda100 * 100) +
					(numeroMoneda200 * 200) + (numeroMoneda500 * 500) +
					(numeroMoneda1000 * 1000);
		return total;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el estado de la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota.<br>
     * @return Cadena que informa la cantidad de monedas que hab�a en la alcanc�a y la cantidad total de dinero.
     */
	public String darEstadoDeAlcancia()
	{
		int totalDeDinero = calcularTotalDinero();
		return "La alcanc�a ten�a: \n " + numeroMoneda50 + 
				" moneda(s) de $50 \n " + numeroMoneda100 +
				" moneda(s) de $100 \n " + numeroMoneda200 + 
				" moneda(s) de $200 \n " + numeroMoneda500 +
				" moneda(s) de $500 \n " + numeroMoneda1000 + 
				" moneda(s) de $1000 \n " + "Para un total de $" +
				totalDeDinero + " pesos.";
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $50 a la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota. <br>
     * <b>post: </b>Aument� en uno la cantidad de monedas de $50 en la alcanc�a.
     */
	public void agregarMoneda50()
	{
		numeroMoneda50		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $100 a la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota. <br>
     * <b>post: </b>Aument� en uno la cantidad de monedas de $100 en la alcanc�a.
     */
	public void agregarMoneda100()
	{
		numeroMoneda100		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $200 a la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota. <br>
     * <b>post: </b>Aument� en uno la cantidad de monedas de $200 en la alcanc�a.
     */
	public void agregarMoneda200()
	{
		numeroMoneda200		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $500 a la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota. <br>
     * <b>post: </b>Aument� en uno la cantidad de monedas de $500 en la alcanc�a.
     */
	public void agregarMoneda500()
	{
		numeroMoneda500		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $1000 a la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota. <br>
     * <b>post: </b>Aument� en uno la cantidad de monedas de $1000 en la alcanc�a.
     */
	public void agregarMoneda1000()
	{
		numeroMoneda1000	+= 1;
	}
	
	 //---------------------------------------------------//
    /**
     * Rompe la alcanc�a. <br>
     * <b>pre: </b>La alcanc�a no est� rota. <br>
     * <b>post: </b>La alcanc�a est� rota.
     */
	public void romperAlcancia()
	{
		estado   			= false;
	}
	
	 //---------------------------------------------------//
	/**
	 * Actualiza la cantidad de monedas<br>
	 * <b>post:</b> se reiniciaron todos los valores a cero.
	 * 
	 */
	public void actualizar() {
		numeroMoneda50 		= 0;
		numeroMoneda100 	= 0;
		numeroMoneda200 	= 0;
		numeroMoneda500  	= 0;
		numeroMoneda1000 	= 0;
	}


	
}
