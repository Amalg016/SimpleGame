package GameObjects;
import core.Window;
import core.Time;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Components.Animation;
import core.AssetPool;
import core.KeyHandler;
public class Player extends GameObject{
Window p;
KeyHandler keyH;

final int idle=0;
final int move=1;
int state=1;
double timeTracker;
int dir=1;
int flipX=0;
int flipW=1;

BufferedImage[] idleAnim;
BufferedImage[] runAnim;
Animation[] animations;
  public Player(Window p,KeyHandler h) {
	 super();
	  this.p=p;
	 this.keyH=h;
	 start();
  }
  public void start() {
	  x=60;
	  y=500;
	  speed=1;
	  
	//image=AssetPool.getSpritesheet("Images/Player/Scavengers_Spritesheet.png");  
	 InputStream is=getClass().getResourceAsStream("/Images/Scavengers_Spritesheet.png");
     try{
    	 image=ImageIO.read(is);
     }catch(Exception e) {
    	 System.out.println(e);
     }
     
     loadAnims();
  }
  
  public void loadAnims() {
	  idleAnim=new BufferedImage[1];
	//  idleAnim[0]=image.getSubimage(0,0,16,30);
	  runAnim=new BufferedImage[6];
      for(int i=0;i<runAnim.length;i++) {
    	  runAnim[i]=image.getSubimage((i)*32, 0, 32, 32);
      }
      animations=new Animation[2];
      animations[0]=new Animation();
      animations[1]=new Animation();
      animations[0].clip=idleAnim;
      animations[1].clip=runAnim;
  }
  
  int currentIndex=0;
  int lastState=0;
  
  @Override
  public void update() {
	   updatePos();
	   updateHitbox();
	   updateAnim();
  }
  
  //Updating position based on input
  public void updatePos() {
	   if(!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
		return;
	   }
	  int xSpeed=0,ySpeed=0;
	  if(keyH.upPressed&&!keyH.downPressed) {
			ySpeed=-speed;
		}
	  if(keyH.downPressed&&!keyH.upPressed) {
			ySpeed=speed;
		}
	  if(keyH.leftPressed&&!keyH.rightPressed) {
			xSpeed=-speed;
			dir=-1;
			flipX=width;
			flipW=-1;
		}
	  if(keyH.rightPressed&&!keyH.leftPressed) {
			xSpeed=speed;
			dir=1;
			flipX=0;
			flipW=1;
		}
	  if(canMoveHere(x+xSpeed,y+ySpeed)) {
		  this.x+=xSpeed;
		  this.y+=ySpeed;
	  }
	  
  }
  
  //updating animations
  public void updateAnim() {
	  timeTracker -= Time.dt;
		if(state!=lastState) {currentIndex=0;}
		    if(timeTracker <= 0)
	        {
	          lastState=state;
			if (currentIndex < animations[state].clip.length-1)
	          {
	              currentIndex++;
	          }
	          else if(currentIndex==animations[state].clip.length-1)
	          {
	               currentIndex=(currentIndex+1)%animations[state].clip.length;
	          }
	        timeTracker=10; 
			image= animations[state].clip[currentIndex]; 
	        }    
  }
  
  @Override
  public void render(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x,y, p.tileSize,p.tileSize);	
        
        g2.drawImage(image,hitbox.x+flipX,hitbox.y,width*flipW,height,null);
       // drawHitbox(g2);
  }
}
