package SpringBootTransactional.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootTransactional.Entity.Product;
import SpringBootTransactional.Repository.ProductRepo;

@RestController
@RequestMapping("product")
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	@GetMapping
	@Transactional(dontRollbackOn = RuntimeException.class)
	public void save() throws Exception {
//		try {
			for (int i = 0; i < 10; i++) {
				Product product = new Product();
				product.setName("Test Product "+i);
				productRepo.save(product);
				if(i==5) {
					throw new RuntimeException("Thowring Error...");
				}
				System.out.println("Insert Success...");
			}
//		}catch(Exception e) {
//			System.out.println("Exception..."); 
//		}
	}

}
