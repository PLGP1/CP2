package view;

import model.Employee;
import controller.EmployeeController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EmployeeListGUI extends JFrame{
    JTable table;
    DefaultTableModel model;
    
    public EmployeeListGUI(){
        setTitle("Employee List");
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
model=new DefaultTableModel(new String[]
{"Emp No","Last","First","SSS","PhilHealth","TIN","Pag-IBIG"},0);
 table=new JTable(model);
 JScrollPane scroll=new JScrollPane(table);
 
 JButton viewBtn=new JButton("View Employee");
 JButton newBtn=new JButton("New Employee");
 
JPanel panel= new JPanel();
panel.add(viewBtn);
panel.add(newBtn);

add(scroll,BorderLayout.CENTER);
add(panel,BorderLayout.SOUTH);

EmployeeController.populateTable(model);

viewBtn.addActionListener(e->{
    int row=table.getSelectedRow();
    if(row >=0){
        String empNo=(String)
   model.getValueAt(row,0);
    new
   EmployeeDetailsGUI(empNo).setVisible(true);
    }else{
        JOptionPane.showMessageDialog(this,"Please select a row");
    }
});
   
newBtn.addActionListener(e->{
    new
CreateEmployeeGUI(this).setVisible(true);
});
    }
    
public void refreshTable(){
    EmployeeController.populateTable(model);
}

public static void main(String[] args){
    SwingUtilities.invokeLater(()->
        new EmployeeListGUI().setVisible(true));
}
}