 
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

class Mario extends Sprite{
  //to store previous positions
	int j=0;
	int w =80;
	int h =80;
	double vert_vel; 
	int frames;
	BufferedImage new_image;
	static Image[] mario_images = null;
	Image[] background = new Image[2];
	int particular_coinblock=0;
	 int curr_x= 0;
		 int curr_y = 0;
		 int curr_w = 0;
		 int curr_h = 0;
	

   Mario(Model m){
      super(m);
   if(mario_images==null){
	 //model = m;
	  
         mario_images = new Image[5];
           try{


         mario_images[0]= ImageIO.read(new File("mario1.png"));
         mario_images[1]= ImageIO.read(new File("mario2.png"));
         mario_images[2]= ImageIO.read(new File("mario3.png"));
         mario_images[3]= ImageIO.read(new File("mario4.png"));
         mario_images[4]= ImageIO.read(new File("mario5.png"));
         background[0] = ImageIO.read(new File("mario10.jpg"));
         background[1] = ImageIO.read(new File("block1.png"));
     }
     catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
   }
   }
    //check if it collides
	boolean doesCollide(int _x, int _y, int _w, int _h){
          if(x + w  <= _x)
          	return false;
          else if(x >= _x + _w)
          	return false;
          else if(y + h <= _y)
          	return false;
          else if( y >= _y + _h)
          	return false;
          else{
          	if(y <= 300){

          		System.out.println("BREAK HERe");
          	}
          	return true;
          }
          	

	}  

	Json marshall(){
		 Json ob = Json.newObject();
		 
		ob.add("type","Mario");
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);
        ob.add("vert_vel", vert_vel);
  
        return ob;
	}
	void get_out(int _x, int _y, int _w, int _h){
		
		if((x + w) >= _x && (prev_x + w) < _x)
		{
			x = prev_x;
			System.out.println("LEFT WORKS");
		}
		else if(x <= (_x + _w) && prev_x > (_x + _w))
		{
			x = prev_x;
			System.out.println("RIGHT WORKS");
		}
		else if(y + h >= _y || prev_y + h > _y)
		{
			y = prev_y;
			vert_vel = 0;
			System.out.println("up works");
		}
		else if(y <= _y + _h && prev_y > _y + _h)
		{
			y = prev_y;
			vert_vel =0;
			System.out.println("down works");
			//frames=0;
		}
		//model.cameraPos = x -100;
	}

	void draw(Graphics g){

		g.drawImage(background[0], 0, 0, null);
int marioDraw = (Math.abs(model.mario.x/20)%5);
		g.drawImage(mario_images[marioDraw], x , y, null);
		model.load("map.json");//loads bricks on screen
   }

	void get_out(Brick b){

	}

	 void prev_position(){
	 	prev_x = x;
	 	prev_y = y;
	 }
       void update(){
       	model.cameraPos = x-100;
       	    vert_vel += 1.2;

       	    y += vert_vel;
       	    


       	    if(y >= 500)
		{
			
			y = 500; // snap back to the ground
			
			frames = 0;
		}
	
		/*Iterator<Sprite> it = model.sprites.iterator();
		while(it.hasNext()){
			Sprite b = it.next();*/
       	    //checks if either mario collides with brick or coinblock
       	    for(int i=0; i<model.sprites.size(); i++) {
       	    	
                 Sprite b = model.sprites.get(i);
         	if(b.isBrick() ) {
         	
               if(doesCollide(b.x-model.cameraPos, b.y, b.w, b.h)){
            	   System.out.println(b);
                get_out(b.x, b.y, b.w, b.h);
				System.out.println("was at" + Integer.toString(prev_x));
				System.out.println("is at"+Integer.toString(x));
				}
			}
         	if(b.isCoinblock()) {
         		 particular_coinblock++;
         		 if(doesCollide(500-model.cameraPos, 60, this.w, this.h)){
         			//finds the particular coinblock we're in
         			 curr_x= b.x-model.cameraPos;
         	         curr_y = b.y;
         			 curr_w = this.w;
         			 curr_h = this.h;
         			 if(j < 5 ) {
         			model.addCoin(500-model.cameraPos, 60);
         			 j++;
         			 
         			 }
         			     //System.out.println("Coinblock width "+ this.w);
                    get_out(b.x, b.y, this.w, this.h);
                                  
     				//System.out.println("was at" + Integer.toString(prev_x));
     				//System.out.println("is at"+Integer.toString(x));
     				}
         	}
         	
			frames++;
			 }
       }
	@Override
	boolean isBrick() {
		//TODO Auto-generated method stub
		return false;
	}
	@Override
	boolean isCoinblock() {
		//TODO Auto-generated method stub
		return false;
	}
}     	