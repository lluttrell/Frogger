import javax.swing.*;
import java.awt.*;

/**
 * Handles JFrame and launching the game.
 */
public class Main extends JFrame {

    public Main() {

        initText();
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

    private void initGUI() {
        ControllerGUI controllerGUI = new ControllerGUI();
        add(controllerGUI.getViewGUI());

        setSize(480, 480);
        setResizable(false);

        setTitle("Frogger");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initText() {
        ControllerText controllerText = new ControllerText();
        add(controllerText.getViewText());

        setSize(0, 0);
        setResizable(false);

        setTitle("Frogger");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
