package frogger;

import frogger.controller.ControllerGUI;
import frogger.controller.ControllerText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Main handles launching the game through a GUI interface.
 * Inherits JFrame and implements ActionListener for button presses.
 */
public class Main extends JFrame implements ActionListener {
    private JFrame controlFrame;

    /**
     * Constructs text or gui version based on user input.
     */
    private Main() {
        controlFrame = new JFrame("Frogger");
        controlFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JButton textBtn = new JButton("Text Version");
        textBtn.setActionCommand("TEXT");
        textBtn.addActionListener(this);

        JButton guiBtn = new JButton("Graphical Version");
        guiBtn.setActionCommand("GUI");
        guiBtn.addActionListener(this);

        textBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlPanel.add(textBtn);

        guiBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlPanel.add(guiBtn);

        controlFrame.getContentPane().add(controlPanel);
        controlFrame.setLocationRelativeTo(null);
        controlFrame.pack();
        controlFrame.setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Main game = new Main();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("TEXT")) {
            controlFrame.dispose();
            try {
                initText();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (event.getActionCommand().equals("GUI")) {
            controlFrame.dispose();
            try {
                initGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Initializes the GUI version of the game
     *
     * @throws IOException
     */
    private void initGUI() throws IOException {
        ControllerGUI controllerGUI = new ControllerGUI();
        super.add(controllerGUI.getViewGUI());
        super.setTitle("Galactic Frogger");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.pack();
        super.setVisible(true);
    }

    /**
     * Initializes the text version of the game
     *
     * @throws IOException
     */
    private void initText() throws IOException {
        ControllerText controllerText = new ControllerText();
        super.add(controllerText.getViewText());
        super.setSize(0, 0);
        super.setResizable(false);
        super.setTitle("Frogger");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
