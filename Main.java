import javax.swing.*;
import java.awt.*;

/**
 * Handles JFrame and launching the game.
 */
public class Main extends JFrame {

    public Main() {

        initUI();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Main game = new Main();
                game.setVisible(true);
            }
        });
    }

    private void initUI() {
        ControllerGUI controllerGUI = new ControllerGUI();
        add(controllerGUI.getViewGUI());

        setSize(480, 480);
        setResizable(false);

        setTitle("Frogger");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
