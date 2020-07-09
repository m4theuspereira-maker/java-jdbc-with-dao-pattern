package model.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import model.bean.Category;

public class CategoryDAOTest {

	@Test
	@Ignore
	public void test() {
		
		Category cat = new Category();		
		CategoryDAO  dao = new CategoryDAO(); 
		cat.setName("Tecno Triller");		
		if(dao.save(cat)){
			System.out.println("Save with success");
		}
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void listAll(){
		
		CategoryDAO dao = new CategoryDAO(); 
		
		for(Category c: dao.findAll()){
			System.out.println(c.getId() + " " + c.getName());
		}
		
	}
	
	@Test
	@Ignore
	public void update(){
		
		Category cat = new Category(); 
		cat.setId(2);
		cat.setName("Tecno-Triller");
		CategoryDAO dao = new CategoryDAO(); 
		
		if(dao.update(cat)){
			System.out.println("Updated with success");		
		}
		fail("error"); 
	}
	
	@Test
	@Ignore
	public void delete(){
		
		Category cat = new Category(); 
		cat.setId(2);
		CategoryDAO dao = new CategoryDAO();
		
		if(dao.delete(cat)){
			System.out.println("Deleted with success");
		}
		fail("error");
	}
	

}
