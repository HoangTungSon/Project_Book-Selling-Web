package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Category;
import source.repository.CategoryRepository;
import source.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository authorRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) authorRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public void save(Category author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }

    @Override
    public List<Category> findAllByName(String name) {
        return authorRepository.findAllByName(name);
    }
}
