package dao;

import model.Task;
import java.util.*;
import java.time.LocalDate;

public interface TaskDAO {
    boolean addTask(int userId,Task task);
    int getUsersTaskId(int userId);
    boolean taskIdExists(int userId,int taskId);
    boolean userIdExists(int userId);
    boolean isTaskExists();
    List<Task> viewTasks(int userId);
    boolean removeTask(int userId,int taskId);
    void deleteTasksOfUser(int userId);
    boolean updateCategory(int userId,int taskId,String category);
    boolean updateStatus(int userId,int taskId,String status);
    boolean updatePriority(int userId,int taskId,String priority);
    boolean updateCreatedDate(int userId, int taskId, LocalDate createdDate);
    boolean updateDueDate(int userId,int taskId,LocalDate dueDate);
    List<Task> viewTasksOfCategory(int userId,String category);
    List<Task> viewTasksOfStatus(int userId,String status);
    List<Task> viewTasksOfPriority(int userId,String priority);
    List<Task> viewTasksOfCreatedDate(int userId,LocalDate createdDate);
    List<Task> viewTasksOfDueDate(int userId,LocalDate dueDate);
    List<Task> viewAllUsersTasks();
    List<Task> getAllTasksOfCategory(String category);
    List<Task> getAllTasksOfStatus(String status);
    List<Task> getAllTasksOfPriority(String priority);
    List<Task> getAllTasksOfCreatedDate(LocalDate createdDate);
    List<Task> getAllTasksOfDueDate(LocalDate dueDate);

}
