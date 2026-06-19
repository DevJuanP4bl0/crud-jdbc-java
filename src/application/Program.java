package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department department = new Department(1, "Seller");
		System.out.println(department);
		
		Seller seller = new Seller(1, "Bob Michael", "bobmichael@gmail.com", "14/02/2004", 2000.00, department);
		System.out.println(seller);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
	}

}
