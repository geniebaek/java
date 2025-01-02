package com.ruby.java.ch07.과제;

class Item {
	private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량

    public Item(String name, double price, int stockQuantity) {
    	this.name = name;
    	this.price=price;
    	this.stockQuantity=stockQuantity;
    	
    }
    // 재고 감소 메소드
    public void reduceStock(int quantity) {
     stockQuantity=quantity;
    
    		 
    }
    // 재고 증가 메소드
    public void increaseStock(int quantity) {
    	
    	
    }
    // 정보 출력 메소드
    public void show() {
    	
    	
    	
    }
    @Override
    public String toString() {
    	return "name = "+name+", price = "+price+", stockQuantity = "+stockQuantity;
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

