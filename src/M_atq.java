import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class M_atq extends JPanel{
	private Combat c;
	private Fenetre f;
	private JPanel jp;
	private Menu_P mp;

	
	public M_atq(Fenetre f, Combat c, JPanel jp, Menu_P mp) {
		this.f=f;
		this.c=c;
		this.jp=jp;
		this.mp=mp;
		String cpt1 = c.getPd1().getCpt1();
		String cpt2 = c.getPd1().getCpt2();
		String cpt3 = c.getPd1().getCpt3();
		String cpt4 = c.getPd1().getCpt4();
		
		JButton b1= new JButton(cpt1);
		JButton b2= new JButton(cpt2);
		JButton b3= new JButton(cpt3);
		JButton b4= new JButton(cpt4);
		JButton b5= new JButton("Retour");
				
		this.setLayout(new GridLayout(3, 2));
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		
		b1.addActionListener(new EcouteurBoutonChanger1());
		b2.addActionListener(new EcouteurBoutonChanger2());
		b3.addActionListener(new EcouteurBoutonChanger3());
		b4.addActionListener(new EcouteurBoutonChanger4());
		b5.addActionListener(new EcouteurBoutonChanger5());
		
	}
	
	public class EcouteurBoutonChanger1 implements ActionListener{ // b1 : cpt1
        public void actionPerformed(ActionEvent clic) {
        	System.out.print(c.getD().getNom()+": ");
        	c.getPd1().competence1(c.getPd2());
        	M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        	System.out.print("\n");
        	
        	if(c.getPd2().getHp()<=0) { // si le pokemon de l'adversaire meurt	
				if(c.getD2().getS()==0) {//si l'adversaire n'est pas un pokemon sauvage, le dresseur prend son prochain pokemon
					if(c.getD2().etat()!=-1) {
						c.getD2().choisir(c.getD2().etat());
						c.setPd2(c.getD2().getTabP()[c.getD2().etat()]);
						M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						jp.remove(M_atq.this);
	        			jp.add(mp,BorderLayout.SOUTH);
	        			f.setC2(jp);

					}else {
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
						
					}
				
				}else { //si c'est un pokemon sauvage, on quitte le combat
					if(c.getPd2().getHp()<=0) {
						
						c.getD2().etat();
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
					}
				}	
			}else {
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
				M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
	        	System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
	        	
	        	if(c.getPd1().getHp()<=0) {
	        		M_pok3 mp3 = new M_pok3(f,c,jp,mp);
	        		jp.remove(M_atq.this);
	        		jp.add(mp3,BorderLayout.SOUTH);
	        		f.setC2(jp);
	        	}else {
        			jp.remove(M_atq.this);
        			jp.add(mp,BorderLayout.SOUTH);
        			f.setC2(jp);
	        	}
        	}
        }
    }
	
	public class EcouteurBoutonChanger2 implements ActionListener{ // b2 : cpt2
        public void actionPerformed(ActionEvent clic) {
        	System.out.print(c.getD().getNom()+": ");
        	c.getPd1().competence2(c.getPd2());
        	M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        	System.out.print("\n");
        	
        	if(c.getPd2().getHp()<=0) { // si le pokemon de l'adversaire meurt	
				if(c.getD2().getS()==0) {//si l'adversaire n'est pas un pokemon sauvage, le dresseur prend son prochain pokemon
					if(c.getD2().etat()!=-1) {
						c.getD2().choisir(c.getD2().etat());
						c.setPd2(c.getD2().getTabP()[c.getD2().etat()]);
						M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						jp.remove(M_atq.this);
	        			jp.add(mp,BorderLayout.SOUTH);
	        			f.setC2(jp);

					}else {
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
						
					}
				
				}else { //si c'est un pokemon sauvage, on quitte le combat
					if(c.getPd2().getHp()<=0) {
						c.getD2().etat();
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
					}
				}	
			}else {
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
				M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
	        	System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
	        	
	        	if(c.getPd1().getHp()<=0) {
	        		M_pok3 mp3 = new M_pok3(f,c,jp,mp);
	        		jp.remove(M_atq.this);
	        		jp.add(mp3,BorderLayout.SOUTH);
	        		f.setC2(jp);
	        	}else {
        			jp.remove(M_atq.this);
        			jp.add(mp,BorderLayout.SOUTH);
        			f.setC2(jp);
	        	}
        	}
        }
    }
	
	public class EcouteurBoutonChanger3 implements ActionListener{ // b3 : cpt3
        public void actionPerformed(ActionEvent clic) {
        	System.out.print(c.getD().getNom()+": ");
        	c.getPd1().competence3(c.getPd2());
        	M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        	System.out.print("\n");
        	if(c.getPd2().getHp()<=0) { // si le pokemon de l'adversaire meurt	
				if(c.getD2().getS()==0) {//si l'adversaire n'est pas un pokemon sauvage, le dresseur prend son prochain pokemon
					if(c.getD2().etat()!=-1) {
						c.getD2().choisir(c.getD2().etat());
						c.setPd2(c.getD2().getTabP()[c.getD2().etat()]);
						M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						jp.remove(M_atq.this);
	        			jp.add(mp,BorderLayout.SOUTH);
	        			f.setC2(jp);

					}else {
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
						
					}
				
				}else { //si c'est un pokemon sauvage, on quitte le combat
					if(c.getPd2().getHp()<=0) {
						c.getD2().etat();
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
					}
				}	
			}else {
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
				M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
	        	System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        	
	        	if(c.getPd1().getHp()<=0) {
	        		M_pok3 mp3 = new M_pok3(f,c,jp,mp);
	        		jp.remove(M_atq.this);
	        		jp.add(mp3,BorderLayout.SOUTH);
	        		f.setC2(jp);
	        	}else {
        			jp.remove(M_atq.this);
        			jp.add(mp,BorderLayout.SOUTH);
        			f.setC2(jp);
	        	}
        	}
        }
    }
	
	public class EcouteurBoutonChanger4 implements ActionListener{ // b4 : cpt4
        public void actionPerformed(ActionEvent clic) {
        	System.out.print(c.getD().getNom()+": ");
        	c.getPd1().competence4(c.getPd2());
        	M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        	System.out.print("\n");
        	if(c.getPd2().getHp()<=0) { // si le pokemon de l'adversaire meurt	
				if(c.getD2().getS()==0) {//si l'adversaire n'est pas un pokemon sauvage, le dresseur prend son prochain pokemon
					if(c.getD2().etat()!=-1) {
						c.getD2().choisir(c.getD2().etat());
						c.setPd2(c.getD2().getTabP()[c.getD2().etat()]);
						M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
						jp.remove(M_atq.this);
	        			jp.add(mp,BorderLayout.SOUTH);
	        			f.setC2(jp);
					}else {
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
						
					}
				
				}else { //si c'est un pokemon sauvage, on quitte le combat
					if(c.getPd2().getHp()<=0) {
						c.getD2().etat();
						System.out.println("Vous gagnez le combat.");
						c.getD().afficher_pokemon(c.getD());
						f.setC();
						mp.getMonde().getClip().stop();
						mp.getMonde().playSound("MUSIC/p_town.wav");
					}
				}	
			}else {
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
				M_atq.this.mp.setL("                                                                             "+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"                                                                                                                                                            "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
	        	System.out.println("\n"+c.getPd1().getNom()+": "+c.getPd1().getHp()+" HP"+"    "+c.getPd2().getNom()+": "+c.getPd2().getHp()+" HP");
        		
	        	if(c.getPd1().getHp()<=0) {
	        		M_pok3 mp3 = new M_pok3(f,c,jp,mp);
	        		jp.remove(M_atq.this);
	        		jp.add(mp3,BorderLayout.SOUTH);
	        		f.setC2(jp);
	        	}else {
        			jp.remove(M_atq.this);
        			jp.add(mp,BorderLayout.SOUTH);
        			f.setC2(jp);
	        	}
        	}
        }
    }
	
	public class EcouteurBoutonChanger5 implements ActionListener{ 
        public void actionPerformed(ActionEvent clic) {
            jp.remove(M_atq.this);
            jp.add(mp,BorderLayout.SOUTH);
			f.setC2(jp);
        }
    }
	
	//L'attaque de l'ordinateur

}
