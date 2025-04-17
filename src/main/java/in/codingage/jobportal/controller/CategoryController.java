package in.codingage.jobportal.controller;

import in.codingage.jobportal.model.Category;
import in.codingage.jobportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "https://jobportalbackend-cd60.onrender.com")
public class CategoryController {

    @Autowired
    private CategoryService categoryService ;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PutMapping("/updateCategoryById")
    public ResponseEntity<Category> updateCategory(@RequestParam String id, @RequestParam Category updatedCategory) {
        return ResponseEntity.ok(categoryService.updateCategory(id, updatedCategory));
    }

    @DeleteMapping("/deleteCategoryById")
    public ResponseEntity<String> deleteCategory(@RequestParam String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
