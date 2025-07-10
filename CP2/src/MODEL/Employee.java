package model;

public class Employee {
    private String employeeId;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;
    private String status;
    private String position;
    private String supervisor;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    // Constructor, getters and setters
    public Employee(String employeeId, String lastName, String firstName, String birthday, String address, String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status, String position, String supervisor, double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.supervisor = supervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Getters and Setters for all fields

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public void setPagibigNumber(String pagibigNumber) {
        this.pagibigNumber = pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) {
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

(CONTROLLER)- EmployeeController.java

package controller;

import model.Employee;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;

public class EmployeeController {
    private static final String FILE_PATH = "resources/employee_records.csv";
    private List<Employee> employeeList;

    public EmployeeController() {
        employeeList = new ArrayList<>();
        loadEmployeeData();
    }

    // Load employee data from the CSV file
    private void loadEmployeeData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], Double.parseDouble(data[13]), Double.parseDouble(data[14]), Double.parseDouble(data[15]), Double.parseDouble(data[16]), Double.parseDouble(data[17]), Double.parseDouble(data[18]));
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save updated employee list to CSV
    private void saveEmployeeData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employeeList) {
                String line = String.join(",", employee.getEmployeeId(), employee.getLastName(), employee.getFirstName(), employee.getBirthday(), employee.getAddress(), employee.getPhoneNumber(), employee.getSssNumber(), employee.getPhilhealthNumber(), employee.getTinNumber(), employee.getPagibigNumber(), employee.getStatus(), employee.getPosition(), employee.getSupervisor(), String.valueOf(employee.getBasicSalary()), String.valueOf(employee.getRiceSubsidy()), String.valueOf(employee.getPhoneAllowance()), String.valueOf(employee.getClothingAllowance()), String.valueOf(employee.getGrossSemiMonthlyRate()), String.valueOf(employee.getHourlyRate()));
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the list of all employees
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    // Update an employee record
    public void updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(updatedEmployee.getEmployeeId())) {
                employee = updatedEmployee;
                break;
            }
        }
        saveEmployeeData();
    }

    // Delete an employee record
    public void deleteEmployee(Employee employeeToDelete) {
        employeeList.remove(employeeToDelete);
        saveEmployeeData();
    }

    // Add new employee
    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        saveEmployeeData();
    }
}


(VIEW)- EmployeeListGUI.java

package view;

import controller.EmployeeController;
import model.Employee;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EmployeeListGUI extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtEmployeeId, txtLastName, txtFirstName, txtBirthday, txtAddress, txtPhoneNumber, txtSssNumber, txtPhilhealthNumber, txtTinNumber, txtPagibigNumber, txtStatus, txtPosition, txtSupervisor, txtBasicSalary, txtRiceSubsidy, txtPhoneAllowance, txtClothingAllowance, txtGrossRate, txtHourlyRate;
    private JButton btnAdd, btnUpdate, btnDelete;
    private EmployeeController controller;

    public EmployeeListGUI() {
        controller = new EmployeeController();
        setTitle("Employee List");
        setLayout(new BorderLayout());

        // Table setup
        model = new DefaultTableModel();
        model.addColumn("Employee ID");
        model.addColumn("Last Name");
        model.addColumn("First Name");
        model.addColumn("Birthday");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("SSS Number");
        model.addColumn("Philhealth Number");
        model.addColumn("TIN Number");
        model.addColumn("Pag-ibig Number");
        model.addColumn("Status");
        model.addColumn("Position");
        model.addColumn("Supervisor");
        model.addColumn("Basic Salary");
        model.addColumn("Rice Subsidy");
        model.addColumn("Phone Allowance");
        model.addColumn("Clothing Allowance");
        model.addColumn("Gross Semi Monthly Rate");
        model.addColumn("Hourly Rate");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Populate table with data
        populateTable();

        // Form fields
        JPanel formPanel = new JPanel(new GridLayout(10, 2));
        txtEmployeeId = new JTextField();
        formPanel.add(new JLabel("Employee ID"));
        formPanel.add(txtEmployeeId);
        txtLastName = new JTextField();
        formPanel.add(new JLabel("Last Name"));
        formPanel.add(txtLastName);
        txtFirstName = new JTextField();
        formPanel.add(new JLabel("First Name"));
        formPanel.add(txtFirstName);
        // Repeat for other fields...
        add(formPanel, BorderLayout.WEST);

        // Buttons for Add, Update, and Delete
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add button functionality
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect data from form fields
                Employee newEmployee = new Employee(txtEmployeeId.getText(), txtLastName.getText(), txtFirstName.getText(), txtBirthday.getText(), txtAddress.getText(), txtPhoneNumber.getText(), txtSssNumber.getText(), txtPhilhealthNumber.getText(), txtTinNumber.getText(), txtPagibigNumber.getText(), txtStatus.getText(), txtPosition.getText(), txtSupervisor.getText(), Double.parseDouble(txtBasicSalary.getText()), Double.parseDouble(txtRiceSubsidy.getText()), Double.parseDouble(txtPhoneAllowance.getText()), Double.parseDouble(txtClothingAllowance.getText()), Double.parseDouble(txtGrossRate.getText()), Double.parseDouble(txtHourlyRate.getText()));
                controller.addEmployee(newEmployee);
                populateTable();
            }
        });

        // Update button functionality
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected employee from table and update
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String employeeId = (String) model.getValueAt(selectedRow, 0);
                    Employee updatedEmployee = new Employee(employeeId, txtLastName.getText(), txtFirstName.getText(), txtBirthday.getText(), txtAddress.getText(), txtPhoneNumber.getText(), txtSssNumber.getText(), txtPhilhealthNumber.getText(), txtTinNumber.getText(), txtPagibigNumber.getText(), txtStatus.getText(), txtPosition.getText(), txtSupervisor.getText(), Double.parseDouble(txtBasicSalary.getText()), Double.parseDouble(txtRiceSubsidy.getText()), Double.parseDouble(txtPhoneAllowance.getText()), Double.parseDouble(txtClothingAllowance.getText()), Double.parseDouble(txtGrossRate.getText()), Double.parseDouble(txtHourlyRate.getText()));
                    controller.updateEmployee(updatedEmployee);
                    populateTable();
                }
            }
        });

        // Delete button functionality
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String employeeId = (String) model.getValueAt(selectedRow, 0);
                    for (Employee employee : controller.getEmployeeList()) {
                        if (employee.getEmployeeId().equals(employeeId)) {
                            controller.deleteEmployee(employee);
                            break;
                        }
                    }
                    populateTable();
                }
            }
        });

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Populate the table with employee data
    private void populateTable() {
        model.setRowCount(0);  // Clear existing rows
        for (Employee employee : controller.getEmployeeList()) {
            model.addRow(new Object[]{
                employee.getEmployeeId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getBirthday(),
                employee.getAddress(),
                employee.getPhoneNumber(),
                employee.getSssNumber(),
                employee.getPhilhealthNumber(),
                employee.getTinNumber(),
                employee.getPagibigNumber(),
                employee.getStatus(),
                employee.getPosition(),
                employee.getSupervisor(),
                employee.getBasicSalary(),
                employee.getRiceSubsidy(),
                employee.getPhoneAllowance(),
                employee.getClothingAllowance(),
                employee.getGrossSemiMonthlyRate(),
                employee.getHourlyRate()
            });
        }
    }

    public static void main(String[] args) {
        new EmployeeListGUI();
    }
}
