import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.*;

class View extends JPanel
{
	JButton b1;
	Model model;
	BufferedImage new_image;
	static Image[] mario_images = null;
	Image[] background = new Image[1];
	//Sprite s;


   //model = new Model();
	View(Controller c, Model m)
	{  
		 model = m;
 
}
		
	

	public void paintComponent(Graphics g){
		//model = new Model();
		//clear the screen
		g.setColor(new Color(128, 255, 255));
		//g.drawImage(mario_images[0], this.getWidth(), this.getHeight(), null);
		
		g.drawImage(background[0], 0, 0, null);
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());

		//
		//draw the ground;
		g.setColor(new Color(15,200,64));
		g.fillRect(0, 596, 900, 596);

		//g.drawImage(mario_images[0], this.getWidth(), this.getHeight(), null);
		
		//g.drawRect(10,10, 200, 200);
		//draw the bricks
		g.setColor(new Color(0, 0, 0));
		for(int i=0;  i < model.sprites.size(); i++){
			Sprite b = model.sprites.get(i);
			
             b.draw(g);
		}
		
	}



	void removeButton(){
		/*this.remove(b1);
		this.repaint();
		*/
	}
}
