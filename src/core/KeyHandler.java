package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed,downPressed,leftPressed,rightPressed;
	public boolean CtrlPressed,P_Pressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code =e.getKeyCode();
		P_Pressed=false;
		
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
		if(code==KeyEvent.VK_P) {
				P_Pressed=true;	
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
		if(code==KeyEvent.VK_P) {
			P_Pressed=true;
		}
	}

}
