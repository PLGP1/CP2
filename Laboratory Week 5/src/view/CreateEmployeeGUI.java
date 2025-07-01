package view;

import model.Employee;
import controller.EmployeeController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateEmployeeGUI extends JFrame {
    private JTextField[] fields = new JTextField[7];
    private String[] labels = {"Emp No", "Last Name", "First Name", "SSS", "PhilHealth", "TIN", "Pag-IBIG"};
    private EmployeeListGUI parent;

    public CreateEmployeeGUI(EmployeeListGUI parent) {
        this.parent = parent;
        setTitle("Add New Employee");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 5, 5));

        for (int i = 0; i < labels.length; i++) {
            add(new JLabel(labels[i]));
            fields[i] = new JTextField();
            add(fields[i]);
        }

        JButton save = new JButton("Save");
        add(new JLabel());
        add(save);

        save.addActionListener(e -> {
            String[] data = new String[7];
            for (int i = 0; i < 7; i++) {
                data[i] = fields[i].getText().trim();
                if (data[i].isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields required.");
                    return;
                }
            }

            EmployeeController.addEmployee(new Employee(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
            parent.refreshTable();
            JOptionPane.showMessageDialog(this, "Employee added.");
            dispose();
        });
    }
}