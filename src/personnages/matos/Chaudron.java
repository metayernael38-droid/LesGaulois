package personnages.matos;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion=quantite;
		this.forcePotion=forcePotion;
	}
	
	public Boolean resterPotion() {
		if (this.quantitePotion==0) {
			return false;}
		else {
			return true;
		}
	}
	
	public int prendreLouche() {
		if (!resterPotion()) {
			this.forcePotion=0;
		}
		return this.forcePotion;
	}
	
}
