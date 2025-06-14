package VIEW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class AttendanceGUI extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton;

    public AttendanceGUI(String username) {
        setTitle("Attendance Records - " + username);
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        loadAttendanceData();
    }

    private void initComponents() {
        // Table columns
        String[] columns = {"Employee ID", "Date", "Time In", "Time Out", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(e -> {
            new DashboardGUI("admin").setVisible(true); // Or pass username if needed
            dispose();
        });
        add(backButton, BorderLayout.SOUTH);
    }

    private void loadAttendanceData() {
        String fileName = "/RESOURCES/MotorPH Employee Data - Attendance Record.csv";
        try (InputStream is = getClass().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                tableModel.addRow(row);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load attendance data: " + e.getMessage());
        }
    }

    // Optional main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AttendanceGUI("admin").setVisible(true));
    }
}