import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Son {

	private int duree;
	private String value="";
	
	public Son(int pduree){  //Constructor	
		this.duree=pduree;
		}
	
	
	public void setDuree(int param) { //Setter
		this.duree=param;
	}

	public void play(){
		
		if (this.duree == 1)
			this.value="short.wav";
		if (this.duree == 2)
			this.value="long.wav";
		if (this.duree == 0)
			this.value="silence.wav";
		
		try {
	         // Open an audio input stream.
			
			
			
            File soundFile = new File(this.value);
    	    
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	    	  
	    	 // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }

}


