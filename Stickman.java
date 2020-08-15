package stickman;

public class Stickman {
	
	public static void main(String[] args)
	{
		Screen draw = new Screen(0,0);
		
		int fps = 30;
		int timer = 1000/fps;
		
		boolean gameOn = true;
		
		while(gameOn == true) {
			draw.update();
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
