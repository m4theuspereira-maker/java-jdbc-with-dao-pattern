package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionFactory;
import model.bean.Book;
import model.bean.Category;

public class BookDAO {
	
	Connection connection = null; 
	PreparedStatement pstmt = null; 
	
	public BookDAO(){
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean save(Book book){
		
		String query = "insert into book (title,pagesqtt, price, category_id) values (?,?,?,?)";
		
		try{
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, book.getTitle());
			pstmt.setInt(2, book.getPagesqtt());
			pstmt.setFloat(3, book.getPrice());
			pstmt.setInt(4, book.getCategory().getId()); 
			pstmt.executeUpdate(); 
			return true; 
		}catch(Exception e){
			System.err.println(e);
			return false; 
		
		}finally{
			ConnectionFactory.closeConnection(connection, pstmt);
		}
	
	}
	
	public List<Book> findAll(){
		
		String query ="select * from book b inner join category c on c.id = b.category_id"; 
		
		List<Book> books = new ArrayList<>(); 
		ResultSet result = null; 
		
		
		try{
			pstmt = connection.prepareStatement(query); 
			result = pstmt.executeQuery();
			
			while(result.next()){
				
				Book b = new Book(); 
				Category c = new Category(); 
				
				b.setId(result.getInt(1)); 
				b.setTitle(result.getString(2));
				b.setPagesqtt(result.getInt(3));
				b.setPrice(result.getFloat(4));
				
				c.setId(result.getInt(5));
				c.setName(result.getString(6));
				
				b.setCategory(c);
					
				books.add(b); 
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
			ConnectionFactory.closeConnection(connection, pstmt, result);
		}
		return books; 
	}
	
	public boolean update(Book book){
		
		
		String query = "update book set title =?, pagesqtt=?,price =?, category_id=? where id=?"; 
		
		try{
			pstmt = connection.prepareStatement(query); 
			
			pstmt.setString(1, book.getTitle());
			pstmt.setInt(2, book.getPagesqtt());
			pstmt.setFloat(3, book.getPrice());				
			pstmt.setInt(4, book.getCategory().getId());	
			pstmt.setInt(5, book.getId());
			
			pstmt.executeUpdate();
			
			return true; 
		}catch(Exception e){
			System.out.println(e);
			return false; 
		}finally{
			ConnectionFactory.closeConnection(connection, pstmt);
		}
		
	}
	
	public boolean delete(Book book){
		
		String query = "delete from book where id =?"; 
		
		try{
			pstmt = connection.prepareStatement(query); 
			pstmt.setInt(1, book.getId());
			pstmt.execute();
			
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false; 
		}finally{
			ConnectionFactory.closeConnection(connection, pstmt);
		}
		
	}
	
	
	
	

}
