package cuit.pojos;

//import java.util.Date;

public class Movie {
	
	private int id;
	private String name;
	private String date;
	private int price;
	private int amount;
	private String info;
	public Movie() {
		
	}
	public Movie(int id,String name,String date,
			int amount,int price,String info) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.price = price;
		this.amount = amount;
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", date=" + date + ", price=" + price + ", amount=" + amount
				+ ", info=" + info + "]";
	}
	
}
