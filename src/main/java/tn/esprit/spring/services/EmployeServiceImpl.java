package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;


@Service

public class EmployeServiceImpl implements IEmployeService{
	
public static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);


	@Autowired
	EmployeRepository employeRepository;

	
	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> emps = null; 
		try {
	
			l.info("In Method retrieveAllEmployes : ");
			emps = (List<Employe>) employeRepository.findAll();  
			for (Employe emp : emps) {
				l.info("Employée:"+emp.toString());   
			} 
			l.info("Out Of Method retrieveAllEmployes With Succes");
		}catch (Exception e) {
			l.error("Out Of Method retrieveAllEmployes With Errors: "+e); 
		}

		return emps;
	}


	@Override
	public Employe addEmploye(Employe u) {
		l.info("In Method addEmploye :"); 
		Employe uSaved = employeRepository.save(u); 
		l.info("Out Of Method addEmploye With Succes");
		return uSaved; 
	}

	@Override 
	public Employe updateEmploye(Employe u) { 
		l.info("In Method updateEmploye :"); 
		Employe uSaved = employeRepository.save(u); 
		l.info("Out Of Method updateEmploye With Succes");
		return uSaved; 
	}

	@Override
	public void deleteEmploye(String id) {
		l.info("In Method deleteEmploye :");
		employeRepository.deleteById(Long.parseLong(id)); 
		l.info("Out Of Method deleteUser With Succes");
	}

	@Override
	public Employe retrieveEmploye(String id) {
		Employe u = null;
		try {
			
			l.info("In Method retrieveEmploye :");
			u =  employeRepository.findById(Long.parseLong(id)).orElse(null);
			l.info("Out Of Method retrieveEmploye With Succes");
			
		}catch(Exception e) {
			l.error("Out Of Method retrieveEmploye With Errors: "+e);
		}
		return u; 
	}

}