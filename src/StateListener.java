import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StateListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - état : " + ((JRadioButton)e.getSource()).isSelected());

	}

}
