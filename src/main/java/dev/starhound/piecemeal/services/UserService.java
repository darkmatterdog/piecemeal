package dev.starhound.piecemeal.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import dev.starhound.piecemeal.models.LoginUser;
import dev.starhound.piecemeal.models.User;
import dev.starhound.piecemeal.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> existingUser = userRepository.findByEmail(newUser.getEmail());
		
		// registration validations
		if(existingUser.isPresent()) {
			result.rejectValue("email", "Matches", "User already exists.");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Matches", "Passwords do not match.");
		}
		
		
		// submit registration if passes validation
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			
			return userRepository.save(newUser);
		}
		
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		
		Optional<User> existingUser = userRepository.findByEmail(newLoginObject.getEmail());
		User thisUser = null;
		
		// validation checks
		if(existingUser.isEmpty()) {
			result.rejectValue("email", "Matches", "User does not exist.");
		}
		else {
			thisUser = existingUser.get();
			if(!BCrypt.checkpw(newLoginObject.getPassword(), thisUser.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid password.");
			}
		}
		
		// logs in, or not
		if(result.hasErrors()) {			
			return null;
		}
		else {
			return thisUser;
		}
	}
	
	
}
