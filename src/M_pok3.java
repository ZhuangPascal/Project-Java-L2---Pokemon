import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.JButton;
@SuppressWarnings("serial")
public class M_pok3 extends JPanel{

	private Fenetre f;
	private Combat c;
	private JPanel jp;
	private Menu_P mp;
	
	public M_pok3(Fenetre f, Combat c, JPanel jp, Menu_P mp) {
		this.f=f;
		this.c=c;
		this.jp=jp;
		this.mp=mp;
		this.setLayout(new GridLayout(4, 2));
		
		String p1 = c.getD().getTabP()[0].getNom()+" : "+ c.getD().getTabP()[0].getHp()+"/"+c.getD().getTabP()[0].getHpMax()+" HP    Level "+c.getD().getTabP()[0].getLevel()+" " +c.getD().getTabP()[0].getenvie();
		JButton b1 = new JButton(p1);
		this.add(b1);
		b1.addActionListener(new EcouteurBoutonChanger(0));
		
		if(c.getD().getTaille() >= 2 ) {
		String p2= c.getD().getTabP()[1].getNom()+" : "+ c.getD().getTabP()[1].getHp()+"/"+c.getD().getTabP()[1].getHpMax()+" HP    Level "+c.getD().getTabP()[1].getLevel()+" " +c.getD().getTabP()[1].getenvie();
		JButton b2 = new JButton(p2);
		this.add(b2);
		b2.addActionListener(new EcouteurBoutonChanger(1));
		}
		
		if(c.getD().getTaille() >=3 ) {
		String p3= c.getD().getTabP()[2].getNom()+" : "+ c.getD().getTabP()[2].getHp()+"/"+c.getD().getTabP()[2].getHpMax()+" HP    Level "+c.getD().getTabP()[2].getLevel()+" " +c.getD().getTabP()[2].getenvie();
		JButton b3 = new JButton(p3);
		this.add(b3);
		b3.addActionListener(new EcouteurBoutonChanger(2));
		}
		
		if(c.getD().getTaille() >= 4 ) {
		String p4 = c.getD().getTabP()[3].getNom()+" : "+ c.getD().getTabP()[3].getHp()+"/"+c.getD().getTabP()[3].getHpMax()+" HP    Level "+c.getD().getTabP()[3].getLevel()+" " +c.getD().getTabP()[3].getenvie();
		JButton b4 = new JButton(p4);
		this.add(b4);
		b4.addActionListener(new EcouteurBoutonChanger(3));
		}
		
		if(c.getD().getTaille() >= 5 ) {
		String p5= c.getD().getTabP()[4].getNom()+" : "+ c.getD().getTabP()[4].getHp()+"/"+c.getD().getTabP()[4].getHpMax()+" HP    Level "+c.getD().getTabP()[4].getLevel()+" " +c.getD().getTabP()[4].getenvie();
		JButton b5 = new JButton(p5);
		this.add(b5);
		b5.addActionListener(new EcouteurBoutonChanger(4));
		}
		
		if(c.getD().getTaille() == 6 ) {
		String p6= c.getD().getTabP()[5].getNom()+" : "+ c.getD().getTabP()[5].getHp()+"/"+c.getD().getTabP()[5].getHpMax()+" HP    Level "+c.getD().getTabP()[5].getLevel()+" " +c.getD().getTabP()[5].getenvie();
		JButton b6 = new JButton(p6);
		this.add(b6);
		b6.addActionListener(new EcouteurBoutonChanger(5));
		}
		
		JButton b7 = new JButton("Fuite");
		this.add(b7);
		b7.addActionListener(new EcouteurBoutonChanger7());
	}
	
	public class EcouteurBoutonChanger implements ActionListener{ // changement de pokemon
		private int i;
		public EcouteurBoutonChanger(int i) {
			this.i=i;
		}
        public void actionPerformed(ActionEvent clic) {
        	if(c.getD().getTabP()[i].getHp()>0) {
        		c.setPd1(c.getD().getTabP()[i]);
        		c.getD().choisir(i);
        		M_pok3.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        		System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        		jp.remove(M_pok3.this);
        		jp.add(mp,BorderLayout.SOUTH);
        		f.setC2(jp);
        	}
        	else {
        		System.out.println("Ce pokemon est KO.");
        		
        	}
        }
    }
	
	public class EcouteurBoutonChanger7 implements ActionListener{ //  Fuite
        public void actionPerformed(ActionEvent clic) {
        	System.out.println("Le dresseur "+c.getD().getNom()+" abandonne.");
        	c.getD().afficher_pokemon(c.getD());
        	f.setC();
        	mp.getMonde().getClip().stop();
        	mp.getMonde().playSound("MUSIC/p_town.wav");
        }
    }
	

}
