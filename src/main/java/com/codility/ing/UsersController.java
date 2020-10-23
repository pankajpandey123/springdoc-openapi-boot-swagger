package com.codility.ing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codility.external.Item1;
import com.sample.person.backbase.Person;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	@GetMapping(value = "{username}/items/total", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Integer> totalItemsBought(@PathVariable String username) {
		Map<String, Integer> mapItemsBoughtbyUser = new HashMap<String, Integer>();
		long userid = 123L;
		mapItemsBoughtbyUser.put(username, usersService.getNumberOfItemsBought(userid));
		return mapItemsBoughtbyUser;
	}

	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Person> create(@RequestBody Item1 item) {
		return new ResponseEntity(usersService.create(item), HttpStatus.CREATED);
	}
}
