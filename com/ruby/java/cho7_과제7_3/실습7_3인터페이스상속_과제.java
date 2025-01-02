package com.ruby.java.cho7_과제7_3;

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;

	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public double getDiscountedPrice(double price) {
		return price * discountRate;
	}
}

//Item 추상 클래스
abstract class Item3 {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	public Item3(String name, double price, int stockQuantity) {
		super();
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
		return "원래 가격 W"+price;
	}
	
	
}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	int madeYear;

	public Electronics3(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}

}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	int size;

	public Clothing3(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}

}

//Order 클래스
class Order3 extends SeasonalDiscount {
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private static int count = 0;

	public Order3(Customer3 customer, double discountRate) {
		super(discountRate);
		this.customer = customer;
		items = new Item3[N];
		quantities = new int[N];
		orderDates = new String[N];

	}

	public void addItem(Item3 item, int quantity, String date) {
		items[count] = item;
		quantities[count] = quantity;
		orderDates[count] = date;
		count++;
	}

	public double calculateTotal() {
		double sum=0.0;
		for(int i = 0; i< count;i++) {
			sum+=items[i].getPrice()*quantities[i];
		}
		return sum;
	}

	public void printOrderSummary() {
		System.out.println("주문요약:");
		for (int i = 0; i < count; i++) {
			System.out.println(items[i].getName() + " x " + quantities[i] + " : W" + items[i].getPrice());
		}
	}

	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		
		for (int i = 0; i<count;i++) {
			System.out.println(items[i].getName()+": 원래 가격 W"+items[i].getPrice()+", 시즌 할인 금액 W"+super.getDiscountedPrice(N)+", 고객할인금액 W");
		}
	}

	@Override
	public double getDiscountedPrice(double price) {
		// TODO Auto-generated method stub
		return super.getDiscountedPrice(price);
	}

	
	
	
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;

	public Customer3(String name) {

		this.name = name;
	}
	
	


	@Override
	public String toString() {
		return "고객 : "+name;
	}




	public abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	public RegularCustomer3(String name) {
		super(name);

	}
	
	static final double REGULARDISCOUNT_RATE = 0.03;

	@Override
	public double applyDiscount(double totalAmount) {

		return totalAmount * REGULARDISCOUNT_RATE;
	}
	
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	public PremiumCustomer3(String name) {
		super(name);

	}

	static final double PREMIUMDISCOUNT_RATE = 0.1;

	@Override
	public double applyDiscount(double totalAmount) {
		// TODO Auto-generated method stub
		return totalAmount * PREMIUMDISCOUNT_RATE;
	}

}

class 실습7_3인터페이스상속_과제 {
	public static void main(String[] args) {
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");
		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer, RegularCustomer3.REGULARDISCOUNT_RATE);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");
		
		System.out.println(regularCustomer);
		
		regularOrder.printOrderSummary();
		
		regularOrder.printDiscountDetails(); // 할인된 내역 출력

		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer, PremiumCustomer3.PREMIUMDISCOUNT_RATE);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		System.out.println(premiumCustomer);
		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출력
	}
}