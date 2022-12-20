package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Converter extends JPanel {

    public Converter() {

        ArrayList<Conversion> conversions = new ArrayList<>();
        conversions.add(new Conversion("m-ft", 3.28084));
        conversions.add(new Conversion("ft-m", 0.3048));
        conversions.add(new Conversion("kg-lb", 2.20462));
        conversions.add(new Conversion("lb-kg", 0.453592));

        setLayout(new GroupLayout(this));

        for (int i = 0; i < conversions.size(); i++) {
            Conversion conversion = conversions.get(i);
            add(addConverterPanel(conversion, i*50));
        }

    }

    private JPanel addConverterPanel(Conversion conversion, int y) {

        JPanel conversionPanel = new JPanel();
        conversionPanel.setLayout(new GroupLayout(conversionPanel));
        conversionPanel.setBounds(0, y,400, 50);

        TextField inputField;
        Button conversionButton;
        Label resultLabel;

        inputField = new TextField("1.0");
        inputField.setBounds(10, 10, 120, 30);

        resultLabel = new Label(String.valueOf(conversion.getConversionUnit()), Label.CENTER);
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setBounds(250, 10, 120, 30);

        conversionButton = new Button(conversion.getConversionLabel());
        conversionButton.setBounds(140, 10, 100, 30);
        conversionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double input = Double.valueOf(inputField.getText());
                    resultLabel.setText(String.valueOf(input * conversion.getConversionUnit()));
                    inputField.setBackground(Color.WHITE);
                } catch (NumberFormatException nfe) {
                    inputField.setBackground(Color.RED);
                }
            }
        });


        conversionPanel.add(inputField);
        conversionPanel.add(conversionButton);
        conversionPanel.add(resultLabel);

        return conversionPanel;

    }

}
