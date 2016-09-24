 package game;

import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;

public class Paddle extends Sprite{

	public Paddle() {
		super(20, 5, Color.RED);
		this.setPosition(Resolution.MSX.width/2 - 10, Resolution.MSX.height - 25);
	}
	
	public void moveDireita ()
	{
		this.move(+3, 0);
		
	}
	
	public void moveEsquerda()
	{
		this.move(-3, 0);
	}

}
