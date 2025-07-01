package view;

import controller.EmployeeController;
import model.Employee;
import javax.swing.*;
import java.awt.*;
import java.util.List;


public class EmployeeDetailsGUI extends JFrame {
    JComboBox<String> monthBox;
    JTextArea infoArea;

    public EmployeeDetailsGUI(String empNo) {
        setTitle("Employee Details");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        monthBox = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        });

        infoArea = new JTextArea();
        infoArea.setEditable(false);

        JButton compute = new JButton("Compute");

        add(monthBox, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
        add(compute, BorderLayout.SOUTH);

        compute.addActionListener(e -> {
            List<Employee> employees = EmployeeController.getAllEmployees();
            for (Employee emp : employees) {
                if (emp.toArray()[0].equals(empNo)) {
                    infoArea.setText("Name: " + emp.toArray()[2] + " " + emp.toArray()[1] +
                            "\nSSS: " + emp.toArray()[3] +
                            "\nPhilHealth: " + emp.toArray()[4] +
                            "\nTIN: " + emp.toArray()[5] +
                            "\nPag-IBIG: " + emp.toArray()[6] +
                            "\nMonth: " + monthBox.getSelectedItem() +
                            "\n[Salary Computation Placeholder]");
                    return;
                }
            }
        });
    }
}
