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
}


class Billing {
	int cardNumber;
	
	public Billing(int cardNumber) {
		this.cardNumber = cardNumber;
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

	public String getData() {
		return order.toString() + "; " + billing.toString() + "; " + this.shipping.toString();
	}
}

public class FacadeExample {

	public static void main(String[] args) {
		CustomerServiceFacade customerServiceFacade = new CustomerServiceFacade(new Order(123), new Billing(987), new Shipping("Israel, Tel Aviv, Dizengoff"));
		String data = customerServiceFacade.getData();
		
		System.out.println(data);
	}

}
