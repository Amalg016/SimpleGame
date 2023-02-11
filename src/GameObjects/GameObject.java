package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.Panel;
import core.SceneManager;

public class GameObject {

	public int x,y;
	public int speed;
	
	protected Rectangle hitbox;
	public int width=30,height=30;
	public BufferedImage image;
	int direction=1;
	
	public GameObject(){
		hitbox=new Rectangle(x,y,width,height);
	}
	protected void updateHitbox() {
		hitbox.x=x;
		hitbox.y=y;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	protected void drawHitbox(Graphics2D g) {
		g.setColor(Color.PINK);
		g.drawRect(x, y, width, height);
	}
	
	protected boolean canMoveHere(int x,int y) {
		if(!isSolid(x,y))
			if(!isSolid(x+width,y+height))
				if(!isSolid(x+width,y))
					if(!isSolid(x,y+height))
					{  return true;}
		return false;
	}
	
	protected boolean isSolid(int x,int y) {
//		if(x<0 || x>=500)
//			return true;
//		if(y<0 || y>=300)
//			return true;
		float xIndex=x/30;
		float yIndex=y/30;
		//	int value=SceneManager.map[x][y];
		int value=SceneManager.map[(int)yIndex][(int)xIndex];
		if(value==1)
		{			
			return true;
		}return false;
	}
	public void update() {
		
	}
	public void render(Graphics2D g) {
		
	}
	protected void Destroy() {
		Panel.sceneObjects.remove(this);
	}
}
