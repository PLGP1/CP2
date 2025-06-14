package VIEW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PayrollGUI extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton;

    public PayrollGUI(String username) {
        setTitle("Payroll Information - " + username);
        setSize(900, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        loadPayrollData();
    }

    private void initComponents() {
        String[] columns = {
            "Employee ID", "Name", "Basic Salary", 
            "SSS Deduction", "PhilHealth Deduction", "Pag-IBIG Deduction",
            "Total Deduction", "Net Pay"
        };

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(e -> {
            new DashboardGUI("admin").setVisible(true); // Adjust username as needed
            dispose();
        });

        add(backButton, BorderLayout.SOUTH);
    }

    private void loadPayrollData() {
        try (
            InputStream is = getClass().getResourceAsStream("/RESOURCES/MotorPH Employee Data - Employee Details.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
        ) {
            String line;
            reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String empID = data[0];
                String name = data[1];
                double basicSalary = Double.parseDouble(data[4]); // Assuming salary is in index 4

                // Load contributions (static or calculate based on salary)
                double sss = basicSalary * 0.045;         // Example 4.5%
                double philHealth = basicSalary * 0.035;  // Example 3.5%
                double pagIbig = 100.00;                  // Fixed monthly value

                double totalDeduction = sss + philHealth + pagIbig;
                double netPay = basicSalary - totalDeduction;

                Object[] row = {
                    empID, name, String.format("%.2f", basicSalary),
                    String.format("%.2f", sss),
                    String.format("%.2f", philHealth),
                    String.format("%.2f", pagIbig),
                    String.format("%.2f", totalDeduction),
                    String.format("%.2f", netPay)
                };

                tableModel.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load payroll data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PayrollGUI("admin").setVisible(true));
    }
}
