//importando classes necessarias
import javax.swing.Timer; //Classe de timer, para definir o tempo e f/r

import java.applet.*; //Classe para exportar o app como um applet
import java.awt.*; //Classes da biblioteca Advanced Windows Toolkit
import java.awt.event.*;

//Comentario irrelevante


public class pongMain extends Applet implements MouseMotionListener, ActionListener{

	//declaração das intancias das classes Ball e os dois Paddles
	Ball ball;
	PaddleLeft pLeft;
	PaddleRight pRight;
	// fonte a ser usada para mostrar o Score
	Font newFont = new Font("sansserif", Font.BOLD, 20);
	// criando so graficos usando a classe bufferGraphics, para lidar com o flickering
	Graphics bufferGraphics; 
	// a imagem que irá conter tudo que vai ser mostrado em bufferGraphics
	Image offscreen;
	//variaveis para definir o tamanho do applet
	final int WIDTH = 500, HEIGHT = 300;
	
	//variavei usada para guardar o tempo decorrido desde o inicio do jogo
	long currentTime;
	
	public void init(){
		//ajusta o tamanho da tela para 500 x 300px
		setSize(500, 300);
		// instanciando a bola e as plataformas
		ball = new Ball();
		pLeft = new PaddleLeft();
		pRight = new PaddleRight(ball.getY() - 35);
		
		// adicionando o mouseMotionListener, para o usuario controlar a plataforma
		addMouseMotionListener(this);
		//adicionando a cor de fundo do jogo
		setBackground(Color.GREEN);
		//cria uma offscreen image para desenhar na tela
		offscreen = createImage(WIDTH, HEIGHT);
		bufferGraphics = offscreen.getGraphics();
		
	}
	
	public void start(){
		//gameloop principal do jogo
		
		//variavel com o tempo atual e milisegundos
		currentTime = System.currentTimeMillis();
		
		//adicionando um timer para a execução do jogo que atualiza
		//a tela a cada 15 milisegundos (1000/15), o que dá 67 frames
		//por segundo
		Timer time = new Timer(15, this);
		
		//inicio do Game Loop. Ele não irá terminar até o computador
		// ter 10 pontos no score.
		//o tempo vai ser iniciado, assim o metodo actionPerformed vai ser executado a cada 15 milisegundos
		time.start();
		while(pRight.getScore() < 10){
			//nada acontece aqui, mas o timer continua rodando no background
			//executando o metodo actionPerformed e fazendo o programa rodar			
		}
		//depois que o jogo termina, o timer é parado e é calculado
		// quanto tempo o  usuario jogou subtraing o tempo atual pela variavel de tempo inicial currentTime
		time.stop();
		currentTime = System.currentTimeMillis() - currentTime;
		//vamos repintar a tela mais uma vez para mostrar
		//quanto tempo o jogador durou no jogo
		repaint();
	}
	
	public void checkCollision(){
		//lembrar que a bola é 10x10px e as posições x e y 
		//são os cantos topo-esquerdo da bola. 
		
		if(ball.getY() == 0 || ball.getY() == 290){
			ball.dy = (ball.dy * -1);
		}
		
		if((ball.getX() == 40) && hitPaddle()){
			ball.dx = (ball.dx * -1);
			
		}
		if(ball.getX() == 460){
			ball.dx = (ball.dx * -1);
			
		}
		if(ball.getX() == 0){
			pRight.setScore(pRight.getScore() + 1);
			ball.reset();
		}
		
	}
	
	public boolean hitPaddle(){
		boolean didHit = false;
		
		if((pLeft.getPos() - 10) <= ball.getY() && (pLeft.getPos() + 70) > ball.getY()){
			
			didHit = true;
		}
		return didHit;
	}
	
	
	public void paint(Graphics g){
		
		// ao invez de usar graficos normais, vou usar bufferGraphics
		bufferGraphics.clearRect(0, 0, WIDTH, HEIGHT);
		
		bufferGraphics.setColor(Color.blue);
		
		//lado esquerdo
		bufferGraphics.fillRect(pLeft.XPOS, pLeft.getPos(), 10, 70);
		//lado direito
		bufferGraphics.fillRect(pRight.XPOS, pRight.getPos(), 10, 70);
		
		bufferGraphics.setColor(Color.WHITE);
		bufferGraphics.setFont(newFont);
		bufferGraphics.drawString("Futile", 150, 15);
		bufferGraphics.drawString("" + pRight.getScore(), 300, 15);
		bufferGraphics.fillRect(240, 0, 20, 300);
		
		if(pRight.getScore() == 10){
			
			bufferGraphics.drawString("Você Durou: "+ (currentTime/1000) + " segundos", 40, 150);
		
		}
		
		bufferGraphics.setColor(Color.red);
		bufferGraphics.fillRect(ball.getX(), ball.getY(), 10, 10);
		g.drawImage(offscreen, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//move a bola
		ball.move();
		// alinha a plataforma da AI com a bola
		pRight.setPos(ball.getY() - 35);
		//checa a bola para achar uma colisão
		checkCollision();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		pLeft.setPos(evt.getY() - 35);
		
	}
	
	

}
