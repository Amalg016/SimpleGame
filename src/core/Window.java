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
import Interfaces.IDamageable;

public class Window extends JPanel implements Runnable{

	final static int originalTileSize=16;
	final static int scale=3;
	public static final int tileSize = originalTileSize*scale;
	final static int maxScreenCol=16;
	final static int maxScreenRow=12;
	public static final int screenWidth=tileSize*maxScreenCol;
	public static final int screenHeight=tileSize*maxScreenRow;			
    
	
	
	int FPS=60;
	
	int playerX=100;
	int playerY=100;
	int playerSpeed=4;
	
	Thread gameThread;
	private AssetPool ap=new AssetPool();
	KeyHandler keyH=new KeyHandler(this);
	SceneManager scene=new SceneManager();
	
	public static ArrayList<GameObject> sceneObjects=new ArrayList<GameObject>();
	public static ArrayList<GameObject> interactables=new ArrayList<GameObject>();
	public static ArrayList<IDamageable> enemyObjects=new ArrayList<IDamageable>();
	
	UI ui;
	Player player;
	
	public int gameState=0;
    public final int titleState=0;
	public final int playState=1;
    public final int pauseState=2;
		
	public Window() {
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
		long lastTime=System.nanoTime();
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
		//gameState=playState;
		ui=new UI(this);
		player=new Player(this,keyH);
		//sceneObjects.add(player);
		Apple apple=new Apple(200,400,player);
		sceneObjects.add(apple);
		Zombie z=new Zombie(400,400,player);
		sceneObjects.add(z);
	}
	private boolean P_Ready=true;
	//Logic Update
	public void update() {
			if(keyH.Esc_Pressed) {
				if(P_Ready) {
				gameState=gameState==playState?pauseState:playState;
				P_Ready=false;
				}
			}
			else {
				P_Ready=true;
			}
		
		
		if(gameState==playState) {
			player.update();
			for(int i=0;i< sceneObjects.size();i++) {
				sceneObjects.get(i).update();
			}					
		}		
		keyH.update();   
	} 
	
	//Rendering 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		if(gameState==titleState){
		   
		}
		else{
		scene.render(g);
		player.render(g2);
			for(int i=0;i< sceneObjects.size();i++) {
			sceneObjects.get(i).render(g2);	
			}	
		}
		ui.render(g2);
			
		g2.dispose();
	}
}
