package GameObjects;

import java.awt.Graphics2D;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Apple extends GameObject{

public Apple() {
	super();
}
Player player;
public Apple(int x,int y,Player player) {
	super();
	this.x=x;
	this.y=y;
   this.player=player;

  
  InputStream is=getClass().getResourceAsStream("/Images/Player/Scavengers_Spritesheet.png");
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
  	if(((int) player.hitbox.x/30==(int)hitbox.x/30)&&((int) player.hitbox.y/30==(int)hitbox.y/30)) {
  		Destroy();
  	}  	
}

@Override
public void render(Graphics2D g) {
	  g.drawImage(image,x,y,width,height,null);
	//  drawHitbox(g);
}

}
