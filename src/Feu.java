
public abstract class Feu extends Pokemon{
	
	public Feu(String nom) {
		super(nom);
		int min=40, max=60; //les stats seront compris entre ces nombres
		
		type=2; //1:Eau  2:Feu  3:Plante
		hp = (int)(Math.random()*(max-min+1)+min); // Math.random()*(MAX-MIN+1)-MIN : nb aleatoire entre MIN et MAX compris
		atq = (int)(Math.random()*(max-min+1)+min);
		def = (int)(Math.random()*(max-min+1)+min);
		vit = (int)(Math.random()*(max-min+1)+min);
		
		atq+=(atq*20)/100; //les pokemons de type Feu ont +20% en attaque
	}
	
	//competences obligatoires pour chaque pokemon
	
	public abstract void competence1(Pokemon p); //Pokemon p est le pokemon qui subie la competence
	public abstract void competence2(Pokemon p);
	public abstract void competence3(Pokemon p);
	public abstract void competence4(Pokemon p);
	
	
	//les affichages
	public String toString(){
		return "Je suis un pokemon de type Feu !";
	}
	public abstract void crie(); //le pokemon crie son nom
	
	
	public void subir(Pokemon p, int degat) { //Pokemon p est le pokemon adverse qui lance l'attaque
		
		int deg=(int)((((level*0.4+2)*atq*degat*5)/(def*50))+2); //formule trouve sur internet pour le calcule des hp.
		
		if(p.type == 1) {
			deg+=(deg*50)/100;
			hp= hp - (deg); 
			System.out.println("C'est tres efficace !");
			System.out.println(p.nom+" inflige -"+deg+" HP a  "+nom+" !\n");
		}else {
			if(p.type==3) {
				deg-=(deg*50)/100;
				hp= hp - deg;
				System.out.println("Ce n'est pas tres efficace ...");
				System.out.println(p.nom+" inflige -"+deg+" HP a  "+nom+" !\n");
			}
			else {
				System.out.println(p.nom+" inflige -"+deg+" HP a  "+nom+" !\n");
				hp= hp - deg;
			}	
		}
		if(hp<=0) {
			hp=0;
			enVie=0;
			System.out.println("Le pokemon "+nom+" est hors combat !");
			p.experience(this);
			envie=" - KO";
		}
	}
	

	
}
