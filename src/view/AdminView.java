package view;

import controller.AdminController;
import controller.TaskController;
import controller.UserController;
import validation.ValidateInput;
import java.time.LocalDate;
import java.util.Scanner;

public class AdminView {
    Scanner x=new Scanner(System.in);
    static ValidateInput validateInput=new ValidateInput();
    static final String errMessage="Invalid input. Please try again...";
    public void adminDashboard(AdminController adminController, UserController userController, TaskController taskController, UserView userView,String username){
        //System.out.println("-----------------------------------Welcome to Admin Dashboard-----------------------------------");
        int adminId=adminController.getAdminId(username);
        System.out.println("Welcome "+username+"!");
        while(true){
//            System.out.println("╔══════════════════════════════════════╗");
//            System.out.println("║           ADMIN DASHBOARD            ║");
//            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("-------------------ADMIN DASHBOARD----------------");
            System.out.println("Operations you can do ");
            System.out.println("1.View your Information\n2.Update your Information\n3.View a User\n4.View All users \n5.Delete User\n6.View Tasks\n7.Filter Tasks\n8.Delete Task\n9.Logout");
            int choice= validateInput.getValidInt("Enter your choice: ");
            if(choice==9){
                System.out.println("Logging Out...!\n");
                return;
            }
            switch(choice){
                case 1:
                    adminController.viewAdmin(adminId);
                    pause();
                    break;
                case 2:
                    updateInformation(adminController,adminId);
                    pause();
                    break;
                case 3:
                    if(userController.hasUsers()) {
                        int userId = validateInput.getValidUserId(userController);
                        userController.viewUser(userId);
                    }else{
                        System.out.println("No users available...");
                    }
                    pause();
                    break;
                case 4:
                    userController.viewAllUsers();
                    pause();
                    break;
                case 5:
                    if(userController.hasUsers()) {
                        int userId = validateInput.getValidUserId(userController);
                        userController.deleteUser(userId);
                        taskController.deleteTasksOfUser(userId);
                    }else{
                        System.out.println("No users available...");
                    }
                    pause();
                    break;
                case 6:
                    viewTasks(userController,taskController);
                    pause();
                    break;
                case 7:
                    filterTask(userView,userController,taskController);
                    pause();
                    break;
                case 8:
                    if(userController.hasUsers()) {
                        int userId = validateInput.getValidUserId(userController);
                        if (taskController.hasTasks(userId)) {
                            int taskId = validateInput.getValidTaskId(taskController, userId);
                            taskController.deleteTask(userId, taskId);
                        } else {
                            System.out.println("No tasks available..");
                        }
                    }else{
                        System.out.println("No users available..");
                    }
                    pause();
                    break;
                default:
                    System.out.println(errMessage);
            }
        }
    }

    public void updateInformation(AdminController adminController,int userId){
        while(true){
            System.out.println("Update your \n1.Email\n2.Password\n3.Contact\n4.Age\n5.Go Back");
            int updateChoice= validateInput.getValidInt("Enter your choice: ");
            if(updateChoice==5){
                return;
            }
            switch(updateChoice){
                case 1:
                    String email= validateInput.getValidEmail();
                    adminController.updateEmail(userId,email);
                    break;
                case 2:
                    String password= validateInput.getValidPassword();
                    adminController.updatePassword(userId,password);
                    break;
                case 3:
                    String contact= validateInput.getValidContact();
                    adminController.updateContact(userId,contact);
                    break;
                case 4:
                    int age= validateInput.getValidAge();
                    adminController.updateAge(userId,age);
                    break;
                default:
                    System.out.println(errMessage);
            }
        }
    }

    public void viewTasks(UserController userController,TaskController taskController){
        while(true) {
            System.out.println("View Task of (All Users/Specific user/Go Back):");
            System.out.print("Enter your choice: ");
            String viewTaskOf=x.nextLine();
            if(viewTaskOf.equalsIgnoreCase("go back")){
                return;
            }
            switch(viewTaskOf.toLowerCase()){
                case "all users":
                    taskController.viewAllUsersTasks();
                    break;
                case "specific user":
                    if(userController.hasUsers()) {
                        int specificUserId = validateInput.getValidUserId(userController);
                        taskController.viewAllTasks(specificUserId);
                    }else{
                        System.out.println("No user is available..");
                    }
                    break;
                default:
                    System.out.println(errMessage);
            }
        }
    }

    public void filterTask(UserView userView,UserController userController,TaskController taskController){
        while(true) {
            System.out.println("Filter Task of (All Users/Specific user/Go Back):");
            System.out.print("Enter your choice: ");
            String viewTaskOf=x.nextLine();
            if(viewTaskOf.equalsIgnoreCase("go back")){
                System.out.println("Back to Dashboard");
                return;
            }
            switch(viewTaskOf.toLowerCase()){
                case "all users":
                    filterAllUsersTask(taskController);
                    break;
                case "specific user":
                    if(userController.hasUsers()) {
                        int userId = validateInput.getValidUserId(userController);
                        userView.filterTask(userId);
                    }else{
                        System.out.println("No users available..");
                    }
                    break;
                default:
                    System.out.println(errMessage);
            }
        }
    }

    public void filterAllUsersTask(TaskController taskController){
        if(!taskController.isTaskExists()){
            System.out.println("No tasks is available to Filter...");
            return;
        }
        while(true){
        System.out.println("Filtering tasks based on \n1.Category\n2.Status\n3.Priority\n4.Created Date\n5.Due Date\n6.Exit");
        int filterChoice= validateInput.getValidInt("Enter your choice: ");
        if(filterChoice==6){
            System.out.println("Terminating Filter Process");
            return;
        }
        switch(filterChoice){
            case 1:
                String category= validateInput.getValidCategory();
                taskController.viewAllTasksOfCategory(category);
                break;
            case 2:
                String status= validateInput.getValidStatus();
                taskController.viewAllTasksOfStatus(status);
                break;
            case 3:
                String priority= validateInput.getValidPriority();
                taskController.viewAllTasksOfPriority(priority);
                break;
            case 4:
                LocalDate createdDate= validateInput.getValidCreatedDate();
                taskController.viewAllTasksOfCreatedDate(createdDate);
                break;
            case 5:
                LocalDate dueDate= validateInput.getValidDueDate();
                taskController.viewAllTasksOfDueDate(dueDate);
                break;
            default:
                System.out.println(errMessage);
        }
    }
    }
    public void pause(){
        System.out.println("Please press Enter to return to the dashboard...");
        x.nextLine();
    }
}
