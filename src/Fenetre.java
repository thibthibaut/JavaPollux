import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener{
	private JPanel container = new JPanel();
	private JRadioButton choix1 = new JRadioButton("Figures");
	private JRadioButton choix2 = new JRadioButton("Letters");
	private JLabel label = new JLabel("Welcome to PolluX !");
	private ButtonGroup bg = new ButtonGroup();
	private JTextArea text1 = new JTextArea("Try me !");
	private JScrollPane scroll = new JScrollPane(text1);
	private JTextArea text2 = new JTextArea();
	private JScrollPane scroll2 = new JScrollPane(text2);
	private JButton butt_encode = new JButton("Encode");
	private JButton butt_decode = new JButton("Decode");
	private String choice="figures";
	public Fenetre(){
		this.setTitle("PolluX");
		this.setSize(520, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		
		bg.add(choix1);
		bg.add(choix2);
		
		choix1.setSelected(true);
		choix1.addActionListener(new StateListener1());
		choix2.addActionListener(new StateListener2());
		
		
		butt_encode.addActionListener(this);
		butt_decode.addActionListener(this);
		
		Font police = new Font("Arial", Font.BOLD, 14);
		text1.setFont(police);
		text1.setColumns(40);
		text1.setRows(5);
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		
		
		text2.setFont(police);
		text2.setColumns(40);
		text2.setRows(5);
		text2.setLineWrap(true);
		text2.setWrapStyleWord(true);
		
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		

		JPanel title = new JPanel();
		title.add(label);
		container.add(title,BorderLayout.NORTH);
		
		JPanel champ1= new JPanel();
		champ1.add(scroll);
		champ1.add(butt_encode);
		champ1.add(butt_decode);
		champ1.add(choix1);
		champ1.add(choix2);
		container.add(champ1,BorderLayout.CENTER);
		
		JPanel champ2 = new JPanel();
		champ2.add(scroll2);
		container.add(champ2,BorderLayout.SOUTH);
		
		this.setContentPane(container);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	


@Override
public void actionPerformed(ActionEvent arg0) {
	
	
	
	if(arg0.getSource() == butt_encode){
	Pollux pol = new Pollux(text1.getText(),"encode",this.choice);
	text2.setText(pol.getPollux());
	}
	

	if(arg0.getSource() == butt_decode){
		Pollux pol = new Pollux(text1.getText(),"decode","");
		text2.setText(pol.getMess());
		}
	 
}

class StateListener1 implements ActionListener{
    

	public void actionPerformed(ActionEvent e) {
      
      if (((JRadioButton)e.getSource()).isSelected()==true) {
    	 choice="figures";
      }
    }
  }


class StateListener2 implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      
      if (((JRadioButton)e.getSource()).isSelected()==true) {
    	  choice="letters";
      }
    }
  }
}
