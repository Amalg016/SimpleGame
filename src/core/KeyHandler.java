package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed,downPressed,leftPressed,rightPressed;
	public boolean CtrlPressed,Esc_Pressed;
	public boolean SpaceBarPressed,EnterPressed;
	boolean spaceReady=true;
	Window window;
	public KeyHandler(Window w) {
		window=w;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code =e.getKeyCode();
		
		if(window.gameState==window.titleState) {
			if(code==KeyEvent.VK_W) {
				window.ui.commandNum--;
				if(window.ui.commandNum<0) {
					window.ui.commandNum=2;
				}
			}
			if(code==KeyEvent.VK_S) {
				window.ui.commandNum++;	
				if(window.ui.commandNum>2) {
					window.ui.commandNum=0;
				}
			}
			if(code==KeyEvent.VK_ENTER) {
				if(window.ui.commandNum==0) {				
					window.gameState=window.playState;	
				}
				if(window.ui.commandNum==2) {				
				  System.exit(0);
				}
			}
		}
		if(window.gameState==window.playState)
		{	
			if(code==KeyEvent.VK_W) {
			upPressed=true;
		}
			if(code==KeyEvent.VK_S) {
			downPressed=true;
		}
			if(code==KeyEvent.VK_A) {
			leftPressed=true;
		}
			if(code==KeyEvent.VK_D) {
			rightPressed=true;
		}
			if(code==KeyEvent.VK_CONTROL) {
			CtrlPressed=true;
		}
			if(code==KeyEvent.VK_ESCAPE) {
				Esc_Pressed=true;	
		}
			if(code==KeyEvent.VK_SPACE) {
				if(spaceReady) {
				SpaceBarPressed=true;	
				spaceReady=false;				 
				}
			}
		}
		if(window.gameState==window.pauseState)
		{
			if(code==KeyEvent.VK_ESCAPE) {
				Esc_Pressed=true;	
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code =e.getKeyCode();
		
		
		if(code==KeyEvent.VK_W) {
			upPressed=false;
		}
		if(code==KeyEvent.VK_S) {
			downPressed=false;
		}
		if(code==KeyEvent.VK_A) {
			leftPressed=false;
		}
		if(code==KeyEvent.VK_D) {
			rightPressed=false;
		}
		if(code==KeyEvent.VK_CONTROL) {
			CtrlPressed=false;
		}
		if(code==KeyEvent.VK_ESCAPE) {
			Esc_Pressed=false;
		}
		if(code==KeyEvent.VK_SPACE) {
			spaceReady=true;			
		}
		if(code==KeyEvent.VK_ENTER) {
			EnterPressed=false;	
		}
	}

	public void update() {
		SpaceBarPressed=false;
	}
}
