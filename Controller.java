import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener,KeyListener
{   boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	boolean keySpace;


	int mouseDownX;
	int mouseDownY;

	View view;
	Model model;
	Mario mario;
	Controller(Model m)
	{
		model = m;
	}


	public void actionPerformed(ActionEvent e)
	{
		//System.out.println("Hey! I said never push that button!");
		view.removeButton();
	}

	void setView(View v)
	{
		view = v;
	}
	/*void update()
	{
	}*/

	public void mousePressed(MouseEvent e)
	{
		//model.setDestination(e.getX(), e.getY());
		mouseDownX = e.getX();
         mouseDownY= e.getY();
	}

	public void mouseReleased(MouseEvent e) {  
      //mode.setDestination(e.)
		int x1 = mouseDownX;
		int x2 = e.getX();
		int y1 = mouseDownY;
		int y2 = e.getY();
		int left = Math.min(x1,x2);
		int right = Math.max(x1,x2);
		int top = Math.min(y1,y2);
		int bottom = Math.max(y1,y2);
            //model.addBrick(mouseDownX, mouseDownY , e.getX()-mouseDownX, e.getY()-mouseDownY);
         model.addBrick(left + model.cameraPos ,top , right - left, bottom - top);
	  }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {  
		if (e.getY() < 100) {
			System.out.println("break here");
		}
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
			case KeyEvent.VK_S: model.save("map.json"); break;
			case KeyEvent.VK_L: model.load("map.json"); break;
		    case KeyEvent.VK_SPACE: keySpace = true;break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
		    case KeyEvent.VK_SPACE: keySpace = false;break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}
  //controls mario movement
	void update()
	{
           model.prev_position();
           //model.cameraPos= x-222;
		if(keyRight) {
			
			model.mario.x+=10;
			// model.cameraPos++;

		}
		if(keyLeft) {
			
			model.mario.x-=10;
			//model.cameraPos--;
	}

	   if(keySpace){
	   	//if(model.mario.frames<=5)
	   	model.mario.vert_vel = -15.1;
	   }	
	}
}
