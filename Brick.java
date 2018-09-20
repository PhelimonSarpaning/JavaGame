public class Brick{
	int x;
	int y;
	int w;
	int h;

	Brick(int xx, int yy , int ww , int hh){
     x = xx;
     y= yy;
     w= ww;
     h= hh;

	}

	Brick (Json ob){
		//atomic = ob.getBool("atomic");
        x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         w = (int)ob.getLong("w");
         h = (int)ob.getLong("h");
         
	}

	void unmarshall(Json ob){
		//atomic = ob.getBool("atomic");
        x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         w = (int)ob.getLong("w");
         h = (int)ob.getLong("h");
         

         /*bricks.clear();
         Json json_bricks = ob.get("bricks");
         for(int i=0; i<json_bricks.size(); i++){
         	Json j = json_bricks.get(i);
         	Brick b = new Brick(j);
         	bricks.add(b);
         }*/

	}

	Json marshall(){
		 Json ob = Json.newObject();
		 //Json json_bricks = Json.newList();
		 //ob.add("bricks", json_bricks);
		 //for(int i=0; i<bricks.size(); i++){
		 	//Brick b = bricks.get(i);
		 	//Json j= b.marshall();
		 	//json_bricks.add(j);
		 
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);
  
        return ob;
	}

}