package game;


import java.util.ArrayList;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {

	private Bola bola;
	private Paddle paddel;
	private Fase1 fase1;
	
	

	@Override
	protected void draw(Canvas canvas) {		
		canvas.clear();

		bola.draw(canvas);

		for (Quadrado a : fase1.quadrados)
		{
			a.draw(canvas);
		}	

		paddel.draw(canvas);
	}

	@Override
	protected void setup() {

		this.setTitle("Arkanoid");
		this.setResolution(Resolution.MSX);
		this.setFramesPerSecond(60);

		bola = new Bola();

		paddel = new Paddle();

		fase1 = new Fase1();

				
		this.bindKeyPressed("LEFT", new KeyboardAction() {
			public void handleEvent() {
				Point pontoPaddle = paddel.getPosition();
				if (pontoPaddle.x > 0)
				{
					paddel.moveEsquerda();
					if (bola.getIsMoving() == false)
					{
						bola.moveEsquerda();
					} 
				}
			}
		});

		this.bindKeyPressed("RIGHT", new KeyboardAction() {
			public void handleEvent() {
				Point pontoPaddle = paddel.getPosition();
				if ( (pontoPaddle.x + paddel.getWidth()) < Resolution.MSX.width)
				{
					paddel.moveDireita();
					if (bola.getIsMoving() == false)
					{
						bola.moveDireita();
					}
				}
			}
		});

		this.bindKeyPressed("SPACE", new KeyboardAction() {
			public void handleEvent() {
				bola.setIsMoving(true);
			}
		});
	}

	@Override
	protected void loop() {

		if (bola.getIsMoving() == true)
		{
			bola.move();
		}

		for (Quadrado a : fase1.quadrados)
		{
			a.impacto(bola);
		}



		Point posicao = bola.getPosition();

		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-4){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-4){
			bola.direcaoX();
		}


		redraw();
	}
}
