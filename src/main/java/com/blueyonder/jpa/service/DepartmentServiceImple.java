package com.blueyonder.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.jpa.entity.Department;
import com.blueyonder.jpa.repo.DepartmentRepo;

@Service
public class DepartmentServiceImple implements DepartmentService {
	private DepartmentRepo repo;
	
	@Autowired
	public DepartmentServiceImple(DepartmentRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void addDepartment(Department dep) {
		repo.save(dep);
	};

	public List<Department> getAllData(){
		List<Department> depList=repo.findAll();
		return depList;
	}
	
	public Department getDepbyDepid(int depid) {
		Optional<Department> dep=repo.findById(depid);
		return dep.get();
	}
	
	public void updateDepartment(int depid) {
		Optional<Department> dep=repo.findById(depid);
			
	}
//	void deleteDepartment(int depid);
	
	
	
	
	
	
}
