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


   //model = new Model();
	View(Controller c, Model m)
	{  
   if(mario_images==null){
	 model = m;
         mario_images = new Image[5];
           try{


         mario_images[0]= ImageIO.read(new File("mario1.png"));
         mario_images[1]= ImageIO.read(new File("mario2.png"));
         mario_images[2]= ImageIO.read(new File("mario3.png"));
         mario_images[3]= ImageIO.read(new File("mario4.png"));
         mario_images[4]= ImageIO.read(new File("mario5.png"));
         background[0] = ImageIO.read(new File("mario10.jpg"));
     }
     catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
   }
}
		
	//}
	/*
	Image[] mario_images;

	View(){
         mario_images = new Image[5];

         mario_images[0]= loadImage("mario1.png");
         mario_images[1]= loadImage("mario2.png");
         mario_images[2]= loadImage("mario3.png");
         mario_images[3]= loadImage("mario4.png");
         mario_images[4]= loadImage("mario5.png");
		

	}
	*/
     //loads image from folder given image name
	/*private Image loadImage(String imageName){
		try{
			new_image = ImageIO.read(new File(imageName));
		} catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
         return new_image;
	}*/


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

		g.drawImage(mario_images[0], this.getWidth(), this.getHeight(), null);
		
		//g.drawRect(10,10, 200, 200);
		//draw the bricks
		g.setColor(new Color(0, 0, 0));
		for(int i=0;  i < model.bricks.size(); i++){
			Brick b = model.bricks.get(i);
			g.drawRect(b.x-model.cameraPos, b.y, b.w, b.h);
		}
		//draw mario
		int marioDraw = (Math.abs(model.mario.x/20)%5);
		g.drawImage(mario_images[marioDraw], model.mario.x , model.mario.y, null);

	}



	void removeButton(){
		/*this.remove(b1);
		this.repaint();
		*/
	}
}
