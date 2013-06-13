import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	public Fenetre(){
		
		this.setVisible(true);
		this.setTitle("PolluX v1.0");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
	    this.setContentPane(new Panneau());               
	   
	}
	

}
