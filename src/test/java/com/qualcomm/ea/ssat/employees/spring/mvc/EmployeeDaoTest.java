package com.qualcomm.ea.ssat.employees.spring.mvc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;


/**
 * 
 * @author mcarr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml","classpath:jdbc-test-context.xml"})
//@Transactional
public class EmployeeDaoTest {

    private static Logger logger = Logger.getLogger(EmployeeDaoTest.class.getName());

	private static final long ID = 0;
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
    private static final String SOCIAL_SECURITY_NUMBER = "SOCIAL_SECURITY_NUMBER";
    private static final int DEPT_NUM = 10;
    private static final String EMP_TYPE = "PERM";

	@Autowired
	EmployeeDao employeeDao;

    @Before
	public void insertEmployee() throws Exception {
		Employee employee = new Employee();
		//employee.setId(ID);
		employee.setFirstName(FIRST_NAME);
		employee.setLastName(LAST_NAME);
        employee.setSocialSecurityNumber(SOCIAL_SECURITY_NUMBER);
        employee.setBirthday(new Date());
        employee.setDepartmentNumber(DEPT_NUM);
        employee.setEmployeeType(EMP_TYPE);

		int insertedRows = employeeDao.insertEmployee(employee);
		assertEquals(insertedRows,1);
	}
	
	
	@Test
	public void getAlLEmployees()	throws Exception {
		Employee employee = new Employee();
		employee.setId(ID);
		employee.setFirstName(FIRST_NAME);
		employee.setLastName(LAST_NAME);
		
		List<Employee> employees = employeeDao.getAllEmployees();
		assertNotNull(employees);
		assertTrue(employees.size() > 0);
	}

	// clean up
	@After
	public void cleanUpAfterEachTest() {
		int rowsDeleted = employeeDao.deleteEmployee();
		System.out.println("rows deleted = " + rowsDeleted);
	}


}
