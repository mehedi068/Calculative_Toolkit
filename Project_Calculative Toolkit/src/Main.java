import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        new calculator.Calculator("Calculator");
//       JFrame frame = new MainFrame("Java Project");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame("Calculative_Toolkit");
                mainFrame.setVisible(true);
            }
        });
    }
}
