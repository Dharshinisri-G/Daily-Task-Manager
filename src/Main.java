import java.util.Scanner;

import controller.AdminController;
import controller.TaskController;
import controller.UserController;
import validation.ValidateInput;
import view.AdminView;
import view.UserView;

public class Main {
    static Scanner x=new Scanner(System.in);
    static ValidateInput validateInput=new ValidateInput();
    static AdminController adminController=new AdminController();
    static UserController userController=new UserController();
    static TaskController taskController=new TaskController();
    static UserView userView=new UserView();
    static AdminView adminView=new AdminView();
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║       WELCOME TO DAILY TASK MANAGER        ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Simplify your schedule. Amplify your productivity.\n");
       while(true){
           System.out.print("Enter your choice(Register,Login,Exit): ");
           String choice=x.nextLine();
           switch(choice.toLowerCase()){
               case "register":
                   register();
                   break;
               case "login":
                   login();
                   break;
               case "exit":
                   System.out.println("Closing Daily Task Manager......");
                   return;
               default:
                   System.out.println("Invalid input, Try Again...");
           }
       }
    }

    public static void register(){
        while(true) {
            System.out.print("Enter Role(Admin/User) OR 'Exit' to return: ");
            String role = x.nextLine();
            if(role.equalsIgnoreCase("exit")) return;
            switch (role.toLowerCase()) {
                case "admin":
//                    System.out.print("Enter Username: ");
                    String adminUsername = validateInput.getValidUserName();
//                    System.out.print("Enter Password: ");
                    String adminPassword = validateInput.getValidPassword();
//                    System.out.print("Enter Name: ");
                    String adminName = validateInput.getValidName();
//                    System.out.print("Enter Email: ");
                    String adminEmail = validateInput.getValidEmail();
//                    System.out.print("Enter Contact: ");
                    String adminContact = validateInput.getValidContact();
//                    System.out.print("Enter Age: ");
                    int adminAge = validateInput.getValidAge();
                    adminController.registerAdmin(adminUsername, adminPassword, adminName, adminEmail, adminContact, adminAge);
                    System.out.println();
                    return;
                case "user":
//                    System.out.print("Enter Username: ");
                    String userUsername = validateInput.getValidUserName();
//                    System.out.print("Enter Password: ");
                    String userPassword = validateInput.getValidPassword();
//                    System.out.print("Enter Name: ");
                    String userName = validateInput.getValidName();
//                    System.out.print("Enter Email: ");
                    String userEmail = validateInput.getValidEmail();
//                    System.out.print("Enter Contact: ");
                    String userContact = validateInput.getValidContact();
//                    System.out.print("Enter Age: ");
                    int userAge = validateInput.getValidAge();
                    userController.registerUser(userUsername, userPassword, userName, userEmail, userContact, userAge);
                    System.out.println();
                    return;
                default:
                    System.out.println("Invalid input, Try Again...");
            }
        }
    }

    public static void login(){
        while(true){
            System.out.print("Enter Role(Admin/User) OR 'Exit' to return: ");
            String role=x.nextLine();
            if(role.equalsIgnoreCase("exit")) return;
            switch(role.toLowerCase()){
                case "admin":
                    while(true){
//                        System.out.print("Enter Username: ");
                        String adminUsername=validateInput.getValidUserName();
//                        System.out.print("Enter Password: ");
                        String adminPassword=validateInput.getValidPassword();
                        if(adminController.validAdmin(adminUsername,adminPassword)){
                            System.out.println();
                            adminView.adminDashboard(adminController,userController,taskController,userView,adminUsername);
                            return;
                        }
                        else{
                             System.out.print("Invalid Credentials...\nWant to Try Again (yes/no): ");
                             String choice=x.nextLine();
                             if(!choice.equalsIgnoreCase("yes")) break;
                        }
                    }
                    return;
                case "user":
                    while(true) {
//                        System.out.print("Enter Username: ");
                        String userUsername = validateInput.getValidUserName();
//                        System.out.print("Enter Password: ");
                        String userPassword = validateInput.getValidPassword();
                        if (userController.validUser(userUsername, userPassword)) {
                            System.out.println();
                            userView.userDashboard(userController,userUsername);
                            return;
                        } else {
                            System.out.print("Invalid Credentials...\nWant to Try Again (yes/no): ");
                            String choice = x.nextLine();
                            if (choice.equalsIgnoreCase("no")) break;
                        }
                    }
                    return;
                default:
                    System.out.println("Invalid input, Try again...");
            }
        }
    }
}