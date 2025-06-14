package VIEW;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;


public class ProfileGUI extends JFrame {
    private JLabel nameLabel, positionLabel, emailLabel;
    private JTextField nameField, positionField, emailField;
    private JButton backButton;

    public ProfileGUI(String username) {
        setTitle("Employee Profile");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents(username);
    }

    private void initComponents(String username) {
        // Create components
        nameLabel = new JLabel("Name:");
        positionLabel = new JLabel("Position:");
        emailLabel = new JLabel("Email:");

        nameField = new JTextField(20);
        positionField = new JTextField(20);
        emailField = new JTextField(20);

        nameField.setEditable(false);
        positionField.setEditable(false);
        emailField.setEditable(false);

        backButton = new JButton("Back");

        // Load profile data
        loadProfile(username);

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(positionLabel, gbc);
        gbc.gridx = 1;
        add(positionField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(backButton, gbc);

        // Button Action
        backButton.addActionListener(e -> dispose());
    }

    private void loadProfile(String username) {
        try {
            Path path = Paths.get("src/resources/profiles.csv");
            BufferedReader reader = Files.newBufferedReader(path);
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(username)) {
                    nameField.setText(parts[1]);
                    positionField.setText(parts[2]);
                    emailField.setText(parts[3]);
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Profile not found for user: " + username);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading profile file.");
            e.printStackTrace();
        }
    }

    // For testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProfileGUI("admin").setVisible(true));
    }
}