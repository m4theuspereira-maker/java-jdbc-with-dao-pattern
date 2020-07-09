package model.bean;

public class Book {

	private int id; 
	private String title;
	private int pagesqtt; 
	private float price; 
	private Category category;
	
	
	public Book(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPagesqtt() {
		return pagesqtt;
	}
	public void setPagesqtt(int pagesqtt) {
		this.pagesqtt = pagesqtt;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
