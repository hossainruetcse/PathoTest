package hello.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.Iservice.IUserService;
import hello.entity.User;



@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity  signUp(HttpServletRequest request,@RequestBody User user) {
		
		System.out.println("User ......... ::: "+user);
		User newUser= new User(user.getFirstName(),user.getLastName(),user.getPassword());
		System.out.println("New User ......... ::: "+newUser);
		String id = userService.createUser(newUser);
		System.out.println("User ......... id ::: "+id);
		return ResponseEntity.ok(id);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public ResponseEntity activateAccount(@PathVariable("id") String id) {
			System.out.println("ID ################################## :::: "+id);
			User user = userService.getUser(id);
			if(user==null)
				return ResponseEntity.badRequest().body("There is no user with the given id.");
			return ResponseEntity.ok(user);
	}
	

}
