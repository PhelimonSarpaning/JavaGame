import java.awt.Graphics;
abstract class Sprite{
	int x;
	int y;
	int w;
	int h;
	int prev_x;
	int prev_y;
	int cameraPos;
	//Model model;

Model model;
Sprite(Model m){
	model = m;
	cameraPos=250;
}
	abstract void draw(Graphics g);
	abstract void update();
	abstract Json marshall();
	abstract boolean isBrick();
	abstract boolean isCoinblock();
}