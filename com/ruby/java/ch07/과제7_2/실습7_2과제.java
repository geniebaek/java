package com.ruby.java.ch07.과제7_2;//같은 패키지 안에서 같은 이름의 클래스가 있다면 패키지 이름을 바꿔서 move 클릭

//Item 클래스
class Item { //클래스 이름 바꾸지 말고 패키지를 다르게 하는게 좋음 같은 패키지 안에서 이름만 다르게 클래스 선언하면 코드 꼬이기 쉬움 
	private String name;
	private double price;
	private int stockQuantity;

	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
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


	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity + "]";
	}//toString 단축키는 alt shif s 기억하기

	
	

}

// Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item {
	private int warranty; // 제품 보증 기간

	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;

	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "Electronics [warranty=" + warranty + "]"+super.toString();//슈퍼클래스 toString 오버라이드 해야됨 
	}
	
}

//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item {
	private String size;
	private String color;

	
	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size=size;
		this.color=color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + "]"+super.toString(); //슈퍼클래스 toString 오버라이드 해야됨
	}
	
}

// Customer 추상 클래스 정의
abstract class Customer {
	private String cname;
	private String city;
	private int age;
	
	public Customer(String cname,String city, int age) {
		this.cname=cname;
		this.city=city;
		this.age=age;
	}
	
	
	abstract double applyDiscount(double totalAmount);

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


	@Override
	public String toString() {
		//return "Customer [cname=" + cname + ", city=" + city + ", age=" + age + "]";
		return cname+", "+"City: "+city+":";
	}
	
}

// RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer(String cname,String city, int age) {
		super(cname,city,age);
		
	}
	
	
	
	@Override
	double applyDiscount(double totalAmount) {
		
		return totalAmount*REGULARDISCOUNT_RATE;
	}

}

// PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	public PremiumCustomer(String cname, String city, int age) {
		super(cname, city, age);
		
	}
	
	

	@Override
	double applyDiscount(double totalAmount) {
		
		return totalAmount * PREMIUMDISCOUNT_RATE;
	}

}

// Order 클래스
class Order {
	private Customer customer;
	private Item[] items;
	private int[] quantities;
	private int itemCount;
	/*
	 * Order2(),addItem() calculateTotal(),calculateDiscountedTotal(),
	 * printOrderSummary()
	 */
	public Order(Customer customer,int itemCount) {
		this.customer=customer;
		items=new Item[itemCount];
		quantities=new int[itemCount];
		itemCount=0;
		
	}
	public void addItem(Item item, int qty) {
		items[itemCount]=item;
		quantities[itemCount]=qty;
		itemCount++; // itemCount++을 안넣으면 값이 안들어가서 출력이 안됨
		
	}
	public double calculateTotal() {
		double sum=0.0;
		for(int i = 0; i< itemCount;i++) {
			sum+=items[i].getPrice()*quantities[i];
		}
		return sum;
	}
	public double calculateDiscountedTotal() {
		return calculateTotal()*RegularCustomer.REGULARDISCOUNT_RATE;
		
	}
	public void printOrderSummary() {
		System.out.println("Item\tQuantity\tPrice");
		실습7_2과제.drawline();
		for(int i = 0;i<itemCount;i++) {
			System.out.println(items[i].getName()+"\t"+quantities[i]+"\t\t"+items[i].getPrice());//item배열의 가격과 이름을 불러올땐 게터를 써야됨
			
		}
	}

	
}

public class 실습7_2과제 {

	public static void drawline() {
		System.out.println("-".repeat(45)); //drawline()메소드를 만들어서 코드 중복사용을 줄이고 수정하기 편하게 함 
	}
	public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Electronics laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order order1 = new Order(premiumCustomer, 4);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order order2 = new Order(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		System.out.println("Order Summary for Customer :"+premiumCustomer);
		drawline();
		
		order1.printOrderSummary();
		drawline();
		System.out.println("Total : "+order1.calculateTotal());
		//System.out.println("Discounted Total : "+order1.calculateDiscountedTotal());
		System.out.println(String.format("Discounted Total : %.2f",order1.calculateDiscountedTotal()));
		
		

		System.out.println("Regular Customer Order:");
		System.out.println("Order Summary for Customer :"+regularCustomer);
		drawline();
		
		order2.printOrderSummary();
		drawline();
		System.out.println("Total : "+order2.calculateTotal());
		System.out.println("Discounted Total : "+order2.calculateDiscountedTotal());
	}
}