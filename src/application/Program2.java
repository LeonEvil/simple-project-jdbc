package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: department findById ===");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department department2 = new Department(null, "security");
		departmentDao.insert(department2);
		System.out.println("Inserted! New id: " + department2.getId());
		System.out.println(department2);
		
		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(10);
		department.setName("digital security");
		departmentDao.update(department);
		System.out.println("Update completed");
		System.out.println(department);
		
		sc.close();
	}
}