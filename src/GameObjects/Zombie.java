package GameObjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Components.Animation;
import core.Time;

public class Zombie extends GameObject {
	public Zombie() {
		super();
	}
	public Zombie(int x, int y,Player player) {
		super();
		this.x=x;
		this.y=y;
		this.player=player;
		loadImage();
		loadAnims();
	}
	
	Player player;
	BufferedImage[] runAnim;
	Animation[] animations;
	int state=0;
	double timeTracker;
	int dir=1;
	int flipX=0;
	int flipW=1;

	
	public void loadImage() {
		 InputStream is=getClass().getResourceAsStream("/Images/Player/Scavengers_Spritesheet.png");
	     try{
	    	 image=ImageIO.read(is);
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }     
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
	
	  int currentIndex=0;
	  int lastState=0;
	 
	@Override
	public void update() {
		updateAnim();
	}
	
	void updateAnim(){
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
	public void render(Graphics2D g) {
		g.drawImage(image, x+flipX, y, width*flipW, height, null);
	}
	
}
