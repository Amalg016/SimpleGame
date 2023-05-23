package GameObjects;

import java.awt.Graphics2D;
import java.io.InputStream;

import javax.imageio.ImageIO;

import core.AssetPool;
import core.Window;

public class Apple extends GameObject{


Player player;
public Apple(int x,int y,Window window) {
	super(window);
	this.x=x;
	this.y=y;
   this.player=window.player;
   Window.interactables.add(this);
     image=AssetPool.getSpritesheet("spritesheet1");
     image=image.getSubimage(3*30, 2*32, 30, 32);
     

}

@Override
public void update() {
	CheckForPlayer();	
	updateHitbox();
}


public void CheckForPlayer() {
  	if(player.hitbox.intersects(this.hitbox)) {	
  		Destroy();
  	}  	
}

@Override
public void Destroy() {
	super.Destroy();
	Window.interactables.remove(this);
}

@Override
public void render(Graphics2D g) {
	  int screenX=x-player.x+player.screenX;
	   int screenY=y-player.y+player.screenY;
//	   g.drawImage(levelSprites[map[y][x]], x*30, (y+2)*30, 30, 30,  null); 
    if(x+30>player.x- player.screenX&&
	  x-30<player.x+player.screenX&&
	  y+30>player.y-player.screenY&&
	  y-30<player.y+player.screenY
	  ) {        	  
	   g.drawImage(image, screenX, screenY, width, 30,  null); 
    }
	 
//	g.drawImage(image,x,y,width,height,null);
	//  drawHitbox(g);
}

}
