package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	
	public static void main(String arg[]) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(5);
	}

}
