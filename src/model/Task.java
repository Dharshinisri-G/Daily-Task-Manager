package model;

import java.time.LocalDate;

public class Task {

    private int taskId;
    private int userId;
    private String name;
    private String description;
    private String category;
    private String status;
    private String priority;
    private LocalDate createdDate;
    private LocalDate dueDate;

    public Task(int taskId,int userId,String name,String description,String category,String status,String priority,LocalDate createdDate,LocalDate dueDate){
        this.taskId=taskId;
        this.userId=userId;
        this.name=name;
        this.description=description;
        this.category=category;
        this.status=status;
        this.priority=priority;
        this.createdDate=createdDate;
        this.dueDate=dueDate;
    }

    public int getTaskId(){return taskId;}
    public int getUserId(){return userId;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getStatus(){return status;}
    public String getCategory(){return category;}
    public String getPriority(){return priority;}
    public LocalDate getCreatedDate(){return createdDate;}
    public LocalDate getDueDate(){return dueDate;}

    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setStatus(String status){this.status=status;}
    public void setCategory(String category){this.category= category;}
    public void setPriority(String priority){this.priority=priority;}
    public void setCreatedDate(LocalDate createdDate){this.createdDate=createdDate;}
    public void setDueDate(LocalDate dueDate){this.dueDate=dueDate;}

    public String toString(){
        return "UserId: "+userId+" | TaskId: "+taskId+" | Name: "+name+" | Description: "+description+" | Status: "+status+" | Category: "+category+" | Priority: "+priority+" | CreatedDate: "+createdDate+" | DueDate: "+dueDate;
    }

}
