package com.example.adminCRUD.database;

import com.example.adminCRUD.entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO{
    private EntityManager entityManager;

    @Autowired
    public AdminDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveAdmin(Admin theAdmin) {
        entityManager.persist(theAdmin);
    }

    @Override
    public Admin findAdminById(int adminId) {
        return entityManager.find(Admin.class, adminId);
    }

    @Override
    public List<Admin> findAllAdmins() {
        TypedQuery<Admin> theQuery = entityManager.createQuery("FROM Admin", Admin.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateAdmin(Admin admin) {
        entityManager.merge(admin);
    }

    @Override
    @Transactional
    public void deleteAdmin(int adminId) {
        Admin myAdmin = entityManager.find(Admin.class, adminId);
        entityManager.remove(myAdmin);
    }

}
