package sn.trafic;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Route extends JFrame{
	
	Voiture voie = new Voiture(-10,200);
	Voiture voie1 = new Voiture(100,200);
	
//	Voiture v = new Voiture(780,70);
	
	public Route() {
		this.setSize(900,600);
		this.setTitle("Panneau de signalisation ");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(voie);
		this.setVisible(true);
		this.demarre();
	}
	
	//Fonction d'objet voieile
		public void demarre(){
//			Voiture v = new Voiture(780,160);

			int X=voie.getPostX();
			int Y=voie.getPostY();
			int a=this.getWidth();
			int b=this.getHeight();
			
			//Point du panneau de la route
			int panne=200;
			for(int i=0;i<a;i++){
		
				if(true){
					voie.setPostX(X+=6);
					voie.repaint();					
					if(X>=a){
						voie.setPostX(-10);
					}
				}

				try {
			        Thread.sleep(50);
		        } catch (InterruptedException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
		        }
			}	
}
		
		
}
