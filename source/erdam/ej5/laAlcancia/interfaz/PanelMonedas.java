package erdam.ej5.laAlcancia.interfaz;



import java.awt.Color;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelMonedas extends JPanel implements ActionListener, ItemListener{
	// ------- C O N S T A N T E S -------//
	/**
	 * Constante para agregar una moneda a la alcancía.
	 */
	private static final String AGREGAR 		= "Agregar";
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazAlcancia                       principal;
	/**
	 * Opción para seleccionar moneda de $50.
	 */
	private JRadioButton 						   jrbMoneda50;
	/**
	 * Opción para seleccionar moneda de $100.
	 */
	private JRadioButton 						   jrbMoneda100;
	/**
	 * Opción para seleccionar moneda de $200.
	 */
	private JRadioButton 						   jrbMoneda200;
	/**
	 * Opción para seleccionar moneda de $500.
	 */
	private JRadioButton 						   jrbMoneda500;
	/**
	 * Opción para seleccionar moneda de $1000.
	 */
	private JRadioButton 						   jrbMoneda1000;
	/**
	 * Grupo de botones que asegura que solamente se selecciona una moneda a la vez.
	 */
	private ButtonGroup                            btgGrupoDeBotones;
	/**
	 * Opción para seleccionar una moneda a la alcancía.
	 */
	private JButton                                btnAgregar;
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Construye un nuevo panel<br>
	 * <b>post:</b> se construyó el panel y se inicializó sus componetes.<br>
	 * @param pPrincipal Referencia a la clase principal de la interfaz. pPrincipal!=null.
	 */
	public PanelMonedas(InterfazAlcancia pPrincipal)
	{
		principal = pPrincipal;
		
		// Inicializa los componentes del panel
		btgGrupoDeBotones = new ButtonGroup();
		
		jrbMoneda50 = new JRadioButton("0", new ImageIcon("data/50.png"));
		btgGrupoDeBotones.add(jrbMoneda50);
		jrbMoneda50.setVerticalTextPosition(SwingConstants.BOTTOM);
		jrbMoneda50.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbMoneda50.addItemListener(this);
		jrbMoneda50.setBorder(null);
		add(jrbMoneda50);
		
		jrbMoneda100 = new JRadioButton("0", new ImageIcon("data/100.png"));
		btgGrupoDeBotones.add(jrbMoneda100);
		jrbMoneda100.setVerticalTextPosition(SwingConstants.BOTTOM);
		jrbMoneda100.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbMoneda100.addItemListener(this);
		jrbMoneda100.setBorder(null);
		add(jrbMoneda100);
		
		jrbMoneda200 = new JRadioButton("0", new ImageIcon("data/200.png"));
		btgGrupoDeBotones.add(jrbMoneda200);
		jrbMoneda200.setVerticalTextPosition(SwingConstants.BOTTOM);
		jrbMoneda200.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbMoneda200.addItemListener(this);
		jrbMoneda200.setBorder(null);
		add(jrbMoneda200);
		
		jrbMoneda500 = new JRadioButton("0", new ImageIcon("data/500.png"));
		btgGrupoDeBotones.add(jrbMoneda500);
		jrbMoneda500.setVerticalTextPosition(SwingConstants.BOTTOM);
		jrbMoneda500.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbMoneda500.addItemListener(this);
		jrbMoneda500.setBorder(null);
		add(jrbMoneda500);
		
		jrbMoneda1000 = new JRadioButton("0", new ImageIcon("data/1000.png"));
		btgGrupoDeBotones.add(jrbMoneda1000);
		jrbMoneda1000.setVerticalTextPosition(SwingConstants.BOTTOM);
		jrbMoneda1000.setHorizontalTextPosition(SwingConstants.CENTER);
		jrbMoneda1000.addItemListener(this);
		jrbMoneda1000.setBorder(null);
		add(jrbMoneda1000);
		
		btnAgregar = new JButton(AGREGAR);
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		btnAgregar.setMargin(new Insets(23, 25, 23, 25));
		add(btnAgregar);
		
		setBorder(new TitledBorder("Monedas"));
		
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Cambia la cantidad de monedas<br>
	 * @param pDenominacion Denominación de la moneda. pDenominacion>0.
	 * @param pCantidad Cantidad de las monedas que hay. pCantidad>0.
	 */
	public void cambiarCantidad(int pDenominacion, int pCantidad)
	{
		switch(pDenominacion)
		{
		case 50:
			jrbMoneda50.setText(""+ pCantidad);
			break;
		case 100:
			jrbMoneda100.setText(""+ pCantidad);
			break;
		case 200:
			jrbMoneda200.setText(""+ pCantidad);
			break;
		case 500:
			jrbMoneda500.setText(""+ pCantidad);
			break;
		case 1000:
			jrbMoneda1000.setText(""+ pCantidad);
			break;
		}
		
	}
	
	//---------------------------------------------------//
    /**
     * Método se llama cuando se selecciona alguno de los botones que indican las denominaciones. <br>
     * El método se encarga de dibujar un borde alrededor de la denominación seleccionada.
     * @param pEvento Evento de la selección de una denominación. pEvento!=null.
     */
	@Override
	public void itemStateChanged(ItemEvent pEvento) {
		try {
			JRadioButton boton =(JRadioButton)pEvento.getItem();
			if(pEvento.getStateChange()==ItemEvent.SELECTED)
			{
				/*BevelBorder (tipo int, color resaltado en el exterior, color resaltado en el interior, sombra de color en exterior, sombra de color en  interior)
				 crea un borde en bisel con el tipo especificado, colores de resaltado y sombra.*/
				boton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.GRAY));
				boton.setBorderPainted(true);
			}
			else
			{
				boton.setBorder(null);
			}
			
		} catch (Exception pEvent) {
			pEvent.printStackTrace();
		}
		validate();
		
	}
	//---------------------------------------------------//
    /**
     * Ejecuta la acción según el botón sobre el que se haya hecho click.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();

			if(AGREGAR.equals(command))
			{
				int denominacion = 0;
				
				if(jrbMoneda50.isSelected())
				{
					denominacion = 50;
				}
				else if(jrbMoneda100.isSelected())
				{
					denominacion = 100;
				}
				else if(jrbMoneda200.isSelected())
				{
					denominacion = 200;
				}
				else if(jrbMoneda500.isSelected())
				{
					denominacion = 500;
				}
				else if(jrbMoneda1000.isSelected())
				{
					denominacion = 1000;
				}
				
				principal.agregarMonedas(denominacion);
				
			}
			
		} catch (Exception pEvent) {
			pEvent.printStackTrace();
		}
		
		
	}


}
