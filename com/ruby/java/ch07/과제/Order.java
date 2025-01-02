package com.ruby.java.ch07.과제;

class Order {

	private Customer customer; // 고객
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates;
	private int count; // 아이템 개수

	// 생성자
	public Order(Customer customer, int maxItems) {
		this.customer=customer;
		items = new Item[maxItems];
		quantities=new int [maxItems];
		orderDates=new String[maxItems];
		count=0;
				

	}

	// 아이템 추가 메소드
	public void addItem(Item item, int orderQuantity) {
		items[count]=item;
		quantities[count]=orderQuantity;
		count++;
	}

	// 총액 계산 메소드
	public double calculateTotal() {
		double sum = 0.0;
		for(int i = 0; i < count; i++) {
			sum+=items[i].getPrice()*quantities[i];
			
		}
		return sum;
		
	}
	
	
	// 주문 요약 출력 메소드
	
	public void printOrderSummary() {
		
		for(int i = 0; i <count; i++) {
			System.out.println(items[i]);
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public int[] getQuantities() {
		return quantities;
	}

	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}

	public String[] getOrderDates() {
		return orderDates;
	}

	public void setOrderDates(String[] orderDates) {
		this.orderDates = orderDates;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
