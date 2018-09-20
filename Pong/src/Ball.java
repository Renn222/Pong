 import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	private static final int DIAMETER = 30;
	
	Random rand = new Random();
	
	double x = rand.nextInt(250);
	double y = 0;
	static double xa = 1;
	double ya = 1;
	private GameWindow game;
	double speed;
	int startAngle = rand.nextInt(2);
	
	public Ball(GameWindow game) 
	{
		this.game= game;
		if(startAngle == 1)
		{
			xa = -1;
		}
	}

	void move() 
	{		
		speed = game.speed;
		if (x + xa < 0)
			xa = speed;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -speed;
		if (y + ya < 0)
			ya = speed;
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		
		if (collision())
		{
			game.addSpeed();
			ya = -speed;
			y = game.paddle.getTopY() - DIAMETER;
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	private boolean collision() 
	{
		return game.paddle.getBounds().intersects(getBounds());
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int) x, (int) y, DIAMETER, DIAMETER);
	}
	
	public void paint(Graphics2D g) {
		g.fillOval((int) x, (int) y, 30, 30);
	}
}