package com.qualcomm.ea.ssat.employees.spring.mvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: mcarr
 * Date: 10/25/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml","classpath:jdbc-test-context.xml"})
public class EmployeeControllerTest {

    @Autowired
    EmployeeController controller;
    private ModelMap modelMap;

    @Test
    public void testPrintDataTable() throws Exception {
        assertNotNull(controller);

        modelMap = new ModelMap();

        controller.printDataTable(modelMap);

        assertEquals("sa", modelMap.get("jdbcUsername"));
    }
}
