package eg.edu.alexu.csd.oop.game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.xml.DOMConfigurator;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.view.Circus;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Main implements Runnable {

	 private static Logger log = Logger.getLogger(Main.class);

	@Override
	public void run() {
		
		final JMenuBar menuBar = new JMenuBar();
		final JFrame f = new JFrame();
		JMenu menu = new JMenu("File");
		final JMenuItem pauseMenuItem = new JMenuItem("Pause");
		final JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem easyMenuItem = new JMenuItem("New Easy Game");
		JMenuItem mediumMenuItem = new JMenuItem("New Medium Game");
		JMenuItem hardMenuItem = new JMenuItem("New Hard Game");
		menu.addSeparator();

		menu.add(easyMenuItem);
		menu.add(mediumMenuItem);
		menu.add(hardMenuItem);
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);

		menuBar.add(menu);

		final GameController gameController = GameEngine.start("Circus Of Plates",
				new eg.edu.alexu.csd.oop.game.view.Circus(1900, 955, "hard"), menuBar, f.EXIT_ON_CLOSE);

		easyMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Start an easy Game");

				gameController.changeWorld(new eg.edu.alexu.csd.oop.game.view.Circus(1900, 955, "easy"));

			}
		});
		mediumMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Start a medium Game");

				gameController.changeWorld(new eg.edu.alexu.csd.oop.game.view.Circus(1900, 955, "medium"));

			}
		});
		hardMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("Start a hard Game");

				gameController.changeWorld(new eg.edu.alexu.csd.oop.game.view.Circus(1900, 955, "hard"));

			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});

	}

}
