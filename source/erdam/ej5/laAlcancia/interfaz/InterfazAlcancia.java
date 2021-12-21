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
     * Panel donde se muestra el estado actual de la alcancía.
     */
	private PanelAlcancia       panelAlcancia;
	
	   /**
     * Panel donde se seleccionan y agregan las monedas.
     */
	private PanelMonedas        panelMonedas;
	
    /**
     * Panel con los botones de las acciones de la aplicación.
     */
	private PanelBotones        panelBotones;
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor de la interfaz de la alcancía, la alcancía se inicia vacía <br>
	 * <b>post.<b> Se inicializó la ventana principal de la aplicación con sus páneles.
	 */
	public InterfazAlcancia()
	{
		setTitle("Alcancía");
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
	//--------- M É T O D O S ----------//
    /**
     * Agrega una moneda a la alcancía siempre y cuando no esté rota. <br>
     * <b>post: </b>Se agregó la cantidad indicada a la alcancía o se presentó un mensaje de error si estaba rota.
     * @param pDenominacion Denominación de la moneda que se va a agregar a la alcancía. pDenominacion >0.
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
			panelAlcancia.setMensaje("La alcancía tiene: $" + alcancia.calcularTotalDinero());
		}
		else
		{
			JOptionPane.showMessageDialog( this, "La alcancía está rota, por favor inicie una nueva alcancía ", "Romper alcancía", JOptionPane.ERROR_MESSAGE );
		}
		
	}
	//---------------------------------------------------//
	/**
	 * Crear nueva alcancía<br>
	 * <b>post:</b> se creó una nueva alcancía.
	 */
	public void nuevaAlcancia()
	{
		if(!alcancia.getEstado()) {
			alcancia = new Alcancia();
			panelAlcancia.setImagenAlcancia(false);
			panelAlcancia.setMensaje("La alcancía está vacía");
		}
		else
		{
			JOptionPane.showMessageDialog( this, "No es posible crear una nueva alcancía ", "Romper alcancía", JOptionPane.INFORMATION_MESSAGE );
		}
		
		
	}
	
	//---------------------------------------------------//
    /**
     * Rompe la alcancía y actualiza la información mostrada. <br>
     * <b>post: </b>La alcancía está rota.
     */
	public void romperAlcancia()
	{
		String mensaje = alcancia.darEstadoDeAlcancia();
		alcancia.romperAlcancia();
		panelAlcancia.setImagenAlcancia(true);
		panelAlcancia.setMensaje("La alcancía está rota");
		JOptionPane.showMessageDialog( this, mensaje, "Romper alcancía", JOptionPane.INFORMATION_MESSAGE );
		JOptionPane.showMessageDialog( this,"Usted retiró la cantidad de :  $"+ alcancia.calcularTotalDinero(), "Romper alcancía", JOptionPane.INFORMATION_MESSAGE );
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
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
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
