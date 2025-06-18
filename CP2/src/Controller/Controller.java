package Controller;

import view.LoginGUI; import view.DashboardGUI; import view.AttendanceGUI; import view.PayrollGUI; import view.ProfileGUI;

import javax.swing.SwingUtilities;

/**

Central application controller (MVC – Controller layer).

Manages the navigation between all Swing views of the MotorPH Employee App.


Assumptions made about each view class:

Each view extends {@code javax.swing.JFrame} (or {@code JDialog}).

Public accessor methods expose the buttons or menu items that trigger navigation 

(e.g. {@code getLoginButton()}, {@code getAttendanceMenuItem()}, etc.).</li> 

Each view provides its own validation or error‑handling helpers as needed 

(for example, {@code isCredentialsValid()} and {@code showError(String)} on 

{@code LoginGUI}). Replace or remove these helpers to fit your concrete API.</li> 

Adapt the method names or wiring below to the signatures you actually expose

in your {@code view.*} classes. */ public class Controller {

// ──────────────────────────── VIEWS ──────────────────────────── //

private LoginGUI loginView; private DashboardGUI dashboardView; private AttendanceGUI attendanceView; private PayrollGUI payrollView; private ProfileGUI profileView;

// ───────────────────────── CONSTRUCTOR ──────────────────────── //

public Controller() { showLogin(); }

// ─────────────────────── NAVIGATION HELPERS ─────────────────── //

private void showLogin() { loginView = new LoginGUI();

// Navigate to Dashboard after successful login loginView.getLoginButton().addActionListener(e -> { if (loginView.isCredentialsValid()) { // delegate credential check to the model loginView.dispose(); showDashboard(); } else { loginView.showError("Invalid username / password"); } }); loginView.setVisible(true); 

}

private void showDashboard() { dashboardView = new DashboardGUI();

// Main‑menu / toolbar routing dashboardView.getAttendanceMenuItem().addActionListener(e -> openAttendance()); dashboardView.getPayrollMenuItem() .addActionListener(e -> openPayroll()); dashboardView.getProfileMenuItem() .addActionListener(e -> openProfile()); dashboardView.getLogoutMenuItem() .addActionListener(e -> logout()); dashboardView.setVisible(true); 

}

private void openAttendance() { attendanceView = new AttendanceGUI(); attendanceView.getBackButton().addActionListener(e -> attendanceView.dispose()); attendanceView.setVisible(true); }

private void openPayroll() { payrollView = new PayrollGUI(); payrollView.getBackButton().addActionListener(e -> payrollView.dispose()); payrollView.setVisible(true); }

private void openProfile() { profileView = new ProfileGUI(); profileView.getBackButton().addActionListener(e -> profileView.dispose()); profileView.setVisible(true); }

private void logout() { // Close child windows if open if (attendanceView != null) attendanceView.dispose(); if (payrollView != null) payrollView.dispose(); if (profileView != null) profileView.dispose(); if (dashboardView != null) dashboardView.dispose();

showLogin(); 

}

// ──────────────────────────── MAIN ──────────────────────────── //

public static void main(String[] args) { SwingUtilities.invokeLater(Controller::new); } }
