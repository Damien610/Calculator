package Calculator;


public class Product {
	 private String name;
	 private double price;
	 
	 public Product(String name, double price) {
		 if (price < 0) {
			 throw new IllegalArgumentException("Le prix ne peux pas être négatif");
		 }
		 this.name = name;
		 this.price = price;
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public double getPrice() {
		 return price;
	 }
}
