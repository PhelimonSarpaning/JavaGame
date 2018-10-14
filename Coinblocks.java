
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

class Coinblocks extends Sprite{
  //to store previous positions
	
	
	int frames;
	BufferedImage new_image;
	double vert_vel; 
	//static Image[] mario_images = null;
	Image[] coinblock = new Image[2];
     int block_posX;
     int block_posY;
   Coinblocks(Model m){
	   super(m);
             //block_posX = a;
             //block_posY = b;
           try{

           
        
         coinblock[0] = ImageIO.read(new File("block1.png"));
         coinblock[1] = ImageIO.read(new File("block2.png"));


         System.out.println("draw block");
     }
     catch (Exception e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
   }

   Coinblocks( int xx, int yy , int ww , int hh, Model m){
   super(m);
     x = xx;
     y= yy;
     w= ww;
     h= hh;

	}
   Coinblocks(Json ob, Model m){
   	 super(m);
   	     x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         w = (int)ob.getLong("w");
         h = (int)ob.getLong("h");
         block_posX = x;
         block_posY = y;
   }
	Json marshall(){
		 Json ob = Json.newObject();
		 
		ob.add("type","Coinblocks");
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);
        //ob.add("vert_vel", vert_vel);*/
  
        return ob;
	}
	   

	void load( String filename){
		//Json ob = unmarshall();
		//ob.load(filename);
		Json ob = Json.load(filename);
		unmarshall(ob);
	}
 //draws coinblocks unto screen
	void draw(Graphics g){
        Sprite b;
        
		//for(int i=0; i<model.sprites.size(); i++) {
			 // b = model.sprites.get(i);
			 //if(b.isCoinblock() ) {
				
					 g.drawImage(coinblock[0],500-model.cameraPos, 60, null);
					 
						
						 //}
				// }
					 if(model.mario.j==5) {
						 g.drawImage(coinblock[1],500-model.cameraPos, 60, null);
					 }
			
		 }	 
			 
		 
		 //check if coinblock has been hit  times and then change coinblock type
	/*if(model.mario.j>=5 ) {
			// Sprite  a = model.sprites.get(model.mario.particular_coinblock);
			 //if(a.isCoinblock()) {
			 g.drawImage(coinblock[1], model.mario.curr_x,model.mario.curr_y, null); 
			 //model.mario.j=0;
			// }
		 }*/
		//model.mario.j=0; 
 
		 
	
		// }
		
		/*g.drawImage(coinblock[0], x-model.cameraPos, y, null);
	    g.setColor(Color.RED);
       g.drawRect(x-model.cameraPos, y, w, h);
       g.fillRect(x-model.cameraPos, y, w, h);
       */
     
 

	//}
	void changeBrick(Graphics g) {
		//if(model.mario.j==5 ) {
			// Sprite  a = model.sprites.get(model.mario.particular_coinblock);
			 //if(a.isCoinblock()) {
			 g.drawImage(coinblock[1], model.mario.curr_x,model.mario.curr_y, null); 
		//}
	}
	void unmarshall(Json ob){
         x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         w = (int)ob.getLong("w");
         h = (int)ob.getLong("h");
	}

	void get_out(Brick b){

	}

	 void prev_position(){
	 	prev_x = x;
	 	prev_y = y;
	 }
      void update(){

		//draw();
       }

	@Override
	boolean isBrick() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isCoinblock() {
		// TODO Auto-generated method stub
		return true;
	}
}     	