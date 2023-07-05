package storePackage;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Order_T")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long order_id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "client_id")
	private Client client_id;
	private LocalDate order_date;
	
	public Order() {
	}
	
	public Order(Client client_id, LocalDate order_date) {
		this.client_id = client_id;
		this.order_date = order_date;

	}
	
	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Client getClient_id() {
		return client_id;
	}
	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", client_id=" + client_id + ", order_date=" + order_date +"]";
	}
	
	
	
}
