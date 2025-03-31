package com.example.adminCRUD.database;

import com.example.adminCRUD.entity.Admin;

import java.util.List;

public interface AdminDAO {
    void saveAdmin(Admin theAdmin);

    Admin findAdminById(int adminId);

    List<Admin> findAllAdmins();

    void updateAdmin(Admin admin);

    void deleteAdmin(int adminId);


}
