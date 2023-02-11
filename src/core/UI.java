package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    Window window;	
	Font arial_40,arial_80B;
	private String message;
	private boolean messageOn;
	Graphics2D g;
	
	public UI(Window p) {
         window=p;
         arial_40=new Font("Arial",Font.PLAIN,40);
         arial_80B=new Font("Arial",Font.BOLD,80);
	}

	public void showMessage(String test) {
		message=test;
		messageOn=true;
	}
	
	public void render(Graphics2D g) {
		this.g=g;
		g.setFont(arial_40);
		g.setColor(Color.white);
		
		if(window.gameState==window.playState) {
			
		}
		if(window.gameState==window.pauseState) {
			drawPauseScreen(); 	
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
