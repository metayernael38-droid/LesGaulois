package test_fonctionnel;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import personnages.matos.Chaudron;

public class TestGaulois {
	
	public static void main(String[] arg) {
		Chaudron chaudron = new Chaudron(0, 0);
		Druide panoramix= new Druide("Panoramix",2,chaudron);
		Gaulois asterix= new Gaulois("Astérix", 8);
		Gaulois obelix= new Gaulois("Obélix", 16);
		Romain minus= new Romain("Minus", 6);
		Romain brutus= new Romain("Brutus", 14);
		
		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirait d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		System.out.println("Dans la forêt " + asterix.toString() + " et " + obelix.getNom()
		+ " tombent nez à nez avec le romain " + minus.getNom() + ".");
		while (minus.getForce()>=1) {
			asterix.frapper(minus);
		}
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		while (brutus.getForce()>=1) {
			asterix.frapper(brutus);
		}
	
	}
}
