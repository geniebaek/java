package com.ruby.java.ch07.과제1;

import java.time.LocalDate;
import java.util.Date;

class Item {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량
	

	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		
		
	}
	// 재고 감소 메소드
	public void reduceStock(int quantity) {
		
		stockQuantity -= quantity;
		
		
		
		
		
	}

	// 재고 증가 메소드
	public void increaseStock(int quantity) {
		stockQuantity += quantity;
	}

	// 정보 출력 메소드
	public void show() {
		
	}

	@Override
	public String toString() {
		return "name = " + name + ", price = " + price + ", stockQuantity = " + stockQuantity;
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

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}

class Customer {

	private String cname;
	private String city;
	private int age;

	public Customer(String cname, String city, int age) {
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	// 정보 출력 메소드
	public void show() {
		
	}

	@Override
	public String toString() {
		return "name = " + cname + ", city = " + city + ", age = " + age;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class Order {

	private Customer customer; // 고객
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates;
	private int count; // 아이템 개수

	// 생성자
	public Order(Customer customer, int maxItems) {
		this.customer = customer;
		items = new Item[maxItems];
		quantities = new int[maxItems];
		orderDates = new String[maxItems];
		count = 0;

	}

	// 아이템 추가 메소드
	public void addItem(Item item, int orderQuantity) {
		items[count] = item;
		quantities[count] = orderQuantity;
		orderDates[count] = LocalDate.now().toString();
		count++;
		item.reduceStock(orderQuantity);
		//item.increaseStock(orderQuantity);
	}

	// 총액 계산 메소드
	public double calculateTotal() {
		
		double sum = 0.0;
		
		for (int i = 0; i < count; i++) {
			sum += items[i].getPrice() * quantities[i];

		}
		return sum;
		
	}
	
	
	

	// 주문 요약 출력 메소드

	public void printOrderSummary() {
		
		for (int i = 0; i < count; i++) {
			System.out.println(items[i] + ", OrderDate = " + orderDates[i]+", Quantity = " + quantities[i]  );
			
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

public class 실습7_1객체생성_과제 {

	public static void main(String[] args) {
		// 고객 생성
		Customer boy = new Customer("홍길동", "부산", 21);
		Customer girl = new Customer("계백", "양산", 22);
		
		

		// 아이템 생성
		Item laptop = new Item("노트북", 1200.00, 10);
		Item tshirt = new Item("티셔츠", 20.00, 50);
		Item phone = new Item("휴대폰", 800.00, 30);
		Item headphones = new Item("헤드폰", 150.00, 20);
		Item mouse = new Item("마우스", 30.00, 15);
//        System.out.println(laptop.toString());
//        System.out.println(tshirt.toString());
//        System.out.println(phone.toString());
//        System.out.println(headphones.toString());
//        System.out.println(mouse.toString());

		// 주문 생성
		Order order1 = new Order(boy, 5); // 최대 5개 아이템
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);
		order1.addItem(phone, 1);
		order1.addItem(headphones, 1);
		order1.addItem(mouse, 1);
		
		
		System.out.println(boy);
		order1.printOrderSummary();
		System.out.println("Total = "+order1.calculateTotal());
		System.out.println("-".repeat(100));

		Order order2 = new Order(girl, 5); // 최대 5개 아이템
		order2.addItem(laptop, 1);
		order2.addItem(tshirt, 1);
		order2.addItem(phone, 1);
		order2.addItem(headphones, 1);
		order2.addItem(mouse, 1);
		
		
		
		
		
		// 주문 요약 출력
		
		
        System.out.println(girl);
		order2.printOrderSummary();
		System.out.println("Total = "+order2.calculateTotal());

	}

}
