package GameObjects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import Components.Animation;
import Interfaces.IDamageable;
import core.AssetPool;
import core.Time;
import core.Window;

public class Zombie extends GameObject implements IDamageable{
	
	Player player;

	//Rendering stuffs
	BufferedImage[] runAnim;
	Animation[] animations;
	int state=0;
	double timeTracker;
	int currentSpriteIndex=0;
	int lastState=0;
	
	
	//direction variables
	int flipX=0;
	int flipW=1;
   
	//Health variables
	final int maxHealth=20;  
	int currentHealth;  
	  
	public Zombie(int x, int y,Player player) {
		super();
		this.x=x;
		this.y=y;
		this.player=player;
		loadImage();
		loadAnims();
		Window.enemyObjects.add(this);
		currentHealth=maxHealth;
		speed=1;
	}
	
		
	public void loadImage() {
		  image=AssetPool.getSpritesheet("spritesheet1");   
	}
	public void loadAnims() {
		 runAnim=new BufferedImage[6];
	     runAnim[0]= image.getSubimage(6*32, 0, 32, 32);
	     runAnim[1]= image.getSubimage(7*32, 0, 32, 32);
		 for(int i=0;i<4;i++) {
	    	  runAnim[i+2]=image.getSubimage((i)*32, 32, 32, 32);
	      }
	      animations=new Animation[2];
	      animations[0]=new Animation();
	      animations[0].clip=runAnim;
	}
	
	 
	@Override
	public void update() {
		updateHitbox();
		updatePos();
		updateAnim();
	}
	public enum Direction{left,right,up,down};
	Direction dir=Direction.right;
	private void updatePos() {
		
		ChooseDir();
		int ySpeed=0,xSpeed=0;
		switch(dir) {
		case left:
			xSpeed+=speed;
			flipX=width;
			flipW=-1;   
			break;
		case right:
			xSpeed-=speed;
			flipX=0;
			flipW=1;
			break;
		case up:
			ySpeed-=speed;
			break;
		case down:
			ySpeed+=speed;
			break;         
		}
		if(canMoveHere(x+xSpeed,y+ySpeed)) { 
			  this.x+=xSpeed;                  
			  this.y+=ySpeed;                  	 
		}
	}
int actionCounter=0;

	private void ChooseDir() {
		actionCounter++;
		if(actionCounter==120) {
			Random random=new Random();
			int i=random.nextInt(100);
			
			if(i<=25) {
				dir=Direction.up;
			}
			if(i<=50&&i>25) {
				dir=Direction.down;
			}
			if(i<=75&&i>50) {
				dir=Direction.left;
			}
			if(i<=100&&i>75) {
				dir=Direction.right;
			}
			actionCounter=0;
		}
	}


	void updateAnim(){
		 timeTracker -= Time.dt;
			if(state!=lastState) {currentSpriteIndex=0;}
			    if(timeTracker <= 0)
		        {
		          lastState=state;
				if (currentSpriteIndex < animations[state].clip.length-1)
		          {
		              currentSpriteIndex++;
		          }
		          else if(currentSpriteIndex==animations[state].clip.length-1)
		          {
		               currentSpriteIndex=(currentSpriteIndex+1)%animations[state].clip.length;
		          }
		        timeTracker=10; 
				 image= animations[state].clip[currentSpriteIndex]; 
		        }    	  
	}
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(image, x+flipX, y, width*flipW, height, null);
	    g.drawRect(hitbox.x, hitbox.y, 30, 30);
	}
	
	@Override
	public void Destroy() {
		super.Destroy();
		Window.enemyObjects.remove(this);
	}
	@Override
	public Rectangle getHitbox() {
		return hitbox;
	}
	//Health System
	@Override
	public void TakeDamage(int damage) {
		currentHealth-=damage;
		if(currentHealth<=0) {
			Destroy();
		}
	}
	
}
