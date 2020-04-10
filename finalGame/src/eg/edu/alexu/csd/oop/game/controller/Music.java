package eg.edu.alexu.csd.oop.game.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream fileInputStream = new FileInputStream("Music.mp3");
			Player player = new Player(fileInputStream);
			
			player.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
