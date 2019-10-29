package source.service;

import source.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    void save (Book book);

    void delete (Long id);

    Iterable<Book> findAllByName (String name);

}
