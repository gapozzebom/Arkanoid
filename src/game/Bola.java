package game;

import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;

public class Bola extends Sprite {
	
	private double dy = -2;
	private double dx = 2;
	private Point ponto = this.getPosition();
	private boolean isMoving = false;
	
	public Bola (){
		super(5, 5, Color.BLACK);
		this.setPosition(Resolution.MSX.width/2 - 2, Resolution.MSX.height - 30);
	}
	
	public void move(){
		super.move(dx, dy);
	}
	
	public void direcaoX(){
		dx *= -1;
	}
	
	public void direcaoY(){
		dy *= -1;
	}
	
	public double getDy() {
		return dy;
	}


	public double getDx() {
		return dx;
	}

		
	public boolean getIsMoving() {
		return isMoving;
	}

	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}


	//Retorna ponto do Inicio da Largura da bola EIXO X
	public double bolaXI() 
	{
		return this.ponto.x;
	}
	//Retorna ponto do Final da Largura da bola EIXO X
	public double bolaXF() 
	{
		return (this.ponto.x + this.getWidth()); 
	}

	//Retorna o canto Superior Esquerdo da bola EIXO Y
	public double bolaYI() 
	{
		return this.ponto.y;
	}
	//Retorna o canto Superior Direito da bola EIXO Y
	public double bolaYF() 
	{
		this.ponto = getPosition();
		return (this.ponto.y + this.getHeight());
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
