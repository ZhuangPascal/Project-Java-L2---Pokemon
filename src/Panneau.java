import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.File;
@SuppressWarnings("serial")
public class Panneau extends JPanel implements KeyListener{
	private Monde m;
	private Fenetre fen;
	private Dresseur d;
	private int n;
	private PanPok p;
	private JPanel co2;
	private Menu_P mp1;
	private JLabel label;
	
	public Image IMG_BUSH;
	public Image IMG_GRASS;
	public Image IMG_WATER;
	public Image IMG_SWIM;
	public Image IMG_FR;
	public Image IMG_FJ;
	public Image IMG_FV;
	
	public Image IMG_PB;
	public Image IMG_PH;
	public Image IMG_PD;
	public Image IMG_PG;
	
	public final int t=23;
	
	public Panneau(Monde mo, Dresseur d,Fenetre f) {
		n=2;
		m=mo;
		this.d=d;
		fen=f;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		m.playSound("MUSIC/p_town.wav");
	}
	
	public void paintComponent(Graphics g) {
		try {
			IMG_BUSH = ImageIO.read(new File("IMAGES/bush.png"));
			IMG_GRASS = ImageIO.read(new File("IMAGES/grass.png"));
			IMG_PB = ImageIO.read(new File("IMAGES/pb.png"));
			IMG_WATER = ImageIO.read(new File("IMAGES/water.png"));
			IMG_SWIM = ImageIO.read(new File("IMAGES/swim.png"));	
			IMG_PH= ImageIO.read(new File("IMAGES/ph.png"));
			IMG_PD= ImageIO.read(new File("IMAGES/pd.png"));
			IMG_PG= ImageIO.read(new File("IMAGES/pg.png"));
			
			for(int i=0;i<=m.getX();i++) {
				for(int j=0;j<=m.getY();j++) {

					if(i==0 || i == m.getX() || j== 0 || j==m.getY() || i== m.getX()/2)
						g.drawImage(IMG_WATER, i*t, j*t,t,t, this);
					
					else {				
						g.drawImage(IMG_GRASS, i*t, j*t,t,t, this);
						if(m.getTab()[j][i]==0)
							g.drawImage(IMG_BUSH, i*t, j*t,t,t, this);

					}
				}
			}
			
			if(d.getX() == m.getX()/2) {
				g.drawImage(IMG_SWIM,d.getX()*t, d.getY()*t,t,t, this);
			}
			else {
				if(n==2)
					g.drawImage(IMG_PB,d.getX()*t, d.getY()*t,t,t, this);	
				else if (n== 3)
					g.drawImage(IMG_PD,d.getX()*t, d.getY()*t,t,t, this);	
				else if (n== 1)
					g.drawImage(IMG_PG,d.getX()*t, d.getY()*t,t,t, this);
				else
					g.drawImage(IMG_PH,d.getX()*t, d.getY()*t,t,t, this);
			}	
			
		}catch(IOException e) {
			e.printStackTrace();
		} 
	
	}
	
	
	public void keyPressed(KeyEvent e)
	{
	
		int c= e.getKeyCode();
		
		if(c== KeyEvent.VK_NUMPAD7 || c== KeyEvent.VK_7 ) {
			//m.Bouger(d,7,fen);
			m.getClip().stop();
			m.playSound("MUSIC/pokemon_m.wav");
			Combat co=new Combat(d, new Dresseur("Red",6));
			label = new JLabel("                                                                             "+co.getPd1().getNom()+": "+co.getPd1().getHp()+" HP"+"                                                                                                                                                            "+co.getPd2().getNom()+": "+co.getPd2().getHp()+" HP");
		    co2= new JPanel();
			p= new PanPok(co);
		    mp1= new Menu_P(fen,co,co2,m,label);
		    m.setMp(mp1);
			co2.setLayout(new BorderLayout());
			co2.add(label, BorderLayout.NORTH);
			co2.add(p, BorderLayout.CENTER);
			co2.add(mp1, BorderLayout.SOUTH);
			fen.setC2(co2);
			
		}
		
		if(c== KeyEvent.VK_NUMPAD9 || c== KeyEvent.VK_9) {
			m.Bouger(d,9,fen);
			repaint();
		}
		
		if(c== KeyEvent.VK_LEFT) {
			n=1;
			m.Bouger(d,1,fen);
			repaint();
		}
		
		if(c== KeyEvent.VK_UP) {
			n=5;
			m.Bouger(d,5, fen);
			repaint();
		}
		
		if(c== KeyEvent.VK_RIGHT) {
			n=3;
			m.Bouger(d,3,fen);
			repaint();
		}
		
		if(c== KeyEvent.VK_DOWN) {
			n=2;
			m.Bouger(d,2,fen);
			repaint();
		}
		
		if(c== KeyEvent.VK_ADD) {
			System.out.println("\nVotre equipe est entierement soigne.\n\n");
			
			for(int l=0;l<d.getTaille();l++) { 
					d.getTabP()[l].setenVie(1);
					d.getTabP()[l].setHp(d.getTabP()[l].getHpMax());
					d.getTabP()[l].setenvie();
				
			}
			d.afficher_pokemon(d);
	
			repaint();
		}
		
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	public int getT() {
		return t;
	}
	public JLabel getL() {
		return label;
	}
	
	
}