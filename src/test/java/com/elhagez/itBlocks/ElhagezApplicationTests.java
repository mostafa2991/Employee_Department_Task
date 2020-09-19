package com.elhagez.itBlocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.elhagez.itBlocks.service.EmployeeService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ElhagezApplicationTests {
    
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void contextLoads() {
		
		
	employeeService.findAll().forEach(i->{
		System.out.println(i);

	});
	}

}
