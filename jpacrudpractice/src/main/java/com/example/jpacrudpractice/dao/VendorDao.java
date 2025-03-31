package com.example.jpacrudpractice.dao;

import com.example.jpacrudpractice.entity.Vendor;

import java.util.List;

public interface VendorDao {
    void saveVendor(Vendor theVendor);

    Vendor findVendorById(int vendorId);

    List<Vendor> viewAllVendors();
}
