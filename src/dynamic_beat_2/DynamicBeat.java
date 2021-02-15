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
	
	public void paint(Graphics g) { //��ӹ��� Jframe���� ���ϸ��� ȭ���� �׷��ִ� �Լ��� ��ӵǾ��ִ� �Լ�
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); //�̹��� ũ�� ����
		screenGraphic = screenImage.getGraphics(); //�ҷ�����
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBg, 0, 0, null);
		this.repaint();
	}
	

}
