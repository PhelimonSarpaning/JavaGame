
import java.util.Iterator;


class Mario{
  //to store previous positions
	int prev_x;
	int prev_y;

     int x;
	int y;
	int w =60;
	int h =95;
	double vert_vel; 
	Model model;
	int frames;
   Mario(Model m){

   model = m;
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
          	if(y < 300){

          		System.out.println("BREAK HERe");
          	}
          	return true;
          }
          	

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
		else if(y + h >= _y && prev_y + h > _y)
		{
			y = prev_y;
			vert_vel = 0;
			System.out.println("up works");
		}
		else if(y <= _y + _h && prev_y > _y + _h)
		{
			y = prev_y;
			vert_vel = 0;
			System.out.println("down works");
			//frames=0;
		}
		//model.cameraPos = x -100;
	}

	void get_out(Brick b){

	}

	 void prev_position(){
	 	prev_x = x;
	 	prev_y = y;
	 }
       void update(){
       	//model.cameraPos = x -100;
       	    vert_vel += 1.2;

       	    y += vert_vel;
       	    


       	    if(y >= 500)
		{
			//vert_vel = 0.0;
			y = 500; // snap back to the ground
			//vert_vel = 0.0;
			//model.cameraPos = x -100;
			frames = 0;
		}
	//}
		//y++;
		Iterator<Brick> it = model.bricks.iterator();
		while(it.hasNext()){
			Brick b = it.next();
		//}
		//for(int i=0; i<model.bricks.size(); i++){
			//Brick b = model.bricks.get(i);
			if(doesCollide(b.x, b.y, b.w, b.h)){
				get_out(b.x, b.y, b.w, b.h);
				System.out.println("was at" + Integer.toString(prev_x));
				System.out.println("is at"+Integer.toString(x));
				
			}
			frames++;
		}
       }
}     	