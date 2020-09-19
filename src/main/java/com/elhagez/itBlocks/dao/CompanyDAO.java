package com.elhagez.itBlocks.dao;

import java.util.List;
import java.util.Set;

import com.elhagez.itBlocks.domain.Department;
import com.elhagez.itBlocks.domain.Employee;

public interface CompanyDAO<T> {

	public void saveItem(T emp);

	public List<T> findAll();

	public List<T> search(String name);

	public T findOne(int id);

	public void delete(int id);

	public Department depart(String name);

	public List<String> departments();

	public Set<Employee> getEmployeesByDepartment(String name);

}
