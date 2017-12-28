package pageObjects;

public class ProductDetails
{
	String productName ;
	float price;
	String sellerName;
	
	public ProductDetails(String productName,float price,String sellerName)
	{
		this.productName = productName;
		this.price = price;
		this.sellerName = sellerName;
	}
	
	public void display() 
	{
		System.out.println(productName+" "+price+" "+sellerName);
	}
}
