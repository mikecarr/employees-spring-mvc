package com.qualcomm.ea.ssat.employees.spring.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author mcarr
 *
 */
@Repository
public class EmployeeDao implements Employees {

	 private static final String insertSql =
			         "INSERT INTO employee(firstName,lastName,birthday,employeeType,departmentNumber,socialSecurityNumber) " +
                             "VALUES(?,?,?,?,?,?)";

	 private static final String deleteByIdSql =
			 "DELETE FROM employee " +
			 "WHERE id = (?)";
	 
	 private static final String deleteAllSql =
			 "DELETE FROM employee";


	@Autowired
	public JdbcTemplate jdbcTemplate;
    
	public Employee getEmployee(int id) {
		String sql = "select * from employee where id = ?";
		Employee employee = null;
		
		RowMapper<Employee> mapper = new RowMapper<Employee>() {
		    
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee employee = new Employee();
	            employee.setId(rs.getLong("id"));
	            employee.setFirstName(rs.getString("firstName"));
	            employee.setLastName(rs.getString("lastName"));
	            return employee;
	        }
	    };
	    
	    try {
			employee = (Employee) jdbcTemplate.queryForObject(sql, mapper, new Object[] {Long.valueOf(id)});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return employee;
	}

	public List<Employee> getAllEmployees() throws Exception{
		String sql = "select * from employee";
		
		List<Employee> employees = null;

		employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		
	    return employees;
	}

	public int deleteEmployeeById(int id) throws Exception{
    	
    	// define query arguments
    	Object[] params = new Object[] { id };

    	// define SQL types of the arguments
    	int[] types = new int[] { Types.INTEGER };

    	// execute insert query to insert the data
    	// return number of row / rows processed by the executed query
    	int row = -1;
		
    	row = jdbcTemplate.update(deleteByIdSql, params, types);
    	
    	System.out.println(row + " rows deleted.");

    	return row;
    }

    public int insertEmployee(Employee employee) throws Exception{

    	// define query arguments
    	Object[] params = new Object[] { employee.getFirstName(), employee.getLastName(),employee.getBirthday(),
        employee.getEmployeeType(), employee.getDepartmentNumber(), employee.getSocialSecurityNumber() };

    	// define SQL types of the arguments
    	int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };

    	// execute insert query to insert the data
    	// return number of row / rows processed by the executed query
    	int row = -1;
		
    	//row = jdbcTemplate.update(insertSql, employee, types);
        row = jdbcTemplate.update(insertSql, params);

    	System.out.println(row + " row inserted.");

    	return row;
    }

	public int deleteEmployee() {
		
		int row = jdbcTemplate.update(deleteAllSql);
    	
    	System.out.println(row + " rows deleted.");

    	return row;
	}
    
    
    
}
