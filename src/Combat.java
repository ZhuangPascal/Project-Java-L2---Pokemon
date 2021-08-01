
public class Combat {
	private Dresseur d1, d2; //d1 et d2 pour un combat entre deux dresseurs
	private Pokemon pd1 ,pd2; //pd1 et pd2 sont les pokemons au combat du dresseur 1 et 2
	private PanPok p ;

	public Combat(Dresseur d1, Dresseur d2){
		
		this.d1=d1;
		this.d2=d2;
		pd1=d1.getTabP()[0];
		pd2=d2.getTabP()[0];
		
		if(d2.getS()==1) {
			System.out.println("\n\n\n\n\n<<<  UN POKEMON SAUVAGE APPARAIT !!! >>> \n\n\n\n");
			try{
					Thread.sleep(1500); 
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		
		System.out.println("Le combat oppose "+d1.getNom()+" a "+d2.getNom()+" !\n");
		d1.choisir(0);
		d2.choisir(0);
		
		System.out.println("\n"+pd1.getNom()+": "+pd1.getHp()+" HP"+"    "+pd2.getNom()+": "+pd2.getHp()+" HP");
	}
	/*
	public void commencer(Fenetre f) {
		
		System.out.println("Le combat oppose "+d1.getNom()+" a "+d2.getNom()+" !\n");
		d1.choisir(0);
		d2.choisir(0);
		System.out.print("\n");
		this.combat(f);
	}
	
	public void combat(Fenetre f) {
		
		int i=-1,j=-1,k=-1,m=-1;
		int b1=1, b2 ,b3,b4, b5,b6,b7,b8, pIA;
		double pp;
		boolean erreur;
		while(b1==1) {
			b2=1; //pour i==3  
			b3=1; //pour i==1
			b4=1;
			b5=1;
			b6=1;
			b7=1; //
			b8=1;
			pIA=(int)(Math.random()*(4)+1);
			System.out.println("\n"+pd1.getNom()+": "+pd1.getHp()+" HP"+"    "+pd2.getNom()+": "+pd2.getHp()+" HP");
			
			if(d1.etat()==-1) { //s'il reste au moins un pokemon en etat de se battre
				d1.etat();	
				b1=0;
			}
			else if(d2.etat()==-1) { //s'il reste au moins un pokemon en etat de se battre
				System.out.println("Attention, je repete : ");
				d2.etat();
				b1=0;
			}
			if(b1==1 && pd1.getenVie()==1 && pd2.getenVie()==1) { 
			afficher_menu();
			System.out.println("Faites un choix : ");
			
			do {
				Scanner sc = new Scanner(System.in);
				erreur = false;
				try {
					i = sc.nextInt();
				}catch(InputMismatchException e) {
					erreur = true;
				}
			}while(erreur == true);
			
			if(i==1) { //Choix d'utilisation d'une competence
				do {	
				afficher_attaque();
				System.out.println("Faites un choix : ");
				do {
					Scanner sc = new Scanner(System.in);
					erreur = false;
					try {
						j = sc.nextInt();
					}catch(InputMismatchException e) {
						erreur = true;
					}
				}while(erreur == true);
				
				if(j==0) { //retour
					b3=0;
					continue;
				}
				else if(j<=4 && j>=0) { //utilisation d'un competence
					b5=0;
					System.out.print(d1.getNom()+": ");
					if(j==1)
						pd1.competence1(pd2);
					if(j==2)
						pd1.competence2(pd2);
					if(j==3)
						pd1.competence3(pd2);
					if(j==4)
						pd1.competence4(pd2);	
					
					if(d2.getS()==0) { //si l'adversaire n'est pas un pokemon sauvage, le dresseur prend son prochain pokemon
						if(pd2.getHp()<=0) {
							if(d2.etat()!=-1) {
								d2.choisir(d2.etat());
								pd2=d2.getTabP()[d2.etat()];
							}
							b5=1;
						}
					}else { //si c'est un pokemon sauvage, on quitte le combat
						if(pd2.getHp()<=0)
							b5=1;				
					}
					
					b3=0;
				}
				else
					continue;
				
				}while(b3==1);
			}
			else if(i==2) { //Sac

				do {
					System.out.println("_____________________________\n");
					System.out.println(" 1.Potion : "+d1.getPotion()+"\n 2.Pokeball :"+d1.getPokeball()+"\n 0.Retour");
					System.out.println("_____________________________\n");
					System.out.println("Faites un choix : ");
					do {
						Scanner sc = new Scanner(System.in);
						erreur = false;
						try {
							j = sc.nextInt();
						}catch(InputMismatchException e) {
							erreur = true;
						}
					}while(erreur == true);
					if(j==0) {
						b6=0;
						continue;
					}
					else if(j==1) { //Utilisation d'une potion
							do {
							afficher_pokemon(d1);
							if(d1.getPotion()==0) {
								System.out.println("Vous n'avez plus de potion !");
								b7=0;
								continue;
							}
							do {
								Scanner sc = new Scanner(System.in);
								erreur = false;
								try {
									m = sc.nextInt();
								}catch(InputMismatchException e) {
									erreur = true;
								}
							}while(erreur == true);				
							if (m<=d1.getTaille() && m==1) {
								if(d1.getTabP()[0].getHp()>=d1.getTabP()[0].getHpMax()) {
									System.out.println("Ce pokemon a tout ses HP !");
									continue;
								}								
								else
									d1.getTabP()[0].setHp(d1.getTabP()[0].getHp()+((d1.getTabP()[0].getHpMax()*50)/100));						
							}
							else if(m<=d1.getTaille() && m==2 )	{	
								if(d1.getTabP()[0].getHp()==d1.getTabP()[0].getHpMax()) {
									System.out.println("Ce pokemon a tout ses HP !");
									continue;
								}								
								else
									d1.getTabP()[1].setHp(d1.getTabP()[1].getHp()+((d1.getTabP()[1].getHpMax()*50)/100));								
							}
							else if(m<=d1.getTaille() && m==3) {
								if(d1.getTabP()[0].getHp()==d1.getTabP()[0].getHpMax()) {
									System.out.println("Ce pokemon a tout ses HP !");
									continue;
								}								
								else
									d1.getTabP()[2].setHp(d1.getTabP()[2].getHp()+((d1.getTabP()[2].getHpMax()*50)/100));								
							}
							else if(m<=d1.getTaille() && m==4) {
								if(d1.getTabP()[0].getHp()==d1.getTabP()[0].getHpMax()) {
									System.out.println("Ce pokemon a tout ses HP !");
									continue;
								}								
								else
									d1.getTabP()[3].setHp(d1.getTabP()[3].getHp()+((d1.getTabP()[3].getHpMax()*50)/100));								
							}
							else if(m<=d1.getTaille() && m==5) {
								if(d1.getTabP()[0].getHp()==d1.getTabP()[0].getHpMax()) {
									System.out.println("Ce pokemon a tout ses HP !");
									continue;
								}								
								else
									d1.getTabP()[4].setHp(d1.getTabP()[4].getHp()+((d1.getTabP()[4].getHpMax()*50)/100));								
							}
							else if(m<=d1.getTaille() && m==6) {
								if(d1.getTabP()[0].getHp()==d1.getTabP()[0].getHpMax()) {
									System.out.println("Ce pokemon a tout ses HP !");
									continue;
								}								
								else
									d1.getTabP()[5].setHp(d1.getTabP()[5].getHp()+((d1.getTabP()[5].getHpMax()*50)/100));					
							}
							if(m==0) {
								b7=0;
								continue;
							}
								
							if(m>=1 && m<=6) {
								d1.setPotion(d1.getPotion()-1);
									b5=0;
									b6=0;
									b7=0;
									b8=0;
									continue;
							}
							}while(b7!=0);
						}
						else if(j==2) { //Capture d'un pokemon
							do {
								
							if(d1.getTaille()>=6) {
								System.out.println("Votre equipe est deja�complet !");
								b8=0;
								b6=0;
								continue;
							}
							else if(d1.getPokeball()==0) {
								System.out.println("Vous n'avez plus de pokeball !");
								b8=0;
								b6=0;
								continue;
							}
							
							else if(d2.getS()==0) {
								System.out.println("Ce n'est pas un pokemon sauvage !");
								b8=0;
								b6=0;
								continue;
							}
							else {
								d1.setPokeball(d1.getPokeball()-1);
								pp=Math.random();
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
									System.out.println("Felicitation, vous avez capture "+d2.getNom()+" !");
									d1.getTabP()[d1.getTaille()]=d2.getTabP()[0];
									d1.setTaille(d1.getTaille()+1);
									b8=0;
									b6=0;
									b1=0;
									
								}else {
									System.out.println(d2.getNom()+" est ressorti !");
									b8=0;
									b6=0;
									b5=0;
								}			
								}
							}while(b8!=0);
						}
					
					
				}while(b6==1);
			
			}
			else if(i==3) { //Changement du pokemon sur le terrain
				
				do {
					afficher_pokemon(d1);
					System.out.println("Faites un choix : ");
					do {
						Scanner sc = new Scanner(System.in);
						erreur = false;
						try {
							j = sc.nextInt();
						}catch(InputMismatchException e) {
							erreur = true;
						}
					}while(erreur == true);
					
					if(j==0) {//retour
						b2=0;
						continue;
					}
					else if(j>=0 && j<=6 && j<=d1.getTaille()) {
						if(pd1 != d1.getTabP()[j-1] && (d1.getTabP()[j-1].getenVie()==1)) {
							pd1=d1.getTabP()[j-1];
							d1.choisir(j-1);
							b2=0;
							b5=0;
							p= new PanPok(this);
							f.setContentPane(p);

					    }else {
					    	if(d1.getTabP()[j-1].getenVie()==0)
					    		System.out.println("Ce pokemon est KO.");
					    	else
					    		System.out.println("Ce pokemon est deja sur le terrain !");
							continue;
						}
					}
					else
						continue;				
					
				}while(b2==1);			
			}
			
			else if(i==4) { //Abandon du dresseur
				System.out.println("Le dresseur "+d1.getNom()+" abandonne.");
				b1=0;
			}
			
			else
				continue;
			
			//L'attaque de l'ordinateur
			if(pIA == 1 && b1==1 && b5==0) {
				System.out.print(d2.getNom()+": ");
				pd2.competence1(pd1);
			}	
			else if(pIA == 2 && b1==1 && b5==0) {
				System.out.print(d2.getNom()+": ");
				pd2.competence2(pd1);
			}
			else if(pIA == 3 && b1==1 && b5==0) {
				System.out.print(d2.getNom()+": ");
				pd2.competence3(pd1);				
			}
			else if(pIA == 4 && b1==1 && b5==0) {
				System.out.print(d2.getNom()+": ");
				pd2.competence4(pd1);	
			}	
			if(pd1.getHp()<=0) { //Mort d'un pokemon du joueur
				do {
					afficher_pokemon(d1);
					System.out.println("Faites un choix : ");
					do {
						Scanner sc = new Scanner(System.in);
						erreur = false;
						try {
							j = sc.nextInt();
						}catch(InputMismatchException e) {
							erreur = true;
						}
					}while(erreur == true);
				
					if(j==0) {
						System.out.println("Voulez-vous abandonnez ?\n 1.Oui     2.Non\n");
						do {
							Scanner sc = new Scanner(System.in);
							erreur = false;
							try {
								k = sc.nextInt();
							}catch(InputMismatchException e) {
								erreur = true;
							}
						}while(erreur == true);
						if(k==1) {
							b4=0;
							b1=0;
							System.out.println("Le dresseur "+d1.getNom()+" abandonne.\n");
							continue;
						}
					}
					else if(j>=0 && j<=6 && j<=d1.getTaille()) {
						if(pd1 != d1.getTabP()[j-1] && (d1.getTabP()[j-1].getenVie()==1)) {
							pd1=d1.getTabP()[j-1];
							d1.choisir(j-1);
							b4=0;
					    }else {
					    	if(d1.getTabP()[j-1].getenVie()==0)
					    		System.out.println("Ce pokemon est KO.");
					    	else
					    		System.out.println("Ce pokemon est deja sur le terrain !");
							continue;
						}
					}
					else
						continue;				
					
				}while(b4==1);
			}
			
			}
			
		}
		System.out.println("Fin du combat.\nVotre equipe est entierement soigne.\n\n");
		
		for(int l=0;l<d1.getTaille();l++) { //restauration des pokemons du dresseur a la fin d'un combat
				d1.getTabP()[l].setenVie(1);
				d1.getTabP()[l].setHp(d1.getTabP()[l].getHpMax());
				d1.getTabP()[l].setenvie();
			
		}
		afficher_pokemon2(d1);
		
		f.setV(true);
		
	}
	
	//methodes d'affichages
	public void afficher_attaque() { //celui du dresseur 1
		String s = "_____________________________\n";
			   s+= " 1."+pd1.getCpt1()+"\n 2."+pd1.getCpt2()+" \n";
			   s+= " 3."+pd1.getCpt3()+"\n 4."+pd1.getCpt4()+" \n";
			   s+= " 0. Retour \n";
			   s+= "_____________________________\n";
		System.out.println(s);
	}
	
	public void afficher_menu() {
		String s = "_____________________________\n";
			   s+= " 1.Attaque      2.Sac \n";
			   s+= " 3.Pokemon      4.Fuite \n";
			   s+= "_____________________________\n";
		System.out.println(s);
	}
	
	public void afficher_pokemon(Dresseur d) { //celui du dresseur 1
		String s = "Vos pokemons :\n_____________________________\n";
			if(d.getTaille()>=1)
			   s+= " 1."+d1.getTabP()[0].getNom()+"  : "+d1.getTabP()[0].getHp()+"/"+d1.getTabP()[0].getHpMax()+"  level "+d1.getTabP()[0].getLevel()+" "+d1.getTabP()[0].getenvie()+"\n "; //HP à rajouter ?
			if(d.getTaille()>=2)
			   s+= " 2."+d1.getTabP()[1].getNom()+"  : "+d1.getTabP()[1].getHp()+"/"+d1.getTabP()[1].getHpMax()+"  level "+d1.getTabP()[1].getLevel()+" "+d1.getTabP()[1].getenvie()+"\n ";
			if(d.getTaille()>=3)
			   s+= " 3."+d1.getTabP()[2].getNom()+"  : "+d1.getTabP()[2].getHp()+"/"+d1.getTabP()[2].getHpMax()+"  level "+d1.getTabP()[2].getLevel()+" "+d1.getTabP()[2].getenvie()+"\n ";
			if(d.getTaille()>=4)
			   s+= " 4."+d1.getTabP()[3].getNom()+"  : "+d1.getTabP()[3].getHp()+"/"+d1.getTabP()[3].getHpMax()+"  level "+d1.getTabP()[3].getLevel()+" "+d1.getTabP()[3].getenvie()+"\n ";
			if(d.getTaille()>=5)
			   s+= " 5."+d1.getTabP()[4].getNom()+"  : "+d1.getTabP()[4].getHp()+"/"+d1.getTabP()[4].getHpMax()+"  level "+d1.getTabP()[4].getLevel()+" "+d1.getTabP()[4].getenvie()+"\n ";
			if(d.getTaille()>=6)
			   s+= " 6."+d1.getTabP()[5].getNom()+"  : "+d1.getTabP()[5].getHp()+"/"+d1.getTabP()[5].getHpMax()+"  level "+d1.getTabP()[5].getLevel()+" "+d1.getTabP()[5].getenvie()+"\n ";
			   s+= " 0. Retour \n";
			   s+= "_____________________________\n";
		System.out.println(s);
	}
	*/
	
	
	public Pokemon getPd1() {
		return pd1;
	}
	
	public Pokemon getPd2(){
		return pd2;
	}
	
	public PanPok getPanP(){
		return p;
	}
	
	public Dresseur getD() {
		return d1;
	}
	
	public Dresseur getD2() {
		return d2;
	}
	
	public void setPd1(Pokemon p) {
		pd1=p;
	}
	
	public void setPd2(Pokemon p) {
		pd2=p;
	}
}
