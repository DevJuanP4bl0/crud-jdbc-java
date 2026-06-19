package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println();
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println();
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> departments = departmentDao.findAll();
		for (Department d : departments) {
			System.out.println(d);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: department Insert ===");
		Department d = new Department(null, "Music");
		departmentDao.insert(d);
		System.out.println("Inserted! New id = " + d.getId());
		
		System.out.println();
		System.out.println("=== TEST 4: department Update ===");
		department = departmentDao.findById(1);
		department.setName("Administration");
		departmentDao.update(department);
		System.out.println("Updated completed!");
		
		System.out.println();
		System.out.println("=== TEST 5: department DeleteById ===");
		System.out.print("Enter id for delete test: ");
		int id = scanner.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		scanner.close();
	}

}
