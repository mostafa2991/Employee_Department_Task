package com.elhagez.itBlocks.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elhagez.itBlocks.domain.Department;
import com.elhagez.itBlocks.domain.Employee;
import com.elhagez.itBlocks.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	

	@RequestMapping("/")
	public String showFirstPage(Model model) {
		List<String> departStrings = employeeService.departments();
		model.addAttribute("departs", departStrings);
//		String name="";
		model.addAttribute("depart",new Department() );
		model.addAttribute("employees", employeeService.findAll());
		return "list";
	}

	@RequestMapping("/employee")
	public String getBack() {
		return "redirect:/";
	}

	@RequestMapping("/employee/create")
	public String create(Model model) {
		List<String> departStrings = employeeService.departments();
		model.addAttribute("departs", departStrings);
		model.addAttribute("employee", new Employee());
		return "form";
	}

	@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	public String save(@RequestParam("name") String name, @RequestParam("department.name") String department,
			RedirectAttributes redirect, @ModelAttribute Employee employee) {

		employee.setDepartment(employeeService.depart(department));

		employeeService.saveItem(employee);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/";
	}

	/*
	 * @RequestMapping(value="/employee/save", method = RequestMethod.POST) public
	 * String save(@ModelAttribute("employee") Employee employee, BindingResult
	 * result, RedirectAttributes redirect) { if (result.hasErrors()) { return
	 * "form"; } employeeService.save(employee);
	 * redirect.addFlashAttribute("success", "Saved employee successfully!"); return
	 * "list"; }
	 */
	@GetMapping("/employee/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		List<String> departStrings = employeeService.departments();
		model.addAttribute("departs", departStrings);
		model.addAttribute("employee", employeeService.findOne(id));

		return "form";
	}

	@GetMapping("/employee/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		employeeService.delete(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/";
	}

	@GetMapping("/employee/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/employee";
		}

		model.addAttribute("employees", employeeService.search(s));
		return "list";
	}
	
	@RequestMapping("/employee/getForDepartment")
	public String getForDepartment(@ModelAttribute("depart") Department depart,Model model) {
     System.out.println("--------------"+depart+"-----------------");
		Set<Employee> employees =employeeService.getEmployeesByDepartment(depart.getName());
		model.addAttribute("depEmployee",employees);

		return "showRequest";
	}
	
	
}