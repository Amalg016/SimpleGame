package core;

import javax.swing.JFrame;

public class Game {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame window=new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2d");
		
		Panel panel=new Panel();
		window.add(panel);
		
		window.pack();
		panel.startGameThread();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

}
