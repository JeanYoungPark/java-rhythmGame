package dynamic_beat_11;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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

	// ȭ��ǥ
	private ImageIcon leftBtn = new ImageIcon(Main.class.getResource("../images/leftArrow.png"));
	private ImageIcon leftBtnOn = new ImageIcon(Main.class.getResource("../images/leftArrowOn.png"));
	private ImageIcon rightBtn = new ImageIcon(Main.class.getResource("../images/rightArrow.png"));
	private ImageIcon rightBtnOn = new ImageIcon(Main.class.getResource("../images/rightArrowOn.png"));

	// ���� ���̵� ��ư
	private ImageIcon easyBtn = new ImageIcon(Main.class.getResource("../images/easyBtn.png"));
	private ImageIcon easyBtnOn = new ImageIcon(Main.class.getResource("../images/easyBtnOn.png"));
	private ImageIcon hardBtn = new ImageIcon(Main.class.getResource("../images/hardBtn.png"));
	private ImageIcon hardBtnOn = new ImageIcon(Main.class.getResource("../images/hardBtnOn.png"));

	// �ڷΰ��� ��ư
	private ImageIcon backBtn = new ImageIcon(Main.class.getResource("../images/backBtn.png"));
	private ImageIcon backBtnOn = new ImageIcon(Main.class.getResource("../images/backBtnOn.png"));

	
	private Image bg = new ImageIcon(Main.class.getResource("../images/introBg.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton exitButton = new JButton(exitBtn);
	private JButton startButton = new JButton(startBtn);
	private JButton quitButton = new JButton(quitBtn);
	private JButton leftButton = new JButton(leftBtn);
	private JButton rightButton = new JButton(rightBtn);
	private JButton easyButton = new JButton(easyBtn);
	private JButton hardButton = new JButton(hardBtn);
	private JButton backButton = new JButton(backBtn);

	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImg;
	private Image selectedImg;
	private Music selectedMusic;
	private int nowSelected = 0;

	Music introMusic = new Music("introMusic.mp3", true); // �������� �߰��ؾߵ�
	
	public static Game game = new Game();

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

		addKeyListener(new KeyListener());
		
		trackList.add(new Track("elevateTitleImg.png", "elevateStartImg.png", "elevateGameImg.png",
				"bensound-elevate.mp3", "bensound-elevate.mp3"));
		trackList.add(new Track("erfTitleImg.png", "erfStartImg.png", "erfGameImg.png", "bensound-erf.mp3",
				"bensound-erf.mp3"));
		trackList.add(new Track("memoriesTitleImg.png", "memoriesStartImg.png", "memoriesGameImg.png",
				"bensound-memories.mp3", "bensound-memories.mp3"));
		
		introMusic.start();

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
				enterMain();
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
				selectLeft();
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
				selectRight();
			}
		});
		add(rightButton);

		// ���� ��ư �߰�
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 260, 67); // ��ġ ����
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyBtnOn);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyBtn);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);

		// �ϵ� ��ư �߰�
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 260, 67); // ��ġ ����
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardBtnOn);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardBtn);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);

		// �ڷΰ��� ��ư �߰�
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60); // ��ġ ����
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backBtnOn);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // ȣ���� �Ҹ� �߰�
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backBtn);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		add(backButton);

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
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(bg, 0, 0, null); // add�Լ� ����X, ���� ������ ��
		if (isMainScreen) {
			g.drawImage(selectedImg, 340, 110, null);
			g.drawImage(titleImg, 340, 50, null);
		}
		if (isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);// jframe �ȿ� �̹����� �׷��ִ� ���� �ǹ� (�ְ� �����Ǵ� �̹��� �϶� �̿�, add�Լ� ����� �� ���)
		this.repaint();
	}

	public void selectTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		titleImg = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImg = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(true);
		bg = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		isGameScreen = true;
		setFocusable(true);
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		bg = new ImageIcon(Main.class.getResource("../images/mainBg.jpg")).getImage();
		selectTrack(nowSelected);
		isGameScreen = false;
	}

	public void enterMain() {
		isMainScreen = true;
		bg = new ImageIcon(Main.class.getResource("../images/mainBg.jpg")).getImage(); // ȭ����ȯ
		startButton.setVisible(false); // ��ư �����
		quitButton.setVisible(false); // ��ư �����
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}
}
