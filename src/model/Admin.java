package model;

public class Admin {
    private static int adminIdCount=1;

    private int adminId;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private int age;

    public Admin(String userName,String password,String name,String email,String phone,int age){
        this.adminId=adminIdCount++;
        this.userName=userName;
        this.password=password;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.age=age;
    }

    public int getAdminId(){return adminId;}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getPhone(){return phone;}

    public void setName(String name){this.name=name;}
    public void setUserName(String userName){this.userName=userName;}
    public void setPassword(String password){this.password=password;}
    public void setPhone(String phone){this.phone=phone;}
    public void setEmail(String email){this.email=email;}
    public void setAge(int age){this.age=age;}

    public String toString() {
        return "AdminId: " + adminId + " | Username: " + userName + " | Name: " + name + " | Email: " + email + " | Phone: " + phone + " | Age: " + age;
    }

}
