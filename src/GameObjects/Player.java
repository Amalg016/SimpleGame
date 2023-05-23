package GameObjects;
import core.Window;

import core.Time;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Components.Animation;
import Components.Vector;
import Interfaces.IDamageable;
import core.AssetPool;
import core.KeyHandler;
public class Player extends GameObject implements IDamageable{

	Window p;
	KeyHandler keyH;
    public int screenX,screenY;
	
//Animation related
	int state=0;
	final int idle=0;
    final int move=1;
    final int dead=2;
    BufferedImage[] runAnim;
    BufferedImage[] attackAnim;
    Animation[] animations;
    double timeTracker;

//direction related
    int dir=1;

//Combat related
<<<<<<< HEAD
<<<<<<< Updated upstream
    Rectangle2D.Float attackbox;
=======
    Vector attackbox;
>>>>>>> Stashed changes
=======
    Rectangle attackbox;
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195

//Health
    final int maxLives=5;    
    public int currentLives=3;

  public Player(Window p,KeyHandler h) {
	 super(p);
	  this.p=p;
	 this.keyH=h;
	 hitboxDefaultX=hitbox.x;
	 hitboxDefaultY=hitbox.y;
	 
	 start();
  }
  public void start() {
	  x=300;
	  y=500;
	  screenX=Window.screenWidth/2  -15;
	  screenY=Window.screenHeight/2 -15;
	  speed=2;
	hitbox.height=20;
	hitbox.width=20;
	image=AssetPool.getSpritesheet("spritesheet1");       
     loadAnims();
     loadAttackBox();
  }
  
  
  public void loadAttackBox() {
<<<<<<< HEAD
<<<<<<< Updated upstream
	  	 attackbox=new Rectangle2D.Float(x,y,15,30); 
=======
	  	 attackbox=new Vector(x,y,15,30); 
>>>>>>> Stashed changes
=======
	  	 attackbox=new Rectangle(x,y,15,30); 
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
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
			  if(attackbox.intersects(Window.enemyObjects.get(i).getHitbox())) {
				  Window.enemyObjects.get(i).TakeDamage(10);
			  }			  
		  }
		}
  }
  
  public void updateAttackBox(){
	  if(dir==1) {
		  attackbox.x=x+hitbox.width;
	  }else {
		  attackbox.x=x-hitbox.width+15;
	  }
	  attackbox.y=y;
  }
  
  //Updating position based on input
  
  public void updatePos() {
	   if(!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
		return;
	   }
	  int xSpeed=0,ySpeed=0;
	  if(keyH.upPressed&&!keyH.downPressed) {
		  direction=Direction.up;	
		//  ySpeed=-speed;
		}
	  if(keyH.downPressed&&!keyH.upPressed) {
		  direction=Direction.down;
		 // ySpeed=speed;
		}
	  if(keyH.leftPressed&&!keyH.rightPressed) {
		  direction=Direction.left;
		  //xSpeed=-speed;
			dir=-1;
			flipX=width;
			flipW=-1;
		}
	  if(keyH.rightPressed&&!keyH.leftPressed) {
		  direction=Direction.right;
		   // xSpeed=speed;
			dir=1;
			flipX=0;
			flipW=1;
		}
<<<<<<< HEAD
<<<<<<< Updated upstream
	  if(canMoveHere(x+xSpeed,y+ySpeed)) {
		  this.x+=xSpeed;
		  this.y+=ySpeed;
	  }	  
=======
=======
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
//	  if(canMoveHere(x+xSpeed,y+ySpeed)) {
//		  this.x+=xSpeed;
//		  this.y+=ySpeed;
//	  }	  
	  
	  collisionOn=false;
	  window.cCheck.checkTile(this);

<<<<<<< HEAD
	  window.cCheck.checkEntity(this,Window.sceneObjects.toArray());
=======
	  int npcIndex=window.cCheck.checkEntity(this,Window.sceneObjects.toArray());
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	  
	  if(collisionOn==false) {
		  switch(direction) {
		  case up: y-=speed;break;
		  case down: y+=speed;break;
		  case left: x-=speed;break;
		  case right: x+=speed;break;
		  }
	  }
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
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
        
//        g2.drawImage(image,hitbox.x+flipX,hitbox.y,width*flipW,height,null);
	    g2.drawImage(image,screenX+flipX,screenY,width*flipW,height,null); 
	     DrawAttackbox(g2);
        // drawHitbox(g2);
  }
  
  public void DrawAttackbox(Graphics2D g2) {
<<<<<<< HEAD
<<<<<<< Updated upstream
	  g2.setColor(Color.blue);
	  g2.drawRect((int)attackbox.x, (int)attackbox.y,(int) attackbox.width,(int) attackbox.height);
=======
=======
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	  g2.setColor(Color.blue);	  
	   int sX=(int)attackbox.x -x+screenX;
	   int sY=(int)attackbox.y -y+screenY;             	  
	   g2.drawRect(sX, sY,(int) attackbox.width,(int) attackbox.height);
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
     
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
  }
 
  @Override
  public Vector getHitbox() {
		return hitbox;
  }
  
  @Override
  public void TakeDamage(int damage) {
	
  }
}
