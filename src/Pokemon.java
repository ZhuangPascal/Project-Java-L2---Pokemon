
public abstract class Pokemon {
	protected String nom;
	protected int id;
	protected int level;
	protected int exp;
	protected int hp,atq,def,vit;
	protected int hpMax;
	protected int type; //1:Eau  2:Feu  3:Plante
	protected int enVie;
	protected String cpt1,cpt2,cpt3,cpt4; //nom des competences
	protected String envie;
	
	public Pokemon(String nom) {
		this.nom=nom;
		level=1;
		exp=0;
		enVie=1;
		envie="    ";
		//type, hp, atq, def et vit seront initialisees dans les classes filles( Eau, Feu, Plante)
	}
	
	public void experience(Pokemon p) { //experience gagne apres un combat
		System.out.println(nom+" gagne "+p.level*40+" points d'experience.");
		exp = exp + p.level*100; //le pokemon gagne 40*le level point d'exp du pokemon passe en parametre
		if(exp>= level*100) { //le pokemon augmente son level si son exp est superieur a level*100 (100 exp pour le lv2, 200 pour le lv3...)
			System.out.println("Felicitation, "+nom+" gagne un niveau de combat !");
			level++;
			exp=0;
			this.aug_stat();
		}
		System.out.println("");
	}
	
	public void aug_stat() { //augmentation des statistiques du pokemon
		hpMax+=3;
		hp+=3;
		atq+=2;
		def+=2;
		vit+=2;
	}
	
	public String toString(){ 
		return "Je suis un pokemon !";
	}
	
	public abstract void crie(); //le pokemon crie son nom
	
	public abstract void subir(Pokemon p, int degat);// utiliser dans les competences
	
	public abstract void competence1(Pokemon p); //Pokemon p est le pokemon qui subie la competence
	public abstract void competence2(Pokemon p);
	public abstract void competence3(Pokemon p);
	public abstract void competence4(Pokemon p);
	
	//accesseurs
	public String getNom() {
		return nom;
	}
	
	public String getStat() {
		String s ="Level : "+level+"\n";
			   s+="Exp : "+exp+"\n";
			   s+="Hp : "+hp+"\n";
			   s+="Atq : "+atq+"\n";
			   s+="Def : "+def+"\n";
			   s+="Vit : "+vit+"\n";
		return s;
	}
	
	public int getId() {
		return id;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getenVie() {
		return enVie;
	}
	
	public String getenvie() {
		return envie;
	}
	
	public String getCpt1(){
		return cpt1;
	}
	public String getCpt2(){
		return cpt2;
	}
	public String getCpt3(){
		return cpt3;
	}
	public String getCpt4(){
		return cpt4;
	}
	
	public int getLevel() {
		return level;
	}
	public int getHpMax() {
		return hpMax;
	}
	public void setHp(int hp) {
		this.hp=hp;
	}
	public void setenVie(int i) {
		enVie=i;
	}
	public void setenvie() {
		envie="    ";
	}
}
