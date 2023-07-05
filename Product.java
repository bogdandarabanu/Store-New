package storePackage;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	private String name;
	private double price;
	private int quantity;
	private LocalDate expiration_date;

	public Product() {

	}

	public Product(String name, double price, int quantity, LocalDate expiration_date) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expiration_date = expiration_date;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(LocalDate expiration_date) {
		this.expiration_date = expiration_date;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", expiration_date=" + expiration_date + "]";
	}

}
