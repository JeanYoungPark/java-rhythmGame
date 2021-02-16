package dynamic_beat_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	//버튼 이미지들
	private ImageIcon exitBtn = new ImageIcon(Main.class.getResource("../images/exitBtn.png"));
	private ImageIcon exitBtnOn = new ImageIcon(Main.class.getResource("../images/exitBtnOn.png"));
	private ImageIcon startBtn = new ImageIcon(Main.class.getResource("../images/startBtn.png"));
	private ImageIcon startBtnOn = new ImageIcon(Main.class.getResource("../images/startBtnOn.png"));
	private ImageIcon quitBtn = new ImageIcon(Main.class.getResource("../images/quitBtn.png"));
	private ImageIcon quitBtnOn = new ImageIcon(Main.class.getResource("../images/quitBtnOn.png"));
	
	private Image bg = new ImageIcon(Main.class.getResource("../images/introBg.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(exitBtn);
	private JButton startButton = new JButton(startBtn);
	private JButton quitButton = new JButton(quitBtn);

	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		//나가기 버튼 추가
		exitButton.setBounds(1245, 0, 30, 30); //위치 선정
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitBtnOn);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3",false); //호버시 소리 추가
				btnOnMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitBtn);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);
		
		//시작 버튼 추가
		startButton.setBounds(800, 400, 400, 100); //위치 선정
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startBtnOn);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3",false); //호버시 소리 추가
				btnOnMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startBtn);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setVisible(false); //버튼 지우기
				quitButton.setVisible(false); //버튼 지우기
				bg = new ImageIcon(Main.class.getResource("../images/mainBg.jpg")).getImage(); //화면전환
			}
		});
		add(startButton);
		
		//종료 버튼 추가
		quitButton.setBounds(800, 530, 400, 100); //위치 선정
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitBtnOn);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3",false); //호버시 소리 추가
				btnOnMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitBtn);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임종료 이벤트
			}
		});
		add(quitButton);
		
		//메뉴바 배경추가
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseX = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { //드래그 할때마다 좌표를 얻어온다.
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		Music introMusic = new Music("introMusic.mp3", true); // 음악파일 추가해야됨
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		paintComponents(g);// jframe 안에 이미지를 그려주는 것을 의미 (주고 고정되는 이미지 일때 이용)
		this.repaint();
	}

}
