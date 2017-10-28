import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {

    public Main() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(480, 480);
        setResizable(false);

        setTitle("Frogger");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
