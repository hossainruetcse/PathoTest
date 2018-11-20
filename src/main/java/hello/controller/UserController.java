package hello.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.Iservice.ITagService;
import hello.Iservice.IUserService;
import hello.entity.Tag;
import hello.entity.User;



@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	@Autowired
	ITagService tagService;

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity  signUp(HttpServletRequest request,@RequestBody User user) {
		User newUser= new User(user.getFirstName(),user.getLastName(),user.getPassword());
		String id = userService.createUser(newUser);
		return ResponseEntity.ok(id);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public ResponseEntity getUser(@PathVariable("id") String id) {
			User user = userService.getUser(id);
			if(user==null)
				return ResponseEntity.badRequest().body("There is no user with the given id.");
			return ResponseEntity.ok(user);
	}
	@RequestMapping(value = "users/{id}/tags", method = RequestMethod.POST)
	public ResponseEntity addTagsToUser(@PathVariable("id") String id, @RequestBody  Map jsonObject) {
		User user = userService.getUser(id);
		List<String> tagNames=(List) jsonObject.get("tags");
		long expiry=(int)jsonObject.get("expiry");
		for(String tagName : tagNames) {
			Tag tag=tagService.createTag(tagName, expiry);
			userService.addTags(user, tag);
		}
		
		return ResponseEntity.ok("{}");
		
	}
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ResponseEntity getUsersByTags(HttpServletRequest request) {
		
		String tags = request.getParameter("tags");
		List<User> users = userService.getUsersByTag(tags);
		return ResponseEntity.ok(users);
	}
			

}
