package dynamic_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteImg = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	private int x,y = 580 - (1000/Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			this.x = 228;
		}else if(noteType.equals("D")) {
			this.x = 332;
		}else if(noteType.equals("F")) {
			this.x = 436;
		}else if(noteType.equals("Space")) {
			this.x = 540;
		}else if(noteType.equals("J")) {
			this.x = 744;
		}else if(noteType.equals("K")) {
			this.x = 848;
		}else if(noteType.equals("L")) {
			this.x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space")) {
			g.drawImage(noteImg,x,y,null);
		}else {
			g.drawImage(noteImg,x,y,null);
			g.drawImage(noteImg,x+100,y,null);
		}
		
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
