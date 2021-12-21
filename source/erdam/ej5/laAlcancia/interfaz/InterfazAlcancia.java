package erdam.ej5.laAlcancia.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import erdam.ej5.laAlcancia.mundo.Alcancia;
/**
 * Clase principal de la interfaz.
 */
@SuppressWarnings("serial")
public class InterfazAlcancia extends JFrame {
	//------- A T R I B U T O S -------//
    /**
     * Clase principal del mundo.
     */
	private Alcancia		 	alcancia;
	
    /**
     * Clase del banner.
     */
	private PanelBanner 		banner;
	
    /**
     * Panel donde se muestra el estado actual de la alcanc�a.
     */
	private PanelAlcancia       panelAlcancia;
	
	   /**
     * Panel donde se seleccionan y agregan las monedas.
     */
	private PanelMonedas        panelMonedas;
	
    /**
     * Panel con los botones de las acciones de la aplicaci�n.
     */
	private PanelBotones        panelBotones;
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor de la interfaz de la alcanc�a, la alcanc�a se inicia vac�a <br>
	 * <b>post.<b> Se inicializ� la ventana principal de la aplicaci�n con sus p�neles.
	 */
	public InterfazAlcancia()
	{
		setTitle("Alcanc�a");
		setSize(600, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		alcancia 				= new Alcancia();
		banner 					= new PanelBanner();
		panelAlcancia           = new PanelAlcancia();
		panelMonedas            = new PanelMonedas(this);
		panelBotones            = new PanelBotones(this);
		
		getContentPane().setLayout(new BorderLayout());
		add(banner, BorderLayout.NORTH);
		
		JPanel panelCentral 	= new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelCentral.add(panelMonedas, BorderLayout.NORTH);
		panelCentral.add(panelAlcancia, BorderLayout.CENTER);
		panelCentral.add(panelBotones, BorderLayout.EAST);
		
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		
	}
	//--------- M � T O D O S ----------//
    /**
     * Agrega una moneda a la alcanc�a siempre y cuando no est� rota. <br>
     * <b>post: </b>Se agreg� la cantidad indicada a la alcanc�a o se present� un mensaje de error si estaba rota.
     * @param pDenominacion Denominaci�n de la moneda que se va a agregar a la alcanc�a. pDenominacion >0.
     */
	public void agregarMonedas(int pDenominacion)
	{
		if(alcancia.getEstado())
		{
			switch(pDenominacion)
			{
			case 50:
				alcancia.agregarMoneda50();
				panelMonedas.cambiarCantidad(pDenominacion, alcancia.getNumeroMoneda50());
				break;
			case 100:
				alcancia.agregarMoneda100();
				panelMonedas.cambiarCantidad(pDenominacion, alcancia.getNumeroMoneda100());
				break;
			case 200:
				alcancia.agregarMoneda200();
				panelMonedas.cambiarCantidad(pDenominacion, alcancia.getNumeroMoneda200());
				break;
			case 500:
				alcancia.agregarMoneda500();
				panelMonedas.cambiarCantidad(pDenominacion, alcancia.getNumeroMoneda500());
				break;
			case 1000:
				alcancia.agregarMoneda1000();
				panelMonedas.cambiarCantidad(pDenominacion, alcancia.getNumeroMoneda1000());
				break;
			}
			panelAlcancia.setMensaje("La alcanc�a tiene: $" + alcancia.calcularTotalDinero());
		}
		else
		{
			JOptionPane.showMessageDialog( this, "La alcanc�a est� rota, por favor inicie una nueva alcanc�a ", "Romper alcanc�a", JOptionPane.ERROR_MESSAGE );
		}
		
	}
	//---------------------------------------------------//
	/**
	 * Crear nueva alcanc�a<br>
	 * <b>post:</b> se cre� una nueva alcanc�a.
	 */
	public void nuevaAlcancia()
	{
		if(!alcancia.getEstado()) {
			alcancia = new Alcancia();
			panelAlcancia.setImagenAlcancia(false);
			panelAlcancia.setMensaje("La alcanc�a est� vac�a");
		}
		else
		{
			JOptionPane.showMessageDialog( this, "No es posible crear una nueva alcanc�a ", "Romper alcanc�a", JOptionPane.INFORMATION_MESSAGE );
		}
		
		
	}
	
	//---------------------------------------------------//
    /**
     * Rompe la alcanc�a y actualiza la informaci�n mostrada. <br>
     * <b>post: </b>La alcanc�a est� rota.
     */
	public void romperAlcancia()
	{
		String mensaje = alcancia.darEstadoDeAlcancia();
		alcancia.romperAlcancia();
		panelAlcancia.setImagenAlcancia(true);
		panelAlcancia.setMensaje("La alcanc�a est� rota");
		JOptionPane.showMessageDialog( this, mensaje, "Romper alcanc�a", JOptionPane.INFORMATION_MESSAGE );
		JOptionPane.showMessageDialog( this,"Usted retir� la cantidad de :  $"+ alcancia.calcularTotalDinero(), "Romper alcanc�a", JOptionPane.INFORMATION_MESSAGE );
		actualizarCampos();
	}
	//---------------------------------------------------//
	/**
	 * Actualiza los campos de texto con las monedas actuales.<br>
	 * <b>post:</b> se actualizaron todos los campos.
	 */
	private void actualizarCampos()
	{
		alcancia.actualizar();
		panelMonedas.cambiarCantidad(50, alcancia.getNumeroMoneda50());
		panelMonedas.cambiarCantidad(100, alcancia.getNumeroMoneda100());
		panelMonedas.cambiarCantidad(200, alcancia.getNumeroMoneda200());
		panelMonedas.cambiarCantidad(500, alcancia.getNumeroMoneda500());
		panelMonedas.cambiarCantidad(1000, alcancia.getNumeroMoneda1000());
	}
	   /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
	public static void main(String[] pArgs) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazAlcancia principal = new InterfazAlcancia();
			principal.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
