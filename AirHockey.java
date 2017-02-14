import static java.lang.Character.toUpperCase;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class AirHockey extends Canvas implements KeyListener, Runnable{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private UpperLeftWall ulWall;
	private LowerLeftWall llWall;
	private UpperRightWall urWall;
	private LowerRightWall lrWall;
	private LeftGoal lGoal;
	
	private int rightScore;
	private int leftScore;


	public AirHockey()
	{
		//set up all variables related to the game
		ball = new Ball();
		leftPaddle = new Paddle(10,100,10,50,Color.red,5);
		rightPaddle = new Paddle(760,100,10,50,Color.blue,5);
		ulWall = new UpperLeftWall();
		llWall = new LowerLeftWall();
		urWall = new UpperRightWall();
		lrWall = new LowerRightWall();
		lGoal = new LeftGoal();



		keys = new boolean[8];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Right player's score = " + rightScore, 300, 380);
		graphToBack.drawString("Left player's score = " + leftScore, 300, 400);
		ulWall.draw(graphToBack);
		llWall.draw(graphToBack);
		urWall.draw(graphToBack);
		lrWall.draw(graphToBack);
		lGoal.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=770))
		{
			if((ball.getY()>=250 && ball.getY()<=350))
			{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			
			if(ball.getX()<=10 && (ball.getY()>=250 && ball.getY()<=350))
			{
				graphToBack.setColor(Color.white);
				graphToBack.drawString("Right player's score = " + rightScore, 300, 380);
				rightScore++;
				graphToBack.setColor(Color.black);
				graphToBack.drawString("Right player's score = " + rightScore, 300, 380);
			}
			if(ball.getX()>=770 && (ball.getY()>=250 && ball.getY()<=350))
			{
				graphToBack.setColor(Color.white);
				graphToBack.drawString("Left player's score = " + leftScore, 300, 400);
				leftScore++;
				graphToBack.setColor(Color.black);
				graphToBack.drawString("Left player's score = " + leftScore, 300, 400);
			}
			}
			else
			{
				ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
			}
		}
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=10 && ball.getY()<=480))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		//see if the ball hits the left paddle
		if(ball.getX()<=(leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed())) &&
				(ball.getY()>=leftPaddle.getY() &&
				ball.getY()<=(leftPaddle.getY()+leftPaddle.getHeight()) ||
				(ball.getY()+ball.getHeight())>=leftPaddle.getY() &&
				(ball.getY()+ball.getHeight())<(leftPaddle.getY()+leftPaddle.getHeight())))
		{
			if(ball.getX()<=(leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed())))
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
			else
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
		}
		//see if the ball hits the right paddle
		if(ball.getX()+ball.getWidth()>=(rightPaddle.getX()+Math.abs(ball.getXSpeed())) &&
				(ball.getY()>=rightPaddle.getY() &&
				ball.getY()<=(rightPaddle.getY()+rightPaddle.getHeight()) ||
				(ball.getY()+ball.getHeight())>=rightPaddle.getY() &&
				(ball.getY()+ball.getHeight())<(rightPaddle.getY()+rightPaddle.getHeight())))
		{
			if(ball.getX()+ball.getWidth()>=(rightPaddle.getX()-Math.abs(ball.getXSpeed())))
			{
				ball.setXSpeed(-ball.getXSpeed());
			}
			else
			{
				ball.setYSpeed(-ball.getYSpeed());
			}
		}
		
		//see if the paddles need to be moved
		if(keys[0]==true)
			leftPaddle.moveUpAndDraw(graphToBack);
		if(keys[1]==true)
			leftPaddle.moveDownAndDraw(graphToBack);
		if(keys[2]==true)
			rightPaddle.moveUpAndDraw(graphToBack);
		if(keys[3]==true)
			rightPaddle.moveDownAndDraw(graphToBack);
		if(keys[4]==true)
			leftPaddle.moveLeftAndDraw(graphToBack);
		if(keys[5]==true)
			leftPaddle.moveRightAndDraw(graphToBack);
		if(keys[6]==true)
			rightPaddle.moveLeftAndDraw(graphToBack);
		if(keys[7]==true)
			rightPaddle.moveRightAndDraw(graphToBack);

		twoDGraph.drawImage(back, null, 0, 0);
   }

   public void keyPressed(KeyEvent e)
   {
	   switch(toUpperCase(e.getKeyChar()))
	   {
	   case 'W' : keys[0]=true; break;
	   case 'S' : keys[1]=true; break;
	   case 'I' : keys[2]=true; break;
	   case 'K' : keys[3]=true; break;
	   case 'A' : keys[4]=true; break;
	   case 'D' : keys[5]=true; break;
	   case 'J' : keys[6]=true; break;
	   case 'L' : keys[7]=true; break;
	   }
   }

   public void keyReleased(KeyEvent e)
   {
	   switch(toUpperCase(e.getKeyChar()))
	   {
	   case 'W' : keys[0]=false; break;
	   case 'S' : keys[1]=false; break;
	   case 'I' : keys[2]=false; break;
	   case 'K' : keys[3]=false; break;
	   case 'A' : keys[4]=false; break;
	   case 'D' : keys[5]=false; break;
	   case 'J' : keys[6]=false; break;
	   case 'L' : keys[7]=false; break;
	   }
   }

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}
