package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionFactory;
import model.bean.Category;

public class CategoryDAO {

	Connection connection = null;

	public CategoryDAO() {

		connection = ConnectionFactory.getConnection();

	}

	public boolean save(Category category) {

		String query = "insert into category (name) values(?)";

		PreparedStatement pstmt = null;

		try {

			pstmt = connection.prepareStatement(query);			
			pstmt.setString(1, category.getName());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, pstmt);
		}

	}

	public List<Category> findAll() {

		String query = "select * from category";

		PreparedStatement pstmt = null;
		
		ResultSet result = null;
		List<Category> categories = new ArrayList<>();

		try {

			pstmt = connection.prepareStatement(query);
			result = pstmt.executeQuery();

			while (result.next()) {
				Category category = new Category();

				category.setId(result.getInt(1));
				category.setName(result.getString(2));
				categories.add(category);

			}

		} catch (Exception e) {
			System.err.println(e);
			return null;
		} finally {
			ConnectionFactory.closeConnection(connection, pstmt, result);
		}

		return categories;

	}
	
	public boolean update(Category category){
		
		String query = "update category set name= ? where id = ?"; 
		PreparedStatement pstmt = null; 
		
		try{
			
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(2, category.getId());
			pstmt.setString(1, category.getName());
			pstmt.executeUpdate(); 			
			return true; 
			
		}catch(Exception e){
			System.err.println(e);
			return false;
		}finally{
			ConnectionFactory.closeConnection(connection, pstmt);
		}
		
	}
	
	public boolean delete(Category category){
		
		String query = "delete from category where id =?"; 
		PreparedStatement pstmt = null; 

		try{
			pstmt = connection.prepareStatement(query); 
			pstmt.setInt(1, category.getId());
			pstmt.executeUpdate(); 
			return true; 
			
		}catch(Exception e){
			
		return false; 
		}finally{
			ConnectionFactory.closeConnection(connection, pstmt);
			
		}
	}
	
	

}
