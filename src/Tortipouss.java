
public class Tortipouss extends Plante{
	protected static int cpt=1; //compteur
	
	public Tortipouss() {
		super("Tortipouss");
		cpt1="Charge";
		cpt2="Vol-vie";
		cpt3="Morsure";
		cpt4="Tranch'Herbe";
		id=cpt++;
		hpMax=hp;
	}
	
	//Competences 
	public void competence1(Pokemon p) { //Pokemon p est le pokemon qui subie la competence
		System.out.println(nom+" attaque "+cpt1+" !");
		if(Math.random()>0.05) { //une probabilite de 5% d'echouer
			p.subir(this,35);
			try{
			     Thread.sleep(1000); 
			  }catch(Exception e){
			     e.printStackTrace();
			  }
		}
		else
			System.out.println("Le pokemon "+p.nom+" esquive l'attaque !");
	}
	public void competence2(Pokemon p) {
		System.out.println(nom+" utilise "+cpt2+" !");
		if(Math.random()>0.1) { //proba de 10% d'echouer
			p.subir(this,40);
			try{
			     Thread.sleep(1000); 
			  }catch(Exception e){
			     e.printStackTrace();
			  }
		}
		else
			System.out.println("Le pokemon "+p.nom+" esquive l'attaque !");
	}
	public void competence3(Pokemon p) {
		System.out.println(nom+" lance "+cpt3+" !");
		if(Math.random()>0.1) { //proba de 10% d'echouer
			p.subir(this,40);
			try{
			     Thread.sleep(1000); 
			  }catch(Exception e){
			     e.printStackTrace();
			  }
		}
		else
			System.out.println("Le pokemon "+p.nom+" esquive l'attaque !");
	}	
	public void competence4(Pokemon p) {
		System.out.println(nom+" lance "+cpt4+" !");
		if(Math.random()>0.2) { //proba de 20% d'echouer
			p.subir(this,55);
			try{
			     Thread.sleep(1000); 
			  }catch(Exception e){
			     e.printStackTrace();
			  }
		}
		else
			System.out.println("Le pokemon "+p.nom+" esquive l'attaque !");
	}
	
	//les affichages
	public String toString() {
		return "Tortipouss";
	}
	public void crie() {
		System.out.println(this.toString());
	}
	
}
