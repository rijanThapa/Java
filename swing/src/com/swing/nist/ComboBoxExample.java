package com.swing.nist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxExample extends JFrame {
    private JComboBox<String> comboBox;
    private JTextField textField;

    public ComboBoxExample() {
        setTitle("ComboBox Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        String[] items = {"Apple", "Banana", "Orange", "Mango", "Grapes"};
        comboBox = new JComboBox<>(items);

        textField = new JTextField(15);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                textField.setText(selectedItem);
            }
        });

        add(comboBox);
        add(textField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxExample();
    }
}
