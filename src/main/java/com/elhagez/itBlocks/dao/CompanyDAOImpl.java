package com.elhagez.itBlocks.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elhagez.itBlocks.domain.Department;
import com.elhagez.itBlocks.domain.Employee;

@Repository
public class CompanyDAOImpl implements CompanyDAO<Employee> {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void saveItem(Employee emp) {
		Session session= entityManager.unwrap(Session.class);
		session.saveOrUpdate(emp);
		
	}

	@Override
	public List<Employee> findAll() {
		Session session= entityManager.unwrap(Session.class);
		List<Employee> empls=session.createQuery("from Employee").getResultList();
		return empls;
	}

	@Override
	public List<Employee> search(String name) {
		Session session= entityManager.unwrap(Session.class);
		List<Employee> empls=session.createQuery("from Employee where name like '%"+name+"%'").getResultList();
		return empls;
	}

	@Override
	public Employee findOne(int id) {
		Session session= entityManager.unwrap(Session.class);
		Employee emp = session.get(Employee.class, id);
		return emp;
	}

	@Override
	public void delete(int id) {
		Session session= entityManager.unwrap(Session.class);
		Employee emp = session.get(Employee.class, id);
		session.delete(emp);
		
	}
	
	@Override
	public Department depart(String name)
	{
		Session session= entityManager.unwrap(Session.class);
		Department department=session.createQuery("from Department where name='"+name+"'",Department.class).getResultList().get(0);
		
		return department;
	}

	@Override
	public List<String> departments() {
		Session session= entityManager.unwrap(Session.class);
		List<Department> departs= session.createQuery("from Department").getResultList();
		List<String> names=new ArrayList<>();
		for(int i=0;i<departs.size();i++) {
			names.add(departs.get(i).getName());
		}
		return names;
	}

	@Override
	public Set<Employee> getEmployeesByDepartment(String name ) {
		Session session= entityManager.unwrap(Session.class);
		Department department=depart(name);
		Set<Employee> employees= department.getEmployees();
		return employees;
	}
}



















