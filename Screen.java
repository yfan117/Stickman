import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;



public class Screen extends JFrame implements KeyListener{
	
	static Display draw;
	static int x = 0;
	static int y = 0;
	//static int deltaX ;
	//static int deltaY ;
	
	public Screen(int x, int y) {
		
		int windowX = 1392;
		int windowY = 851;
		
		this.x = x;
		this.y = windowY - 300;
		
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//setLocationRelativeTo(null);
		setSize(windowX , windowY);

		draw = new Display();
		getContentPane().add(draw);
	
		setVisible(true);
	}
	
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	static int i = 1;
	
	static boolean left = false;
	static boolean right = false;
	static boolean up = false;
	static boolean down = false;
	
	@Override
	public void keyPressed(KeyEvent e) {

		moveReset();
		
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_D) {
			//System.out.println("a");
			x = x + 10;
			right = true;
			i++;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			//System.out.println("a");
			y = y + 10;
			down = true;
			i++;
			//draw.update(x,y);
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			//System.out.println("a");
			x = x - 10;
			left = true;
			i++;
			
			//draw.update(x,y);
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			//System.out.println("a");
			y = y - 10;
			up = true;
			i++;
			//draw.update(x,y);
			
		}
		
		if(i>5)
			i=1;
		//draw.update(i, x , y, left, right, up, down);
		
	}
	
	public void update() {
		draw.update(i, x , y, left, right, up, down);
	}
	
	public void moveReset()
	{
		left = false;
		right = false;
		up = false;
		down = false;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class Display extends JPanel{
	
	static Image stickman = new ImageIcon("stickman.png").getImage();
	static int stickmanStage = 1;
	static char previousMove ;
	static int x = 0;
	static int y = 0;
	static boolean left = false;
	static boolean right = false;
	static boolean up = false;
	static boolean down = false;
	static int jumpY = 0;
	static int jumpHeight = 100;
	
	public void update(int i, int x, int y, boolean left, boolean right, boolean up, boolean down) {
		
		stickmanStage=i;
		this.x = x;
		this.y = y;
		jumpY = y;
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		
		repaint();
	}
	
	//public void setX(int x)
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if(right == true)
		{	
			
			g.drawImage(stickman, x,y,150+x,266+y, 150*stickmanStage,0,150*(1 + stickmanStage),266,null);
			previousMove = 'r';
			moveReset();
		}
		else if((up == true)&&(previousMove == 'r'))
		{
			g.drawImage(stickman, x,y,150+x,266+y, 150*stickmanStage,0,150*(1 + stickmanStage),266,null);
			previousMove = 'r';
			moveReset();

		}
		else if(left == true)
		{	
			//System.out.println("here");
			g.drawImage(stickman, x,y,150+x,266+y, 150*stickmanStage,266,150*(1 + stickmanStage),532,null);
			previousMove = 'l';
			moveReset();
		}
		else if((up == true)&&(previousMove == 'l'))
		{	
			//System.out.println("here");
			g.drawImage(stickman, x,y,150+x,266+y, 150*stickmanStage,266,150*(1 + stickmanStage),532,null);
			previousMove = 'l';
			moveReset();
		}
		else if((down == true)&&(previousMove == 'l'))
		{	
			//System.out.println("here");
			g.drawImage(stickman, x,y,150+x,266+y, 150*stickmanStage,266,150*(1 + stickmanStage),532,null);
			previousMove = 'l';
			moveReset();
		}
		else if((down == true)&&(previousMove == 'r'))
		{	
			//System.out.println("here");
			g.drawImage(stickman, x,y,150+x,266+y, 150*stickmanStage,0,150*(1 + stickmanStage),266,null);
			previousMove = 'r';
			moveReset();
		}
	}
	
	public void moveReset()
	{
		left = false;
		right = false;
		//up = false;
		//down = false;
	}
}


