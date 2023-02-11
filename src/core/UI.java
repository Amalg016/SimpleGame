package core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UI {

    Window window;	
	Font arial_40,arial_80B;
	Graphics2D g;
	public int commandNum=0; 
	BufferedImage heart;
	
	public UI(Window p) {
         window=p;
         arial_40=new Font("Arial",Font.PLAIN,40);
         arial_80B=new Font("Arial",Font.BOLD,80);     
         heart=AssetPool.getSpritesheet("spritesheet2");
         heart=heart.getSubimage(8, 12*3, 9, 12);
	}
   int lives=3;
	public void render(Graphics2D g) {
		this.g=g;
		g.setFont(arial_40);
		g.setColor(Color.white);

		if(window.gameState==window.titleState) {
		  	drawTitleScreen();
		}
		if(window.gameState==window.playState) {
			for(int i=0;i<window.player.currentLives;i++)
			{
				g.drawImage(heart,40*i, 10, 40, 40, null);
			}
		}
		if(window.gameState==window.pauseState) {
		    drawSubWindow(Window.screenWidth/4 ,Window.screenHeight/4 -30,Window.screenWidth/2,Window.screenHeight/2);
			drawPauseScreen(); 	
		}
	}
    public void drawSubWindow(int x,int y ,int width,int height) {
    	Color c=new Color(0,0,0,210);
    	g.setColor(c);
    	g.fillRoundRect(x,y,width,height,35,35);
    	
    	c=new Color(255,255,255);
    	g.setColor(c);
    	g.setStroke(new BasicStroke());
    	g.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
    
	private void drawTitleScreen() {
	//g.setColor(Color.green);
	//g.fillRect(0, 0, window.screenWidth, window.screenHeight);
		g.setFont(g.getFont().deriveFont(Font.BOLD,96F));
		String text="!!";
		
		int x=getX(text);	
		int y=window.tileSize*2;
		
		g.setColor(Color.white);
		g.drawString(text, x, y);
      
		
		g.setFont(g.getFont().deriveFont(Font.BOLD,48F));
		text="New Game";
		x=getX(text);
		y+=window.tileSize*5;
        g.drawString(text,x,y);
        if(commandNum==0) {
        	g.drawString(">", x-40, y);
        }
        
         
		text="Load";
		x=getX(text);
		y+=window.tileSize*2;
        g.drawString(text,x,y);
        if(commandNum==1){
        	g.drawString(">", x-20, y);        	
        }
        
		text="Exit";
		x=getX(text);
		y+=window.tileSize*2;
        g.drawString(text,x,y);
        if(commandNum==2){
        	g.drawString(">", x-20, y);        	
        }

	}

	public void drawPauseScreen() {
	g.setFont(g.getFont().deriveFont(Font.PLAIN,80F));
		String test="PAUSED";
		int x=getX(test);
		int y=window.screenHeight/2; 
		g.drawString(test,x,y);
	}
	public int getX(String test) {
		int length=(int)g.getFontMetrics().getStringBounds(test, g).getWidth();
		int x=window.screenWidth/2-length/2;
		return x;	
	}
}
