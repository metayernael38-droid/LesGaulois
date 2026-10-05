package personnages;

import personnages.matos.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;

	public Druide(String nom, int force, Chaudron chaudron) {
		this.nom = nom;
		this.force = force;
		this.chaudron = chaudron;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le druide" + nom + ":";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concocté "+quantite+" doses de potion magique. Elle a une force de "+forcePotion+".");
	}
	
	public void booster(Gaulois gaulois) {
		boolean contientPotion=this.chaudron.resterPotion();
		String nomGaulois= gaulois.getNom();
		if (contientPotion) {
			if (nomGaulois=="Obélix") {
				this.parler("Non "+nomGaulois+" Non !... Et tu le sait très bien !");
			}
			else {
				int forcePotion= this.chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				this.parler("Tiens "+nomGaulois+", un peu de potion magique.");
			}
		}
		else {
			this.parler("Désolé "+nomGaulois+" il n'y a plus une seule goutte de potion.");
		}
	}

}
