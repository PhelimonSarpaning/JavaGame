import java.util.ArrayList;
class Model
{
	
     int cameraPos;
     Mario mario;
	ArrayList<Brick> bricks;

	Model()
	{
		bricks = new ArrayList<Brick>();
		mario = new Mario(this);
		//Brick b = new Brick(400,300,200,100);
		//bricks.add(b);
	}

	public void update()
	{
		//mario = new Mario();
		mario.update();
		//mario.cameraPos = x-222;
	}

	public void setDestination(int x, int y)
	{
		
	}

	void prev_position(){
		mario.prev_position();
	}

	void addBrick(int x, int y, int w, int h){
          Brick b = new Brick(x, y,w,h);
          bricks.add(b);
	}
    //saves objects in JSON format 
	void save(String filename){

		Json ob = marshall();
		ob.save(filename);
	}

   //loads saved rectangles from JSON object
	void load( String filename){
		//Json ob = unmarshall();
		//ob.load(filename);
		Json ob = Json.load(filename);
		unmarshall(ob);
	}
	//helps in picking objects from JSON 
	void unmarshall(Json ob){

         bricks.clear();
         Json json_bricks = ob.get("bricks");
         for(int i=0; i<json_bricks.size(); i++){
         	Json j = json_bricks.get(i);
         	Brick b = new Brick(j);
         	bricks.add(b);
         }


	}

	Json marshall(){
		 Json ob = Json.newObject();
		 Json json_bricks = Json.newList();
		 ob.add("bricks", json_bricks);
		 for(int i=0; i<bricks.size(); i++){
		 	Brick b = bricks.get(i);
		 	Json j= b.marshall();
		 	json_bricks.add(j);
		 }
        /*ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);*/
  
        return ob;
	}
}