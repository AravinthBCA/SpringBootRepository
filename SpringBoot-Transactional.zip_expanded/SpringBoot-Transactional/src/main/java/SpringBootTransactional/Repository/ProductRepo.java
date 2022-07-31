package SpringBootTransactional.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootTransactional.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
