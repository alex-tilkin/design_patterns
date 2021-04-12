package unit_10_facade;

import java.util.ArrayList;

class Order {
	int id;
	
	public Order(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ID: " + id;
	}
	
	public void getPrice() {
		
	}
}


class Billing {
	int cardNumber;
	
	public Billing(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public void charge() {
		
	}
	
	public void returnOrder() {
		
	}
	
	@Override
	public String toString() {
		return "Card Number: " + cardNumber;
	}
}

class Shipping {
	String address;

	public Shipping(String address) {
		this.address = address;
	}
	
	public void ship() {
		
	}
	
	@Override
	public String toString() {
		return "Address: " + address;
	}
}

class CustomerServiceFacade {
	private Order order;
	private Billing billing;
	private Shipping shipping;
	
	public CustomerServiceFacade(Order order, Billing billing, Shipping shipping) {
		this.order = order;
		this.billing = billing;
		this.shipping = shipping;
	}
	
	public void returnOrder() {
		billing.returnOrder();
	}
	
	public void processOrder() {
		order.getPrice();
		billing.charge();
		shipping.ship();
	}
	
	public String getData() {
		return order.toString() + "; " + billing.toString() + "; " + this.shipping.toString();
	}
}

public class FacadeExample {

	public static void main(String[] args) {
		Order order = new Order(123);
		Billing billing = new Billing(987);
		Shipping shipping = new Shipping("Israel, Tel Aviv, Dizengoff");
		
		CustomerServiceFacade customerServiceFacade = new CustomerServiceFacade(order, billing, shipping);
		
		order.getPrice();
		billing.charge();
		shipping.ship();
		
		customerServiceFacade.processOrder();
		
		String data = customerServiceFacade.getData();
		
		System.out.println(data);
	}

}
