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

    	   if(window.scene.tiles[entityLeftCol][entityTopRow].collision==true||window.scene.tiles[entityRightCol][entityTopRow].collision==true) {
    		   entity.collisionOn=true;
    	   } 
    	   break;
       case down:
    	   entityBottomRow=(entityBottomWorldY+entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityLeftCol][entityBottomRow];
    	   tileNum2=window.scene.map[entityRightCol][entityTopRow];

    	   if(window.scene.tiles[entityLeftCol][entityBottomRow].collision==true||window.scene.tiles[entityRightCol][entityTopRow].collision==true) {
    		   entity.collisionOn=true;
    	   }
    	   break;
       case left:
    	   entityLeftCol=(entityLeftWorldX-entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityLeftCol][entityTopRow];
    	   tileNum2=window.scene.map[entityLeftCol][entityBottomRow];

    	   if(window.scene.tiles[entityLeftCol][entityTopRow].collision==true||window.scene.tiles[entityLeftCol][entityBottomRow].collision==true) {
    		   entity.collisionOn=true;
    	   }
    	   break;
    	   
       case right:
    	   entityRightCol=(entityRightWorldX+entity.speed)/window.tileSize;
    	   tileNum1=window.scene.map[entityRightCol][entityTopRow];
    	   tileNum2=window.scene.map[entityRightCol][entityBottomRow];
    	   if(window.scene.tiles[entityRightCol][entityTopRow].collision==true||window.scene.tiles[entityRightCol][entityBottomRow].collision==true) {
    		   entity.collisionOn=true;
    	   }
    	   break;
       }
   }
   
   //NPC
   public int checkEntity(GameObject entity,GameObject[] target) {
	   int index=999;
	   for(int i=0;i<target.length;i++) {

		   if(target[i]!=null&&entity!=target[i]) {

			   
			   entity.hitbox.x=entity.x+entity.hitbox.x;
			   entity.hitbox.y=entity.y+entity.hitbox.y;
			   

//			   target[i].hitbox.x=target[i].x+target[i].hitbox.x;
//			   target[i].hitbox.y=target[i].y+target[i].hitbox.y;

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

//		   entity.hitbox.x=entity.hitboxDefaultX;
//		   entity.hitbox.y=entity.hitboxDefaultY;
//				   target[i].hitbox.x=target[i].hitboxDefaultX;
//				   target[i].hitbox.y=target[i].hitboxDefaultY;
	   }
	   return index;
   }
   

   public int checkEntity(GameObject entity,Object[] target) {
	   int index=999;
	   for(int i=0;i<target.length;i++) {
		   GameObject t=(GameObject)target[i]; 

		   if(target[i]!=null&&entity!=t && !t.trigger) 
		   {
//			   entity.hitbox.x=entity.x+entity.hitbox.x;
//			   entity.hitbox.y=entity.y+entity.hitbox.y;
			 
			//   t.hitbox.x=t.x+t.hitbox.x;
			//   t.hitbox.y=t.y+t.hitbox.y;
			   
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
			default:
				break;
			   }
			   
		   
		   }
			//   entity.hitbox.x=entity.hitboxDefaultX;
		   //entity.hitbox.y=entity.hitboxDefaultY;
//				   t.hitbox.x=t.hitboxDefaultX;
//				   t.hitbox.y=t.hitboxDefaultY;

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
		  Window.player.hitbox.x=Window.player.hitboxDefaultX;
		  Window.player.hitbox.y=Window.player.hitboxDefaultY; 

   
}
   }
