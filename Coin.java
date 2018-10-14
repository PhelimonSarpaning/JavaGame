
import java.util.Iterator;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.*;

class Coin extends Sprite{
  //to store previous positions
	
	//int w =60;
	//int h =95;
	int a=0;
	int b;
	double vert_vel; 
	int frames;
	BufferedImage new_image;
	static Image[] coin_images = null;
	

   Coin(int d, int c,Model m){
         super(m);
         a = d;
         b = c;
   if(coin_images==null){
	 //model = m;
         coin_images = new Image[1];
           try{


         coin_images[0]= ImageIO.read(new File("bitcoin.png"));
        
     }
     catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
   }
   }
   

	Json marshall(){
		 Json ob = Json.newObject();
		 
		ob.add("type","Coinblock");
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);
        ob.add("vert_vel", vert_vel);
  
        return ob;
	}

	void draw(Graphics g){
       
		g.drawImage(coin_images[0], this.a, this.b, null);


	}

       void update(){
       	//cameraPos = x -100;
       	    vert_vel += 1.2;

       	    b += vert_vel;      	    
		
       }


	@Override
	boolean isBrick() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	boolean isCoinblock() {
		// TODO Auto-generated method stub
		return false;
	}
}     	