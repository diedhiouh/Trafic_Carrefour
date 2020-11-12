package sn.trafic;

public class Voie {
	
	boolean statut;
	int nbreVoiture;
	Voiture encours = new Voiture(null, null, null);
//	int nbreVehicule;

	public Voie() {
		super();
		this.statut = true;
	}
	
	synchronized boolean accept(Voiture v) {
		
		if(this.statut) {
			System.out.format("[Voirie] :%s accepté \n", v.nom);
			System.out.format("Voiture engagee -> direction [%s] \n", v.direction);
		    encours = v;
			this.statut = false;
			return true;
		}else if(!this.statut && encours.getDirection()==v.getDirection()) {
			System.out.format("[Voirie] :%s accepté \n", v.nom);
			System.out.format("Voiture engagee -> direction [%s] \n", v.direction);
		    encours = v;
			this.statut = false;
			return true;
		}
		else {
		    System.out.format("Voirie : %s refusée \n", v.nom);
			return false;
		}
	}
	
	synchronized void leave(Voiture v) {
		this.statut= true;
		System.out.format("Voirie :[%s] est sortie, -> direction [%s] \n", v.nom, v.direction);

	}
	
	

}
