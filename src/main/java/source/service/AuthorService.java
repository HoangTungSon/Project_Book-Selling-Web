package source.service;

import source.model.Author;
import source.model.Book;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(Long id);

    void save (Author author);

    void delete (Long id);

    List<Author> findAllByName (String name);

    Author findByName(String name);

    Author authorCheck(String author_name);
}
