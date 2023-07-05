package storePackage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Order_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderdet_id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id")
	private Order order_id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	private Product product_id;
	private int quantity;
	private double total_price;

	public Order_Details() {
	}

	public Order_Details(Order order_id, Product product_id, int quantity) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.total_price = this.price();
	}

	public Long getOrderdet_id() {
		return orderdet_id;
	}

	public void setOrderdet_id(Long orderdet_id) {
		this.orderdet_id = orderdet_id;
	}

	public Order getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Order order_id) {
		this.order_id = order_id;
	}

	public Product getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Product product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double price() {
		double price = product_id.getPrice() * quantity;
		return price;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Order_Details [orderdet_id=" + orderdet_id + ", order_id=" + order_id + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", total_price=" + total_price + "]";
	}

}
