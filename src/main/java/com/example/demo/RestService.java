package com.example.demo;

import com.example.demo.model.GroceryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestService {

	public static void main(String[] args) {
		SpringApplication.run(RestService.class, args);
	}

	@GetMapping("/groceries/{name}")
	public GroceryList getGroceries(@PathVariable String name) {
		GroceryList groceryList = new GroceryList();
		groceryList.setTitle(name);
		return groceryList;
	}

}
