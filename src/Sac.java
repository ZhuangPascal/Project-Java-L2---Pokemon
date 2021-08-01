import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;



import javax.swing.JButton;
@SuppressWarnings("serial")

public class Sac extends JPanel {
	private Fenetre f;
	private Combat c;
	private JPanel jp;
	private Menu_P mp;
	private JButton b1;
	private JButton b2;
	
	public Sac(Fenetre f, Combat c, JPanel jp, Menu_P mp) {
		this.f=f;
		this.jp=jp;
		this.c=c;
		this.mp=mp;
		this.setLayout(new GridLayout(2, 1));
		b1 = new JButton("Potion  x"+c.getD().getPotion());
		b2 = new JButton("Pokeball  x"+c.getD().getPokeball());
		JButton b3 = new JButton("Retour");
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		b1.addActionListener(new EcouteurBoutonChanger1());
		b2.addActionListener(new EcouteurBoutonChanger2());
		b3.addActionListener(new EcouteurBoutonChanger3());
		
	}
	
	public class EcouteurBoutonChanger1 implements ActionListener{ // potion
        public void actionPerformed(ActionEvent clic) {
        	if(c.getD().getPotion()!=0) {
        		jp.remove(Sac.this);
        		jp.add(new M_pok2(f,c,jp,mp,Sac.this),BorderLayout.SOUTH);
        		f.setC2(jp);
        	}else
        		System.out.println("Vous n'avez plus de potion.");
        }
    }
	
	public class EcouteurBoutonChanger2 implements ActionListener{ // pokeball
 
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent clic) {
        	if(c.getD().getPokeball()==0)
        		System.out.println("Vous n'avez plus de pokeball.");
        	else {
        		if(c.getD().getTaille()>=6)
        			System.out.println("Votre equipe est deja au complet !");
        		else if(c.getD2().getS()==0)
        			System.out.println("Ce n'est pas un pokemon sauvage !");
        		
        		else {
        			c.getD().setPokeball((c.getD().getPokeball()-1));
        			double pp=Math.random();
					System.out.print("1");
					try{
					     Thread.sleep(700); 
					  }catch(Exception e){
					     e.printStackTrace();
					  } 
					System.out.print(".");
					try{
					     Thread.sleep(700); 
					  }catch(Exception e){
					     e.printStackTrace();
					  }
					System.out.print(". ");
					try{
					     Thread.sleep(700); 
					  }catch(Exception e){
					     e.printStackTrace();
					  }
					
					if(pp>=0.2) {
						System.out.print("2");
						try{
						     Thread.sleep(700); 
						  }catch(Exception e){
						     e.printStackTrace();
						  }
						System.out.print(".");
						try{
						     Thread.sleep(700); 
						  }catch(Exception e){
						     e.printStackTrace();
						  }
						System.out.print(". ");
						try{
						     Thread.sleep(700); 
						  }catch(Exception e){
						     e.printStackTrace();
						  }
					}
					if(pp>=0.4) {
						System.out.print("3");
						try{
						     Thread.sleep(700); 
						  }catch(Exception e){
						     e.printStackTrace();
						  }
						System.out.print(".");
						try{
						     Thread.sleep(700); 
						  }catch(Exception e){
						     e.printStackTrace();
						  }
						System.out.print(". ");
						try{
						     Thread.sleep(700); 
						  }catch(Exception e){
						     e.printStackTrace();
						  }
					}
					if(pp>=0.6) {
						System.out.println("Felicitation, vous avez capture "+c.getD2().getNom()+" !");
						c.getD().getTabP()[c.getD().getTaille()]=c.getD2().getTabP()[0];
						c.getD().setTaille(c.getD().getTaille()+1);
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
						
					}else {
						System.out.println(c.getD2().getNom()+" est ressorti !\n");
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
			        	System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
		        	
			        	if(c.getPd1().getHp()<=0) {
			        		M_pok3 mp3 = new M_pok3(f,c,jp,mp);
			        		jp.remove(Sac.this);
			        		jp.add(mp3,BorderLayout.SOUTH);
			        		f.setC2(jp);
			        	}else {
		        			jp.remove(Sac.this);
		        			jp.add(mp,BorderLayout.SOUTH);
		        			f.setC2(jp);
			        	}
		
					}
						b2.setLabel("Pokeball  x"+c.getD().getPokeball());				
        		}
        	}	
        }
    }
	
	public class EcouteurBoutonChanger3 implements ActionListener{ 
        public void actionPerformed(ActionEvent clic) {
            jp.remove(Sac.this);
            jp.add(mp,BorderLayout.SOUTH);
            f.setC2(jp);
        }
    }
	
	@SuppressWarnings("deprecation")
	public void setB1(String n) {
		b1.setLabel(n);
	}
	
}
