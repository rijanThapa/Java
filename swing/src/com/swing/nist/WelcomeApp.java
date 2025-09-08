package com.swing.nist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeApp extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton okButton, clearButton;

    public WelcomeApp() {
        setTitle("Welcome App");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(15);
        okButton = new JButton("OK");
        clearButton = new JButton("Clear");

        okButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(textField);
        add(okButton);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            textField.setText("Welcome");
        } else if (e.getSource() == clearButton) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new WelcomeApp();
    }
}
