public class Leave{
    private String startDate,endDate,reason;
    private String status="Pending";

public String viewHistory(){
return"Leave history viewed";
}

public void apply(){
this.status= "Applied";
}

public void approve(){
this.status="Approved";
}

public void reject(){
this.status= "Rejected";
}

public String applicationStatus(){
return this.status;
}

public String generateReport(){
return "Leave report generated";
}
}

