/*
 * Classe para controlar a plataforma da esquerda

*/
public class PaddleLeft {
	
	private int yPos = 0; // variavel do eixo Y - Vertical
	final int XPOS = 30; // variavel do eixo X - Horizontal
	
	public PaddleLeft (){
	//metodo construtor	
		
		setPos(120); //ajusta a posi��o no meio da tela no eixo Y
		
	}
	
	public void setPos(int pos){
	//M�todo para ajustar a posi��o da pleataforma	no eixo Y
	this.yPos = pos;
	
	if (yPos > 230) {
		
		setPos(230); 
		
	} else if (yPos < 0 ) {
		
		setPos(0);  
		
	}
	
	}

	public int getPos() {
		return yPos; //metodo getter para pegar a posi��o da Plataforma
	
	}

}
