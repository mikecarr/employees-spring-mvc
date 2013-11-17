package com.qualcomm.ea.ssat.employees.spring.mvc.controller;

import com.qualcomm.ea.ssat.employees.spring.mvc.Employee;
import com.qualcomm.ea.ssat.employees.spring.mvc.EmployeeDao;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;

    @RequestMapping(method = RequestMethod.GET)
	public String printDataTable(ModelMap model) {

        String jdbcUrl = "";
        String jdbcDriver = "";
        String jdbcUsername = "";
        String jdbcPassword = "";

        if(employeeDao.jdbcTemplate.getDataSource() != null){
            if(employeeDao.jdbcTemplate.getDataSource() instanceof SimpleDriverDataSource)
            {
                SimpleDriverDataSource sdDs = (SimpleDriverDataSource) employeeDao.jdbcTemplate.getDataSource();
                jdbcDriver = sdDs.getDriver().toString();
                jdbcUrl = sdDs.getUrl();
                jdbcUsername = sdDs.getUsername();
                jdbcPassword = sdDs.getPassword();
            }
            if(employeeDao.jdbcTemplate.getDataSource() instanceof BasicDataSource)
            {
                BasicDataSource sdDs = (BasicDataSource) employeeDao.jdbcTemplate.getDataSource();
                jdbcDriver = sdDs.getDriverClassName();
                jdbcUrl = sdDs.getUrl();
                jdbcUsername = sdDs.getUsername();
                jdbcPassword = sdDs.getPassword();
            }
        }

        model.addAttribute("jdbcUrl", jdbcUrl);
        model.addAttribute("jdbcDriver", jdbcDriver);
        model.addAttribute("jdbcUsername", jdbcUsername);
        model.addAttribute("jdbcPassword", jdbcPassword);


		List<Employee> employees = null;
		try {
			employees = employeeDao.getAllEmployees();
		} catch (Exception e) {
			model.addAttribute("errorMessage",e.getMessage());
		}
		model.addAttribute("employees",employees);

		return "hello";
 
	}
	
}
