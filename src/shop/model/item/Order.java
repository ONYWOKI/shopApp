package shop.model.item;


public class Order {
	private int itemID;
    private String phone,itemName;
    private int quantityBought;
    private double price, totalCost;

    public Order() {
    }
    

    
	
	public int getItemID() {
		return itemID;
	}




	public void setItemID(int itemID) {
		this.itemID = itemID;
	}




	public Order(String itemName,String phone, int quantityBought, double totalCost) {
		super();
		this.phone = phone;
		this.itemName = itemName;
		this.quantityBought = quantityBought;
		this.totalCost = totalCost;
	}




	public Order(int itemID,String phone, int quantityBought,double totalCost,String itemName, double price) {
		super();
		this.itemID = itemID;
		this.phone = phone;
		this.price = price;
		this.quantityBought = quantityBought;
		this.totalCost = totalCost;
		this.itemName = itemName;
	}


	

	public Order( int itemID, String phone, int quantityBought, double price, double totalCost) {
		super();
		this.phone = phone;
		this.itemID = itemID;
		this.quantityBought = quantityBought;
		this.price = price;
		this.totalCost = totalCost;
	}



	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public int getQuantityBought() {
		return quantityBought;
	}


	public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }



	public String getItemName() {
		// TODO Auto-generated method stub
		return itemName;
	}
}
