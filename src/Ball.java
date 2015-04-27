
public class Ball {
	
	private int xPos, yPos; //variaveis para as posi��es no eixo X e Y
	public int dx = 5, dy = -5; //variaveis para a dire��o de bounce da bola
	
	public Ball (){
		// metodo construtor da bola
		setPos(250,140); //
	}
	
	public void setPos(int x, int y){
		// metodo para ajustar a posi��o da bola na tela
		this.xPos = x; // ajusta a posi��o da bola no eixo X
		this.yPos = y;// ajusta a posi��o da bola no eixo Y	
	}
	
	public int getX(){
		return xPos; //metodo getter para a posi��o da bola no eixo X
	}
	
	public int getY(){
		return yPos;
		
	}
	
	public void move(){
		// metodo para mover a bola na tela
		// pega a posi��o atual de X e Y e adiciona uma dire��o de movimento
		// (dx e dy) para alterar o ricocheteio da bola
		setPos(this.getX() + dx, this.getY()+dy);
		
	}
	
	public void reset(){
		// metodo para resetar quando o computador pontua
		// ajusta para os valores iniciais
		setPos(250, 140);
		dx = 5;
		dy = -5;
	}
}

