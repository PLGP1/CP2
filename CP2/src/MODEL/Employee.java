package model;

public class Employee {
  private String employeeID;
  private String employeeName;
  private String employeeType;
  private String position;
  private int age;
  private String dateOfBirth;
  
public Employee(String id,String name,String type,String position,int age,String dateOfBirth){
    this.employeeID=id;
    this.employeeName=name;
    this.employeeType=type;
    this.position=position;
    this.age=age;
    this.dateOfBirth=dateOfBirth;
}

public void editProfile(String name, String position,int age){
    this.employeeName=name;
    this.position=position;
    this.age=age;
}
}