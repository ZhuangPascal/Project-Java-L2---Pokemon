import java.awt.BorderLayout;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Monde {
	private int[][] Tab;
	private final int TailleX=50,TailleY=20;
	private PanPok p;
	private JPanel co2;
	private Menu_P mp;
	private JLabel label;
	private static Clip clip;
	
	public Monde() {
		Tab=new int[TailleY][TailleX];
		for(int i=1;i<TailleY;i++) {	
			for(int j=1;j<TailleX;j++) {
				if(Math.random()>=0.75) 
					Tab[i][j]=0;
				else 
					Tab[i][j]=1;
			}
		}
	}
	
	public void BougerDresseur(Dresseur d,int x, Fenetre f) {
		
		if(x==1) {
			if(d.getX()-1>=1) 
				d.ChangerX(d.getX()-1);
		}
		if(x==3) {
			if(d.getX()+1<TailleX) 
				d.ChangerX(d.getX()+1);
	
		}
		if(x==5) {
			if(d.getY()-1>=1) 
				d.ChangerY(d.getY()-1);
		}
		if(x==2) {
			if(d.getY()+1<TailleY) 
				d.ChangerY(d.getY()+1);
		}
		
		if(x==9) {
			System.out.println("\nFIN DU JEU, MERCI D'AVOIR TESTE NOTRE JEU !");
			 System.exit(0);
		}
		f.setC();
	}
	public boolean Aggro(Dresseur d) {
		if(Tab[d.getY()][d.getX()]==0 && Math.random()>=0.85 && d.getX()!= TailleX/2) {
			return true;
		}
		return false;
	}
	public void Bouger(Dresseur d,int x, Fenetre f) {
		
		 BougerDresseur(d,x,f);
		 
		 if(Aggro(d) && x!=9) {
			 
			clip.stop();
			playSound("MUSIC/lbat.wav");
			Combat c=new Combat(d,new Dresseur());
			label = new JLabel("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
			co2= new JPanel();
			p= new PanPok(c);
		    mp= new Menu_P(f,c,co2,this,label);
			co2.setLayout(new BorderLayout());
			co2.add(label, BorderLayout.NORTH);
			co2.add(p, BorderLayout.CENTER);
			co2.add(mp, BorderLayout.SOUTH);
			
			f.setC2(co2);
			
		 }	
	
	}
	public int [][] getTab(){
		return Tab;
	}
	
	public int getX() {
		return TailleX;
	}
	public int getY() {
		return TailleY;
	}
	
	public JPanel getC2() {
		return co2;
	}
	
	public PanPok getP() {
		return p;
	}
	public Menu_P getMp() {
		return mp;
	}
	
	public void setMp(Menu_P mp) {
		this.mp=mp;
	}
	
	public void playSound(String name) {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public Clip getClip() {
		return clip;
	}
	
	public JLabel getL() {
		return label;
	}
	
}
