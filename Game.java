import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{      Model model;
	Controller controller ;
	View view ;
	public Game()
	{    
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		//view = new View();
		view.addMouseListener(controller);
		this.addKeyListener(controller);
		this.setTitle("Turtle Attack!");
		this.setSize(900, 700);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//model.load("map.json");

	}

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
	public void run()
{
	while(true)
	{
		controller.update();
		model.update();
        view.repaint(); // Indirectly calls View.paintComponent
		
		Toolkit.getDefaultToolkit().sync(); // Updates screen
        //model.load("map.json");//loads bricks on screen
		// Go to sleep for 50 miliseconds
		try
		{
			Thread.sleep(50);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		//System.out.println("hi"); // remove this line
	}
}
}
