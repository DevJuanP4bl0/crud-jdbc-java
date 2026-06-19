package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection connection;
	
	public DepartmentDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM department "
					+ "WHERE Id = ?");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Department department = instantiateDepartment(rs);
				
				return department;
			}
			
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException  {
		return new Department(rs.getInt("Id"), rs.getString("Name"));
	}
}
