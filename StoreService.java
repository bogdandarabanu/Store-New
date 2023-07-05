package storePackage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

	@Autowired
	private final ProductRepository productRepository;
	@Autowired
	private final OrderdetRepository orderRepository;
	@Autowired
	private final ClientRepository clientRepository;

	public StoreService(OrderdetRepository orderRepository, ProductRepository productRepository, ClientRepository clientRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.clientRepository = clientRepository;
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	public void saveClient(Client client) {
		clientRepository.save(client);
	}
	

	public List<Order_Details> getAllOrders() {
		return orderRepository.findAll();
	}

	public void saveOrder(Order_Details orderDetails) {
		Long productId = orderDetails.getProduct_id().getProduct_id();
		Optional<Product> productO = productRepository.findById(productId);
		if (productO.isPresent()) {
			Product product = productO.get();
			int quantityOrdered = orderDetails.getQuantity();
			int currentStock = product.getQuantity();

			if (currentStock >= quantityOrdered) {
				int updatedStock = currentStock - quantityOrdered;
				product.setQuantity(updatedStock);
				productRepository.save(product);
				orderRepository.save(orderDetails);
			} else {
				throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
			}
		} else {
			throw new IllegalArgumentException("Product not found.");
		}
	}

	public void addStock(Long id, Integer stock) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			Product updatedProduct = product.get();
			int currentStock = updatedProduct.getQuantity();
			int newStock = currentStock + stock;
			updatedProduct.setQuantity(newStock);
			productRepository.save(updatedProduct);
			System.out.println("Stock added successfully. New Stock: " + newStock +" for product " + updatedProduct.getName());
		} else {
			throw new IllegalArgumentException("Product not found.");
		}
	}

	public void removeStock(Long id, Integer stock) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			Product updatedProduct = product.get();
			int currentStock = updatedProduct.getQuantity();
			if (currentStock > stock) {
				int newStock = currentStock - stock;
				updatedProduct.setQuantity(newStock);
				productRepository.save(updatedProduct);
				System.out.println(stock + " units deleted from product " + updatedProduct.getName());
			} else {
				throw new IllegalArgumentException("Cannot perform this operation.");
			}
		} else {
			throw new IllegalArgumentException("Product not found.");
		}
	}
	
	public void verifyStock() {
		List<Product> products = productRepository.findAll();
		for(Product p : products) {
			if(p.getQuantity() <= 5) {
				System.out.println("The stock for product " + p.getName() + " is " +p.getQuantity() +", you should restock.");
			}
		}
	}

}
