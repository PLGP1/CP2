package model;

public class Employee{
    private String empNo,lastName,firstName,sss,philhealth,tin,pagibig;

public Employee(String empNO,String lastName,String firstName,String sss,String philhealth,String tin,String pagibig){
    this.empNo=empNo;
    this.lastName=lastName;
    this.firstName=firstName;
    this.sss=sss;
    this.philhealth=philhealth;
    this.tin=tin;
    this.pagibig=pagibig;
}
        
public String[]toArray(){
    return new String[]{empNo,lastName,firstName,sss,philhealth,tin,pagibig};
}

@Override
public String toString(){
    return empNo+","+lastName+","+firstName+","+sss+","+philhealth+","+tin+","+pagibig;
}
}