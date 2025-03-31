package com.example.adminCRUD;

import com.example.adminCRUD.database.AdminDAO;
import com.example.adminCRUD.entity.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdminCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AdminDAO adminDAO){
		return runner -> {
//			createAdmin(adminDAO);
//			findAdminById(adminDAO);
//		printAllAdmins(adminDAO);
//			updateAdmin(adminDAO);

			deleteAdmin(adminDAO);
		};
	}

	private void deleteAdmin(AdminDAO adminDAO) {
		int adminId = 3;
		adminDAO.deleteAdmin(adminId);
		System.out.println("Admin deleted with id: " + adminId);
	}

	private void updateAdmin(AdminDAO adminDAO) {
		int adminId = 1;
		Admin myAdmin = adminDAO.findAdminById(adminId);
		System.out.println("Admin found: " + myAdmin);
		myAdmin.setFirstName("Dakshitaaaa");
		adminDAO.updateAdmin(myAdmin);
		System.out.println("Admin updated: " + myAdmin);
	}

	private void printAllAdmins(AdminDAO adminDAO) {
		System.out.println("List Of all Admins");
		List<Admin> myAdminList = adminDAO.findAllAdmins();
		for(Admin a : myAdminList){
			System.out.println(a + "\n");
		}
	}

	private void findAdminById(AdminDAO adminDAO) {
		int adminId = 1;
		Admin myAdmin = adminDAO.findAdminById(adminId);
		System.out.println("Admin found: " + myAdmin);
	}

	private void createAdmin(AdminDAO adminDAO) {
		Admin a1 = new Admin("Dakshita", "Thakkar", "dakshita@gmail.com");
		Admin a2 = new Admin("Aditya", "Patil", "aditya@gmail.com");
		Admin a3 = new Admin("Ravish", "Rozario", "ravish@gmail.com");
		adminDAO.saveAdmin(a1);
		adminDAO.saveAdmin(a2);
		adminDAO.saveAdmin(a3);
		System.out.println("Admin saved: " + a1 + "\n" + a2 + "\n" + a3);
	}





}
