package com.example.demo;

import com.example.demo.model.GroceryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/groceries/{name}")
	public GroceryList createGroceryList(@PathVariable String name) {
		GroceryList groceryList = new GroceryList();
		groceryList.setTitle(name);
		return groceryList;
	}

	@PostMapping("/groceries/{name}/items/{item}")
	public GroceryList addGroceryItem(@PathVariable String name, @PathVariable String item) {
		GroceryList groceryList = new GroceryList();
		groceryList.setTitle(name);
		groceryList.addItem(item);
		return groceryList;
	}

	@DeleteMapping("/groceries/{name}/items/{item}")
	public GroceryList removeGroceryItem(@PathVariable String name, @PathVariable String item) {
		GroceryList groceryList = new GroceryList();
		groceryList.setTitle(name);
		groceryList.removeItem(item);
		return groceryList;
	}
}
