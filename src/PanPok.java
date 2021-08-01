
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.File;
@SuppressWarnings("serial")
public class PanPok extends JPanel{

	public Image IMG_CARA;
	public Image IMG_BULBI;
	public Image IMG_SALA;
	public Image IMG_ARKO;
	public Image IMG_GOBOU;
	public Image IMG_POUSSI;
	public Image IMG_TIPL;
	public Image IMG_TORTI;
	public Image IMG_OUIST;
	public Image IMG_VS;
	private Combat c;
	private final int t =300;
	private final int n = 300;
	private final int x =40;
	private final int y = 100;

	
	public PanPok(Combat c){
		this.c=c;

	}
	
	public void paintComponent(Graphics g) {
		try {
			
			IMG_CARA = ImageIO.read(new File("IMAGES/carapuce.png"));
			IMG_BULBI = ImageIO.read(new File("IMAGES/bulbizarre.png"));
			IMG_SALA = ImageIO.read(new File("IMAGES/salameche.png"));
			IMG_ARKO = ImageIO.read(new File("IMAGES/arko.png"));
			IMG_GOBOU = ImageIO.read(new File("IMAGES/gobou.png"));
			IMG_POUSSI = ImageIO.read(new File("IMAGES/poussifeu.png"));
			IMG_TIPL = ImageIO.read(new File("IMAGES/tiplouf.png"));
			IMG_TORTI = ImageIO.read(new File("IMAGES/tortipouss.png"));
			IMG_OUIST = ImageIO.read(new File("IMAGES/ouisticram.png"));
			IMG_VS = ImageIO.read(new File("IMAGES/versus.png"));
			
			// dresseur 1
			if(c.getPd1().getNom().equals("Carapuce"))	
				g.drawImage(IMG_CARA, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Bulbizarre"))	
				g.drawImage(IMG_BULBI, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Salameche"))	
				g.drawImage(IMG_SALA, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Arcko"))	
				g.drawImage(IMG_ARKO, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Gobou"))	
				g.drawImage(IMG_GOBOU,x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Poussifeu"))	
				g.drawImage(IMG_POUSSI, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Tiplouf"))	
				g.drawImage(IMG_TIPL, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Tortipouss"))	
				g.drawImage(IMG_TORTI, x*3, y,t,t, this);
			if(c.getPd1().getNom().equals("Ouisticram"))	
				g.drawImage(IMG_OUIST, x*3, y,t,t, this);
			
			// dresseur 2
			if(c.getPd2().getNom().equals("Carapuce"))	
				g.drawImage(IMG_CARA, t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Bulbizarre"))	
				g.drawImage(IMG_BULBI, t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Salameche"))	
				g.drawImage(IMG_SALA, t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Arcko"))	
				g.drawImage(IMG_ARKO,  t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Gobou"))	
				g.drawImage(IMG_GOBOU,  t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Poussifeu"))	
				g.drawImage(IMG_POUSSI,  t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Tiplouf"))	
				g.drawImage(IMG_TIPL, t+n+x*4, y,t,t, this);
			if(c.getPd2().getNom().equals("Tortipouss"))	
				g.drawImage(IMG_TORTI, t+n+x*4,y,t,t, this);
			if(c.getPd2().getNom().equals("Ouisticram"))	
				g.drawImage(IMG_OUIST,  t+n+x*4, y,t,t, this);
			
			g.drawImage(IMG_VS,  t+n-50, y+100,50,50, this);
			
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}
	
}
