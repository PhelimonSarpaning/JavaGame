import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.*;

public class Brick extends Sprite {
	

     Image brick_image;

    Brick(Model m){
         
    	super(m);
        try{
            brick_image = ImageIO.read(new File("brick.jpg"));
            System.out.println("loaded");
            //System.out.println(model.cameraPos);
        }
         catch(Exception e){
            e.printStackTrace(System.err);
            System.exit(1);
         }
    }

	Brick( int xx, int yy , int ww , int hh, Model m){
      super(m);
     x = xx;
     y= yy;
     w= ww;
     h= hh;
	}

	Brick (Json ob,Model m){
		super(m);
        x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         w = (int)ob.getLong("w");
         h = (int)ob.getLong("h");
         //model = m; 
	}

    void draw(Graphics g){
         //System.out.println("the pos is " + model.cameraPos);
        try{
        g.setColor(new Color(153,102,0));
            g.drawRect(x-model.cameraPos,y,w,h);
            g.fillRect(x-model.cameraPos, y, w, h);
            //g.drawImage(brick_image,x,y,null);
        }
        catch(Exception e){
            e.printStackTrace(System.err);
            System.exit(1);
        }
     
    }

     void update(){

     }

	void unmarshall(Json ob){
		//atomic = ob.getBool("atomic");
        x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         w = (int)ob.getLong("w");
         h = (int)ob.getLong("h");

	}
	boolean isBrick() {
		return true;
	}

	Json marshall(){
		 Json ob = Json.newObject();
         ob.add("type","Brick");
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);
  
        return ob;
	}

	@Override
	boolean isCoinblock() {
		// TODO Auto-generated method stub
		return false;
	}

}