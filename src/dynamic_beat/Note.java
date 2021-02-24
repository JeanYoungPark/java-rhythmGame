package dynamic_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteImg = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	private int x,y = 580 - 1000/Main.SLEEP_TIME * Main.NOTE_SPEED;
	private String noteType;
	
	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("short")) {
			g.drawImage(noteImg,x,y,null);
		}else if(noteType.equals("long")) {
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
