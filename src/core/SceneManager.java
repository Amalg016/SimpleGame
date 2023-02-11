package core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class SceneManager {

	   public static int[][] map =
           {
            {  1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
            {  1 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
            {  1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 1 , 1 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 1 , 1 , 1 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,1,1,1,1,1,0,0,1,},
            {  1 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,1,1,1,1,1,0,0,1,},
            {  1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
      };
	BufferedImage[] levelSprites;

	BufferedImage image;
   
	public SceneManager() {
	   levelSprites=new BufferedImage[8];
	   InputStream is=getClass().getResourceAsStream("/Assets/Images/Scavengers_Spritesheet.png");
	     try{
	    	 image=ImageIO.read(is);
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }
	    
	     levelSprites[0]=image.getSubimage(30, 32*4, 30, 32);
	   
	     for(int i=1;i<8;i++) {	    	 
	    	 levelSprites[i]=image.getSubimage((i)*30, 3*32, 30, 32);	     
	     }   
	}
   
	   public void render(Graphics g)
       {
            for (int x = 0; x < map[0].length; x++)
           {
               for (int y = 0; y < 19; y++)
               {
                	  g.drawImage(levelSprites[map[y][x]], x*30, y*30, 30, 30,  null); 
               }
           }
       }
}
