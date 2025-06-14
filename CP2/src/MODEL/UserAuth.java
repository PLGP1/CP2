package model;

public class UserAuth {
    private String email;
    private String password;

public UserAuth(String email,String password){
    this.email= email;
    this.password= password;
}

public boolean verifyEmail(String input){
    return email.equals(input);
}

public boolean verifyPassword(String input){
    return password.equals(input);
}

public void resetPassword(String newPassword){
    this.password=newPassword;
}

public String employeeTypeIdentifier(){
    return email.contains("admin")?"Admin":"Regular";
}
}