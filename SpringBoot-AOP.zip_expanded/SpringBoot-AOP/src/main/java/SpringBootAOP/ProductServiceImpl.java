package SpringBootAOP;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

	@Override
	public int multiply(int num1, int num2) {
		System.out.println(num1*num2);
		return num1 * num2;
	}

}
