package dynamic_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteImg = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	private int x,y = 580 - (1000/Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
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
		if(y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);;
				}else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void judge() {
		if(y >= 613) {
			System.out.println("Fail");
			close();
		}else if(y >= 600) {
			System.out.println("Good");
			close();
		}else if(y >= 587) {
			System.out.println("Great");
			close();
		}else if(y >= 573) {
			System.out.println("Perfect");
			close();
		}else if(y >= 565) {
			System.out.println("Great");
			close();
		}else if(y >= 550) {
			System.out.println("Good");
			close();
		}else if(y >= 535) {
			System.out.println("Fail");
			close();
		}
	}
}
