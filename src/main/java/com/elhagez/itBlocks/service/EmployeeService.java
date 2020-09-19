package com.elhagez.itBlocks.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elhagez.itBlocks.dao.CompanyDAO;
import com.elhagez.itBlocks.domain.Department;
import com.elhagez.itBlocks.domain.Employee;

@Service
public class EmployeeService implements CompanyDAO<Employee> {

	@Autowired
	private CompanyDAO<Employee> companyDAO;

	@Override
	@Transactional
	public void saveItem(Employee emp) {
		companyDAO.saveItem(emp);

	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return companyDAO.findAll();
	}

	@Override
	@Transactional
	public List<Employee> search(String name) {
		
		return companyDAO.search(name);
	}

	@Override
	@Transactional
	public Employee findOne(int id) {
		return companyDAO.findOne(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		companyDAO.delete(id);

	}

	@Override
	@Transactional
	public Department depart(String name) {
		return companyDAO.depart(name);
	}

	@Override
	@Transactional
	public List<String> departments() {
		
		return companyDAO.departments();
	}

	
	public Set<Employee> getEmployeesByDepartment(String name){
		return companyDAO.getEmployeesByDepartment(name);
		
	}

}
