import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		System.out.println("\n=== Test Insert ===");
		department = new Department(1, null);
		seller = new Seller(null, "Bruno", "b.demartini@zipmail.com", new Date(), 1500.00, department);
		sellerDao.insert(seller);
		System.out.println("Inserido com sucesso: " + seller.getId());
		
		System.out.println("\n=== Test update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Jogadora");
		sellerDao.update(seller);
		System.out.println("Registro atualizado!");
	}
}
