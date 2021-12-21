package erdam.ej5.laAlcancia.interfaz;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel en el que se encuentran los botones para romper la alcanc�a y crear una nueva.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener{
	// ------- C O N S T A N T E S -------//
	/**
	 * Constante para romper la alcanc�a.
	 */
	private static final String ROMPER ="Romper";
	/**
	 * Constante para crear una nueva alcanc�a.
	 */
	private static final String NUEVA = "Nueva alcanc�a";
	
	//------- A T R I B U T O S -------//
	/**
	 * Ventana principal de la aplicaci�n.
	 */
	private InterfazAlcancia principal;
	/**
	 * Bot�n usado para romper la alcanc�a.
	 */
	private JButton 					btnRomperAlcancia;
	/**
	 * Bot�n usado para crear una nueva alcanc�a.
	 */
	private JButton 					btnCrearNuevaAlcancia;
	//----- C O N S T R U C T O R  -----//
    /**
     * Construye un nuevo panel .<br>
     * <b>post: </b>Se construy� el panel y se inicializaron sus componentes.
     * @param pPrincipal Referencia a la clase principal de la interfaz. pPrincipal != null
     */
	public PanelBotones(InterfazAlcancia pPrincipal)
	{
		principal = pPrincipal;
		setLayout(new BorderLayout());
		
		//inicializo los componentes del panel.
		JPanel panelInternoNuevo		= new JPanel();
		btnCrearNuevaAlcancia 			= new JButton(NUEVA);
		btnCrearNuevaAlcancia.setActionCommand(NUEVA);
		btnCrearNuevaAlcancia.addActionListener(this);
		panelInternoNuevo.add(btnCrearNuevaAlcancia);
		
		JPanel panelInternoRomper		= new JPanel();
		btnRomperAlcancia     			= new JButton(new ImageIcon("data/martillo.png"));
		btnRomperAlcancia.setActionCommand(ROMPER);
		btnRomperAlcancia.addActionListener(this);
		btnRomperAlcancia.setMargin(new Insets(1, 1, 1, 1));
		btnRomperAlcancia.setOpaque(false);
		btnRomperAlcancia.setContentAreaFilled(false);
		panelInternoRomper.add(btnRomperAlcancia);
		panelInternoRomper.setBorder(new TitledBorder("Romper alcanc�a"));
		
		add(panelInternoNuevo, BorderLayout.SOUTH);
		add(panelInternoRomper, BorderLayout.CENTER);
	}
	//--------- M � T O D O S ----------//
	//---------------------------------------------------//
    /**
     * Ejecuta la acci�n seg�n el bot�n sobre el que se haya hecho click.
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		try {
			String command = pEvento.getActionCommand();
			switch(command)
			{
			case ROMPER:
				principal.romperAlcancia();
				break;
			case NUEVA:
				principal.nuevaAlcancia();
				break;
			}
		
			
		} catch (Exception pEvent) {
			pEvent.printStackTrace();
		}
		
	}

}
