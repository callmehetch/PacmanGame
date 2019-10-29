package main;

import java.awt.Graphics2D;

import br.ol.pacman.PacmanGame;
import br.ol.pacman.infra.Display;
import br.ol.pacman.infra.Game;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Game extends Runnable {

	public static boolean running = false;
	public Thread gameThread;
	public Grpahics2D;
	public synchronized void start() {
		if(running)return;
		running = true;
		gameThread = new Thread(this);
		  Game game = new PacmanGame();
		gameThread.start();		
	}
	public synchronized void stop() {
		if(!running)return;
		running = false;
		gameThread.join();		
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
              
            	Display view = new Display(game);      	  
                JFrame frame = new JFrame();
                frame.setTitle("Pacman");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                view.requestFocus();
                view.start();
                
              
            }

        });
    }
    
}
