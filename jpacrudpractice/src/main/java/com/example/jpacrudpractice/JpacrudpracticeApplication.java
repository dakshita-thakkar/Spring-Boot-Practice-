package com.example.jpacrudpractice;

import com.example.jpacrudpractice.dao.VendorDao;
import com.example.jpacrudpractice.entity.Vendor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpacrudpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacrudpracticeApplication.class, args);
//		System.out.println("Application Started");
	}

	@Bean
	public CommandLineRunner commandLineRunner(VendorDao vendorDao){
		return runner -> {
			//createNewVendor(vendorDao);
			//createMultipleVendors(vendorDao);
			findVendor(vendorDao);
		};
	}

	private void findVendor(VendorDao vendorDao) {
		Vendor vendor = vendorDao.findVendorById(1);
		System.out.println("Vendor found: " + vendor);
	}

	private void createMultipleVendors(VendorDao vendorDao) {
		Vendor v1 = new Vendor("Bonnie", "Shell", "bonnies@gmail.com");
		Vendor v2 = new Vendor("Charlie", "Brown", "charlieb@gmail.com");
		Vendor v3 = new Vendor("deepak", "shah", "deepaks@gmail.com");

		vendorDao.saveVendor(v1);
		vendorDao.saveVendor(v2);
		vendorDao.saveVendor(v3);

		System.out.println("Vendors saved with id: " + v1.getId() + ", " + v2.getId() + ", " + v3.getId());
	}

	private void createNewVendor(VendorDao vendorDao) {
		Vendor vendor = new Vendor("Ajit", "Patil", "ajitp@gmail.com");
		vendorDao.saveVendor(vendor);
		System.out.println("Vendor saved with id: " + vendor.getId());
	}




}
