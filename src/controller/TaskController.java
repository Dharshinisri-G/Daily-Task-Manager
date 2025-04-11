package controller;

import dao.TaskDAO;
import dao.TaskDAOImpl;
import model.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskController {
  static TaskDAO taskDAO=new TaskDAOImpl();

  public void setTask(int userId, String name, String description, String category, String status, String priority, LocalDate createdDate,LocalDate dueDate){
      int taskId=taskDAO.getUsersTaskId(userId);
      Task task=new Task(taskId,userId,name,description,category,status,priority,createdDate,dueDate);
      if(taskDAO.addTask(userId,task))
          System.out.println("Setting Task successfully.");
  }

  public void viewAllTasks(int userId){
       List<Task> tasks=taskDAO.viewTasks(userId);
       if(tasks.isEmpty()){
           System.out.println("No Task is added..");
       }else{
           for(Task task:tasks)
               System.out.println(task);
       }
  }

  public void deleteTask(int userId,int taskId){
       if(taskDAO.removeTask(userId,taskId))
        System.out.println("Task "+taskId+" deleted successfully");
  }

  public boolean validTaskId(int userId,int taskId){
        return taskDAO.taskIdExists(userId,taskId);
  }

    public boolean hasTasks(int userId){
        return taskDAO.userIdExists(userId);
    }

   public void updateCategory(int userId,int taskId,String category){
        if(taskDAO.updateCategory(userId,taskId,category))
            System.out.println("Category of Task "+taskId+" was Updated as "+category);
   }

    public void updateStatus(int userId,int taskId,String status){
        if(taskDAO.updateStatus(userId,taskId,status))
            System.out.println("Status of Task "+taskId+" was Updated as "+status);
    }

    public void updatePriority(int userId,int taskId,String priority){
        if(taskDAO.updatePriority(userId,taskId,priority))
            System.out.println("Priority of Task "+taskId+" was Updated as "+priority);
    }

    public void updateCreatedDate(int userId,int taskId,LocalDate createdDate){
        if(taskDAO.updateCreatedDate(userId,taskId,createdDate))
            System.out.println("Created Date of Task "+taskId+" was Updated as "+createdDate);
    }

    public void updateDueDate(int userId,int taskId,LocalDate dueDate){
        if(taskDAO.updateDueDate(userId,taskId,dueDate))
            System.out.println("Due Date of Task "+taskId+" was Updated as "+dueDate);
    }

    public void viewTasksOfCategory(int userId,String category){
        List<Task> tasks=taskDAO.viewTasksOfCategory(userId,category);
        if(tasks.isEmpty()){
            System.out.println("No tasks available under category "+category);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewTasksOfStatus(int userId,String status){
        List<Task> tasks=taskDAO.viewTasksOfStatus(userId,status);
        if(tasks.isEmpty()){
            System.out.println("No tasks available under status "+status);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewTasksOfPriority(int userId,String priority){
        List<Task> tasks=taskDAO.viewTasksOfPriority(userId,priority);
        if(tasks.isEmpty()){
            System.out.println("No tasks available under priority "+priority);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewTasksOfCreatedDate(int userId,LocalDate createdDate){
        List<Task> tasks=taskDAO.viewTasksOfCreatedDate(userId,createdDate);
        if(tasks.isEmpty()){
            System.out.println("No tasks available under created date "+createdDate);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewTasksOfDueDate(int userId,LocalDate dueDate){
        List<Task> tasks=taskDAO.viewTasksOfDueDate(userId,dueDate);
        if(tasks.isEmpty()){
            System.out.println("No tasks available under due date "+dueDate);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewAllUsersTasks() {
         List<Task> tasks=taskDAO.viewAllUsersTasks();
         if(tasks.isEmpty()){
             System.out.println("No Tasks is available.");
         }else{
             for(Task task:tasks)
                 System.out.println(task);
         }
    }

    public boolean isTaskExists(){
      return taskDAO.isTaskExists();
    }

    public void viewAllTasksOfCategory(String category){
       List<Task> tasks=taskDAO.getAllTasksOfCategory(category);
       if(tasks.isEmpty()){
           System.out.println("No task is available under category "+category);
       }else{
           for(Task task:tasks)
               System.out.println(task);
       }
    }

    public void viewAllTasksOfStatus(String status){
        List<Task> tasks=taskDAO.getAllTasksOfStatus(status);
        if(tasks.isEmpty()){
            System.out.println("No task is available under status "+status);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewAllTasksOfPriority(String priority){
        List<Task> tasks=taskDAO.getAllTasksOfPriority(priority);
        if(tasks.isEmpty()){
            System.out.println("No task is available under priority "+priority);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewAllTasksOfCreatedDate(LocalDate createdDate){
        List<Task> tasks=taskDAO.getAllTasksOfCreatedDate(createdDate);
        if(tasks.isEmpty()){
            System.out.println("No task is available under created date "+createdDate);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void viewAllTasksOfDueDate(LocalDate dueDate){
        List<Task> tasks=taskDAO.getAllTasksOfDueDate(dueDate);
        if(tasks.isEmpty()){
            System.out.println("No task is available under due date "+dueDate);
        }else{
            for(Task task:tasks)
                System.out.println(task);
        }
    }

    public void deleteTasksOfUser(int userId){
         taskDAO.deleteTasksOfUser(userId);
    }
}
