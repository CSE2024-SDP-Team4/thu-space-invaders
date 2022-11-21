package engine;

import java.awt.*;

import javax.swing.*;

import screen.Screen;

import java.awt.Graphics;
import java.awt.Image;

/**
 * Implements a frame to show screens on.
 *
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 *
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

	/** Frame width. */
	private int width;
	/** Frame height. */
	private int height;
	/** Screen currently shown. */
	private Screen currentScreen;


	class MyPanel extends JPanel{
		ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/sp.png");
		Image img = icon.getImage();
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 20, 20, this);
		}
	}

	//시도 1

	/**
	JScrollPane scrollPane;
	public Frame(){
		ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/sp.png");

		JPanel background = new JPanel() {
			public void paintComponent(Graphics g){
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
	}
	**/
	//시도 2

	/**
	 * Initializes the new frame.
	 *
	 * @param width
	 *            Frame width.
	 * @param height
	 *            Frame height.
	 */
	public Frame(final int width, final int height) {
		//추가된 줄 (시도 1)
		MyPanel panel = new MyPanel();
		this.add(panel, BorderLayout.CENTER);
		// 테스트
		//테스트 14
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setVisible(true);

		Insets insets = getInsets();
		this.width = width - insets.left - insets.right;
		this.height = height - insets.top + insets.bottom;
		setTitle("Invaders");

		addKeyListener(Core.getInputManager());
	}

	//private Image background = new ImageIcon(Frame.class.getResource("C:/Users/USER/Desktop/sp.png")).getImage();
	//public void paint(Graphics g) {//그리는 함수
	//	g.drawImage(background, 0, 0, null);//background를 그려줌
	//}
	//시도 3

	/**
	 * Sets current screen.
	 *
	 * @param screen
	 *            Screen to show.
	 * @return Return code of the finished screen.
	 */
	public final int setScreen(final Screen screen) {
		currentScreen = screen;
		currentScreen.initialize();
		return currentScreen.run();
	}

	/**
	 * Getter for frame width.
	 *
	 * @return Frame width.
	 */
	public final int getWidth() {
		return this.width;
	}

	/**
	 * Getter for frame height.
	 *
	 * @return Frame height.
	 */

	public final int getHeight() {
		return this.height;
	}
}
