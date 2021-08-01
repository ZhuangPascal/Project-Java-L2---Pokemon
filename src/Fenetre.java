import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	private Panneau pan;
	private Paccueil p;
	private JPanel co= new JPanel();
	
	private int x,y;
	private JButton b = new JButton("START");
	
	public Fenetre(Monde m, Dresseur d) {
	
		pan= new Panneau(m,d,this);
		p= new Paccueil(this);

		
		//FENETRE
		x=(m.getX()+2)*pan.getT();
		y=(m.getY()+3)*pan.getT()+10;
		this.setTitle("Pokemon");
		this.setSize(x,y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ACCUEIL
		co.setLayout(new BorderLayout());
		co.add(p, BorderLayout.CENTER);
		co.add(b, BorderLayout.SOUTH);
		b.addActionListener(new EcouteurBoutonChanger());
		b.requestFocus();
		this.setContentPane(co);
		
		//AUTRES
		this.setVisible(true);
		setAlwaysOnTop(true);
	
		
		System.out.println("/!\\ A LIRE SVP /!\\\nBIENVENUE DANS LE MONDE DES POKEMON !!!\nVOTRE OBJECTIF EST DE PERDRE DU TEMPS DANS CETTE MAP EN VOUS PROMENANT OU BIEN EN FAISANT DES COMBATS POKEMON.\nC'EST TOUT, MERCI AHAHA !!!\n(AIDES: Deplacez-vous en utilisant les fleches | Entrez '7' pour un combat contre un dresseur | '9' pour quitter.)\n");
		d.afficher_pokemon(d);
	}
	
	public void setV(boolean b) {
		this.setVisible(b);
	}
	
	public void setC() {
		this.setContentPane(pan);
		this.revalidate();
		pan.requestFocus();
	}
	
	
	public void setC2(JPanel p) {
		this.setContentPane(p);
		this.revalidate();
		p.requestFocus();
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Panneau getP() {
		return pan;
	}
	
	public class EcouteurBoutonChanger implements ActionListener{
        public void actionPerformed(ActionEvent clic) {
            //Appelle la methode de changement de panel
        	/*
        	Fenetre.this.setVisible(false);
        	try{
			     Thread.sleep(8000); 
			  }catch(Exception e){
			     e.printStackTrace();
			  }
			  */
            Fenetre.this.setC();
            Fenetre.this.setVisible(true);
        }
    }
	

	 
}
