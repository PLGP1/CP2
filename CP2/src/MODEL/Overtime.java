package model;

public class Overtime{
    private String startDate,endDate,startTime,endTime;
    private String status="Pending";
    
public String viewHistory(){
    return"Showing of History";
}

public void apply(){
    this.status="Applied";
}

public void approve(){
    this.status="Approved";
}

public void reject(){
    this.status="Rejected";
}

public String applicationStatus(){
    return this.status;
} 

public String generateReport(){
    return "Overtime report generated";
}

public int calculateOvertimeHours(){
    return 2; // Stub value
}
}
