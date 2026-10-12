package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		int case_pointee= 0;
		while (this.villageois[case_pointee]!=null) {
			case_pointee+=1;
		}
		this.villageois[case_pointee]=gaulois;
		this.nbVillageois+=1;
		gaulois.setVillage(this);
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois>=1 && numVillageois<=this.nbVillageois) {
			return this.villageois[numVillageois-1];
		} else {
			System.out.println("Il n'y a pas  autant d'habitant dans notre village !");
			return null;
		}
	}
	
	public void afficherVillage() {
		System.out.println("le "+this.nom+" a "+this.nbVillageois+" et a pour chef "+this.chef.getNom()+".");
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le "+this.nom+" du chef "+this.chef.getNom()+" vivent les légendaires gaulois :");
		for (Gaulois gaulois : villageois) {
			if (gaulois != null) {
				System.out.println("- "+gaulois.getNom());
			}
		}
	}
	
	public static void main(String arg[]) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
		village.trouverVillageois(30);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		abraracourcix.sePrésenter();
		asterix.sePrésenter();
		doublepolemix.sePrésenter();
		
	}

}
