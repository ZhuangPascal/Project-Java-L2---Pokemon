import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class Menu_P extends JPanel{
	private Combat c;
	private JButton b1 = new JButton("Attaque");
	private JButton b2 = new JButton("Sac");
	private JButton b3 = new JButton("Pokemon");
	private JButton b4 = new JButton("Fuite");
	private Fenetre f;
	private JPanel jp;
	private Monde m;
	private M_atq ma;
	private M_pok mpo;
	private Sac s;
	private JLabel label;
	
	public Menu_P(Fenetre f, Combat c, JPanel jp, Monde m, JLabel l) {
		label=l;
		this.f=f;
		this.c=c;
		this.jp=jp;
		this.m=m;
		
		this.setLayout(new GridLayout(2, 2));
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		
		b1.addActionListener(new EcouteurBoutonChanger1());
		b2.addActionListener(new EcouteurBoutonChanger2());
		b3.addActionListener(new EcouteurBoutonChanger3());
		b4.addActionListener(new EcouteurBoutonChanger4());
		
	}
	
	public class EcouteurBoutonChanger1 implements ActionListener{ // b1 : Attaque
        public void actionPerformed(ActionEvent clic) {
            jp.remove(m.getMp());
            ma= new M_atq(f,c,jp,Menu_P.this);
            jp.add(ma,BorderLayout.SOUTH);
            f.setC2(jp);
        }
    }
	
	public class EcouteurBoutonChanger2 implements ActionListener{ // b2 : Sac
        public void actionPerformed(ActionEvent clic) {

        	jp.remove(m.getMp());
            s=new Sac(f,c,jp,Menu_P.this);
            jp.add(s,BorderLayout.SOUTH);
            f.setC2(jp);
        }
    }
	
	public class EcouteurBoutonChanger3 implements ActionListener{ // b3 : Pokemon
        public void actionPerformed(ActionEvent clic) {
        	jp.remove(m.getMp());
            mpo= new M_pok(f,c,jp, Menu_P.this);
            jp.add(mpo,BorderLayout.SOUTH);
            f.setC2(jp);
        }
    }
	
	public class EcouteurBoutonChanger4 implements ActionListener{ // b4 : Fuite
        public void actionPerformed(ActionEvent clic) {
        	System.out.println("Le dresseur "+c.getD().getNom()+" abandonne.");
        	c.getD().afficher_pokemon(c.getD());
        	f.setC();
        	m.getClip().stop();
        	m.playSound("MUSIC/p_town.wav");
        }
    }
	public Monde getMonde() {
		return m;
	}
	
	public void setL(String n) {
		label.setText(n);
	}
}
