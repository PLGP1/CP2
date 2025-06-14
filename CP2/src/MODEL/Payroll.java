package model;
import java.util.List;

public class Payroll {
private float hourlyRates;
private double govDeduct;
private double govContrib;
private double tax;
private float overtimeRate;

public Payroll(float hourlyRates,double govDeduct,double govContrib,double tax,float overtimeRate){
    this.hourlyRates=hourlyRates;
    this.govDeduct=govDeduct;
    this.govContrib=govContrib;
    this.tax=tax;
    this.overtimeRate=overtimeRate;
}

public double calculateGrosspay(int hoursWorked){
    return hoursWorked*hourlyRates;
}

public double calculateNetSalary(int hoursWorked,double overtimePay){
    double gross=
   calculateGrosspay(hoursWorked);
    return gross+overtimePay-govDeduct-tax;
}

public double calculateOvertimepay(int overtimeHours){
    return overtimeHours*overtimeRate;
}

public String downloadPayslip(){
    return "Payslip downloaded";
}

public String releasePayslip(){
    return "Payslip released";
}

public String generateReport(){
    return "Payroll report generated";
}
}