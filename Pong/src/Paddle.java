import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle 
{
	private static int y;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	double x = 0;
	double xa = 0;
	private GameWindow game;
	double speed;

	public Paddle(GameWindow game) 
	{
		this.game = game;
		y = 725;
		System.out.println(y);
		//y = 100;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect((int) x, y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) 
	{
		xa = 0;
	}

	public void keyPressed(KeyEvent e) 
	{
		speed = game.getSpeed() * 0.75;
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -speed;
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = speed;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return y;
	}
}