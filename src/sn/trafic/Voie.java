package sn.trafic;

public class Voie {
	
	boolean statut;
	
//	int nbreVehicule;

	public Voie() {
		super();
		this.statut = true;
	}
	
	synchronized boolean accept(Voiture v) {
		if(this.statut) {
			System.out.format("[Voirie] :%s accepté \n", v.nom);
			System.out.format("Voiture engagee \n");
			this.statut = false;
			return true;
		}else {
		    System.out.format("Voirie : %s refusée \n", v.nom);
			return false;
		}
	}
	
	synchronized void leave(Voiture v) {
		this.statut= true;
		System.out.format("Voirie :[%s] est sortie \n", v.nom);

	}
	
	

}
