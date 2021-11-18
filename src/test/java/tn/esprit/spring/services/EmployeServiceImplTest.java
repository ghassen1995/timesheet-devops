package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
//import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {
	
	@Autowired 
	IEmployeService es;
	
	
	@Test
	@Order(1)
	public void retrieveAllEmployes() {
		List<Employe> listUsers = es.retrieveAllEmployes();
		Assertions.assertEquals(6, listUsers.size());
	}
	
	@Test
 	@Order(2)
	public void testAddEmploye() {
		
		Employe emp = new Employe("MOHAMED", "DHAHRI","MOHAMED.AMIN@gmail.com", "MEDAMINE", false, Role.ADMINISTRATEUR);
		Employe empAdd = es.addEmploye(emp);
		Assertions.assertEquals(emp.getNom(), empAdd.getNom());
	}	


	@Test
 	@Order(3)
	public void testUpdateEmploye() {
		Employe emp = new Employe(3L,"JIHENE", "ARFAOUI","JIHEN.ARFAOUI@gmail.com", "JIJI", false, Role.CHEF_DEPARTEMENT);
		Employe empUpdated = es.addEmploye(emp);
		Assertions.assertEquals(emp.getEmail(), empUpdated.getEmail());
	}

	@Test
 	@Order(4)
	public void testRetrieveEmploye() {
		Employe empRetrieved = es.retrieveEmploye("1");
		Assertions.assertEquals(1L, empRetrieved.getId());
	}

	@Test
 	@Order(5)
	public void testDeleteEmploye(){
		es.deleteEmploye("36");
		Assertions.assertNull(es.retrieveEmploye("36"));
	}


}
