import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ItemState implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
		System.out.println("Choix :" + e.getItem());

	}

}
