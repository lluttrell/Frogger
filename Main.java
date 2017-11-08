import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Handles JFrame and launching the game.
 */
public class Main extends JFrame {

    private Main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter \"text\" or \"GUI\":");
        String choice = sc.next();
        while (!(choice.equalsIgnoreCase("text") || choice.equalsIgnoreCase("GUI"))) {
            System.out.println("Incorrect input");
            System.out.print("Enter \"text\" or \"GUI\":");
            choice = sc.next();
        }
        if (choice.equalsIgnoreCase("text")) {
            initText();
        } else if (choice.equalsIgnoreCase("GUI")) {
            initGUI();
        }
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
