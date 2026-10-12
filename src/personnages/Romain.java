package personnages;

import personnages.matos.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements=0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}
	
	private boolean isInvariantVerified() {
		return force>=0;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain" + nom + ":";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>0;
		int force_avant=force;
		this.force=this.force-forceCoup;
		if (force<1) {
			this.parler("J'abandonne !");
		} else {
			this.parler("Aïe");
		}
		assert force<force_avant;
		assert isInvariantVerified();
	}
	
	private void ajouterEquipement(Equipement equip, int indice) {
		assert indice<=2;
		equipements[indice]=equip;
		nbEquipements+=1;
	}
	
	public void sEquiper(Equipement equip) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat "+nom+" est déjà bien équipé !");
			break;
		case 1:
			if (equipements[0]==equip) {
				System.out.println("Le soldat "+nom+" possède déja un "+equipements[0].toString()+"!");
			} else {
				ajouterEquipement(equip, 1);
				System.out.println("Le soldat "+nom+" s'équipe d'un "+equip.toString());
			}
			break;
		default:
			ajouterEquipement(equip, 0);
			System.out.println("Le soldat "+nom+" s'équipe d'un "+equip.toString());
			break;
		}
	}
	
	public static void main(String arg[]) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(5);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
