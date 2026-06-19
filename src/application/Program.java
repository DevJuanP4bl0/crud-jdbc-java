package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao(); 
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
	
		for (Seller s : sellers) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: seller findAll ===");
		sellers = sellerDao.findAll();
	
		for (Seller s : sellers) {
			System.out.println(s);
		}
		
		System.out.println();
		System.out.println("=== TEST 4: seller Insert ===");
		Seller s = new Seller(null, "Juan", "juan@gmail.com", LocalDate.parse("14/02/2004", DateTimeFormatter.ofPattern("dd/MM/yyyy")), 2000.00, department); 
		sellerDao.insert(s);
		System.out.println("Inserted! New id = " + s.getId());
		
		System.out.println();
		System.out.println("=== TEST 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Carlo Ancelotti");
		sellerDao.update(seller);
		System.out.println("Updated completed!");
		
		System.out.println();
		System.out.println("=== TEST 6: seller DeleteById ===");
		System.out.print("Enter id for delete test: ");
		int id = scanner.nextInt(); 
		sellerDao.deleteById(id);		
		System.out.println("Delete completed!");
		
		scanner.close();
	}

}
