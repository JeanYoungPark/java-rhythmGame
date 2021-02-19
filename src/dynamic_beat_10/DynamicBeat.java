package dynamic_beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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

	// 버튼 이미지들
	private ImageIcon exitBtn = new ImageIcon(Main.class.getResource("../images/exitBtn.png"));
	private ImageIcon exitBtnOn = new ImageIcon(Main.class.getResource("../images/exitBtnOn.png"));
	private ImageIcon startBtn = new ImageIcon(Main.class.getResource("../images/startBtn.png"));
	private ImageIcon startBtnOn = new ImageIcon(Main.class.getResource("../images/startBtnOn.png"));
	private ImageIcon quitBtn = new ImageIcon(Main.class.getResource("../images/quitBtn.png"));
	private ImageIcon quitBtnOn = new ImageIcon(Main.class.getResource("../images/quitBtnOn.png"));

	// 화살표
	private ImageIcon leftBtn = new ImageIcon(Main.class.getResource("../images/leftArrow.png"));
	private ImageIcon leftBtnOn = new ImageIcon(Main.class.getResource("../images/leftArrowOn.png"));
	private ImageIcon rightBtn = new ImageIcon(Main.class.getResource("../images/rightArrow.png"));
	private ImageIcon rightBtnOn = new ImageIcon(Main.class.getResource("../images/rightArrowOn.png"));

	// 게임 난이도 버튼
	private ImageIcon easyBtn = new ImageIcon(Main.class.getResource("../images/easyBtn.png"));
	private ImageIcon easyBtnOn = new ImageIcon(Main.class.getResource("../images/easyBtnOn.png"));
	private ImageIcon hardBtn = new ImageIcon(Main.class.getResource("../images/hardBtn.png"));
	private ImageIcon hardBtnOn = new ImageIcon(Main.class.getResource("../images/hardBtnOn.png"));

	// 뒤로가기 버튼
	private ImageIcon backBtn = new ImageIcon(Main.class.getResource("../images/backBtn.png"));
	private ImageIcon backBtnOn = new ImageIcon(Main.class.getResource("../images/backBtnOn.png"));

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteImage = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
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

	Music introMusic = new Music("introMusic.mp3", true); // 음악파일 추가해야됨

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

		trackList.add(new Track("elevateTitleImg.png", "elevateStartImg.png", "elevateGameImg.png",
				"bensound-elevate.mp3", "bensound-elevate.mp3"));
		trackList.add(new Track("erfTitleImg.png", "erfStartImg.png", "erfGameImg.png", "bensound-erf.mp3",
				"bensound-erf.mp3"));
		trackList.add(new Track("memoriesTitleImg.png", "memoriesStartImg.png", "memoriesGameImg.png",
				"bensound-memories.mp3", "bensound-memories.mp3"));

		introMusic.start();

		// 나가기 버튼 추가
		exitButton.setBounds(1245, 0, 30, 30); // 위치 선정
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitBtnOn);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 시작 버튼 추가
		startButton.setBounds(800, 400, 400, 100); // 위치 선정
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startBtnOn);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 종료 버튼 추가
		quitButton.setBounds(800, 530, 400, 100); // 위치 선정
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitBtnOn);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
				btnOnMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitBtn);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 게임종료 이벤트
			}
		});
		add(quitButton);

		// 왼쪽 화살표 버튼 추가
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); // 위치 선정
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftBtnOn);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 오른쪽 화살표 버튼 추가
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); // 위치 선정
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightBtnOn);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 이지 버튼 추가
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 260, 67); // 위치 선정
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyBtnOn);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 하드 버튼 추가
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 260, 67); // 위치 선정
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardBtnOn);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 뒤로가기 버튼 추가
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60); // 위치 선정
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backBtnOn);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music btnOnMusic = new Music("exitBtnOnMusic.mp3", false); // 호버시 소리 추가
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

		// 메뉴바 배경추가
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
			public void mouseDragged(MouseEvent e) { // 드래그 할때마다 좌표를 얻어온다.
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
		g.drawImage(bg, 0, 0, null); // add함수 사용시X, 그저 보여줄 때
		if (isMainScreen) {
			g.drawImage(selectedImg, 340, 110, null);
			g.drawImage(titleImg, 340, 50, null);
		}
		if (isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null);
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);
			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 740, 30, null);
			g.drawImage(noteRouteLineImage, 844, 30, null);
			g.drawImage(noteRouteLineImage, 948, 30, null);
			g.drawImage(noteRouteLineImage, 1052, 30, null);
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementLineImage, 0, 580, null);
			g.drawImage(noteImage, 228, 120, null);
			g.drawImage(noteImage, 332, 580, null);
			g.drawImage(noteImage, 436, 500, null);
			g.drawImage(noteImage, 540, 340, null);
			g.drawImage(noteImage, 640, 340, null);
			g.drawImage(noteImage, 744, 325, null);
			g.drawImage(noteImage, 848, 305, null);
			g.drawImage(noteImage, 952, 305, null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // 폰트깨짐현상
																												// 방지
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("elevate", 20, 702);
			g.drawString("Easy", 1190, 702);
			g.setFont(new Font("Arial", Font.PLAIN, 26));
			g.setColor(Color.DARK_GRAY);
			g.drawString("S", 270, 609);
			g.drawString("D", 374, 609);
			g.drawString("F", 478, 609);
			g.drawString("Space Bar", 580, 609);
			g.drawString("J", 784, 609);
			g.drawString("K", 889, 609);
			g.drawString("L", 993, 609);
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString("000000", 565, 702);
		}
		paintComponents(g);// jframe 안에 이미지를 그려주는 것을 의미 (주고 고정되는 이미지 일때 이용, add함수 사용이 될 경우)
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
		bg = new ImageIcon(Main.class.getResource("../images/mainBg.jpg")).getImage(); // 화면전환
		startButton.setVisible(false); // 버튼 지우기
		quitButton.setVisible(false); // 버튼 지우기
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}
}
