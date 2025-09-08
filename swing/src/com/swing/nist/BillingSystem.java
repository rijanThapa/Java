package com.swing.nist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BillingSystem extends JFrame {
    private JTextField itemNameField, quantityField, priceField, discountField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel totalLabel, discountLabel, finalTotalLabel;
    private JTextArea receiptArea;

    public BillingSystem() {
        setTitle("Billing System");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ---------------- TOP PANEL ----------------
        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 10, 10));

        itemNameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        discountField = new JTextField("0");

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(e -> addItem());

        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(new JLabel("Discount %:"));
        inputPanel.add(new JLabel("")); // Empty space

        inputPanel.add(itemNameField);
        inputPanel.add(quantityField);
        inputPanel.add(priceField);
        inputPanel.add(discountField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // ---------------- TABLE ----------------
        String[] columns = {"Item", "Quantity", "Price", "Total"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane tableScroll = new JScrollPane(table);
        add(tableScroll, BorderLayout.CENTER);

        // ---------------- BOTTOM PANEL ----------------
        JPanel bottomPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        totalLabel = new JLabel("Total: 0.0");
        discountLabel = new JLabel("Discount: 0.0");
        finalTotalLabel = new JLabel("Final Total: 0.0");

        JButton generateBillButton = new JButton("Generate Bill");
        generateBillButton.addActionListener(e -> generateBill());

        bottomPanel.add(totalLabel);
        bottomPanel.add(discountLabel);
        bottomPanel.add(finalTotalLabel);
        bottomPanel.add(generateBillButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // ---------------- RECEIPT ----------------
        receiptArea = new JTextArea(40, 30); // enough rows and columns to fit full bill
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        receiptArea.setLineWrap(false); // keep alignment

        // Add directly (no scroll pane, so full content is always visible)
        add(receiptArea, BorderLayout.EAST);
    }

    // Add item to table
    private void addItem() {
        try {
            String itemName = itemNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            double total = quantity * price;

            tableModel.addRow(new Object[]{itemName, quantity, price, total});
            updateTotals();

            // Clear fields
            itemNameField.setText("");
            quantityField.setText("");
            priceField.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter correct values.");
        }
    }

    // Update totals dynamically
    private void updateTotals() {
        double sum = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            sum += (double) tableModel.getValueAt(i, 3);
        }

        double discountPercent = 0.0;
        try {
            discountPercent = Double.parseDouble(discountField.getText());
        } catch (Exception ignored) {}

        double discountAmount = sum * discountPercent / 100.0;
        double finalTotal = sum - discountAmount;

        totalLabel.setText("Total: " + sum);
        discountLabel.setText("Discount: " + discountAmount);
        finalTotalLabel.setText("Final Total: " + finalTotal);
    }

    // Generate receipt
    private void generateBill() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("=========== BILL RECEIPT ===========\n");
        receipt.append(String.format("%-15s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Total"));
        receipt.append("-----------------------------------\n");

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String item = (String) tableModel.getValueAt(i, 0);
            int qty = (int) tableModel.getValueAt(i, 1);
            double price = (double) tableModel.getValueAt(i, 2);
            double total = (double) tableModel.getValueAt(i, 3);

            receipt.append(String.format("%-15s %-10d %-10.2f %-10.2f\n", item, qty, price, total));
        }

        receipt.append("-----------------------------------\n");
        receipt.append(totalLabel.getText() + "\n");
        receipt.append(discountLabel.getText() + "\n");
        receipt.append(finalTotalLabel.getText() + "\n");
        receipt.append("=========== THANK YOU! =============\n");

        receiptArea.setText(receipt.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BillingSystem().setVisible(true);
        });
    }
}
