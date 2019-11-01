package source.service;

import source.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void save (Category author);

    void delete (Long id);

    List<Category> findAllByName (String name);
}
