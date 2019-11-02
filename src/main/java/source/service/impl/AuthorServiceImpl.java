package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Author;
import source.repository.AuthorRepository;
import source.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findOne(id);
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }

    @Override
    public List<Author> findAllByName(String name) {
        return authorRepository.findAllByName(name);
    }
}
