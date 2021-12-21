package erdam.ej5.laAlcancia.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Panel con la imagen del banner.
 */
@SuppressWarnings("serial")
public class PanelBanner extends JPanel{
	
	//----- C O N S T R U C T O R  -----//
	/**
	 * Constructor del Panel <br>
	 * <b>post:</b> El panel quedó iniciado
	 */
	public PanelBanner()
	{
		JLabel contenedor = new JLabel();
		ImageIcon ruta    = new ImageIcon("data/Encabezado.png");
		contenedor.setIcon(ruta);
		add(contenedor);
	}
}
