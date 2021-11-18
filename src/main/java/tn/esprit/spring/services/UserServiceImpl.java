package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	  
	public static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In Method retrieveAllUsers : ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {   
				l.info("User:"+user.toString());
			} 
			l.info("Out Of Method retrieveAllUsers With Succes");
		}catch (Exception e) {
			l.error("Out Of Method retrieveAllUsers With Errors: "+e); 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In Method addUser :"); 
		User uSaved = userRepository.save(u); 
		l.info("Out Of Method addUser With Succes");
		return uSaved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In Method updateUser :"); 
		User uSaved = userRepository.save(u); 
		l.info("Out Of Method updateUser With Succes");
		return uSaved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("In Method deleteUser :");
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("Out Of Method deleteUser With Succes");
	}

	@Override
	public User retrieveUser(String id) {
		User u = null ;
		try {
			l.info("In Method retrieveUser :");
			u =  userRepository.findById(Long.parseLong(id)).orElse(null);
			l.info("Out Of Method retrieveUser With Succes");
		}catch (Exception e) {
			l.error("Out Of Method retrieveUser With Errors: "+e); 
		}
		
		return u;
	}

}