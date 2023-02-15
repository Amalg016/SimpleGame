package GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import GameObjects.GameObject.Direction;
import core.Window;
import core.TileManager;

public class GameObject {

	public int x,y;
	public int speed;
	public int hitboxDefaultX,hitboxDefaultY;
	//direction variables
		int flipX=0;
		int flipW=1;
	   
	public boolean collisionOn=false;
	public Rectangle hitbox;
	public int width=30,height=30;
	public BufferedImage image;
	//int direction=1;
	public enum Direction{left,right,up,down};
	public Direction direction=Direction.right;
  
	Window window;
	public boolean onPath=false;
	int actionCounter=0;

	
	public GameObject(Window window){
		this.window=window;
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
//		if(x<0 || x>=Window.screenWidth)
//			return true;
//		if(y<0 || y>=Window.screenHeight)
//			return true;
		float xIndex=x/30;
		float yIndex=y/30;
		//	int value=SceneManager.map[x][y];
		int value=TileManager.map[(int)yIndex][(int)xIndex];
		if(value==1)			
			return true;
		return false;
	}
	public void update() {
	  	ChooseDir();
       // checkCollision(); 
	  	
	  	if(collisionOn==false) {
	  			  switch(direction) {
	  			  case up: y-=speed;break;
	  			  case down: y+=speed;break;
	  			  case left: 
	  				  x-=speed;
	  				  flipX=width;
	  				  flipW=1;   
	  				  break;
	  			  case right:
	  				  x+=speed;
	  				  flipX=0;
	  				  flipW=-1;
	  				  break;
	  			  }
	  		  }
	  	
	}
	public void checkCollision() {
		collisionOn=false;
	  	window.cCheck.checkTile(this);
	  	//	window.cCheck.checkObject(this,false);
	  	window.cCheck.checkPlayer(this);	 
	}
	public void render(Graphics2D g) {
		
	}
	protected void Destroy() {
		Window.sceneObjects.remove(this);
	}
	private void ChooseDir() {
		
		if(onPath==true) {
			int goalCol=8;
			int goalRow=3;
		    searchPath(goalCol,goalRow);   
		}
		else {
			
			actionCounter++;	
			if(actionCounter==120) {
			
				Random random=new Random();
			
				int i=random.nextInt(100);
		
				if(i<=25) {
					direction=Direction.up;
				}
				if(i<=50&&i>25) {
				    direction=Direction.down;
			    }
				if(i<=75&&i>50) {
				    direction=Direction.left;
			    }
			    if(i<=100&&i>75) {
				    direction=Direction.right;
			    }
			       actionCounter=0;	
			}
		}
	}
	public void searchPath(int goalCol,int goalRow) {
		int startCol=(x)/30;
		int startRow=(y)/30;
		
		//System.out.println(TileManager.map.length);
		window.pFinder.setNode(startCol, startRow, goalCol, goalRow, this);
		if(window.pFinder.search()==true) {
			int nextX=window.pFinder.pathList.get(0).col*30;
			int nextY=window.pFinder.pathList.get(0).row*30;
		
		    int enLeftX=x;
		    int enRightX=x+hitbox.width;
		    int enTopY=y;
		    int enBottomY=y+hitbox.height;
		    
		    if(enTopY>nextY&&enLeftX>=nextX &&enRightX<nextX+30) {
		    	direction=Direction.up;
		    }
		    else if(enTopY<nextY&&enLeftX>=nextX&&enRightX<nextX+30) {
		    	direction=Direction.down;
		    }
		    else if(enTopY>nextY&&enBottomY<nextY+30) {
		   
		    	if(enLeftX>nextX) {
		    		direction=Direction.left;
		    	}
		    	if(enLeftX<nextX) {
		    		direction=Direction.right;
		    	}
		    }
		    else if(enTopY>nextY&&enLeftX>nextX) {
		    	direction=Direction.up;
		    	//checkCollision();
		    	checkCollision();
		    	//System.out.println(collisionOn);
		    	if(collisionOn) { 	
		    		direction=Direction.left;
		    	}
		    }
		    else if(enTopY>nextY&&enLeftX<nextX) {
		    	direction=Direction.up;

		    	checkCollision();
		    	if(collisionOn) { 			
		    		direction=Direction.right;
		    	}
		    }
		    else if(enTopY<nextY&&enLeftX>nextX) {
		    	direction=Direction.down;
		    	//checkCollision();
		    	checkCollision();
		    	if(collisionOn) { 	
		    		direction=Direction.left;
		    	}
		    }
		    else if(enTopY<nextY&&enLeftX<nextX) {
		    	direction=Direction.down;
		    	//checkCollision();
		    	checkCollision();
		    	if(collisionOn) { 	
		    		direction=Direction.right;
		    	}
		    }
		    
		    int nextCol=window.pFinder.pathList.get(0).col;
		    int nextRow=window.pFinder.pathList.get(0).row;
		    if(nextCol==goalCol&&nextRow==goalRow) {
		    	onPath=false;
		    }
		}
	}
	
	
}
