import java.util.ArrayList;
class Model
{
	
     int cameraPos;
     Mario mario;
    Coinblocks coinblock;
	//ArrayList<Brick> bricks;
     ArrayList<Sprite> sprites;
    //Coin coins;

	Model()
	{
		//bricks = new ArrayList<Brick>();
		sprites = new ArrayList<Sprite>();
		mario = new Mario(this);
		//coins = new Coin(this);
		sprites.add(mario);
		//sprites.add(coins);
		coinblock = new Coinblocks(this);
		sprites.add(coinblock);
		cameraPos=250;
	}

	public void update()
	{
		
		for(int i=0; i<sprites.size(); i++){
			Sprite s = sprites.get(i);
			//Brick a = new Brick(this);
			s.update();

			
		}

	}

	public void setDestination(int x, int y)
	{
		
	}

	void prev_position(){
		mario.prev_position();
	}

	void addBrick(int x, int y, int w, int h){
          Brick b = new Brick(x, y,w,h,this);
          sprites.add(b);
	}
	//adds coinblock to the screen. 
	void addCoinblock(int x ,int y) {
		//Coinblocks c = new Coinblocks(x,y,this);
		//sprites.add(c);
		
		
	}
    //saves objects in JSON format 
	void save(String filename){

		Json ob = marshall();
		ob.save(filename);
	}
	//drops coin when coinblock is hit
     void addCoin(int x, int y) {
    	 Coin coins = new Coin(x,y,this);
    	 sprites.add(coins);
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

         //sprites.clear();
         Json json_bricks = ob.get("sprites");
         for(int i=0; i<json_bricks.size(); i++){
         	Json j = json_bricks.get(i);
         	String s = j.getString("type");
         	//System.out.println(s);
         	if(s.equals("Brick")) {
         		Brick b = new Brick(j,this);
         		sprites.add(b);
         	}
         	else if(s.equals("Coinblock")) {
         		Coinblocks c = new Coinblocks(j,this);
         		sprites.add(c);
         	}
        
         	
         }


	}
     
	Json marshall(){
		 Json ob = Json.newObject();
		 Json json_bricks = Json.newList();
		 ob.add("sprites", json_bricks);
		 for(int i=0; i<sprites.size(); i++){
		 	Sprite s = sprites.get(i);
		 	Json j= s.marshall();
		 	json_bricks.add(j);
		 }
        /*ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);*/
  
        return ob;
	}
}