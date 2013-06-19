import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Pollux {

	private String message;
	private String morse_encoded;
	private String pollux;
	private int lowerboundrand;
	private int upperboundrand;
	private static String morse_array[][] = {
	        { "a", ".- "   },{ "b", "-... " },{ "c", "-.-. " },{ "d", "-.. "  },
	        { "e", ". "    },{ "f", "..-. " },{ "g", "--. "  },{ "h", ".... " },
	        { "i", ".. "   },{ "j", ".--- " },{ "k", ".-.- " },{ "l", ".-.. " },
	        { "m", "-- "   },{ "n", "-. "   },{ "o", "--- "  },{ "p", ".--. " },
	        { "q", "--.- " },{ "r", ".-. "  },{ "s", "... "  },{ "t", "- "    },
	        { "u", "..- "  },{ "v", "...- " },{ "w", ".-- "  },{ "x", "-..- " },
	        { "y", "-.-- " },{ "z", "--.. " },{ ".", ".-.-.- "},{ ",", "--..-- "},
	        { "?", "..--.. "},{  "'", ".----. "},{ "!", "-.-.-- "},{ " ", " "    },
	        { "/", "-..-. " },{ "(", "-.--. " },{ ")", "-.--.- "},{ "&", ".-... " },
	        { ":", "---... "},{ ";", "-.-.-. "},{ "=", "-...- " },{ "+", ".-.-. " },
	        { "-", "-....- "},{ "_", "..--.- "},{ "\"",  ".-..-. "},{ "$", "...-..- "},
	        { "@", ".--.-. "},{ "0", "----- " },{ "1", ".---- " },{ "2", "..--- " },
	        { "3", "...-- " },{ "4", "....- " },{ "5", "..... " },{ "6", "-.... " },
	        { "7", "--... " },{ "8", "---.. " },{ "9", "----. " },{ "à", ".--.- " },
	        { "ç", "-.-.. " },{ "è", ".-..- " },{ "é", "..-.. " },
	    };
	
	
	public Pollux() { //Default constructor
		
		message = "";
		morse_encoded = "";
		pollux="";
	}
	
	public Pollux(String pmessage, String choice,String choice2) { //Constructor
		
		if(choice.equals("encode") && choice2.equals("figures")){
		message = pmessage;
		morse_encoded = "";
		pollux="";
		lowerboundrand=0;
		upperboundrand=2;
		}
		
		if(choice.equals("encode") && choice2.equals("letters")){
			message = pmessage;
			morse_encoded = "";
			pollux="";
			lowerboundrand=4;
			upperboundrand=10;
			}
		
		if(choice.equals("decode")){
			message = "";
			morse_encoded = "";
			pollux=pmessage;
			}
		
	}
	
	public String getMess() { //Getter : Gets message
		this.fromPolluxtoMorse();
		this.morseDecode();
		return prettyText(this.message);
	}
	
	public String getMorseEncoded() { //Getter : Gets morse_encoded
		this.toMorseCode();
		return this.morse_encoded;
	}
	
	public String getPollux() { //Getter : Gets morse_encoded
		this.toPollux();
		return this.pollux;
	}
	
	public void setMess(String pmessage) { //Setter : Sets message
		this.message = pmessage;
	}
	
	public void setPollux(String ppollux) {
		this.pollux=ppollux;
	}
	
	public void toMorseCode() { //Convert a String to Morse Code TODO: Declare private
		
		char[] mess_array = this.message.toLowerCase().toCharArray(); //Convert message to an array of characters
		
		for(char letter : mess_array){ //for each letter in the array
			for(String sub_array[] : morse_array) {
				String str_letter = String.valueOf(letter); //convert letter into string in order to use equals()
				if( sub_array[0].equals(str_letter) ) {		//if the letter correspond to the symbol in morse_array			
					this.morse_encoded += sub_array[1];			//concatenate morse_encoded with himself and the value of morse code which correspond
					
				}
			}
		}
		
		
		
	}
	
public void morseDecode() {
	String morseDecoded="";
	String letter="";	
	String morsemessage = this.morse_encoded;
	char[] morsemessageArray = morsemessage.toCharArray();
	for(char symbol : morsemessageArray){
		letter += String.valueOf(symbol);
		for(int i=0; i<morse_array.length; i++){
			if(letter.equals(morse_array[i][1]) && symbol == ' '){
				morseDecoded += morse_array[i][0];
				letter="";
			}
		}
	}
	
	this.message=morseDecoded;
	
	}
	

public void fromPolluxtoMorse(){
	
	char[] polluxCodeArray = this.pollux.toCharArray();
	for(char s : polluxCodeArray){
		
        if ( s == '0' || s == '3' || s == '7' || s == '8' || s == 'A' || s =='E' || s =='F' || s == 'M' ||  s =='O' || s =='P' || s =='Q' || s =='X' || s =='Y' ||  s =='Z') {
            this.morse_encoded += ".";}
        
        if ( s == '1' || s == '4' || s == '5' || s == 'B' || s == 'C' || s =='G' || s =='J' || s == 'N' ||  s =='R' || s =='T' || s =='W' ) {
            this.morse_encoded += "-";}
        
        if ( s == '2' || s == '6' || s == '9' || s == 'D' || s == 'H' || s =='I' || s =='K' || s == 'L' ||  s =='S' || s =='U' || s =='V' ) {
            this.morse_encoded +=" ";}
	}
	
	
}

public long random(int upperbound, int lowerbound) {
	return Math.round(lowerbound + Math.random()*(upperbound-lowerbound));
	
}

public void toPollux() {
	
	String mess = this.getMorseEncoded();
	char[] mess_array = mess.toCharArray();
	
	for(char morse_symb : mess_array) {
		
		if(morse_symb == '.') {
			int rand = (int)random(0,13);
			if(this.lowerboundrand==0){
			rand = (int)random(lowerboundrand,upperboundrand + (int)random(0,1)); 
			}
			
			if(this.lowerboundrand==4){
			rand = (int)random(lowerboundrand,upperboundrand + (int)random(0,3)); 
				}
			
			switch(rand){
			
			case 0:
			this.pollux += "0";
			break;
			case 1:
			this.pollux += "3";
			break;
			case 2:
			this.pollux += "7";
			break;
			case 3:
			this.pollux += "8";
			break;
			case 4:
			this.pollux += "A";
			break;
			case 5:
			this.pollux += "E";
			break;
			case 6:
			this.pollux += "F";
			break;
			case 7:
			this.pollux += "M";
			break;
			case 8:
			this.pollux += "O";
			break;
			case 9:
			this.pollux += "P";
			break;
			case 10:
			this.pollux += "Q";
			break;
			case 11:
			this.pollux += "X";
			break;
			case 12:
			this.pollux += "Y";
			break;
			case 13:
			this.pollux += "Z";
			break;
			
			}
			
		}
		if(morse_symb == '-') {
			
		int	rand = (int)random(lowerboundrand,upperboundrand);
			
			switch(rand){
			
			case 0:
			this.pollux += "1";
			break;
			case 1:
			this.pollux += "4";
			break;
			case 2:
			this.pollux += "5";
			break;
			case 3:
			this.pollux += "B";
			break;
			case 4:
			this.pollux += "C";
			break;
			case 5:
			this.pollux += "G";
			break;
			case 6:
			this.pollux += "J";
			break;
			case 7:
			this.pollux += "N";
			break;
			case 8:
			this.pollux += "R";
			break;
			case 9:
			this.pollux += "T";
			break;
			case 10:
			this.pollux += "W";
			break;
			
			}		
		
		}
		
		if(morse_symb == ' ') {
			
			int rand = (int)random(lowerboundrand,upperboundrand);
			
			switch(rand){
			
			case 0:
			this.pollux += "2";
			break;
			case 1:
			this.pollux += "6";
			break;
			case 2:
			this.pollux += "9";
			break;
			case 3:
			this.pollux += "D";
			break;
			case 4:
			this.pollux += "H";
			break;
			case 5:
			this.pollux += "I";
			break;
			case 6:
			this.pollux += "K";
			break;
			case 7:
			this.pollux += "L";
			break;
			case 8:
			this.pollux += "S";
			break;
			case 9:
			this.pollux += "U";
			break;
			case 10:
			this.pollux += "V";
			break;
			
			}		
		
		}
	
	}

	
}

public String prettyText(String txt){
	
	String output="";
	char[] array = txt.toCharArray();
	
	array[0] = txt.toUpperCase().charAt(0);
	int i=0;
	for(char letter : array){
		i++;
		if ( (letter=='.' || letter=='!' || letter =='?') && i< (array.length -2)) {
		
			if(array[i]==' '){
				array[i+1]=	txt.toUpperCase().charAt(i+1);
			}
			else{ //TODO Add char space ' ' after . ! ?	
				
			}
			
		}
		
	
	}
	
	output = String.valueOf(array);
	
	return output;
	
}

public void PlayMorse() throws InterruptedException {
	
	char[] morse_array= this.morse_encoded.toCharArray();
	
	
	for(char symbol : morse_array){
		
		if (symbol == '.'){
			Son court = new Son(1);
			court.play();
		Thread.sleep(300);
		}
		
		if (symbol == '-'){
			Son lon = new Son(2);
			lon.play();
			Thread.sleep(500);
		}
		
		if (symbol == ' '){
			Son silence = new Son(0);
			silence.play();
			Thread.sleep(500);
		}
			
		
	}
	
	
	
	
}

}

	
