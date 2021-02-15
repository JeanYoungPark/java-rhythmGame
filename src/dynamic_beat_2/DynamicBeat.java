package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; 
	
	private Image introBg;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introBg  = new ImageIcon(Main.class.getResource("../images/introBg.jpg")).getImage();
	}
	
	public void paint(Graphics g) { //상속받은 Jframe에서 제일먼저 화면을 그려주는 함수로 약속되어있는 함수
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); //이미지 크기 설정
		screenGraphic = screenImage.getGraphics(); //불러오기
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBg, 0, 0, null);
		this.repaint();
	}
	

}
