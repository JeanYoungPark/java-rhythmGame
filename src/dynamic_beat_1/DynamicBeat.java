package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);//크기변경 불가능
		setLocationRelativeTo(null);//창 정중앙 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창 닫으면 프로그램 종료
		setVisible(true);//보이도록
	}
}
