package dynamic_beat_6;

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

	// ��ư �̹�����
	private ImageIcon exitBtn = new ImageIcon(Main.class.getResource("../images/exitBtn.png"));
	private ImageIcon exitBtnOn = new ImageIcon(Main.class.getResource("../images/exitBtnOn.png"));
	private ImageIcon startBtn = new ImageIcon(Main.class.getResource("../images/startBtn.png"));
	private ImageIcon startBtnOn = new ImageIcon(Main.class.getResource("../images/startBtnOn.png"));
	private ImageIcon quitBtn = new ImageIcon(Main.class.getResource("../images/quitBtn.png"));
	private ImageIcon quitBtnOn = new ImageIcon(Main.class.getResource("../images/quitBtnOn.png"));

	//ȭ��ǥ
	private ImageIcon leftBtn = new ImageIcon(Main.class.getResource("../images/leftArrow.png"));
	private ImageIcon leftBtnOn = new ImageIcon(Main.class.getResource("../images/leftArrowOn.png"));
	private ImageIcon rightBtn = new ImageIcon(Main.class.getResource("../images/rightArrow.png"));
	private ImageIcon rightBtnOn = new ImageIcon(Main.class.getResource("../images/rightArrowOn.png"));
	
	private Image titleImg = new ImageIcon(Main.class.getResource("../images/elevateTitleImg.png")).getImage();
	private Image selectedImg = new ImageIcon(Main.class.getResource("../images/elevateStartImg.png")).getImage();
	private Image bg = new ImageIcon(Main.class.getResource("../images/introBg.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(exitBtn);
	private JButton startButton = new JButton(startBtn);
	private JButton quitButton = new JButton(quitBtn);
	private JButton leftButton = new JButton(leftBtn);
	private JButton rightButton = new JButton(rightBtn);

	private int mouseX, mouseY;

	private boolean isMainScreen = false;

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

		// ������ ��ư �߰�
		exitButton.setBounds(1245, 0, 30, 30); // ��ġ ����
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitBtnOn);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
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

		// ���� ��ư �߰�
		startButton.setBounds(800, 400, 400, 100); // ��ġ ����
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startBtnOn);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startBtn);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setVisible(false); // ��ư �����
				quitButton.setVisible(false); // ��ư �����
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				bg = new ImageIcon(Main.class.getResource("../images/mainBg.jpg")).getImage(); // ȭ����ȯ
				isMainScreen = true;
			}
		});
		add(startButton);

		// ���� ��ư �߰�
		quitButton.setBounds(800, 530, 400, 100); // ��ġ ����
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitBtnOn);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitBtn);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// �������� �̺�Ʈ
			}
		});
		add(quitButton);
		
		// ���� ȭ��ǥ ��ư �߰�
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); // ��ġ ����
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftBtnOn);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftBtn);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//���� ��ư �̺�Ʈ
			}
		});
		add(leftButton);
		
		// ������ ȭ��ǥ ��ư �߰�
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); // ��ġ ����
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightBtnOn);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightBtn);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//������ ��ư �̺�Ʈ
			}
		});
		add(rightButton);
				
		// �޴��� ����߰�
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
			public void mouseDragged(MouseEvent e) { // �巡�� �Ҷ����� ��ǥ�� ���´�.
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		Music introMusic = new Music("introMusic.mp3", true); // �������� �߰��ؾߵ�
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(bg, 0, 0, null); //add�Լ� ����X, ���� ������ ��
		if (isMainScreen) {
			g.drawImage(selectedImg, 340, 140, null);
			g.drawImage(titleImg, 340, 80, null);
		}
		paintComponents(g);// jframe �ȿ� �̹����� �׷��ִ� ���� �ǹ� (�ְ� �����Ǵ� �̹��� �϶� �̿�, add�Լ� ����� �� ���)
		this.repaint();
	}

}