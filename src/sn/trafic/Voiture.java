package sn.trafic;

public class Voiture implements Runnable{
	
	String nom;
	Voie v;	
	String direction;

	public Voiture(String nom, Voie v, String d) {
		super();
		this.nom = nom;
		this.v = v;
		this.direction = d;
	}

	public Voiture(String nom, Voie v) {
		super();
		this.nom = nom;
		this.v = v;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Voie getV() {
		return v;
	}

	public void setV(Voie v) {
		this.v = v;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Voie v =  new Voie();
		Thread MesVoituresd[] = new Thread[5];
		Thread MesVoituresg[] = new Thread[5];
		for (int i =0; i< 5; i++){
		    MesVoituresd[i]= new Thread(new Voiture(String.format("Voiture droite %d ", i) , v, "d"));
		    MesVoituresd[i].start();
		    
		    MesVoituresg[i]= new Thread(new Voiture(String.format("Voiture gauche %d ", i) , v, "g"));
		    MesVoituresg[i].start();
		    }
		
		
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.format("[%s]: Je débute !  \n", this.nom);
		try {
			while(true) {
				Thread.sleep((long)  (50000* Math.random()));
				System.out.format("[%s]: Je demande à rentrer  \n", this.nom);
				this.rentrer();
				System.out.format("[%s]: Je viens d'entrer \n", this.nom);
//				Thread.sleep((long)  (50000* Math.random()));
				Thread.sleep(6000);
				System.out.format("[%s]: Je demande à sortir  \n", this.nom);
				this.v.leave(this);  
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void rentrer() throws InterruptedException{
		while(!(this.v.accept(this))) {
//		    Thread.sleep((long)  (1000* Math.random()));
			Thread.sleep(10000);
		    System.out.format("[%s]  :direction [%s] -> Je redemande à rentrer  \n", this.nom, this.direction);
		}
	}
}