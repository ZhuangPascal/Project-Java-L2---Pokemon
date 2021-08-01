import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class M_pok extends JPanel{

	private Fenetre f;
	private Combat c;
	private JPanel jp;
	private Menu_P mp;
	
	public M_pok(Fenetre f, Combat c, JPanel jp, Menu_P mp) {
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
		String p2 = c.getD().getTabP()[1].getNom()+" : "+ c.getD().getTabP()[1].getHp()+"/"+c.getD().getTabP()[1].getHpMax()+" HP    Level "+c.getD().getTabP()[1].getLevel()+" " +c.getD().getTabP()[1].getenvie();
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
		
		JButton b7 = new JButton("Retour");
		this.add(b7);
		b7.addActionListener(new EcouteurBoutonChanger2());
		
	}
	
	public class EcouteurBoutonChanger implements ActionListener{ // changement de pokemon
		private int i;
		public EcouteurBoutonChanger(int i) {
			this.i=i;
		}
        public void actionPerformed(ActionEvent clic) {
        	if(c.getPd1()==c.getD().getTabP()[i])
        		System.out.println("Ce pokemon est deja sur le terrain");
        	
        	else if( c.getD().getTabP()[i].getenVie()==0 )
        		System.out.println("Ce pokemon est KO.");
        	
        	else{
        		c.setPd1(c.getD().getTabP()[i]);
        		c.getD().choisir(i);
        		M_pok.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        		System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        		
        		int pIA=(int)(Math.random()*(4)+1);
        		if(pIA == 1) {
        			System.out.print(c.getD2().getNom()+": ");
        			c.getPd2().competence1(c.getPd1());
        		}	
        		else if(pIA == 2) {
        			System.out.print(c.getD2().getNom()+": ");
        			c.getPd2().competence2(c.getPd1());
        		}
        		else if(pIA == 3) {
        			System.out.print(c.getD2().getNom()+": ");
        			c.getPd2().competence3(c.getPd1());			
        		}
        		else if(pIA == 4) {
        			System.out.print(c.getD2().getNom()+": ");
        			c.getPd2().competence4(c.getPd1());
        		}	
        		M_pok.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        		System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
    
        	
        		if(c.getPd1().getHp()<=0) {
        			M_pok3 mp3 = new M_pok3(f,c,jp,mp);
        			jp.remove(M_pok.this);
        			jp.add(mp3,BorderLayout.SOUTH);
        			f.setC2(jp);
        		}else {
        			jp.remove(M_pok.this);
        			jp.add(mp,BorderLayout.SOUTH);
        			f.setC2(jp);
        		}
        	}
        }
    }
	public class EcouteurBoutonChanger2 implements ActionListener{ 
        public void actionPerformed(ActionEvent clic) {
        	jp.remove(M_pok.this);
			jp.add(mp,BorderLayout.SOUTH);
			f.setC2(jp);
           
        }
    }
	

}
