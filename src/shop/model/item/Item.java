package shop.model.item;

public class Item {
    private String itemName, itemID,itemCategory;
    private double buyingPrice,SellingPrice;
    private int quantity;

    public Item(String itemName) {
		
		this.itemName = itemName;
	}

	public Item(String itemName, String itemCategory, int quantityBought) {
		
		this.itemName = itemName;
		this.itemCategory = itemCategory;
	}


    public Item(String itemID,String itemName, String itemCategory, double buyingPrice, double sellingPrice,int quantity) {
	
		this.itemName = itemName;
		this.itemID = itemID;
		this.itemCategory = itemCategory;
		this.buyingPrice = buyingPrice;
		SellingPrice = sellingPrice;
		this.quantity = quantity;
	}


	public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return SellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        SellingPrice = sellingPrice;
    }
}
