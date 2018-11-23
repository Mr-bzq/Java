package gluttonousSnake.bzq;

import java.awt.Toolkit;

import javax.swing.JFrame;



public class SnakeFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
	
		new SnakeFrame();
	}
	
	public SnakeFrame() {
		
		this.setTitle("Ã∞≥‘…ﬂ");
		
		int scWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int scHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int width = 800;
		int height = 800;
		this.setBounds((scWidth-width)/2, (scHeight-height)/2, width, height);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SnakePanel sp=new SnakePanel();
		this.add(sp);
		sp.move();

		this.setVisible(true);
	}

}
