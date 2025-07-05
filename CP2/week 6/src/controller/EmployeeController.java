package controller;

import model.Employee;

import java.io.*;
import java.util.*;

public class EmployeeController {
    private static final String FILE_PATH = "src/resources/EmployeeData.csv";

    // ✅ Load all employees
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (data.length == 19) {
                    employees.add(new Employee(
                        data[0], data[1], data[2], data[3], data[4], data[5],
                        data[6], data[7], data[8], data[9], data[10], data[11],
                        data[12], data[13], data[14], data[15], data[16], data[17], data[18]
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // ✅ Save all employees
    public static void saveAllEmployees(List<Employee> employees) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Employee e : employees) {
                pw.println(String.join(",", e.toArray()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Update an employee
    public static void updateEmployee(Employee updated) {
        List<Employee> employees = getAllEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpId().equals(updated.getEmpId())) {
                employees.set(i, updated);
                break;
            }
        }
        saveAllEmployees(employees);
    }

    // ✅ Delete an employee
    public static void deleteEmployee(String empId) {
        List<Employee> employees = getAllEmployees();
        employees.removeIf(e -> e.getEmpId().equals(empId));
        saveAllEmployees(employees);
    }
}