package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import GameObjects.Apple;
import GameObjects.GameObject;
import GameObjects.Player;
import GameObjects.Zombie;

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
	SceneManager scene=new SceneManager();
	public static ArrayList<GameObject> sceneObjects=new ArrayList<GameObject>();
	Player player;
	int gameState;
    final int playState=0;
    final int pauseState=1;
	
	
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
		//double dt=0;
		long lastTime=System.nanoTime();
		//long currentTime;
		long timer=0;
		int drawCount=0;
		
		start();
		while(gameThread!=null) 
		{			
		Time.time=System.nanoTime();
		Time.dt+=(Time.time-lastTime)/drawInterval;
		timer+=(Time.time-lastTime);		
		lastTime=Time.time;
		
		   if(Time.dt>=1){
				
			  update();			
			  repaint();
			
		      Time.dt--;		
		      drawCount++;
		    }
	  	if(timer>=1000000000) {
			//System.out.println("FPS"+drawCount);
			drawCount=0;
			timer=0;
		}
		}
	}
	private void start() {
		
		gameState=playState;
		
		player=new Player(this,keyH);
		sceneObjects.add(player);
		Apple apple=new Apple(200,400,player);
		sceneObjects.add(apple);
		Zombie z=new Zombie(400,400,player);
		sceneObjects.add(z);
	}

	//Logic Update
	public void update() {
		if(gameState==playState) {
			for(int i=0;i< sceneObjects.size();i++) {
				sceneObjects.get(i).update();
			}					
		}		
	} 
	//Rendering 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		scene.render(g);
		
		if(gameState==playState) {			
			for(int i=0;i< sceneObjects.size();i++) {
			sceneObjects.get(i).render(g2);
			}
		}
	//	player.render(g2);
		g2.dispose();
	}
}
