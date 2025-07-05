package view;

import controller.EmployeeController;
import model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListGUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Employee> employees;
    private List<JTextField> textFields = new ArrayList<>();
    private JButton updateButton, deleteButton;

    public EmployeeListGUI() {
        setTitle("MotorPH Employee Records");
        setSize(1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table headers
        String[] headers = {
            "Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number",
            "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position",
            "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance",
            "Clothing Allowance", "Gross Rate", "Hourly Rate"
        };

        tableModel = new DefaultTableModel(headers, 0);
        table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(20, 2, 5, 5));
        for (String header : headers) {
            formPanel.add(new JLabel(header));
            JTextField tf = new JTextField();
            tf.setEditable(!header.equals("Employee #"));
            textFields.add(tf);
            formPanel.add(tf);
        }

        // Buttons
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JScrollPane(formPanel), BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(tableScroll, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        loadTable();

        // Row selection listener
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                int row = table.getSelectedRow();
                for (int i = 0; i < textFields.size(); i++) {
                    textFields.get(i).setText(table.getValueAt(row, i).toString());
                }
                updateButton.setEnabled(true);
                deleteButton.setEnabled(true);
            }
        });

        // 🔁 Update button
        updateButton.addActionListener(e -> {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "No record selected.");
                return;
            }

            String[] data = new String[textFields.size()];
            for (int i = 0; i < textFields.size(); i++) {
                data[i] = textFields.get(i).getText().trim();
            }

            Employee updated = new Employee(
                data[0], data[1], data[2], data[3], data[4], data[5],
                data[6], data[7], data[8], data[9], data[10], data[11],
                data[12], data[13], data[14], data[15], data[16], data[17], data[18]
            );

            EmployeeController.updateEmployee(updated);
            loadTable();
            JOptionPane.showMessageDialog(this, "Employee record updated.");
        });

        // 🗑️ Delete button
        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "No record selected.");
                return;
            }

            String empId = table.getValueAt(row, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete Employee #" + empId + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                EmployeeController.deleteEmployee(empId);
                loadTable();
                for (JTextField tf : textFields) tf.setText("");
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Employee record deleted.");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        employees = EmployeeController.getAllEmployees();
        for (Employee emp : employees) {
            tableModel.addRow(emp.toArray());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeListGUI::new);
    }
}
