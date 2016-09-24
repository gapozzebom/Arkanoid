package game;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Sprite;

public class Quadrado extends Sprite{


	private Point posicao;
	private int vida;
	
	public Quadrado(int width, int height, Color background, int resist) {
		
		super(width, height, background);
		posicao = this.getPosition();
		vida = resist;
		
	}
	
	public int getVida() {
		return vida;
	}

	@Override
	public void draw(Canvas canvas) {
		if (vida > 0)
			super.draw(canvas);
	}

	public void impacto (Bola bola)
	{
		if ( quadradoYF() > bola.bolaYI() &&  quadradoYI() < bola.bolaYF() ) 
		{
			if (bola.bolaXI() < quadradoXF() && bola.bolaXF() > quadradoXI() ) // bateu em baixo
			{

				bola.direcaoY();
				this.vida--;
				Console.println(this.vida + "Bateu!" );

			}
		}
	}
	
	//Retorna ponto do Inicio da Largura do quadrado EIXO X
	public double quadradoXI() 
	{
		return this.posicao.x;
	}
	//Retorna ponto do Final da Largura da bola EIXO X
	public double quadradoXF() 
	{
		return (this.posicao.x + this.getWidth()); 
	}

	//Retorna o canto Superior Esquerdo da bola EIXO Y
	public double quadradoYI() 
	{
		return this.posicao.y;
	}
	//Retorna o canto Superior Direito da bola EIXO Y
	public double quadradoYF() 
	{
		return (this.posicao.y + this.getHeight());
	}
	
}
