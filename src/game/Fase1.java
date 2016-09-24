package game;

import java.util.ArrayList;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Resolution;

public class Fase1 {
	
	private int larguraDoQuadrado = Resolution.MSX.width/14;
	ArrayList<Quadrado> quadrados = new ArrayList<Quadrado>();
	private int auxiliar;
	public int auxiliarLinha;
	
	ArrayList<Color> cores = new ArrayList<Color>();
	
	
	
	public Fase1()
	{
		cores.add(Color.GRAY);
		cores.add(Color.RED);
		cores.add(Color.YELLOW);
		cores.add(Color.BLUE);
		cores.add( new Color(255,105,180) );
		cores.add(Color.GREEN);
				
		for (int l = 0; l<6; l++)
		{
			auxiliarLinha = 10*l + l;
			for (int i = 0; i<13; i++)
			{
				int resist = l == 0 ? 1 : 2; 
				
				Quadrado quadrado = new Quadrado(larguraDoQuadrado, 8, cores.get(l), resist);
				auxiliar = larguraDoQuadrado*i + i ;

				quadrado.setPosition(auxiliar+1, auxiliarLinha+1);
				quadrados.add(quadrado);
				
			}
			
		}

	}

}

