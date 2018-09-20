import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameWindow extends JPanel
{
	private static JFrame frame = new JFrame();
	Ball ball = new Ball(this);
	Paddle paddle;
	double speed = 1;
	double scoreDouble;
	int score;
	Random rand = ball.rand;
	
	public GameWindow() 
	{

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				paddle.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}
		});
		setFocusable(true);
		
		paddle = new Paddle(this);

	}
	
	public double getSpeed() 
	{
		return speed;
	}
	
	public void addSpeed()
	{
		speed = speed + 0.5;
	}
	
	private int getScore()
	{
		scoreDouble = speed * 2 - 2;
		score = (int) scoreDouble;
		return score;
	}
	
	private void move() 
	{
		ball.move();
		paddle.move();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		paddle.paint(g2d);

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}

	public void gameOver() 
	{
		JOptionPane.showMessageDialog(this, "Your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public static void main(String [] args)  throws InterruptedException
	{
		frame.setTitle("Paddle Ball");
		frame.setBounds(100, 100, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameWindow game = new GameWindow();
		frame.add(game);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(cards);
		
		 
		while (true) 
		{
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
	

}
