package GameObjects;

import java.awt.Graphics2D;
import java.io.InputStream;

import javax.imageio.ImageIO;

import core.Window;

public class Apple extends GameObject{


Player player;
public Apple(int x,int y,Player player) {
	super();
	this.x=x;
	this.y=y;
   this.player=player;
   Window.interactables.add(this);

  
  InputStream is=getClass().getResourceAsStream("/Assets/Images/Scavengers_Spritesheet.png");
     try{
    	 image=ImageIO.read(is);
     }catch(Exception e) {
    	 System.out.println(e);
     }
     image=image.getSubimage(3*30, 2*32, 30, 32);

}

@Override
public void update() {
	CheckForPlayer();	
	updateHitbox();
}


public void CheckForPlayer() {
  	if(player.hitbox.intersects(hitbox)) {	
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
	  g.drawImage(image,x,y,width,height,null);
	//  drawHitbox(g);
}

}
