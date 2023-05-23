package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

<<<<<<< Updated upstream
=======
import Components.Vector;
import GameObjects.GameObject.Direction;
>>>>>>> Stashed changes
import core.Window;
import core.SceneManager;

public class GameObject {

	public int x,y;
	public int speed;
<<<<<<< Updated upstream
	
	protected Rectangle hitbox;
	public int width=30,height=30;
	public BufferedImage image;
	int direction=1;
	
	public GameObject(){
		hitbox=new Rectangle(x,y,width,height);
=======
	public int hitboxDefaultX,hitboxDefaultY;
	//direction variables
		int flipX=0;
		int flipW=1;
	   
	public boolean collisionOn=false;
	public Vector hitbox;
	public int width=30,height=30;
	public BufferedImage image;
	//int direction=1;
	public enum Direction{left,right,up,down,nulll};
	public Direction direction=Direction.right;
  
	Window window;
	public boolean onPath=false;
	int actionCounter=0;
    public boolean trigger=false;
	
	public GameObject(Window window){
		this.window=window;
		hitbox=new Vector(x,y,width,height);
>>>>>>> Stashed changes
	}
	protected void updateHitbox() {
		hitbox.x=x;
		hitbox.y=y;
	}
	public Vector getHitbox() {
		return hitbox;
	}
	protected void drawHitbox(Graphics2D g) {
		g.setColor(Color.PINK);
		g.drawRect(x, y, width, height);
	}
	
	
	protected boolean isSolid(int x,int y) {
		if(x<0 || x>=Window.screenWidth)
			return true;
		if(y<0 || y>=Window.screenHeight)
			return true;
		float xIndex=x/30;
		float yIndex=y/30;
		//	int value=SceneManager.map[x][y];
		int value=SceneManager.map[(int)yIndex][(int)xIndex];
		if(value==1)			
			return true;
		return false;
	}
	public void update() {
<<<<<<< Updated upstream
		
=======
       // checkCollision(); 
	  	collisionOn=false;
	  	window.cCheck.checkEntity(this,Window.sceneObjects.toArray());
	  if(onPath&&!collisionOn) 
	  {
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
	  			  case nulll:
	  				  break;
	  			  }
	  }	
	  ChooseDir();
	  
//	  else {
//		  checkCollision();
//		if(collisionOn) {
//		  	switch(direction) {
//			  case up: y-=speed;break;
//			  case down: y+=speed;break;
//			  case left: 
//				  x-=speed;
//				  flipX=width;
//				  flipW=1;   
//				  break;
//			  case right:
//				  x+=speed;
//				  flipX=0;
//				  flipW=-1;
//				  break;
//			  }
//			
//		}
//	  }
	  	updateHitbox();	
	}
	public void checkCollision() {
		collisionOn=false;
	  	window.cCheck.checkTile(this);
	  	//	window.cCheck.checkObject(this,false);
	  	window.cCheck.checkPlayer(this);	 
>>>>>>> Stashed changes
	}
	public void render(Graphics2D g) {
		
	}
	protected void Destroy() {
		Window.sceneObjects.remove(this);
	}
<<<<<<< Updated upstream
=======
	private void ChooseDir() {
		
		if(onPath==true) {
			int goalCol=Window.player.x/30;
			int goalRow=Window.player.y/30;
//			int goalCol=15;
//			int goalRow=3;
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
		int startCol=(int)x/30;
		int startRow=(int)y/30;
		//if(startCol==goalCol&& startRow==goalRow) return;
		window.pFinder.setNode(startCol, startRow, goalCol, goalRow, this);
		if(window.pFinder.search()) {
			int nextX=window.pFinder.pathList.get(0).col*30;
			int nextY=window.pFinder.pathList.get(0).row*30;
		
			
	       
			
	        	if(nextX>x&&nextY==y) {
	        		direction=Direction.right;
	        	}
	        	else if(nextX<x&&nextY==y) {
	        		direction=Direction.left;
	        	}	        	
	        	else if(nextY>y&&nextX==x) {
	        		direction=Direction.down;
	        	}
	        	else if(nextY<y&&nextX==x) {
	        		direction=Direction.up;
	        	}
	        	else if(direction==Direction.left||direction==Direction.right||direction==Direction.nulll &&Math.abs(nextY-y)<30){
	        		if(nextX>x) {
		        		direction=Direction.right;
		        	}
		        	else if(nextX<x) {
		        		direction=Direction.left;
		        	}	        	
		        		
	        	}
	        	else if(direction==Direction.up||direction==Direction.down||direction==Direction.nulll&&Math.abs(nextX-x)<30){
	        		if(nextY>y) {
		        		direction=Direction.down;
		        	}
		        	else if(nextY<y) {
		        		direction=Direction.up;
		        	}	        	
	        	}
	        	
//	          if(nextX==x&&nextY==y) {
//	        		onPath=false;
//	        		System.out.println(nextX+"<"+y);
//	        	}
//	           if((int)x/30==goalCol&& (int)y/30==goalRow) {
//			    	onPath=false;
//	        		System.out.println(nextX+"<"+y);
//	        	}
			
			
//		    int enLeftX=x;
//		    int enRightX=x+hitbox.width;
//		    int enTopY=y;
//		    int enBottomY=y+hitbox.height;
//		    
//		    if(enTopY>nextY&&enLeftX>=nextX &&enRightX<nextX+30) {
//		    	direction=Direction.up;
//		    }
//		    else if(enTopY<nextY&&enLeftX>=nextX&&enRightX<nextX+30) {
//		    	direction=Direction.down;
//		    }
//		    else if(enTopY>=nextY&&enBottomY<nextY+30) {
//		   
//		    	if(enLeftX>nextX) {
//		    		direction=Direction.left;
//		    	}
//		    	if(enLeftX<nextX) {
//		    		direction=Direction.right;
//		    	}
//		    }
//		    else if(enTopY>nextY&&enLeftX>nextX) {
//		    	direction=Direction.up;
//		    	checkCollision();
//		    	//System.out.println(collisionOn);
//		    	if(collisionOn) { 
//		    		direction=Direction.left;
//		    	}
//		    }
//		    else if(enTopY>nextY&&enLeftX<nextX) {
//		    	direction=Direction.up;
//
//		    	checkCollision();
//		    	if(collisionOn) { 			
//		    		direction=Direction.right;
//		    	}
//		    }
//		    else if(enTopY<nextY&&enLeftX>nextX) {
//		    	direction=Direction.down;
//		    	checkCollision();
//		    	if(collisionOn) { 	
//		    		direction=Direction.left;
//		    	}
//		    }
//		    else if(enTopY<nextY&&enLeftX<nextX) {
//		    	direction=Direction.down;
//		    	checkCollision();
//		    	if(collisionOn) { 	
//		    		direction=Direction.right;
//		    	}
//		    }
		    
		    int nextCol=window.pFinder.pathList.get(0).col;
		    int nextRow=window.pFinder.pathList.get(0).row;
		    if(nextCol==goalCol&&nextRow==goalRow) {
	//	    	onPath=false;
		    	direction=Direction.nulll;
		    }
		    		    
		}
	}
	
	
>>>>>>> Stashed changes
}
