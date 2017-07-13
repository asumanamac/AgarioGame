package Game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;


public class Sound {
	public static Clip clipa;
	static boolean musicPlay = true;
	  static Clip clip;

	

public static void TimeSound() throws Exception {
		try {
			File f = new File("sound//Time_wav.wav");
			if (f.exists()) {
				AudioInputStream audio = AudioSystem.getAudioInputStream(f);
				clipa = AudioSystem.getClip();
				clipa.open(audio);
				clipa.loop(100);
				
				clipa.start();

			}

		}

		catch (UnsupportedAudioFileException uae) {
			System.out.println(uae);
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (LineUnavailableException lua) {

		}
	}

public static void ButtonSound() throws Exception {
	try {
		File f = new File("sound//ButtonSound.wav");
		if (f.exists()) {
			AudioInputStream audio = AudioSystem.getAudioInputStream(f);
			clipa = AudioSystem.getClip();
			clipa.open(audio);
			clipa.loop(100);
			
			clipa.start();

		}

	}

	catch (UnsupportedAudioFileException uae) {
		System.out.println(uae);
	} catch (IOException ioe) {
		System.out.println(ioe);
	} catch (LineUnavailableException lua) {

	}
}

	
	public static void playSound(){
		
		 try {
			 //File f = new File("sound//Time_wav.wav");
	        // URL url = Sound.class.getClass().getClassLoader().getResource("sound/Time_wav.wav");
			 File f = new File("sound//Time_wav.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(f);
	         // Get a sound clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         
	         FloatControl gainControl = (FloatControl) clip
						.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.

	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
	public static void stopClip()
	{
		if(clip.isRunning())
			clip.stop();
	}




	}




