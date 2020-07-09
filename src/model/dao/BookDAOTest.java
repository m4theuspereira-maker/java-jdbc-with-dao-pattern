package model.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import model.bean.Book;
import model.bean.Category;

public class BookDAOTest {

	@Test
	@Ignore
	public void testSave() {
		
		Category category = new Category(); 
		BookDAO bdao = new BookDAO(); 		
		Book book = new Book(); 
		book.setTitle("The backerviews's book");
		book.setPagesqtt(2015);
		book.setPrice(5);
		category.setId(4);
		book.setCategory(category);
		
		if(bdao.save(book)){
			System.out.println("Save with success");
		}
		
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void findAll(){
		
		BookDAO bdao = new BookDAO();
		
		 
		for(Book b: bdao.findAll()){
			System.out.println(b.getTitle()+ " " + b.getPagesqtt() + " "+ b.getPrice()+ " " + b.getCategory().getId()
					+ " "	+ b.getCategory().getName());
		}
		
	}
	
	@Test	
	@Ignore
	public void update(){
		
		BookDAO bdao = new BookDAO(); 
		
		Book b = new Book(); 
		
		Category cat = new Category(); 
		
		b.setId(3);
		b.setTitle("Millenium");
		b.setPrice(10);
		b.setPagesqtt(500);
		
		cat.setId(4);
		b.setCategory(cat);		
		
		if(bdao.update(b)){
			System.out.println("Save with successs");
		}
		
	}
	
	@Test
	public void delete(){
		
		Book book = new Book(); 
		BookDAO bdao = new BookDAO();
		
		book.setId(5);
		if(bdao.delete(book)){
			
			System.out.println("Deleted with success");
		}
		
	}
	

}





