package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import GameObjects.Player;

public class Panel extends JPanel implements Runnable{

	final int originalTileSize=16;
	final int scale=3;
	public final int tileSize = originalTileSize*scale;
	final int maxScreenCol=16;
	final int maxScreenRow=12;
	final int screenWidth=tileSize*maxScreenCol;
	final int screenHeight=tileSize*maxScreenRow;			

	int FPS=60;
	
	int playerX=100;
	int playerY=100;
	int playerSpeed=4;
	
	Thread gameThread;
	KeyHandler keyH=new KeyHandler();
	Player player=new Player(this,keyH);
	
	public Panel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread=new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval=1000000000/FPS;
		double dt=0;
		long lastTime=System.nanoTime();
		long currentTime;
		long timer=0;
		int drawCount=0;
		
		
		while(gameThread!=null) 
		{			
		currentTime=System.nanoTime();
		dt+=(currentTime-lastTime)/drawInterval;
		timer+=(currentTime-lastTime);		
		lastTime=currentTime;
		
		   if(dt>=1){
				
			  update();			
			  repaint();
			
		      dt--;		
		      drawCount++;
		    }
	  	if(timer>=1000000000) {
			System.out.println("FPS"+drawCount);
			drawCount=0;
			timer=0;
		}
		}
	}
	public void update() {
		player.update();
	} 
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		player.render(g2);
		g2.dispose();
	}
}
