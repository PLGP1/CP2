package model;

public class Employee {
    private String empId, lastName, firstName, birthday, address, phoneNumber;
    private String sss, philhealth, tin, pagibig;
    private String status, position, supervisor;
    private String basicSalary, riceSubsidy, phoneAllowance, clothingAllowance;
    private String grossRate, hourlyRate;

    public Employee(String empId, String lastName, String firstName, String birthday, String address,
                    String phoneNumber, String sss, String philhealth, String tin, String pagibig,
                    String status, String position, String supervisor, String basicSalary,
                    String riceSubsidy, String phoneAllowance, String clothingAllowance,
                    String grossRate, String hourlyRate) {
        this.empId = empId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sss = sss;
        this.philhealth = philhealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.supervisor = supervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossRate = grossRate;
        this.hourlyRate = hourlyRate;
    }

    public String[] toArray() {
        return new String[] {
            empId, lastName, firstName, birthday, address, phoneNumber,
            sss, philhealth, tin, pagibig, status, position, supervisor,
            basicSalary, riceSubsidy, phoneAllowance, clothingAllowance,
            grossRate, hourlyRate
        };
    }

    public String getEmpId() { return empId; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getSss() { return sss; }
    public String getPhilhealth() { return philhealth; }
    public String getTin() { return tin; }
    public String getPagibig() { return pagibig; }
    public String getStatus() { return status; }
    public String getPosition() { return position; }
    public String getSupervisor() { return supervisor; }
    public String getBasicSalary() { return basicSalary; }
    public String getRiceSubsidy() { return riceSubsidy; }
    public String getPhoneAllowance() { return phoneAllowance; }
    public String getClothingAllowance() { return clothingAllowance; }
    public String getGrossRate() { return grossRate; }
    public String getHourlyRate() { return hourlyRate; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setSss(String sss) { this.sss = sss; }
    public void setPhilhealth(String philhealth) { this.philhealth = philhealth; }
    public void setTin(String tin) { this.tin = tin; }
    public void setPagibig(String pagibig) { this.pagibig = pagibig; }
    public void setStatus(String status) { this.status = status; }
    public void setPosition(String position) { this.position = position; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }
    public void setBasicSalary(String basicSalary) { this.basicSalary = basicSalary; }
    public void setRiceSubsidy(String riceSubsidy) { this.riceSubsidy = riceSubsidy; }
    public void setPhoneAllowance(String phoneAllowance) { this.phoneAllowance = phoneAllowance; }
    public void setClothingAllowance(String clothingAllowance) { this.clothingAllowance = clothingAllowance; }
    public void setGrossRate(String grossRate) { this.grossRate = grossRate; }
    public void setHourlyRate(String hourlyRate) { this.hourlyRate = hourlyRate; }
}