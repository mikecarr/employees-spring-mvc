package com.qualcomm.ea.ssat.employees.spring.mvc;

/**
 * 
 * @author mcarr
 *
 */
public interface Employees {

	public Employee getEmployee(int id) throws Exception;
	
	public int insertEmployee(Employee employee) throws Exception;
	
	public int deleteEmployee() throws Exception;
	
	public int deleteEmployeeById(int id) throws Exception;
	
}
