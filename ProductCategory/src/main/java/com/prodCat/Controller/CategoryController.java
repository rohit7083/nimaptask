package com.prodCat.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodCat.Entity.CategoryEntity;
import com.prodCat.Service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	// Save operation
		@PostMapping("/categories")
		public CategoryEntity saveCategory(@Validated @RequestBody CategoryEntity category) {
			return categoryService.saveCategory(category);
		}

		// Read operation
		@GetMapping("/categories")
		public List<CategoryEntity> getAllCategory() {
			return categoryService.getAllCategory();
		}

		// Update operation
		@PutMapping("/categories/{categoryId}")
		public CategoryEntity updateProduct(@RequestBody CategoryEntity category, @PathVariable("categoryId") Integer categoryId) {
			return categoryService.updateCategory(category, categoryId);
		}

		// Delete operation
		@DeleteMapping("/categories/{categoryId}")
		public String delectProductById(@PathVariable("categoryId") Integer categoryId) {
			categoryService.delectCategoryById(categoryId);
			return "Deleted Successfully";
		}
		
		// Update operation
		@GetMapping("/categories/{categoryId}")
			public Optional<CategoryEntity> findById(@PathVariable("categoryId") Integer categoryId) {
				return categoryService.findById(categoryId);
			}

}
