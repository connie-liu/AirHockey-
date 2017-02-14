//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}
	//add the other Ball constructors
	public Ball(int x, int y)
	{
		super(x, y, 10, 10);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int h)
	{
		super(x, y, wid, h);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int h, Color col)
	{
		super(x, y, wid, h, col);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int wid, int h, Color col, int xSp, int ySp)
	{
		super(x, y, wid, h, col);
		xSpeed = xSp;
		ySpeed = ySp;
	}
	//add the set methods
	public void setXSpeed(int x)
	{
		xSpeed = x;
	}
	public void setYSpeed(int y)
	{
		ySpeed = y;
	}

	public void moveAndDraw(Graphics window)
	{
		//draw a white ball at old ball location
		window.setColor(Color.WHITE);
		window.fillRect(getX(), getY(), getWidth(), getHeight());

		setX(getX()+getXSpeed());
		//setY
		setY(getY()+getYSpeed());
		//draw the ball at its new location
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj)
	{
		Object no = (Object) obj;
		if(getX()==((Ball) no).getX()
				&& getY()==((Ball)no).getY()
				&& getWidth()==((Ball)no).getWidth()
				&& getHeight()==((Ball)no).getHeight()
				&& getColor()==((Ball)no).getColor()
				&& getXSpeed()==((Ball)no).getXSpeed()
				&& getYSpeed()==((Ball)no).getYSpeed())
		{
			return true;
		}
		return false;
	}   

	public boolean didCollideLeft(Object obj)
	{
		if((getX())<=(((Block) obj).getX()+ ((Block)obj).getWidth()))
		{
			return true;
		}
		return false;
	}
	public boolean didCollideRight(Object obj)
	{
		if((getX()+getWidth())>=((Block)obj).getX())
		{
			return true;
		}
		return false;
	}
	public boolean didCollideTop(Object obj)
	{
		if((getY())<=(((Block)obj).getY()+((Block)obj).getHeight()))
		{
			return true;
		}
		return false;
	}
	public boolean didCollideBottom(Object obj)
	{
		if((getY()+getHeight())>=(((Block)obj).getY()))
		{
			return true;
		}
		return false;
	}
	
	//add the get methods
	public int getXSpeed()
	{
		return xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}

	//add a toString() method
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed() + " " + getYSpeed();
	}
}