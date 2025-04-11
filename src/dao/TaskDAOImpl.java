package dao;

import model.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskDAOImpl implements TaskDAO{
    private final Map<Integer, Map<Integer,Task>> taskMap=new HashMap<>();
    private final Map<Integer,Integer> taskIdCounter=new HashMap<>();
    @Override
    public boolean addTask(int userId,Task task) {
        taskMap.putIfAbsent(userId,new HashMap<>());
        taskMap.get(userId).put(task.getTaskId(),task);
        return true;
    }

    public int getUsersTaskId(int userId){
        int taskIdCount=taskIdCounter.getOrDefault(userId,0)+1;
        taskIdCounter.put(userId,taskIdCount);
        return taskIdCount;
    }

    @Override
    public boolean taskIdExists(int userId,int taskId) {
        if(taskMap.containsKey(userId)){
            Map<Integer,Task> tasks=taskMap.get(userId);
            return tasks.containsKey(taskId);
        }
        return false;
    }

    @Override
    public boolean userIdExists(int userId) {
        return taskMap.containsKey(userId);
    }

    @Override
    public boolean isTaskExists() {
        return !taskMap.isEmpty();
    }

    @Override
    public List<Task> viewTasks(int userId){
        if(taskMap.containsKey(userId))
         return new ArrayList<>(taskMap.get(userId).values());
        return new ArrayList<>();
    }



    @Override
    public boolean removeTask(int userId,int taskId) {
         if(taskMap.containsKey(userId)){
             Map<Integer,Task> tasks=taskMap.get(userId);
             if(tasks.containsKey(taskId)){
                 tasks.remove(taskId);
                 return true;
             }
         }
         return false;
    }

    @Override
    public void deleteTasksOfUser(int userId) {
        taskIdCounter.remove(userId);
        if(taskMap.containsKey(userId))
            taskMap.remove(userId);
    }

    @Override
    public boolean updateCategory(int userId, int taskId, String category) {
            if(taskMap.containsKey(userId)){
                Map<Integer,Task> tasks=taskMap.get(userId);
                if(tasks.containsKey(taskId)){
                    tasks.get(taskId).setCategory(category);
                    return true;
                }
            }
            return false;
    }

    @Override
    public boolean updateStatus(int userId, int taskId, String status) {
           if(taskMap.containsKey(userId)){
               Map<Integer,Task> tasks=taskMap.get(userId);
               if(tasks.containsKey(taskId)){
                   tasks.get(taskId).setStatus(status);
                   return true;
               }
           }
           return false;
    }

    @Override
    public boolean updatePriority(int userId, int taskId, String priority) {
        if(taskMap.containsKey(userId)){
            Map<Integer,Task> tasks=taskMap.get(userId);
            if(tasks.containsKey(taskId)){
                tasks.get(taskId).setPriority(priority);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateCreatedDate(int userId, int taskId, LocalDate createdDate) {
        if(taskMap.containsKey(userId)){
            Map<Integer,Task> tasks=taskMap.get(userId);
            if(tasks.containsKey(taskId)){
                tasks.get(taskId).setCreatedDate(createdDate);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateDueDate(int userId, int taskId, LocalDate dueDate) {
        if(taskMap.containsKey(userId)){
            Map<Integer,Task> tasks=taskMap.get(userId);
            if(tasks.containsKey(taskId)){
                tasks.get(taskId).setDueDate(dueDate);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Task> viewTasksOfCategory(int userId, String category) {
        List<Task> categoryTask=new ArrayList<>();
         if(taskMap.containsKey(userId)){
             List<Task> tasks=new ArrayList<>(taskMap.get(userId).values());
             for(Task task:tasks){
                 if(task.getCategory().equalsIgnoreCase(category))
                     categoryTask.add(task);
             }
         }
         return categoryTask;
    }

    @Override
    public List<Task> viewTasksOfStatus(int userId, String status) {
        List<Task> statusTask=new ArrayList<>();
        if(taskMap.containsKey(userId)){
            List<Task> tasks=new ArrayList<>(taskMap.get(userId).values());
            for(Task task:tasks){
                if(task.getStatus().equalsIgnoreCase(status))
                    statusTask.add(task);
            }
        }
        return statusTask;
    }

    @Override
    public List<Task> viewTasksOfPriority(int userId, String priority) {
        List<Task> priorityTask=new ArrayList<>();
        if(taskMap.containsKey(userId)){
            List<Task> tasks=new ArrayList<>(taskMap.get(userId).values());
            for(Task task:tasks){
                if(task.getPriority().equalsIgnoreCase(priority))
                    priorityTask.add(task);
            }
        }
        return priorityTask;
    }

    @Override
    public List<Task> viewTasksOfCreatedDate(int userId, LocalDate createdDate) {
        List<Task> createdDateTask=new ArrayList<>();
        if(taskMap.containsKey(userId)){
            List<Task> tasks=new ArrayList<>(taskMap.get(userId).values());
            for(Task task:tasks){
                if(task.getCreatedDate().equals(createdDate))
                    createdDateTask.add(task);
            }
        }
        return createdDateTask;
    }

    @Override
    public List<Task> viewTasksOfDueDate(int userId, LocalDate dueDate) {
        List<Task> dueDateTask=new ArrayList<>();
        if(taskMap.containsKey(userId)){
            List<Task> tasks=new ArrayList<>(taskMap.get(userId).values());
            for(Task task:tasks){
                if(task.getDueDate().equals(dueDate))
                   dueDateTask.add(task);
            }
        }
        return dueDateTask;
    }

    @Override
    public List<Task> viewAllUsersTasks() {
        List<Task> tasks=new ArrayList<>();
        for(Map.Entry<Integer,Map<Integer,Task>> e:taskMap.entrySet()){
            tasks.addAll(e.getValue().values());
        }
        return tasks;
    }

    @Override
    public List<Task> getAllTasksOfCategory(String category) {
        List<Task> tasks=new ArrayList<>();
        for(Map.Entry<Integer,Map<Integer,Task>> e:taskMap.entrySet()){
            for(Task task:e.getValue().values()){
                if(task.getCategory().equalsIgnoreCase(category))
                    tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getAllTasksOfStatus(String status) {
        List<Task> tasks=new ArrayList<>();
        for(Map.Entry<Integer,Map<Integer,Task>> e:taskMap.entrySet()){
            for(Task task:e.getValue().values()){
                if(task.getStatus().equalsIgnoreCase(status))
                    tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getAllTasksOfPriority(String priority) {
        List<Task> tasks=new ArrayList<>();
        for(Map.Entry<Integer,Map<Integer,Task>> e:taskMap.entrySet()){
            for(Task task:e.getValue().values()){
                if(task.getPriority().equalsIgnoreCase(priority))
                    tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getAllTasksOfCreatedDate(LocalDate createdDate) {
        List<Task> tasks=new ArrayList<>();
        for(Map.Entry<Integer,Map<Integer,Task>> e:taskMap.entrySet()){
            for(Task task:e.getValue().values()){
                if(task.getCreatedDate().equals(createdDate))
                    tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getAllTasksOfDueDate(LocalDate dueDate) {
        List<Task> tasks=new ArrayList<>();
        for(Map.Entry<Integer,Map<Integer,Task>> e:taskMap.entrySet()){
            for(Task task:e.getValue().values()){
                if(task.getDueDate().equals(dueDate))
                    tasks.add(task);
            }
        }
        return tasks;
    }
}
