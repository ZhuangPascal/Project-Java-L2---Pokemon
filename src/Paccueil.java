import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import java.io.File;
@SuppressWarnings("serial")
public class Paccueil extends JPanel{
	private Fenetre fen;
	public Image IMG_LOGO;
	
	public Paccueil (Fenetre f) {
		fen=f;	
	}
	
	public void paintComponent(Graphics g) {
		try {
			IMG_LOGO = ImageIO.read(new File("IMAGES/lp.png"));
			g.drawImage(IMG_LOGO, 0, 0,fen.getX(),fen.getY(), this);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
