/*1. java audio sound*/
import java.io.*;
import sun.audio.*;

public class JavaAudioPlaySoundExample
{
	public static String gongFile = "";//file name
	 public static AudioStream audioStream;
  public static void main(String[] args) 
  throws Exception
  {
    // open the sound file as a Java input stream
    InputStream in = new FileInputStream(gongFile);

    // create an audiostream from the inputstream
   audioStream = new AudioStream(in);

   
  }
  
  public void start()
  {
	  // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audioStream);
  }
  
  public void stop()
  {
	  // play the audio clip with the audioplayer class
	    AudioPlayer.player.stop(audioStream);
  }
  
}
================================
/*main*/
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		
		
		JavaAudioPlaySoundExample example=new JavaAudioPlaySoundExample();
		example.gongFile="map.wav";
		example.main(null);
		
		example.start();
		
	}

}
===================================
/*step to execute program*/
1.javac JavaAudioPlaySoundExample.java
2.gescoe@node13:~/Desktop/cl3_programs/audio$ javac Main.java 
3.oe@node13:~/Desktop/cl3_programs/audio$ java Main


