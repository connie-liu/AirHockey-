

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int blockSpeed;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = Color.BLACK;
	}
	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y, int wid, int h)
	{
		xPos = x;
		yPos = y;
		width = wid;
		height = h;
		color = Color.black;
	}
	public Block(int x, int y, int wid, int h, Color col)
	{
		xPos = x;
		yPos = y;
		width = wid;
		height = h;
		color = col;
	}
	public Block(int i, int j) {
		xPos = i;
		yPos = j;
		width = 10;
		height = 10;
		color = Color.black;
	}
	public Block(int x, int y, int speed) {
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
		color = Color.black;
		blockSpeed = speed;
	}
	public Block(int x, int y, int wid, int h, int speed) {
		xPos = x;
		yPos = y;
		width = wid;
		height = h;
		color = Color.black;
	}
	//add the other set methods
	public void setPos(int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	public void setX(int x)
	{
		xPos = x;
	}
	public void setY(int y)
	{
		yPos = y;
	}
	public void setColor(Color col)
	{
		color = col;
	}

	public void draw(Graphics window)
	{
		//uncomment after you write the set and get methods
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col)
	{
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj)
	{
		Object no = (Object) obj;
		if(getX()==((Block) no).getX()
				&& getY()==((Block)no).getY()
				&& getWidth()==((Block)no).getWidth()
				&& getHeight()==((Block)no).getHeight()
				&& getColor()==((Block)no).getColor())
		{
			return true;
		}
		return false;
	}   

	//add the other get methods
	public int getX()
	{
		return xPos;
	}
	public int getY()
	{
		return yPos;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public Color getColor()
	{
		return color;
	}

	//add a toString() method  - x , y , width, height, color
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
	}
}