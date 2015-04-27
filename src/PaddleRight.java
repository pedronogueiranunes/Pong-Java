// plataforma que vai ser controlada pela AI
public class PaddleRight {

	private int yPos = 0, score;  // variavel do eixo Y - controla a plataforma do lado direito
	final int XPOS = 460; // posi��o da plataforma no eixo X - Horizontal
	
	// o construtor recebe um inteiro, que neste caso � a posi��o Y da bola
	public PaddleRight(int ballPos) {
		//ajusta a posi��o e seta o score em 0
		setPos(ballPos); 
		setScore(0);
		
	}
	public void setPos(int pos){
	//mesmo ajuste que a plataforma esqueda (PaddleLeft)
		this.yPos = pos; // recebe a variavel inteira pos e altera a variavel yPos
		if (yPos > 230){
			setPos(230);
			
		}else if (yPos < 0 ){
			setPos(0);	
		}
	}
	
	public int getPos(){		
		return yPos; //metodo getter para pegar a posi��o da Plataforma
	}
	
	public void setScore(int score){
		this.score = score; //metodo setter para ajustar a posi��o da plataforma
		
	}
	
	public int getScore(){ 
		return this.score; // metodo para pegar a pontua��o da paddle 
		
	}
}
