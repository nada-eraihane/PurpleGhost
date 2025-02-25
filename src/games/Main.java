package games;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel gp = new GamePanel();
        window.setTitle("Game Title");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setContentPane(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gp.startGameThread(); // Start the game thread
    }
}
