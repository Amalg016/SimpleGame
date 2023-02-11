package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    Panel gp;	
	Font arial_40,arial_80B;
	private String message;
	private boolean messageOn;
	Graphics2D g;
	
	public UI(Panel p) {
         gp=p;
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
		
		if(gp.gameState==gp.playState) {
			
		}
		if(gp.gameState==gp.pauseState) {
			
		}
	}

	public void drawPauseScreen() {
		String test="PAUSED";
	//	int length=(int)g.getFontMetrics().
	//	int x,y=gp.screenHeight/2; 
		
	}
}
