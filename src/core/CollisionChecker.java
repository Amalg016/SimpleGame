package core;

import GameObjects.GameObject;

public class CollisionChecker {

   Window window;
   public CollisionChecker(Window window) {
	   this.window=window;
   }
   
   public void checkTile(GameObject entity) {
	   int entityLeftWorldX=entity.x ;//+ entity.hitbox.x;
	   int entityRightWorldX=entity.x +entity.hitbox.width;
	   int entityTopWorldY=entity.y ;//+ entity.hitbox.y;
	   int entityBottomWorldY=entity.y +entity.hitbox.height;
	   
	   int entityLeftCol=entityLeftWorldX/window.tileSize;
	   int entityRightCol=entityRightWorldX/window.tileSize;
       int entityTopRow=entityTopWorldY/window.tileSize;
       int entityBottomRow=entityBottomWorldY/window.tileSize;
       int tileNum1,tileNum2;
       
       switch(entity.direction) {
       case up:
    	   entityTopRow=(entityTopWorldY-entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityLeftCol][entityTopRow];
    	   tileNum2=window.scene.map[entityRightCol][entityTopRow];
    	//	  System.out.println(tileNum1+","+tileNum2);
<<<<<<< HEAD
    	   if(window.scene.tiles[entityLeftCol][entityTopRow].collision==true||window.scene.tiles[entityRightCol][entityTopRow].collision==true) {
=======
    	   if(window.scene.tiles[tileNum1].collision==true||window.scene.tiles[tileNum2].collision==true) {
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
    		   entity.collisionOn=true;
    	   } 
    	   break;
       case down:
    	   entityBottomRow=(entityBottomWorldY+entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityLeftCol][entityBottomRow];
    	   tileNum2=window.scene.map[entityRightCol][entityTopRow];
<<<<<<< HEAD
    	   if(window.scene.tiles[entityLeftCol][entityBottomRow].collision==true||window.scene.tiles[entityRightCol][entityTopRow].collision==true) {
=======
    	   if(window.scene.tiles[tileNum1].collision==true||window.scene.tiles[tileNum2].collision==true) {
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
    		   entity.collisionOn=true;
    	   }
    	   break;
       case left:
    	   entityLeftCol=(entityLeftWorldX-entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityLeftCol][entityTopRow];
    	   tileNum2=window.scene.map[entityLeftCol][entityBottomRow];
<<<<<<< HEAD
    	   if(window.scene.tiles[entityLeftCol][entityTopRow].collision==true||window.scene.tiles[entityLeftCol][entityBottomRow].collision==true) {
=======
    	   if(window.scene.tiles[tileNum1].collision==true||window.scene.tiles[tileNum2].collision==true) {
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
    		   entity.collisionOn=true;
    	   }
    	   break;
    	   
       case right:
    	   entityRightCol=(entityRightWorldX+entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityRightCol][entityTopRow];
    	   tileNum2=window.scene.map[entityRightCol][entityBottomRow];
<<<<<<< HEAD
    	   if(window.scene.tiles[entityRightCol][entityTopRow].collision==true||window.scene.tiles[entityRightCol][entityBottomRow].collision==true) {
=======
    	   if(window.scene.tiles[tileNum1].collision==true||window.scene.tiles[tileNum2].collision==true) {
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
    		   entity.collisionOn=true;
    	   }
    	   break;
       }
   }
   
   //NPC
   public int checkEntity(GameObject entity,GameObject[] target) {
	   int index=999;
	   for(int i=0;i<target.length;i++) {
<<<<<<< HEAD
		   if(target[i]!=null&&entity!=target[i]) {
=======
		   if(target[i]!=null) {
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
			   
			   entity.hitbox.x=entity.x+entity.hitbox.x;
			   entity.hitbox.y=entity.y+entity.hitbox.y;
			   
<<<<<<< HEAD
//			   target[i].hitbox.x=target[i].x+target[i].hitbox.x;
//			   target[i].hitbox.y=target[i].y+target[i].hitbox.y;
//			   
=======
			   target[i].hitbox.x=target[i].x+target[i].hitbox.x;
			   target[i].hitbox.y=target[i].y+target[i].hitbox.y;
			   
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
			   switch(entity.direction) {
			   case up:
				   entity.hitbox.y-=entity.speed;
				   if(entity.hitbox.intersects(target[i].hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   case down:
				   entity.hitbox.y+=entity.speed;
				   if(entity.hitbox.intersects(target[i].hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   case left:
				   entity.hitbox.x-=entity.speed;
				   if(entity.hitbox.intersects(target[i].hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   case right:
				   entity.hitbox.x+=entity.speed;
				   if(entity.hitbox.intersects(target[i].hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   }
			   
		   }
<<<<<<< HEAD
//		   entity.hitbox.x=entity.hitboxDefaultX;
//		   entity.hitbox.y=entity.hitboxDefaultY;
//				   target[i].hitbox.x=target[i].hitboxDefaultX;
//				   target[i].hitbox.y=target[i].hitboxDefaultY;
	   }
	   return index;
   }
   
=======
		   entity.hitbox.x=entity.hitboxDefaultX;
		   entity.hitbox.y=entity.hitboxDefaultY;
				   target[i].hitbox.x=target[i].hitboxDefaultX;
				   target[i].hitbox.y=target[i].hitboxDefaultY;
	   }
	   return index;
   }
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
   public int checkEntity(GameObject entity,Object[] target) {
	   int index=999;
	   for(int i=0;i<target.length;i++) {
		   GameObject t=(GameObject)target[i]; 
<<<<<<< HEAD

		   if(target[i]!=null&&entity!=t && !t.trigger) 
		   {
//			   entity.hitbox.x=entity.x+entity.hitbox.x;
//			   entity.hitbox.y=entity.y+entity.hitbox.y;
			 
			//   t.hitbox.x=t.x+t.hitbox.x;
			//   t.hitbox.y=t.y+t.hitbox.y;
=======
		   if(target[i]!=null) {
			   entity.hitbox.x=entity.x+entity.hitbox.x;
			   entity.hitbox.y=entity.y+entity.hitbox.y;
			   
			   t.hitbox.x=t.x+t.hitbox.x;
			   t.hitbox.y=t.y+t.hitbox.y;
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
			   
			   switch(entity.direction) {
			   case up:
				   entity.hitbox.y-=entity.speed;
				   if(entity.hitbox.intersects(t.hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   case down:
				   entity.hitbox.y+=entity.speed;
				   if(entity.hitbox.intersects(t.hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   case left:
				   entity.hitbox.x-=entity.speed;
				   if(entity.hitbox.intersects(t.hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
			   case right:
				   entity.hitbox.x+=entity.speed;
				   if(entity.hitbox.intersects(t.hitbox)) {
					   entity.collisionOn=true;	   
				       index=i;
				   }
				   break;
<<<<<<< HEAD
			default:
				break;
			   }
			   
		   
		   }
			//   entity.hitbox.x=entity.hitboxDefaultX;
		   //entity.hitbox.y=entity.hitboxDefaultY;
//				   t.hitbox.x=t.hitboxDefaultX;
//				   t.hitbox.y=t.hitboxDefaultY;
=======
			   }
			   
		   }
		   entity.hitbox.x=entity.hitboxDefaultX;
		   entity.hitbox.y=entity.hitboxDefaultY;
				   t.hitbox.x=t.hitboxDefaultX;
				   t.hitbox.y=t.hitboxDefaultY;
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	   }
	   return index;
   }
   public void checkPlayer(GameObject entity) {
	   entity.hitbox.x=entity.x+entity.hitbox.x;
	   entity.hitbox.y=entity.y+entity.hitbox.y;
	   
	   window.player.hitbox.x=window.player.x+window.player.hitbox.x;
	   window.player.hitbox.y=window.player.y+window.player.hitbox.y;
	   
	   switch(entity.direction) {
	   case up:
		   entity.hitbox.y-=entity.speed;
		   if(entity.hitbox.intersects(window.player.hitbox)) {
			   entity.collisionOn=true;	      
		   }
		   break;
	   case down:
		   entity.hitbox.y+=entity.speed;
		   if(entity.hitbox.intersects(window.player.hitbox)) {
			   entity.collisionOn=true;	   
		   }
		   break;
	   case left:
		   entity.hitbox.x-=entity.speed;
		   if(entity.hitbox.intersects(window.player.hitbox)) {
			   entity.collisionOn=true;	   
		   }
		   break;
	   case right:
		   entity.hitbox.x+=entity.speed;
		   if(entity.hitbox.intersects(window.player.hitbox)) {
			   entity.collisionOn=true;	   
		   }
		   break;
	   }
	   
   
   entity.hitbox.x=entity.hitboxDefaultX;
   entity.hitbox.y=entity.hitboxDefaultY;
<<<<<<< HEAD
		  Window.player.hitbox.x=Window.player.hitboxDefaultX;
		  Window.player.hitbox.y=Window.player.hitboxDefaultY; 
=======
		  window.player.hitbox.x=window.player.hitboxDefaultX;
		  window.player.hitbox.y=window.player.hitboxDefaultY; 
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
   
}
   }
