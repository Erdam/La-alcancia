package erdam.ej5.laAlcancia.mundo;
/**
 * Clase que representa una alcancía.
 */
public class Alcancia {
	//------- A T R I B U T O S -------//
    /**
     * Número de monedas de $50 que hay en la alcancía.
     */
	private int numeroMoneda50;
    /**
     * Número de monedas de $10 que hay en la alcancía.
     */
	private int numeroMoneda100;
    /**
     * Número de monedas de $200 que hay en la alcancía.
     */
	private int numeroMoneda200;
    /**
     * Número de monedas de $500 que hay en la alcancía.
     */
	private int numeroMoneda500;
    /**
     * Número de monedas de $1000 que hay en la alcancía.
     */
	private int numeroMoneda1000;
    /**
     * Estado de la alcancía. <br>
     * 0 indica que no está rota. <br>
     * 1 indica que está rota.
     */
	private boolean estado;
	//----- C O N S T R U C T O R  -----//
    /**
     * Construye la alcancía. <br>
     * <b>post: </b> El número de monedas de 50, número de monedas de 100, número de monedas de 200, número de monedas de 500, número de monedas de 1000 y el estado fueron
     * incializados en 0.
     */
	public Alcancia()
	{
		actualizar();
		estado             	= true;
		
	}
	//--------- M É T O D O S ----------//
    /**
     * Retorna el número de monedas de $50 que hay en la alcancía.
     * @return Número de monedas de $50 en la alcancía.
     */
	public int getNumeroMoneda50() {
		return numeroMoneda50;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el número de monedas de $100 que hay en la alcancía.
     * @return Número de monedas de $100 en la alcancía.
     */
	public int getNumeroMoneda100() {
		return numeroMoneda100;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el número de monedas de $200 que hay en la alcancía.
     * @return Número de monedas de $200 en la alcancía.
     */
	public int getNumeroMoneda200() {
		return numeroMoneda200;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el número de monedas de $500 que hay en la alcancía.
     * @return Número de monedas de $500 en la alcancía.
     */
	public int getNumeroMoneda500() {
		return numeroMoneda500;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el número de monedas de $1000 que hay en la alcancía.
     * @return Número de monedas de $1000 en la alcancía.
     */
	public int getNumeroMoneda1000() {
		return numeroMoneda1000;
	}
	 //---------------------------------------------------//
    /**
     * Informa si la alcancía está rota o no.
     * @return Retorna 1 si está rota, 0 en caso contrario.
     */
	public boolean getEstado() {
		return estado;
	}
	 //---------------------------------------------------//
    /**
     * Retorna el total de dinero que hay en la alcancía.
     * @return Total de dinero que hay en la alcancía.
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
     * Retorna el estado de la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota.<br>
     * @return Cadena que informa la cantidad de monedas que había en la alcancía y la cantidad total de dinero.
     */
	public String darEstadoDeAlcancia()
	{
		int totalDeDinero = calcularTotalDinero();
		return "La alcancía tenía: \n " + numeroMoneda50 + 
				" moneda(s) de $50 \n " + numeroMoneda100 +
				" moneda(s) de $100 \n " + numeroMoneda200 + 
				" moneda(s) de $200 \n " + numeroMoneda500 +
				" moneda(s) de $500 \n " + numeroMoneda1000 + 
				" moneda(s) de $1000 \n " + "Para un total de $" +
				totalDeDinero + " pesos.";
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $50 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $50 en la alcancía.
     */
	public void agregarMoneda50()
	{
		numeroMoneda50		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $100 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $100 en la alcancía.
     */
	public void agregarMoneda100()
	{
		numeroMoneda100		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $200 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $200 en la alcancía.
     */
	public void agregarMoneda200()
	{
		numeroMoneda200		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $500 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $500 en la alcancía.
     */
	public void agregarMoneda500()
	{
		numeroMoneda500		+= 1;
	}
	 //---------------------------------------------------//
    /**
     * Agrega una moneda de $1000 a la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>Aumentó en uno la cantidad de monedas de $1000 en la alcancía.
     */
	public void agregarMoneda1000()
	{
		numeroMoneda1000	+= 1;
	}
	
	 //---------------------------------------------------//
    /**
     * Rompe la alcancía. <br>
     * <b>pre: </b>La alcancía no está rota. <br>
     * <b>post: </b>La alcancía está rota.
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
