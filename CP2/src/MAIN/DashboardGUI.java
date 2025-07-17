package view;

import javax.swing.*;

public class DashboardGUI extends JFrame {
    public DashboardGUI() {
        setTitle("MotorPH Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome to the MotorPH Employee App!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel);

        setVisible(true);
    }
}
