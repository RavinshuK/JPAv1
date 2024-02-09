package com.blueyonder.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import com.blueyonder.jpa.entity.Department;
import com.blueyonder.jpa.repo.DepartmentRepo;
import com.blueyonder.jpa.service.DepartmentService;

@Controller
public class HomeController {
	
	@Autowired
	DepartmentRepo repo;
	@Autowired
	DepartmentService service;
	
	public HomeController(DepartmentService service) {
	super();
	this.service = service;
}

	@GetMapping	("/")
	public String Details() {
		return "index";
	}
	
//	@GetMapping("submit")
//	public ModelAndView getResult() {
//		return new ModelAndView("result", "department", new Department());
//	}	
	
	
//	@RequestMapping(value="submit", method=RequestMethod.POST)
//	public String storeInDB(@ModelAttribute("department") Department department, BindingResult
//			bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "result";
//		}
//		service.addDepartment(department);
//		
//		return "redirect:/";
//	}
//	@PostMapping("/submit")
//	public String storeInDB(@RequestParam("depid")int depid, @RequestParam("depname") String depname,
//			@RequestParam("deplocation") String deplocation, Model m) {
//			Department dep=new Department(depid,depname,deplocation);
//			m.addAttribute("fullname",dep);
//			
////			repo.save(dep);
//			service.addDepartment(dep);
//			return "result";
//		
//	}
	
	@PostMapping("/submit")
	public String storeInDB(@RequestParam("depid") Integer depid, 
            @RequestParam("depname") String depname, 
            @RequestParam("deplocation") String deplocation) {
			// Create a Department object from form data
			Department department = new Department();
			department.setDepid(depid);
			department.setDepname(depname);
			department.setDeplocation(deplocation);
			// Add the department to the database
			service.addDepartment(department);
			System.out.println("Data inserted");
			// Print message
			return "redirect:/";
			
	} 
	
	@GetMapping("/getData")
	public String getData(Model m) {
		m.addAttribute("fullname", service.getAllData());
		return "result";
	}
	
	@GetMapping("/byId")
	public String getById(@RequestParam("depid") int depid,Model m) {
		m.addAttribute("fullname", service.getDepbyDepid(depid));
		return "result";
	}
//	@GetMapping("/submit")
//	public String getOneData(@RequestParam int depid,Model m) {
//		m.addAttribute("fullname", repo.findById(depid));
//		return "result";
//	}
//	
	
	
}
