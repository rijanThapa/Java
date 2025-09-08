package com.swing.nist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDifferenceApp extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public SumDifferenceApp() {
        setTitle("Sum and Difference Finder");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel num1Label = new JLabel("First Number:");
        JLabel num2Label = new JLabel("Second Number:");
        JLabel resultLabel = new JLabel("Result:");

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton calcButton = new JButton("Press / Release Mouse");

        // Add Mouse Listener
        calcButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calculateSum();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateDifference();
            }
        });

        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // empty space
        add(calcButton);

        setVisible(true);
    }

    private void calculateSum() {
        try {
            int a = Integer.parseInt(num1Field.getText());
            int b = Integer.parseInt(num2Field.getText());
            resultField.setText("Sum = " + (a + b));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid Input");
        }
    }

    private void calculateDifference() {
        try {
            int a = Integer.parseInt(num1Field.getText());
            int b = Integer.parseInt(num2Field.getText());
            resultField.setText("Difference = " + (a - b));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new SumDifferenceApp();
    }
}
