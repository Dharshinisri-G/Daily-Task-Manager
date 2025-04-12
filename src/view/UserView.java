package view;

import controller.TaskController;
import controller.UserController;
import validation.ValidateInput;

import java.time.LocalDate;
import java.util.Scanner;

public class UserView{
   Scanner x=new Scanner(System.in);
    static ValidateInput validateInput=new ValidateInput();
    static TaskController taskController=new TaskController();
    static String errMessage="Invalid input. Please try again...\n";
    public void userDashboard(UserController userController,String username){
        //System.out.println("-----------------------------------Welcome to User Dashboard-----------------------------------");
        int userId=userController.getUserId(username);
        System.out.println("Welcome "+username+"!");
        while(true){
//            System.out.println("╔══════════════════════════════════════╗");
//            System.out.println("║            USER DASHBOARD            ║");
//            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("-------------------USER DASHBOARD----------------");
            System.out.println("Operations you can do ");
            System.out.println("1.View your Information\n2.Update your Information \n3.Set Task\n4.View Tasks\n5.Update Tasks\n6.Filter Tasks\n7.Delete Task\n8.Logout");
            int choice= validateInput.getValidInt("Enter your choice: ");
            if(choice==8){
                System.out.println("Logging Out...!\n");
                return;
            }
            switch(choice){
                case 1:
                    userController.viewUser(userId);
                    pause();
                    break;
                case 2:
                    updateInformation(userController,userId);
                    pause();
                    break;
                case 3:
                    String taskName= validateInput.getValidTaskName();
                    String description=validateInput.getValidDescription();
                    String category=validateInput.getValidCategory();
                    String status=validateInput.getValidStatus();
                    String priority=validateInput.getValidPriority();
                    LocalDate createdDate=validateInput.getValidCreatedDate();
                    LocalDate dueDate=validateInput.getValidDueDate();
                    taskController.setTask(userId,taskName,description,category,status,priority,createdDate,dueDate);
                    pause();
                    break;
                case 4:
                    taskController.viewAllTasks(userId);
                    pause();
                    break;
                case 5:
                    updateTask(userId);
                    pause();
                    break;
                case 6:
                    filterTask(userId);
                    pause();
                    break;
                case 7:
                    if(taskController.hasTasks(userId)) {
                        int taskId = validateInput.getValidTaskId(taskController, userId);
                        taskController.deleteTask(userId, taskId);
                    }else{
                        System.out.println("No Tasks is available..");
                    }
                    pause();
                    break;
                default:
                    System.out.println(errMessage);
            }
        }
    }

    public void updateInformation(UserController userController,int userId){
        while(true){
            System.out.println("Update your \n1.Email\n2.Password\n3.Contact\n4.Age\n5.Go Back");
            int updateChoice= validateInput.getValidInt("Enter your choice: ");
            if(updateChoice==5){
                return;
            }
            switch(updateChoice){
                case 1:
                    String email= validateInput.getValidEmail();
                    userController.updateEmail(userId,email);
                    break;
                case 2:
                    String password= validateInput.getValidPassword();
                    userController.updatePassword(userId,password);
                    break;
                case 3:
                    String contact= validateInput.getValidContact();
                    userController.updateContact(userId,contact);
                    break;
                case 4:
                    int age= validateInput.getValidAge();
                    userController.updateAge(userId,age);
                    break;
                default:
                    System.out.println(errMessage);
            }
        }
    }

    public void updateTask(int userId){
        if(!taskController.hasTasks(userId)){
            System.out.println("No tasks is available to Update...");
            return;
        }
        int taskId= validateInput.getValidTaskId(taskController,userId);
        while(true) {
            System.out.println("Update Fields of Task \n1.Category\n2.Status\n3.Priority\n4.Created Date\n5.Due Date\n6.Go Back");
            int updateChoice= validateInput.getValidInt("Enter your choice: ");
            if(updateChoice==6){
                System.out.println("Terminating Update Process");
                return;
            }
            switch(updateChoice){
                case 1:
                    String category= validateInput.getValidCategory();
                    taskController.updateCategory(userId,taskId,category);
                    break;
                case 2:
                    String status= validateInput.getValidStatus();
                    taskController.updateStatus(userId,taskId,status);
                    break;
                case 3:
                    String priority= validateInput.getValidPriority();
                    taskController.updatePriority(userId,taskId,priority);
                    break;
                case 4:
                    LocalDate createdDate= validateInput.getValidCreatedDate();
                    taskController.updateCreatedDate(userId,taskId,createdDate);
                    break;
                case 5:
                    LocalDate dueDate= validateInput.getValidDueDate();
                    taskController.updateDueDate(userId,taskId,dueDate);
                    break;
                default:
                    System.out.println(errMessage);
            }
        }

    }

    public void filterTask(int userId){
        if(!taskController.hasTasks(userId)){
            System.out.println("No tasks is available to Filter...");
            return;
        }
        while(true) {
            System.out.println("Filtering tasks based on \n1.Category\n2.Status\n3.Priority\n4.Created Date\n5.Due Date\n6.Go Back");
            int filterChoice= validateInput.getValidInt("Enter your choice: ");
            if(filterChoice==6){
                System.out.println("Terminating Filter Process");
                return;
            }
            switch(filterChoice){
                case 1:
                    String category= validateInput.getValidCategory();
                    taskController.viewTasksOfCategory(userId,category);
                    break;
                case 2:
                    String status= validateInput.getValidStatus();
                    taskController.viewTasksOfStatus(userId,status);
                    break;
                case 3:
                    String priority= validateInput.getValidPriority();
                    taskController.viewTasksOfPriority(userId,priority);
                    break;
                case 4:
                    LocalDate createdDate= validateInput.getValidCreatedDate();
                    taskController.viewTasksOfCreatedDate(userId,createdDate);
                    break;
                case 5:
                    LocalDate dueDate= validateInput.getValidDueDate();
                    taskController.viewTasksOfDueDate(userId,dueDate);
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
