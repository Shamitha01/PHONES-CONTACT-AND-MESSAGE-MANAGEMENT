package project;
	import java.io.File;
	import java.io.IOException;
	import java.util.Scanner;
	import javax.sound.sampled.*;

	public class Songs {
	 public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	 {
		 Scanner scanner = new Scanner(System.in);
		  File file = new File("Islabonita.wav");
		  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		  Clip clip = AudioSystem.getClip();
		  clip.open(audioStream);
	
		  String response = "";
		 
		  while(!response.equals("Q")) {
		   System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
		   System.out.print("Enter your choice: ");
		   
		   response = scanner.next();
		   response = response.toUpperCase();
		   
		   switch(response) {
		    case ("P"): clip.start();
		    break;
		    case ("S"): clip.stop();
		    break;
		    case ("R"): clip.setMicrosecondPosition(0);
		    break;
		    case ("Q"): clip.close();
		    break;
		    default: System.out.println("Not a valid response");
		   }
		    
	 }
	System.out.println("\n"+Coloured.ANSI_BG_BLUE +"--------------------------BYEE--------------------------------------"+Coloured.ANSI_RESET);
	}
	}
