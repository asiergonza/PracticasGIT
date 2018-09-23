
/**
 * @author asiergonzi
 *definimos nuestro coche que luego sera el objeto que usaremos 
 */
public class Coche {
	JLabelGraficoAjustado ja;
	int vel;
	int x;
	int y;
	double rot;
	double movX;
	double movY;
	
	
	public Coche(JLabelGraficoAjustado ja,int vel, int x, int y, double rot) {
		this.ja = ja;
		this.vel = vel;
		this.x = x;
		this.y = y;
		this.rot = rot;
		
	}
	
	
	public Coche(JLabelGraficoAjustado ja,int vel, int x, int y, double rot,double movX, double movY) {
		this.ja = ja;
		this.vel = vel;
		this.x = x;
		this.y = y;
		this.rot = rot;
		this.movX = movX;
		this.movY = movY;
		
	}

}
