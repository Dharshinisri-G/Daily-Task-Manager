package validation;

import controller.TaskController;
import controller.UserController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.*;

public class ValidateInput {
    static Scanner x=new Scanner(System.in);
    static final String errMessage="Invalid input, Try Again...";

    public String getValidUserName() {
//          String regEx="^[a-zA-Z0-9_.]{5,30}$";
//          while(true){
              System.out.print("Enter Username: ");
              String username=x.nextLine();
//              if(username.matches(regEx))
                  return username;
//              else
//                  System.out.println(errMessage);
//          }
    }

    public String getValidPassword(){
//        String regEx="([a-z]{1,}[A-Z]{1,}\\d{1,}[!@#$%^&]{1,}){8,30}";
//        while(true){
            System.out.print("Enter Password: ");
            String password=x.nextLine();
//            if(password.matches(regEx))
                return password;
//            else System.out.println(errMessage);
//        }
    }

    public String getValidName(){
        System.out.print("Enter Name: ");
        String name=x.nextLine();
        return name;
    }

    public String getValidEmail(){
        System.out.print("Enter Email: ");
        String email=x.nextLine();
        return email;
    }

    public String getValidContact(){
        System.out.print("Enter Contact: ");
        String contact=x.nextLine();
        return contact;
    }

    public int getValidAge(){
        System.out.print("Enter Age: ");
        int age=x.nextInt();
        x.nextLine();
        return age;
    }

    public int getValidUserId(UserController userController){
        while(true){
            System.out.print("Enter UserId: ");
            int userId=x.nextInt();
            x.nextLine();
            if(userController.validUserId(userId)){
                return userId;
            }else{
                System.out.println(errMessage);
            }
        }
    }

    public String getValidTaskName(){
        while(true){
            System.out.print("Enter Task Name: ");
            String taskname=x.nextLine();
            return taskname;
        }
    }

    public String getValidDescription(){
        while(true){
            System.out.print("Enter Description: ");
            String description=x.nextLine();
            return description;
        }
    }

    public String getValidCategory(){
        while(true){
            System.out.print("Enter Category: ");
            String category=x.nextLine();
            return category;
        }
    }

    public String getValidStatus(){
        while(true){
            System.out.print("Enter Status: ");
            String status=x.nextLine();
            return status;
        }
    }

    public String getValidPriority(){
        while(true){
            System.out.print("Enter Priority: ");
            String priority=x.nextLine();
            return priority;
        }
    }

    public LocalDate getValidCreatedDate(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true){
            System.out.print("Enter CreatingDate(dd/mm/yyyy): ");
            String createdDate=x.nextLine();
            try{
                return LocalDate.parse(createdDate,formatter);
            }
            catch(DateTimeParseException e){
                System.out.println(errMessage);
            }
        }
    }

    public LocalDate getValidDueDate(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true){
            System.out.print("Enter DueDate(dd/mm/yyyy): ");
            String dueDate=x.nextLine();
            try{
                return LocalDate.parse(dueDate,formatter);
            }
            catch(DateTimeParseException e){
                System.out.println(errMessage);
            }
        }
    }

    public int getValidTaskId(TaskController taskController,int userId){
        while(true){
            System.out.print("Enter TaskId: ");
            int taskId=x.nextInt();
            x.nextLine();
            if(taskController.validTaskId(userId,taskId)){
                return taskId;
            }else{
                System.out.println(errMessage);
            }
        }
    }

    public int getValidInt(String prompt){
        while(true){
            System.out.print(prompt);
            try{
                return Integer.parseInt(x.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number...");
            }
        }
    }

}
