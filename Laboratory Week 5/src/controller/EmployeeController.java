package controller;

import model.Employee;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeController{
    private static final String File_Path="src/resources/employee.csv";

public static List<Employee>getAllEmployees(){
    List<Employee>list=new ArrayList<>();
    try(BufferedReader br=new
  BufferedReader(new FileReader(File_Path))){
        String line;
        while((line=br.readLine())!=null){
            String[] d=line.split(",");
            list.add(new Employee(d[0],d[1],d[2],d[3],d[4],d[5],d[6]));
        }
    }catch (IOException e){
        e.printStackTrace();
    }
    return list;
}

public static void addEmployee(Employee emp){
    try(BufferedWriter bw=new
   BufferedWriter(new FileWriter(File_Path,true))){
        bw.write(emp.toString());
        bw.newLine();
    } catch (IOException e){
        e.printStackTrace();
    }
}
public static void
        populateTable(DefaultTableModel model){
            model.setRowCount(0);
            for(Employee emp: getAllEmployees()){
                model.addRow(emp.toArray());
            }
        }
}