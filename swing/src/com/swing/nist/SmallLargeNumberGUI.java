package com.swing.nist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmallLargeNumberGUI extends JFrame implements ActionListener {
    private JTextField field1, field2;
    private JButton btnSmall, btnLarge;
    private JLabel resultLabel;

    public SmallLargeNumberGUI() {
        // Frame settings
        setTitle("Small & Large Number Finder");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Components
        field1 = new JTextField(10);
        field2 = new JTextField(10);

        btnSmall = new JButton("Small");
        btnLarge = new JButton("Large");

        resultLabel = new JLabel("Result will be shown here");

        // Add listeners
        btnSmall.addActionListener(this);
        btnLarge.addActionListener(this);

        // Add to frame
        add(new JLabel("Enter first number:"));
        add(field1);
        add(new JLabel("Enter second number:"));
        add(field2);
        add(btnSmall);
        add(btnLarge);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(field1.getText());
            int num2 = Integer.parseInt(field2.getText());

            if (e.getSource() == btnSmall) {
                resultLabel.setText("Smaller number: " + Math.min(num1, num2));
            } else if (e.getSource() == btnLarge) {
                resultLabel.setText("Larger number: " + Math.max(num1, num2));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SmallLargeNumberGUI();
    }
}
