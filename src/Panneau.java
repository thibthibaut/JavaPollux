import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Panneau extends JPanel{
	
	public void paintComponent(Graphics g){
	    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
	    System.out.println("Je suis exécutée !"); 
	    int x1 = this.getWidth()/4;
	    int y1 = this.getHeight()/4;                      
	    Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.red);
	    g.drawString("Welcome to PolluX !!", 5, 20);
	    
	}
}
