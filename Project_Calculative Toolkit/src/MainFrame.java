
import calculator.Calculator;
import calendar.DateCalculator;
import converter.Converter;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    private final int FRAME_WIDTH = 400, FRAME_HEIGHT = 400;

    MainFrame(String title) throws HeadlessException {
        super(title);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Calculator", new Calculator());
        tabbedPane.addTab("Converter", new Converter());
        tabbedPane.addTab("Calendar", new DateCalculator());

        add(tabbedPane, BorderLayout.CENTER);

//        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }
}
