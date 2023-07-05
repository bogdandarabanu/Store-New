package storePackage;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = { "storePackage" })
public class TestStoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestStoreApplication.class, args);
		
		StoreService storeService = context.getBean(StoreService.class);
		
		OrderRepository orderRepository = context.getBean(OrderRepository.class);
		
		Client client = new Client("John Doe", "john@example.com", "123456789");
		
		storeService.saveClient(client);

		// Create some products
		Product product1 = new Product("Product 1", 10.0, 4, LocalDate.of(2023, 12, 31));
		Product product2 = new Product("Product 2", 15.0, 5, LocalDate.of(2023, 12, 31));
		Product product3 = new Product("Product 3", 11.0, 3, LocalDate.of(2023, 12, 31));
		Product product4 = new Product("Product 4", 9.0, 2, LocalDate.of(2023, 12, 31));
		storeService.saveProduct(product1);
		storeService.saveProduct(product2);
		storeService.saveProduct(product3);
		storeService.saveProduct(product4);

		// Create orders

		Order order = new Order(client, LocalDate.of(2023, 07, 03));
		orderRepository.save(order);
		Order_Details orderdet = new Order_Details(order, product1, 3);
		Order_Details orderdet2 = new Order_Details(order, product2, 2);
		storeService.saveOrder(orderdet);
		storeService.saveOrder(orderdet2);

		// Adding stock to a product
		storeService.addStock(1L, 50);

		// Remove stock from a product
		storeService.removeStock(1L, 42);

		// verifying stock for products
		storeService.verifyStock();
	}

}
