import java.util.List;

import model.application.Department;
import model.application.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test FindById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test FindByDepartmentId ===");
		Department department = new Department(2, null);
		List<Seller> lstSeller = sellerDao.findByDepartment(department);
		for(Seller sel : lstSeller) {
			System.out.println(sel);
		}
		
		System.out.println("\n=== Test findAll ===");
		lstSeller = sellerDao.findAll();
		for(Seller sel : lstSeller) {
			System.out.println(sel);
		}
	}
}
