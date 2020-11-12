package sn.trafic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Voiture extends JPanel implements Runnable{
	
	String nom;
	Voie v;	
	String direction;
	
	public int postX;
	public int postY;

	public int getPostX() {
		return postX;
	}

	public Voiture(int postX, int postY) {
		super();
		this.postX = postX;
		this.postY = postY;
	}

	public void setPostX(int postX) {
		this.postX = postX;
	}

	public int getPostY() {
		return postY;
	}

	public void setPostY(int postY) {
		this.postY = postY;
	}

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
	
	public Voiture() {
		super();
		JPanel pan = new JPanel();
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
		Route r = new Route();
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
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
//	Dessin des voies et routes
		g.setColor(Color.BLACK);
		g.fillRect(-30, 160, 1000, 100);
		g.fillRect(670, 0, 140, 700);
		g.fillRect(140, 0, 140, 700);
		g.setColor(Color.GRAY);
		g.fillOval(190, 200, 25, 25);
		g.fillOval(720, 200, 25, 25);
		
		try{
			Image img= ImageIO.read(new File("images/voiture.png"));
			g.drawImage(img,postX,postY,this);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e);
		}
		
		try{
			Image img2= ImageIO.read(new File("images/voitureg.png"));
			g.drawImage(img2,780,160,this);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
}