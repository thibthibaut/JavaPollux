import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Fenetre extends JFrame {
	private JPanel container = new JPanel();
	private JRadioButton choix1 = new JRadioButton("Figures");
	private JRadioButton choix2 = new JRadioButton("Letters");
	private JLabel label = new JLabel("Pollux !");
	private ButtonGroup bg = new ButtonGroup();
	private JTextField text1 = new JTextField("Valeur à encoder");
	private JTextField text2 = new JTextField("Valeur encodée");
	private JButton butt_encode = new JButton("Encode");
	private JButton butt_decode = new JButton("Decode");
	

	public Fenetre(){
		this.setTitle("PolluX");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		
		bg.add(choix1);
		bg.add(choix2);
		
		choix1.setSelected(true);
		choix1.addActionListener(new StateListener());
		choix2.addActionListener(new StateListener());
		
		Font police = new Font("Arial", Font.BOLD, 14);
		text1.setFont(police);
		text1.setPreferredSize(new Dimension(450, 30));
		

		JPanel title = new JPanel();
		title.add(label);
		container.add(title,BorderLayout.NORTH);
		
		JPanel champ1= new JPanel();
		champ1.add(text1);
		container.add(champ1,BorderLayout.CENTER);
		champ1.add(butt_encode);
		champ1.add(butt_decode);
		
		
		JPanel champ2 = new JPanel();
		champ2.add(text2);
		//container.add(champ2,BorderLayout.SOUTH);
		
		this.setContentPane(container);
		this.setVisible(true);
		
}
}