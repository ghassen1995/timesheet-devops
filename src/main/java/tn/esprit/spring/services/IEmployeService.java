package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {
	
	List<Employe> retrieveAllEmployes(); 
	Employe addEmploye(Employe e);
	void deleteEmploye(String id);
	Employe updateEmploye(Employe e);
	Employe retrieveEmploye(String id);
	

}