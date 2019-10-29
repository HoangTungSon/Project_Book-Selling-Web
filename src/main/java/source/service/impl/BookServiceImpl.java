package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Book;
import source.repository.BookRepository;
import source.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>)bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Iterable<Book> findAllByName(String name) {
        return null;
    }
}
