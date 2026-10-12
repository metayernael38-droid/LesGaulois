package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village=null;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village=village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois" + nom + ":";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		int forceCoup = (force*effetPotion) / 3;
		if (effetPotion>1) {
			this.effetPotion-=1;
		}
		romain.recevoirCoup(forceCoup);
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	
	public void sePrésenter() {
		if (village == null) {
			this.parler("Bonjour,  je m'appelle "+nom+". Je voyage de villages en villages.");
		}else if (this==this.village.getChef()) {
			this.parler("Bonjour, je m'appelle "+nom+". Je suis le chef du village :"+village.getNom()+".");
		} else {
			this.parler("Bonjour, Je m'appelle "+nom+". J'habite le village :"+village.getNom()+".");
		}
	}

	public static void main(String[] arg) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.toString());
	}

}
