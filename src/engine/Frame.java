package engine;

import java.awt.*;

import javax.swing.*;

import screen.Screen;

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

	/**
	 * Initializes the new frame.
	 *
	 * @param width
	 *            Frame width.
	 * @param height
	 *            Frame height.
	 */

	class MyPanel extends JPanel{
		ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/sp.png");
		Image img = icon.getImage();
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 20, 20, this);
		}
	}

	public Frame(final int width, final int height, ImageIcon img) {
//		ImageIcon sp = new ImageIcon(("C:\\Users\\USER\\space_invador\\thu-space-invaders\\res\\tlqkf.jpg"));
//		img = sp;
//		Image imgs = img.getImage();
//		Image updateImg = imgs.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//		ImageIcon changeImg = new ImageIcon(updateImg);
//		JLabel lbl =  new JLabel(changeImg);
//		add(lbl);

		MyPanel panel = new MyPanel();
		this.add(panel, BorderLayout.CENTER);

		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		Insets insets = getInsets();
		this.width = width - insets.left - insets.right;
		this.height = height - insets.top + insets.bottom;
		setTitle("Invaders");
		addKeyListener(Core.getInputManager());
	}

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

