package in.codingage.jobportal.service;

import in.codingage.jobportal.model.Category;

import java.util.List;

public interface CategoryService {

     Category createCategory(Category category);

     List<Category> getAllCategories();

     Category updateCategory(String id, Category updatedCategory);

     void deleteCategory(String id);

}
