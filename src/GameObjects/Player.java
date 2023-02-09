package GameObjects;
import core.Panel;

import java.awt.Color;
import java.awt.Graphics2D;

import core.KeyHandler;
public class Player extends GameObject{
Panel p;
KeyHandler keyH;
  
  public Player(Panel p,KeyHandler h) {
	 this.p=p;
	 this.keyH=h;
	 start();
  }
  public void start() {
	  x=100;
	  y=100;
	  speed=4;
  }
  public void update() {
	  if(keyH.upPressed) {
			y-=speed;
		}
		else if(keyH.downPressed) {
			y+=speed;
		}
		else if(keyH.leftPressed) {
			x-=speed;
		}
		else if(keyH.rightPressed) {
			x+=speed;
		}
  }
  
  public void render(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(x,y, p.tileSize,p.tileSize);	
  }
}
