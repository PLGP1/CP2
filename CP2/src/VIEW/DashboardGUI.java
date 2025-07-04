package VIEW;

import javax.swing.*;
import java.awt.*;


public class DashboardGUI extends JFrame {

    private JLabel welcomeLabel;
    private JButton attendanceButton;
    private JButton payrollButton;
    private JButton profileButton;
    private JButton logoutButton;

    public DashboardGUI(String Manuel) {
        setTitle("MotorPH Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null); // center on screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents(Manuel);
    }

    private void initComponents(String Manuel) {
        // Top welcome label
        welcomeLabel = new JLabel("Welcome, " + Manuel + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(welcomeLabel, BorderLayout.NORTH);

        // Center buttons panel
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        attendanceButton = new JButton("Attendance");
        payrollButton = new JButton("Payroll");
        profileButton = new JButton("Profile");
        logoutButton = new JButton("Logout");

        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        centerPanel.add(attendanceButton);
        centerPanel.add(payrollButton);
        centerPanel.add(profileButton);
        centerPanel.add(logoutButton);

        add(centerPanel, BorderLayout.CENTER);

        // Button actions
        attendanceButton.addActionListener(e -> {
            new AttendanceGUI(Manuel).setVisible(true);
            dispose();
        });

        payrollButton.addActionListener(e -> {
            new PayrollGUI(Manuel).setVisible(true);
            dispose();
        });

        profileButton.addActionListener(e -> {
            new ProfileGUI(Manuel).setVisible(true);
            dispose();
        });

        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?");
            if (confirm == JOptionPane.YES_OPTION) {
                new LoginGUI().setVisible(true);
                dispose();
            }
        });
    }

    // Test launcher
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardGUI("admin").setVisible(true));
    }
}
