package model;

public class Attendance {
private String employeeID;
private String date;
private int timeIn;
private int timeOut;
private int gracePeriod;
private int workingHours;
 
public Attendance(String employeeID,String date,int timeIn,int timeOut, int gracePeriod){
    this.employeeID=employeeID;
    this.date=date;
    this.timeIn=timeIn;
    this.timeOut=timeOut;
    this.gracePeriod=gracePeriod;
    this.workingHours=calculateHoursWorked();
}

public int scan(){
    return timeOut-timeIn;
}

public int calculateHoursWorked(){
    return timeOut-timeIn-gracePeriod;
}

public int calculateHoursLate(){
    int late=timeIn-8;
    return late>0? late:0;
}

public String employeeStatus(){
    return(calculateHoursWorked()>=8)?
"Present": "Incomplete";
}
}
