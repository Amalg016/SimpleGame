package GameObjects;
import core.Window;
import core.Time;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
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
int state=0;
double timeTracker;
int dir=1;
int flipX=0;
int flipW=1;

BufferedImage[] runAnim;
BufferedImage[] attackAnim;
Animation[] animations;
Rectangle2D.Float attackbox;




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
	 InputStream is=getClass().getResourceAsStream("/Assets/Images/Scavengers_Spritesheet.png");
     try{
    	 image=ImageIO.read(is);
     }catch(Exception e) {
    	 System.out.println(e);
     }
     
     loadAnims();
     loadAttackBox();
  }
  
  
  public void loadAttackBox() {
	  	 attackbox=new Rectangle2D.Float(x,y,15,30); 
  }
  
  
  public void loadAnims() {
	//  idleAnim[0]=image.getSubimage(0,0,16,30);
	  runAnim=new BufferedImage[6];
	  attackAnim=new BufferedImage[2];
     
	  // updating idle sprites to the array
	  for(int i=0;i<runAnim.length;i++) {
    	  runAnim[i]=image.getSubimage((i)*32, 0, 32, 32);
      }
	  
	  //updating running sprites to the array

	  attackAnim[0]=image.getSubimage(0,5*32, 32, 32); 
	  attackAnim[1]=image.getSubimage(32,5*32, 32, 32); 
	  
	  
      animations=new Animation[2];
      animations[0]=new Animation();
      animations[1]=new Animation();
      animations[0].clip=runAnim;
      animations[1].clip=attackAnim;
  }
  
  int currentIndex=0;
  int lastState=0;
  
  @Override
  public void update() {
	  updateAttackBox();
	  updateAttackLogic();
	   updatePos();
	   updateHitbox();
	   updateAnim();
  }
  
  public void updateAttackLogic(){
	  if(keyH.SpaceBarPressed&&state!=1) {
		  state=1;
		  for(int i =0;i<Window.enemyObjects.size();i++) {
			  if(attackbox.intersects(Window.enemyObjects.get(i).hitbox)) {
				  Window.enemyObjects.get(i).Destroy();
			  }
			  
		  }
		}
  }
  
  public void updateAttackBox(){
	  if(dir==1) {
		  attackbox.x=hitbox.x+hitbox.width;
	  }else {
		  attackbox.x=hitbox.x-hitbox.width+15;
	  }
	  attackbox.y=hitbox.y;
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
			if(state==1&&currentIndex==1) {
				state=0;
			}
	        }    
  }
  
  @Override
  public void render(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x,y, p.tileSize,p.tileSize);	
        
        g2.drawImage(image,hitbox.x+flipX,hitbox.y,width*flipW,height,null);
       DrawAttackbox(g2);
        // drawHitbox(g2);
  }
  
  public void DrawAttackbox(Graphics2D g2) {
	  g2.setColor(Color.blue);
	  g2.drawRect((int)attackbox.x, (int)attackbox.y,(int) attackbox.width,(int) attackbox.height);
  }
}
