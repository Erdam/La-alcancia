package erdam.ej5.laAlcancia.interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
/**
 * Panel donde se muestra el estado actual de la alcanc�a.
 */
@SuppressWarnings("serial")
public class PanelAlcancia extends JPanel{
	//------- A T R I B U T O S -------//
    /**
     * Etiqueta donde se dibuja la alcanc�a.
     */
	private JLabel 		lblALcancia;
    /**
     * �rea donde se muestran los mensajes sobre la alcanc�a.
     */
	private JTextArea 	txtMensaje;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del Panel Alcanc�a <br>
	 * <b>post.<b> se construyo el panel y se inicializaron todos sus componentes 
	 */
	public PanelAlcancia()
	{
		setLayout(new BorderLayout());
		lblALcancia = new JLabel(new ImageIcon("data/alcancia.png"));
		
		txtMensaje  = new JTextArea(3,40);//JTextArea(fila, columna)
		Font fuente = new Font("Comic Sans MS",Font.PLAIN, 12);
		txtMensaje.setFont(fuente);
		txtMensaje.setText("Alcanc�a vac�a");
		txtMensaje.setWrapStyleWord(true);//Hace que corten s�lo en palabras completas
		txtMensaje.setLineWrap(true);//Hace que las l�neas corten en el l�mite del �rea
		txtMensaje.setBackground(getBackground());
		txtMensaje.setEditable(false);
		setBorder(new TitledBorder("Alcanc�a"));
		add(lblALcancia, BorderLayout.CENTER);
		add(txtMensaje, BorderLayout.SOUTH);
	
		
	}
	//--------- M � T O D O S ----------//
	/**
	 * Cambia el mensaje mostrado <br>
	 * <b>post:</b> se cambi� el mensaje<br>
	 * @param pMensaje Mensaje que se quiere mostrar. pMensaje != null.
	 */
	public void setMensaje(String pMensaje)
	{
		txtMensaje.setText(pMensaje);
		validate();
	}
	//---------------------------------------------------//
	/** Cambia la imagen de la alcancia seg�n su estado <br>
	 * <b> post: </b> se actualizo el icono de la alcanc�a<br>
	 * @param pRota Indica si la alcancia est� rota o no. 
	 */
	public void setImagenAlcancia(boolean pRota)
	{
		if(pRota)
		{
			lblALcancia.setIcon(new ImageIcon("data/alcanciaRota.png"));
		}
		else
		{
			lblALcancia.setIcon(new ImageIcon("data/alcancia.png"));
			
		}
		validate();
	}
}
