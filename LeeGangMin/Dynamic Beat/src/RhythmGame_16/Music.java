package RhythmGame_16;

import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player;
	private boolean isLoop;
//	private File file;
	private InputStream in;
//	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			in = Main.class.getResourceAsStream("/music/" + name);
			//file = new File(Main.class.getResource().toURI());
//			fis = new FileInputStream(file);
			bis = new BufferedInputStream(in);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if(player == null) return 0;
		
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
			}while(isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}