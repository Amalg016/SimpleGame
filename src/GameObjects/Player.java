package GameObjects;
import core.Panel;
import core.Time;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Components.Animation;
import core.KeyHandler;
public class Player extends GameObject{
Panel p;
KeyHandler keyH;

final int idle=0;
final int move=1;
int state=0;
double timeTracker;

BufferedImage[] idleAnim;
BufferedImage[] runAnim;
Animation[] animations;
  public Player(Panel p,KeyHandler h) {
	 this.p=p;
	 this.keyH=h;
	 start();
  }
  public void start() {
	  x=100;
	  y=100;
	  speed=4;
	 InputStream is=getClass().getResourceAsStream("/Images/Player/bigSpritesheet.png");
     try{
    	 image=ImageIO.read(is);
     }catch(Exception e) {
    	 System.out.println(e);
     }
     loadAnims();
  }
  
  public void loadAnims() {
	  idleAnim=new BufferedImage[1];
	  idleAnim[0]=image.getSubimage(0,0,16,30);
	  runAnim=new BufferedImage[3];
      for(int i=0;i<runAnim.length;i++) {
    	  runAnim[i]=image.getSubimage((i+1)*16, 0, 16, 30);
      }
      animations=new Animation[2];
      animations[0]=new Animation();
      animations[1]=new Animation();
      animations[0].clip=idleAnim;
      animations[1].clip=runAnim;
  }
  
  int currentIndex=0;
  int lastState=0;
  public void update() {
	  if(keyH.upPressed) {
			y-=speed;
		}
		else if(keyH.downPressed) {
			y+=speed;
		}
		else if(keyH.leftPressed) {
			x-=speed;
			state=1;
		}
		else if(keyH.rightPressed) {
			x+=speed;
			state=1;
		}
		else if(!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
			state=0;
		}
	  
	  
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
  
  public void render(Graphics2D g2) {
		g2.setColor(Color.white);
		//g2.fillRect(x,y, p.tileSize,p.tileSize);	
        g2.drawImage(image,x, y, null);
      //  g2.drawImage(runAnim[0],x, y, null);
  }
}
