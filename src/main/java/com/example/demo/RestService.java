package com.example.demo;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.GroceryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@CrossOrigin
public class RestService {

	// In-memory 'database'
	private Map<String, GroceryList> database = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(RestService.class, args);
	}

	@GetMapping("/groceries/{name}")
	public GroceryList getGroceries(@PathVariable String name) {
		if (! database.containsKey(name)) {
			throw new ResourceNotFoundException();
		}

		return database.get(name);
	}

	@GetMapping("/groceries")
	public List<GroceryList> getGroceryLists() {
		return new ArrayList<>(database.values());
	}

	@PostMapping("/groceries/{name}")
	public GroceryList createGroceryList(@PathVariable String name) {
		if (database.containsKey(name)) {
			throw new ValidationException("Grocery list already exists");
		}

		GroceryList groceryList = new GroceryList();
		groceryList.setTitle(name);

		database.put(name, groceryList);

		return groceryList;
	}

	@PostMapping("/groceries/{name}/items/{item}")
	public GroceryList addGroceryItem(@PathVariable String name, @PathVariable String item) {
		if (! database.containsKey(name)) {
			throw new ResourceNotFoundException();
		}

		GroceryList groceryList = database.get(name);
		groceryList.addItem(item);
		return groceryList;
	}

	@DeleteMapping("/groceries/{name}/items/{item}")
	public GroceryList removeGroceryItem(@PathVariable String name, @PathVariable String item) {
		if (! database.containsKey(name)) {
			throw new ResourceNotFoundException();
		}

		GroceryList groceryList = database.get(name);
		groceryList.removeItem(item);
		return groceryList;
	}
}
