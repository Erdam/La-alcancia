package erdam.ej5.laAlcancia.interfaz;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
/**
 * Panel donde se muestra el estado actual de la alcancía.
 */
@SuppressWarnings("serial")
public class PanelAlcancia extends JPanel{
	//------- A T R I B U T O S -------//
    /**
     * Etiqueta donde se dibuja la alcancía.
     */
	private JLabel 		lblALcancia;
    /**
     * Área donde se muestran los mensajes sobre la alcancía.
     */
	private JTextArea 	txtMensaje;
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del Panel Alcancía <br>
	 * <b>post.<b> se construyo el panel y se inicializaron todos sus componentes 
	 */
	public PanelAlcancia()
	{
		setLayout(new BorderLayout());
		lblALcancia = new JLabel(new ImageIcon("data/alcancia.png"));
		
		txtMensaje  = new JTextArea(3,40);//JTextArea(fila, columna)
		Font fuente = new Font("Comic Sans MS",Font.PLAIN, 12);
		txtMensaje.setFont(fuente);
		txtMensaje.setText("Alcancía vacía");
		txtMensaje.setWrapStyleWord(true);//Hace que corten sólo en palabras completas
		txtMensaje.setLineWrap(true);//Hace que las líneas corten en el límite del área
		txtMensaje.setBackground(getBackground());
		txtMensaje.setEditable(false);
		setBorder(new TitledBorder("Alcancía"));
		add(lblALcancia, BorderLayout.CENTER);
		add(txtMensaje, BorderLayout.SOUTH);
	
		
	}
	//--------- M É T O D O S ----------//
	/**
	 * Cambia el mensaje mostrado <br>
	 * <b>post:</b> se cambió el mensaje<br>
	 * @param pMensaje Mensaje que se quiere mostrar. pMensaje != null.
	 */
	public void setMensaje(String pMensaje)
	{
		txtMensaje.setText(pMensaje);
		validate();
	}
	//---------------------------------------------------//
	/** Cambia la imagen de la alcancia según su estado <br>
	 * <b> post: </b> se actualizo el icono de la alcancía<br>
	 * @param pRota Indica si la alcancia está rota o no. 
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
