package calendar;

import converter.Conversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateCalculator extends JPanel {

    private int diffYears, diffDays;

    public DateCalculator() {

        setLayout(new GroupLayout(this));

//        Date 1
        Label dateLabelOne = new Label("Date 1", Label.CENTER);
        dateLabelOne.setBounds(10 , 10, 360, 30);

        JPanel conversionPanelOne = new JPanel();
        conversionPanelOne.setLayout(new GroupLayout(conversionPanelOne));
        conversionPanelOne.setBounds(0, 40,400, 50);

        Label yearLabelOne, monthLabelOne, dayLabelOne;
        TextField yearTextFieldOne, monthTextFieldOne, dayTextFieldOne;

        yearLabelOne = new Label("Year", Label.CENTER);
        yearLabelOne.setBounds(5, 10, 40,30);

        yearTextFieldOne = new TextField("");
        yearTextFieldOne.setBounds(55, 10, 60, 30);

        monthLabelOne = new Label("Month", Label.CENTER);
        monthLabelOne.setBounds(115, 10, 40,30);

        monthTextFieldOne = new TextField("");
        monthTextFieldOne.setBounds(165,10,60,30);

        dayLabelOne = new Label("Day", Label.CENTER);
        dayLabelOne.setBounds(235, 10, 40,30);

        dayTextFieldOne = new TextField("");
        dayTextFieldOne.setBounds(285,10,60,30);

        conversionPanelOne.add(yearLabelOne);
        conversionPanelOne.add(yearTextFieldOne);
        conversionPanelOne.add(monthLabelOne);
        conversionPanelOne.add(monthTextFieldOne);
        conversionPanelOne.add(dayLabelOne);
        conversionPanelOne.add(dayTextFieldOne);

//    Date 2
        Label dateLabelTwo = new Label("Date 2", Label.CENTER);
        dateLabelTwo.setBounds(10 , 90, 360, 30);

        JPanel conversionPanelTwo = new JPanel();
        conversionPanelTwo.setLayout(new GroupLayout(conversionPanelTwo));
        conversionPanelTwo.setBounds(0, 130,400, 50);

        Label yearLabelTwo, monthLabelTwo, dayLabelTwo;
        TextField yearTextFieldTwo, monthTextFieldTwo, dayTextFieldTwo;


        yearLabelTwo = new Label("Year", Label.CENTER);
        yearLabelTwo.setBounds(5, 10, 40,30);

        yearTextFieldTwo = new TextField("");
        yearTextFieldTwo.setBounds(55, 10, 60, 30);

        monthLabelTwo = new Label("Month", Label.CENTER);
        monthLabelTwo.setBounds(115, 10, 40,30);

        monthTextFieldTwo = new TextField("");
        monthTextFieldTwo.setBounds(165,10,60,30);

        dayLabelTwo = new Label("Day", Label.CENTER);
        dayLabelTwo.setBounds(235, 10, 40,30);

        dayTextFieldTwo = new TextField("");
        dayTextFieldTwo.setBounds(285,10,60,30);

        conversionPanelTwo.add(yearLabelTwo);
        conversionPanelTwo.add(yearTextFieldTwo);
        conversionPanelTwo.add(monthLabelTwo);
        conversionPanelTwo.add(monthTextFieldTwo);
        conversionPanelTwo.add(dayLabelTwo);
        conversionPanelTwo.add(dayTextFieldTwo);

//        Calculation and warnings
        Label dateLabelWarning = new Label("*Date 1 must be smaller than Date 2", Label.CENTER);
        dateLabelWarning.setBounds(10 , 180, 360, 20);

        Button calculateButton = new Button("Calculate");
        calculateButton.setBounds(10,220,360,30);

        Label resultLabel = new Label("", Label.CENTER);
        resultLabel.setBounds(10,270,360,30);
        resultLabel.setBackground(Color.WHITE);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yearOne, monthOne, dayOne, yearTwo, monthTwo, dayTwo;

                try {
                    // First date (Before)
                    yearOne = Integer.parseInt(yearTextFieldOne.getText());
                    monthOne = Integer.parseInt(monthTextFieldOne.getText());
                    dayOne = Integer.parseInt(dayTextFieldOne.getText());

                    // Second date (After)
                    yearTwo = Integer.parseInt(yearTextFieldTwo.getText());
                    monthTwo = Integer.parseInt(monthTextFieldTwo.getText());
                    dayTwo = Integer.parseInt(dayTextFieldTwo.getText());

                    Calendar calendarOne = getCalnedarFromDate(yearOne, monthOne, dayOne);
                    Calendar calendarTwo = getCalnedarFromDate(yearTwo, monthTwo, dayTwo);

                    if (calendarOne.after(calendarTwo)) {
                        JOptionPane.showMessageDialog(null, "Date 1 must be smaller than Date 2!");
                    } else {
                        resultLabel.setText(getDifference(calendarOne, calendarTwo));
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter valid date!");
                }
            }
        });

        add(dateLabelOne);
        add(conversionPanelOne);
        add(dateLabelTwo);
        add(conversionPanelTwo);
        add(dateLabelWarning);
        add(calculateButton);
        add(resultLabel);
    }

/*    private JPanel addDatePanel(int y) {

        JPanel conversionPanel = new JPanel();
        conversionPanel.setLayout(new GroupLayout(conversionPanel));
        conversionPanel.setBounds(0, y,400, 50);

        Label yearLabel, monthLabel, dayLabel;
        TextField yearTextField, monthTextField, dayTextField;


        yearLabel = new Label("Year", Label.CENTER);
        yearLabel.setBounds(5, 10, 40,30);

        yearTextField = new TextField("");
        yearTextField.setBounds(55, 10, 60, 30);

        monthLabel = new Label("Month", Label.CENTER);
        monthLabel.setBounds(115, 10, 40,30);

        monthTextField = new TextField("");
        monthTextField.setBounds(165,10,60,30);

        dayLabel = new Label("Day", Label.CENTER);
        dayLabel.setBounds(235, 10, 40,30);

        dayTextField = new TextField("");
        dayTextField.setBounds(285,10,60,30);

        conversionPanel.add(yearLabel);
        conversionPanel.add(yearTextField);
        conversionPanel.add(monthLabel);
        conversionPanel.add(monthTextField);
        conversionPanel.add(dayLabel);
        conversionPanel.add(dayTextField);

        return conversionPanel;
    }*/

    private Calendar getCalnedarFromDate(int year, int month, int day) {
        return new GregorianCalendar(year, month, day);
    }

    private String getDifference(Calendar calendarOne, Calendar calendarTwo) {
        diffYears = calendarTwo.get(Calendar.YEAR) - calendarOne.get(Calendar.YEAR);
        System.out.println(String.format("Diff Year: %d, One: %d, Two: %d", diffYears, calendarOne.get(Calendar.YEAR), calendarTwo.get(Calendar.YEAR)));
        diffDays = calendarTwo.get(Calendar.DAY_OF_YEAR) - calendarOne.get(Calendar.DAY_OF_YEAR);
        System.out.println(String.format("Diff Days: %d, One: %d, Two: %d", diffDays, calendarOne.get(Calendar.DAY_OF_YEAR), calendarTwo.get(Calendar.DAY_OF_YEAR)));
        if (diffDays < 0) {
            diffDays = 365 + diffDays;
            diffYears = diffYears - 1;
        }

        String dayLabel = diffDays > 1 ? "Days" : "Day";
        String yearLabel = diffYears > 1 ? "Years" : "Year";

        return String.format("%d %s and %d %s", diffYears, yearLabel, diffDays, dayLabel);
    }
}