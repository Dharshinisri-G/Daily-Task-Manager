package dao;

import model.Admin;

public interface AdminDAO {
    boolean addAdmin(Admin admin);
    boolean adminExist(String username,String password);
    int getAdminId(String username);
    Admin getAdmin(int adminId);
    void changeEmail(int adminId,String email);
    void changeContact(int adminId,String contact);
    void changeAge(int adminId,int age);
    void changePassword(int adminId,String password);

}
