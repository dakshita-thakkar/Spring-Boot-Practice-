package com.example.jpacrudpractice.dao;

import com.example.jpacrudpractice.entity.Vendor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VendorDaoImpl implements VendorDao {

    private EntityManager entityManager;

    @Autowired
    public VendorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    @Transactional
    public void saveVendor(Vendor theVendor) {
        entityManager.persist(theVendor);
    }

    @Override
    @Transactional
    public Vendor findVendorById(int id){
        return entityManager.find(Vendor.class, id);
    }
}
